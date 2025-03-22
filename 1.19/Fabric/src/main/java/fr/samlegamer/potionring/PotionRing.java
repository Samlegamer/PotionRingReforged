package fr.samlegamer.potionring;

import fr.samlegamer.potionring.commands.PRGetColorCommand;
import fr.samlegamer.potionring.item.PRTagsItemRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import fr.samlegamer.potionring.item.PRItemsRegistry;

public class PotionRing implements ModInitializer
{
	public static final String MODID = "potionring";
	public static final Logger log = LogManager.getLogger();

	@Override
	public void onInitialize()
	{
		CommandRegistrationCallback.EVENT.register((commandDispatcher, commandRegistryAccess, registrationEnvironment) -> new PRGetColorCommand(commandDispatcher));
		PRTagsItemRegistry.registerTags();
		PRItemsRegistry.registryVanillaRings();
		PRItemsRegistry.registryModdedCustom();
		log.info("Potion Rings - REFORGED is Charged");
	}
}