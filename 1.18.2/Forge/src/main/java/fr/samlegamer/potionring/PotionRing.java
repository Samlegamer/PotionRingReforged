package fr.samlegamer.potionring;

import fr.samlegamer.potionring.cfg.*;
import fr.samlegamer.potionring.client.PRLang;
import fr.samlegamer.potionring.client.PRModels;
import fr.samlegamer.potionring.data.PRRecipes;
import fr.samlegamer.potionring.data.PRTags;
import fr.samlegamer.potionring.item.PRTagsItemRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;
import java.util.ArrayList;
import java.util.List;
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

		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		PRItemsRegistry.ITEMS_REGISTRY.register(bus);
		PRTagsItemRegistry.registerTags();
		PRItemsRegistry.registryVanillaRings();
		PRItemsRegistry.registryModdedCustom(bus);
		log.info("Potion Rings - REFORGED is Charged");
	}

	private void onGatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

		if (event.includeClient()) {
			generator.addProvider(new PRModels(generator, existingFileHelper));
			generator.addProvider(new PRLang(generator));
		}
		if (event.includeServer()) {
			generator.addProvider(new PRRecipes(generator));
			generator.addProvider(new PRTags(generator, existingFileHelper));
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