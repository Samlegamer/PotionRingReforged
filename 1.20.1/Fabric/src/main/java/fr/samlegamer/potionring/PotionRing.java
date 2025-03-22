package fr.samlegamer.potionring;

import fr.samlegamer.potionring.commands.PRGetColorCommand;
import fr.samlegamer.potionring.item.PRTagsItemRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import fr.samlegamer.potionring.item.PRItemsRegistry;

import java.util.List;

public class PotionRing implements ModInitializer
{
	public static final String MODID = "potionring";
	public static final Logger log = LogManager.getLogger();

	@Override
	public void onInitialize()
	{
		CommandRegistrationCallback.EVENT.register((commandDispatcher, commandRegistryAccess, registrationEnvironment) -> new PRGetColorCommand(commandDispatcher, commandRegistryAccess));
		PRTagsItemRegistry.registerTags();
		PRItemsRegistry.registryVanillaRings();
		PRItemsRegistry.registryModdedCustom();
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
			entries.add(PRItemsRegistry.POTION_RING);
			entries.add(PRItemsRegistry.RING_OF_HASTE);
			entries.add(PRItemsRegistry.RING_OF_JUMP_BOOST);
			entries.add(PRItemsRegistry.RING_OF_REGENERATION);
			entries.add(PRItemsRegistry.RING_OF_SPEED);
			entries.add(PRItemsRegistry.RING_OF_RESISTANCE);
			entries.add(PRItemsRegistry.RING_OF_STRENGTH);

			entries.add(PRItemsRegistry.RING_OF_FIRE_RESISTANCE);
			entries.add(PRItemsRegistry.RING_OF_INVISIBILITY);
			entries.add(PRItemsRegistry.RING_OF_SLOWNESS);
			entries.add(PRItemsRegistry.RING_OF_MINING_FATIGUE);
			entries.add(PRItemsRegistry.RING_OF_NAUSEA);
			entries.add(PRItemsRegistry.RING_OF_BLINDNESS);
			entries.add(PRItemsRegistry.RING_OF_HUNGER);
			entries.add(PRItemsRegistry.RING_OF_NIGHT_VISION);
			entries.add(PRItemsRegistry.RING_OF_SATURATION);
			entries.add(PRItemsRegistry.RING_OF_POISON);
			entries.add(PRItemsRegistry.RING_OF_WATER_BREATHING);
			entries.add(PRItemsRegistry.RING_OF_WEAKNESS);
			entries.add(PRItemsRegistry.RING_OF_WITHER);
			entries.add(PRItemsRegistry.RING_OF_GLOWING);
			entries.add(PRItemsRegistry.RING_OF_LEVITATION);
			entries.add(PRItemsRegistry.RING_OF_LUCK);
			entries.add(PRItemsRegistry.RING_OF_UNLUCK);
			entries.add(PRItemsRegistry.RING_OF_SLOW_FALLING);
			entries.add(PRItemsRegistry.RING_OF_CONDUIT_POWER);
			entries.add(PRItemsRegistry.RING_OF_DOLPHIN_GRACE);
			entries.add(PRItemsRegistry.RING_OF_DARKNESS);

			if(FabricLoader.getInstance().isModLoaded("sizeshiftingpotions"))
			{
				entries.add(PRItemsRegistry.RING_OF_SHRINKING);
				entries.add(PRItemsRegistry.RING_OF_THINNING);
				entries.add(PRItemsRegistry.RING_OF_WIDENING);
				entries.add(PRItemsRegistry.RING_OF_GROWING);
			}
			List<String> list = (List<String>) PRItemsRegistry.createNewFileOrLearn(false);

			if(!list.isEmpty()) {
                for (String s : list) {
                    String[] parts = s.split(":");
                    if (parts.length == 2) {
                        final String mod = parts[0];
                        final String id = parts[1];

                        Item itemModded = Registries.ITEM.get(new Identifier(PotionRing.MODID, "ring_of_" + id));
                        if (FabricLoader.getInstance().isModLoaded(mod)) {
                            entries.add(itemModded);
                        }
                    }
                }
			}
		});
		log.info("Potion Rings - REFORGED is Charged");
	}
}