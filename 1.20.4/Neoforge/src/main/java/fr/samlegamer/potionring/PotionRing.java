package fr.samlegamer.potionring;

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
import java.util.List;
import java.util.concurrent.CompletableFuture;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import fr.samlegamer.potionring.item.PRItemsRegistry;

@Mod(value = PotionRing.MODID)
public class PotionRing
{
	public static final String MODID = "potionring";
	public static final Logger log = LogManager.getLogger();

	public PotionRing(IEventBus bus)
	{
		bus.addListener(this::onGatherData);
		bus.addListener(this::addToTab);

		PRItemsRegistry.ITEMS_REGISTRY.register(bus);
		PRTagsItemRegistry.registerTags();
		PRItemsRegistry.registryVanillaRings();
		PRItemsRegistry.registryModdedCustom(bus);
		log.info("Potion Rings - REFORGED is Charged");
	}

	private void addToTab(BuildCreativeModeTabContentsEvent event)
	{
		List<String> list = (List<String>) PRItemsRegistry.createNewFileOrLearn(false);

		if(event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS)
		{
			for(DeferredHolder<Item, ? extends Item> item : PRItemsRegistry.ITEMS_REGISTRY.getEntries())
			{
				event.accept(item.get());
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
		CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

		if (event.includeClient()) {
			generator.addProvider(true, new PRModels(packOutput, existingFileHelper));
			generator.addProvider(true, new PRLang(packOutput));
		}
		if (event.includeServer()) {
			PRTags.PRBlockTags blockTagGenerator = generator.addProvider(event.includeServer(),
					new PRTags.PRBlockTags(packOutput, lookupProvider, existingFileHelper));
			generator.addProvider(true, new PRRecipes(packOutput));
			generator.addProvider(true, new PRTags(packOutput, lookupProvider, blockTagGenerator.contentsGetter(), existingFileHelper));
		}
	}
}