package fr.samlegamer.potionring;

import fr.samlegamer.potionring.cfg.*;
import fr.samlegamer.potionring.client.RingModel;
import fr.samlegamer.potionring.data.PRRecipes;
import fr.samlegamer.potionring.data.PRTags;
import fr.samlegamer.potionring.item.PotionRingItem;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraft.potion.Effect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import fr.samlegamer.potionring.item.PRItemsRegistry;

@Mod(value = PotionRing.MODID)
public class PotionRing {
	public static final String MODID = "potionring";
	public static final Logger log = LogManager.getLogger();

	public PotionRing() {

		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, TutorialConfig.SPEC, "tutorialmod-common.toml");

		MinecraftForge.EVENT_BUS.register(CfgT.class);
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Configs.SERVER_CONFIG);
		//ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Configs.SPEC, "potionring1-common.toml");
		//Configs.init();

		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		PRItemsRegistry.registryVanillaRings();

		//PRItemsRegistry.registryModdedCustom();
		//MinecraftForge.EVENT_BUS.addListener(this::onTagsUpdated);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onClientSetup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onGatherData);

//		MinecraftForge.EVENT_BUS.register(this);

		log.info("PR bool : " + TutorialConfig.example_string.get().toString());
		//MinecraftForge.EVENT_BUS.register(this);
		PRItemsRegistry.ITEMS_REGISTRY.register(bus);

		log.info("Potion Rings - REFORGED is Charged");
	}

	private void onGatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

		if (event.includeServer()) {
			generator.addProvider(new PRRecipes(generator));
			generator.addProvider(new PRTags(generator, null));
		}
	}

	public void onClientSetup(FMLClientSetupEvent event)
	{
//		for (PotionRingItem item : PRItemsRegistry.DYNAMIC_ITEMS) {
//			RingModel.register(item, item.eff::getColor);
//		}
	}
//	public void onTagsUpdated(TagsUpdatedEvent event)
//	{
//		final ITag.INamedTag<Item> CURIOS_RING = ItemTags.bind("curios:ring");
//		event.getTagManager().getItems().getTag(new ResourceLocation("curios", "ring"));
//		Set<Supplier<Item>> sets = new HashSet<>();
//		sets.add(()->PRItemsRegistry.RING_OF_FIRE_RESISTANCE.get());
//		ITag.INamedTag<Item> customTag = ItemTags.createOptional(new ResourceLocation("curios", "ring"), sets);
//		ItemTags.bind(customTag.getName().toString());
//	}

	public static Item getItemFromConfig(String mod, String name)
	{
        return ForgeRegistries.ITEMS.getValue(new ResourceLocation(mod, name));
	}

	public static Effect getEffectFromConfig(String mod, String name)
	{
		return ForgeRegistries.POTIONS.getValue(new ResourceLocation(mod, name));
	}

	public static boolean isLoaded(String mod)
	{
		return ModList.get().isLoaded(mod);
	}

	private void enqueueIMC(final InterModEnqueueEvent event)
	{
		if (Configs.SERVER_CONFIG != null) {

			SlotTypePreset[] slots = {
					SlotTypePreset.HEAD, SlotTypePreset.NECKLACE, SlotTypePreset.BACK, SlotTypePreset.BODY,
					SlotTypePreset.HANDS, SlotTypePreset.RING, SlotTypePreset.CHARM
			};
			List<SlotTypeMessage.Builder> builders = new ArrayList<>();
			for (SlotTypePreset slot : slots) {
				SlotTypeMessage.Builder builder = slot.getMessageBuilder();
				if (slot == SlotTypePreset.RING) {
					builder.size(TutorialConfig.example_integer.get());
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
}