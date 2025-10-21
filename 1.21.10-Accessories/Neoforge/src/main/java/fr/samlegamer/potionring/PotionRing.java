package fr.samlegamer.potionring;

import fr.samlegamer.potionring.client.PRLang;
import fr.samlegamer.potionring.client.PRModels;
import fr.samlegamer.potionring.data.PRRecipes;
import fr.samlegamer.potionring.data.PRTags;
import fr.samlegamer.potionring.item.PRTagsItemRegistry;
import io.wispforest.accessories.api.client.AccessoriesRendererRegistry;
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
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
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
		bus.addListener(this::onGatherClient);
		bus.addListener(this::client);
		bus.addListener(this::addToTab);

		PRItemsRegistry.ITEMS_REGISTRY.register(bus);
		PRTagsItemRegistry.registerTags();
		PRItemsRegistry.registryVanillaRings();
		PRItemsRegistry.registryModdedCustom(bus);
		log.info("Potion Rings - REFORGED is Charged");
	}

	private void client(FMLClientSetupEvent event)
	{
		for(DeferredHolder<Item, ? extends Item> item : PRItemsRegistry.ITEMS_REGISTRY.getEntries())
		{
			AccessoriesRendererRegistry.bindItemToRenderer(item.get(), AccessoriesRendererRegistry.NO_RENDERER_ID);
		}
		AccessoriesRendererRegistry.bindItemToRenderer(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(MODID, "ring_of_growing")).get().value(), AccessoriesRendererRegistry.NO_RENDERER_ID);
		AccessoriesRendererRegistry.bindItemToRenderer(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(MODID, "ring_of_shrinking")).get().value(), AccessoriesRendererRegistry.NO_RENDERER_ID);
		AccessoriesRendererRegistry.bindItemToRenderer(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(MODID, "ring_of_thinning")).get().value(), AccessoriesRendererRegistry.NO_RENDERER_ID);
		AccessoriesRendererRegistry.bindItemToRenderer(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(MODID, "ring_of_widening")).get().value(), AccessoriesRendererRegistry.NO_RENDERER_ID);

		List<String> list = (List<String>) PRItemsRegistry.createNewFileOrLearn(false);

		if(!list.isEmpty()) {

			for (String s : list) {

				String[] parts = s.split(":");
				if (parts.length == 2) {
					final String mod = parts[0];
					final String id = parts[1];
					final Item itemModded = BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(PotionRing.MODID, "ring_of_"+id)).get().value();

					if(ModList.get().isLoaded(mod))
					{
						AccessoriesRendererRegistry.bindItemToRenderer(itemModded, AccessoriesRendererRegistry.NO_RENDERER_ID);
					}
				}
			}
		}
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

			if(ModList.get().isLoaded("sizeshiftingpotions"))
			{
				event.accept(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(MODID, "ring_of_growing")).get().value());
				event.accept(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(MODID, "ring_of_shrinking")).get().value());
				event.accept(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(MODID, "ring_of_thinning")).get().value());
				event.accept(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(MODID, "ring_of_widening")).get().value());
			}
			
			if(!list.isEmpty()) {

				for (String s : list) {

					String[] parts = s.split(":");
					if (parts.length == 2) {
						final String mod = parts[0];
						final String id = parts[1];
						final Item itemModded = BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(PotionRing.MODID, "ring_of_"+id)).get().value();

						if(ModList.get().isLoaded(mod))
						{
							event.accept(itemModded);
						}
					}
				}
			}
		}
	}

	private void onGatherClient(GatherDataEvent.Client event)
	{
		DataGenerator generator = event.getGenerator();
		PackOutput output = event.getGenerator().getPackOutput();
		CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
		PRTags.PRBlockTags blockTagGenerator = generator.addProvider(true, new PRTags.PRBlockTags(output, lookupProvider));

		generator.addProvider(true, new PRRecipes.Runner(output, lookupProvider));
		generator.addProvider(true, new PRTags(output, lookupProvider, blockTagGenerator.contentsGetter()));
		generator.addProvider(true, new PRLang(output));
		generator.addProvider(true, new PRModels(output));

		//event.createProvider(PRModels::new);
		//event.createProvider(PRLang::new);

		//generator.addProvider(true, new PRRecipes(lookupProvider)    //a, lookupProvider));
	}
}