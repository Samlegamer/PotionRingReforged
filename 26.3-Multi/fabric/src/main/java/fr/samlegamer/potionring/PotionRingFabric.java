package fr.samlegamer.potionring;

import fr.samlegamer.potionring.commands.PRGetColorCommand;
import fr.samlegamer.potionring.item.PRItemsRegistry;
import fr.samlegamer.potionring.item.PRTagsItemRegistry;
import fr.samlegamer.potionring.util.RingAPIFabric;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

public class PotionRingFabric implements ModInitializer
{
	public static final RingAPIFabric RING_API_FABRIC = new RingAPIFabric();

	@Override
	public void onInitialize()
	{
		CommandRegistrationCallback.EVENT.register((commandDispatcher, commandRegistryAccess, registrationEnvironment) -> new PRGetColorCommand(commandDispatcher, commandRegistryAccess));
		PRTagsItemRegistry.registerTags();
		PRItemsRegistry.registryVanillaRings();
		PRItemsRegistry.registryModdedCustom(RING_API_FABRIC);
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FOOD_AND_DRINKS).register(entries -> {
			for(Item item : PotionRing.itemInTab(RING_API_FABRIC)) {
				entries.accept(item);
			}
		});
		PotionRing.finishLog();
	}
}