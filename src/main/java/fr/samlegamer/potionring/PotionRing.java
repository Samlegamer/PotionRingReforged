package fr.samlegamer.potionring;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import fr.samlegamer.potionring.item.PRItems;

public class PotionRing implements ModInitializer
{
	public static final Logger LOGGER = LoggerFactory.getLogger("potionring");
	public static final String MODID = "potionring";
	 	
	@Override
	public void onInitialize()
	{
		PRItems.registry();
		LOGGER.info("Potion Ring - REFORGED is Charged !");
	}
}
