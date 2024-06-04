package fr.samlegamer.potionring;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.loader.api.QuiltLoader;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import fr.samlegamer.potionring.item.PRItems;

public class PotionRing implements ModInitializer
{
	public static final String MODID = "potionring";
	public static final Logger LOGGER = LoggerFactory.getLogger("potionring");

	@Override
	public void onInitialize(ModContainer mod)
	{
		PRItems.moddedCompat();
		PRItems.registry();
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINKS).register(entries -> { 
			entries.addItem(PRItems.POTION_RING);
			entries.addItem(PRItems.RING_OF_HASTE);
			entries.addItem(PRItems.RING_OF_JUMP_BOOST);
			entries.addItem(PRItems.RING_OF_REGENERATION);
			entries.addItem(PRItems.RING_OF_SPEED);
			entries.addItem(PRItems.RING_OF_RESISTANCE);
			entries.addItem(PRItems.RING_OF_STRENGH);
			if(QuiltLoader.isModLoaded("sizeshiftingpotions"))
			{
				entries.addItem(PRItems.RING_OF_SHRINKING);
				entries.addItem(PRItems.RING_OF_THINNING);
				entries.addItem(PRItems.RING_OF_WIDENING);
				entries.addItem(PRItems.RING_OF_GROWING); 
			}});
		LOGGER.info("Potion Ring - REFORGED is Charged !");
	}
}
