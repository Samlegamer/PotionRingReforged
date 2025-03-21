package fr.samlegamer.potionring;

import fr.samlegamer.potionring.client.PRLang;
import fr.samlegamer.potionring.client.PRModels;
import fr.samlegamer.potionring.data.PRRecipes;
import fr.samlegamer.potionring.data.PRTags;
import fr.samlegamer.potionring.item.PRTagsItemRegistry;
import net.fabricmc.api.ModInitializer;
import net.minecraft.data.DataGenerator;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import fr.samlegamer.potionring.item.PRItemsRegistry;

public class PotionRing implements ModInitializer
{
	public static final String MODID = "potionring";
	public static final Logger log = LogManager.getLogger();

	@Override
	public void onInitialize() {
		//FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onGatherData);

		//IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
//		PRItemsRegistry.ITEMS_REGISTRY.register(bus);
		PRTagsItemRegistry.registerTags();
		PRItemsRegistry.registryVanillaRings();
		PRItemsRegistry.registryModdedCustom();
		log.info("Potion Rings - REFORGED is Charged");
	}

//	private void onGatherData(GatherDataEvent event) {
//		DataGenerator generator = event.getGenerator();
//		ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
//
//		if (event.includeClient()) {
//			generator.addProvider(new PRModels(generator, existingFileHelper));
//			generator.addProvider(new PRLang(generator));
//		}
//		if (event.includeServer()) {
//			generator.addProvider(new PRRecipes(generator));
//			generator.addProvider(new PRTags(generator, existingFileHelper));
//		}
//	}
}