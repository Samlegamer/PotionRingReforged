package fr.samlegamer.potionring;

import fr.samlegamer.potionring.commands.PRGetColorCommand;
import fr.samlegamer.potionring.item.PRTagsItemRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import fr.samlegamer.potionring.item.PRItemsRegistry;

import java.util.List;
import java.util.Optional;

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
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FOOD_AND_DRINKS).register(entries -> {
			entries.accept(PRItemsRegistry.POTION_RING);
			entries.accept(PRItemsRegistry.RING_OF_HASTE);
			entries.accept(PRItemsRegistry.RING_OF_JUMP_BOOST);
			entries.accept(PRItemsRegistry.RING_OF_REGENERATION);
			entries.accept(PRItemsRegistry.RING_OF_SPEED);
			entries.accept(PRItemsRegistry.RING_OF_RESISTANCE);
			entries.accept(PRItemsRegistry.RING_OF_STRENGTH);

			entries.accept(PRItemsRegistry.RING_OF_FIRE_RESISTANCE);
			entries.accept(PRItemsRegistry.RING_OF_INVISIBILITY);
			entries.accept(PRItemsRegistry.RING_OF_SLOWNESS);
			entries.accept(PRItemsRegistry.RING_OF_MINING_FATIGUE);
			entries.accept(PRItemsRegistry.RING_OF_NAUSEA);
			entries.accept(PRItemsRegistry.RING_OF_BLINDNESS);
			entries.accept(PRItemsRegistry.RING_OF_HUNGER);
			entries.accept(PRItemsRegistry.RING_OF_NIGHT_VISION);
			entries.accept(PRItemsRegistry.RING_OF_SATURATION);
			entries.accept(PRItemsRegistry.RING_OF_POISON);
			entries.accept(PRItemsRegistry.RING_OF_WATER_BREATHING);
			entries.accept(PRItemsRegistry.RING_OF_WEAKNESS);
			entries.accept(PRItemsRegistry.RING_OF_WITHER);
			entries.accept(PRItemsRegistry.RING_OF_GLOWING);
			entries.accept(PRItemsRegistry.RING_OF_LEVITATION);
			entries.accept(PRItemsRegistry.RING_OF_LUCK);
			entries.accept(PRItemsRegistry.RING_OF_UNLUCK);
			entries.accept(PRItemsRegistry.RING_OF_SLOW_FALLING);
			entries.accept(PRItemsRegistry.RING_OF_CONDUIT_POWER);
			entries.accept(PRItemsRegistry.RING_OF_DOLPHIN_GRACE);
			entries.accept(PRItemsRegistry.RING_OF_DARKNESS);

			if(FabricLoader.getInstance().isModLoaded("sizeshiftingpotions"))
			{
				entries.accept(PRItemsRegistry.RING_OF_SHRINKING);
				entries.accept(PRItemsRegistry.RING_OF_THINNING);
				entries.accept(PRItemsRegistry.RING_OF_WIDENING);
				entries.accept(PRItemsRegistry.RING_OF_GROWING);
			}
			List<String> list = (List<String>) PRItemsRegistry.createNewFileOrLearn(false);

			if(!list.isEmpty()) {
                for (String s : list) {
                    String[] parts = s.split(":");
                    if (parts.length == 2) {
                        final String mod = parts[0];
                        final String id = parts[1];

                        Optional<Holder.Reference<Item>> itemModded = BuiltInRegistries.ITEM.get(Identifier.fromNamespaceAndPath(PotionRing.MODID, "ring_of_" + id));
                        if (itemModded.isPresent() && FabricLoader.getInstance().isModLoaded(mod)) {
                            entries.accept(itemModded.get().value());
                        }
                    }
                }
			}
		});
		log.info("Potion Rings - REFORGED is Charged");
	}
}