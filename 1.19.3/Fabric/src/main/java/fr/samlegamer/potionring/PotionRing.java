package fr.samlegamer.potionring;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.impl.itemgroup.MinecraftItemGroups;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import fr.samlegamer.potionring.item.PRItems;

public class PotionRing implements ModInitializer
{
	public static final String MODID = "potionring";
	public static final Logger LOGGER = LoggerFactory.getLogger("potionring");
	
	@Override
	public void onInitialize()
	{
		PRItems.moddedCompat();
		PRItems.registry();
		ItemGroupEvents.modifyEntriesEvent(MinecraftItemGroups.FOOD_AND_DRINK_ID).register(entries -> { 
			entries.add(PRItems.POTION_RING);
			entries.add(PRItems.RING_OF_HASTE);
			entries.add(PRItems.RING_OF_JUMP_BOOST);
			entries.add(PRItems.RING_OF_REGENERATION);
			entries.add(PRItems.RING_OF_SPEED);
			entries.add(PRItems.RING_OF_RESISTANCE);
			entries.add(PRItems.RING_OF_STRENGH);
			if(FabricLoader.getInstance().isModLoaded("sizeshiftingpotions"))
			{
				entries.add(PRItems.RING_OF_SHRINKING);
				entries.add(PRItems.RING_OF_THINNING);
				entries.add(PRItems.RING_OF_WIDENING);
				entries.add(PRItems.RING_OF_GROWING); 
			}});
		LOGGER.info("Potion Ring - REFORGED is Charged !");
	}
}