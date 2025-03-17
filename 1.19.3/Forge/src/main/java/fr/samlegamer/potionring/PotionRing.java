package fr.samlegamer.potionring;

import fr.samlegamer.potionring.cfg.*;
import fr.samlegamer.potionring.client.PRLang;
import fr.samlegamer.potionring.client.PRModels;
import fr.samlegamer.potionring.data.PRRecipes;
import fr.samlegamer.potionring.data.PRTags;
import fr.samlegamer.potionring.item.PRTagsItemRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import fr.samlegamer.potionring.item.PRItemsRegistry;

@Mod(value = PotionRing.MODID)
public class PotionRing
{
	public static final String MODID = "potionring";
	public static final Logger log = LogManager.getLogger();

	public PotionRing()
	{
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, RingsConfig.SPEC, "potionring-common.toml");
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onGatherData);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::addToTab);

		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		PRItemsRegistry.ITEMS_REGISTRY.register(bus);
		PRTagsItemRegistry.registerTags();
		PRItemsRegistry.registryVanillaRings();
		PRItemsRegistry.registryModdedCustom(bus);
		log.info("Potion Rings - REFORGED is Charged");
	}

	private void addToTab(CreativeModeTabEvent.BuildContents event)
	{
		List<String> list = (List<String>) PRItemsRegistry.createNewFileOrLearn(false);

		if(event.getTab() == CreativeModeTabs.FOOD_AND_DRINKS)
		{
			for(RegistryObject<Item> item : PRItemsRegistry.ITEMS_REGISTRY.getEntries())
			{
				event.accept(item);
			}
			if(!list.isEmpty()) {

				for (String s : list) {

					String[] parts = s.split(":");
					if (parts.length == 2) {
						final String mod = parts[0];
						final String id = parts[1];
						final Item itemModded = BuiltInRegistries.ITEM.get(new ResourceLocation(PotionRing.MODID, "ring_of_"+id));

						if(ModList.get().isLoaded(mod))
						{
							event.accept(itemModded);
						}
					}
				}
			}
		}
	}

	private void onGatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
		PackOutput packOutput = generator.getPackOutput();
		CompletableFuture<HolderLookup.Provider> completableFuture = event.getLookupProvider();

		if (event.includeClient()) {
			generator.addProvider(true, new PRModels(packOutput, existingFileHelper));
			generator.addProvider(true, new PRLang(packOutput));
		}
		if (event.includeServer()) {
			generator.addProvider(true, new PRRecipes(packOutput));
			generator.addProvider(true, new PRTags(packOutput, completableFuture, existingFileHelper));
		}
	}

	private void enqueueIMC(final InterModEnqueueEvent event)
	{
		SlotTypePreset[] slots = {
				SlotTypePreset.HEAD, SlotTypePreset.NECKLACE, SlotTypePreset.BACK, SlotTypePreset.BODY,
				SlotTypePreset.HANDS, SlotTypePreset.RING, SlotTypePreset.CHARM
		};
		List<SlotTypeMessage.Builder> builders = new ArrayList<>();
		for (SlotTypePreset slot : slots) {
			SlotTypeMessage.Builder builder = slot.getMessageBuilder();
			if (slot == SlotTypePreset.RING) {
				builder.size(RingsConfig.numberOfRingsSlots.get());
			}
			builders.add(builder);
		}
		for (SlotTypeMessage.Builder builder : builders) {
			SlotTypeMessage message = builder.build();
			InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE,
					() -> message);
		}
	}
}