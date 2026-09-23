package fr.samlegamer.potionring;

import fr.samlegamer.potionring.client.PRLang;
import fr.samlegamer.potionring.client.PRModels;
import fr.samlegamer.potionring.data.PRRecipes;
import fr.samlegamer.potionring.data.PRTags;
import fr.samlegamer.potionring.item.PRItemsRegistry;
import fr.samlegamer.potionring.item.PRTagsItemRegistry;
import fr.samlegamer.potionring.util.RingAPINeoForge;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

import java.util.Set;
import java.util.concurrent.CompletableFuture;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@Mod(value = PotionRing.MODID)
public class PotionRingNeoForge
{
	public static final RingAPINeoForge RING_API_NEO_FORGE = new RingAPINeoForge();

	public PotionRingNeoForge(IEventBus bus)
	{
		bus.addListener(this::onGatherClient);
		bus.addListener(this::addToTab);

		PRItemsRegistry.ITEMS_REGISTRY.register(bus);
		PRItemsRegistry.registryVanillaRings();
		PRItemsRegistry.registryModdedCustom(RING_API_NEO_FORGE);
		PRTagsItemRegistry.registerTags();
		PotionRing.finishLog();
	}

	private void addToTab(BuildCreativeModeTabContentsEvent event)
	{
		if(event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS)
		{
			for(Item item : PotionRing.itemInTab(RING_API_NEO_FORGE))
			{
				event.accept(item);
			}
		}
	}

	private void onGatherClient(GatherDataEvent.Client event)
	{
		DataGenerator generator = event.getGenerator();
		PackOutput output = event.getGenerator().getPackOutput();
		CompletableFuture<HolderLookup.Provider> lookupProvider = event.getReloadableLookupProvider();
		CompletableFuture<HolderLookup.Provider> worldProvider = event.getWorldLookupProvider();
		final RegistrySetBuilder RELOADABLE_BUILDER = new RegistrySetBuilder().add(PRRecipes.create());

		generator.addProvider(true, DatapackBuiltinEntriesProvider.forReloadableLayer(
				output, "Potion Ring - Reforged Reloadable Registries", worldProvider, lookupProvider,
				RELOADABLE_BUILDER, Set.of(PotionRing.MODID)));
		generator.addProvider(true, new PRTags(output, lookupProvider));
		generator.addProvider(true, new PRLang(output));
		generator.addProvider(true, new PRModels(output));
	}
}