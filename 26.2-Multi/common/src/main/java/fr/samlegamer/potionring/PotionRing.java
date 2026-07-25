package fr.samlegamer.potionring;

import fr.samlegamer.potionring.item.PRItemsMap;
import fr.samlegamer.potionring.util.RingAPI;
import net.minecraft.world.item.Item;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.LinkedList;
import java.util.List;

import static fr.samlegamer.potionring.util.PRFunc.ringSearch;
import static fr.samlegamer.potionring.util.PRFunc.ringSearchModded;

public class PotionRing
{
	public static final String MODID = "potionring";
	public static final Logger log = LogManager.getLogger();

	public static void finishLog()
	{
		log.info("Potion Rings - REFORGED is Charged");
	}

	public static Item[] itemInTab(RingAPI ringAPI)
	{
        List<Item> items = new LinkedList<>(List.of(
                ringSearch("potion_ring"),
                ringSearch("ring_of_haste"),
                ringSearch("ring_of_jump_boost"),
                ringSearch("ring_of_resistance"),
                ringSearch("ring_of_speed"),
                ringSearch("ring_of_strength"),
                ringSearch("ring_of_regeneration"),
                ringSearch("ring_of_fire_resistance"),
                ringSearch("ring_of_invisibility"),
                ringSearch("ring_of_slowness"),
                ringSearch("ring_of_mining_fatigue"),
                ringSearch("ring_of_nausea"),
                ringSearch("ring_of_blindness"),
                ringSearch("ring_of_hunger"),
                ringSearch("ring_of_saturation"),
                ringSearch("ring_of_night_vision"),
                ringSearch("ring_of_poison"),
                ringSearch("ring_of_water_breathing"),
                ringSearch("ring_of_weakness"),
                ringSearch("ring_of_wither"),
                ringSearch("ring_of_glowing"),
                ringSearch("ring_of_levitation"),
                ringSearch("ring_of_luck"),
                ringSearch("ring_of_unluck"),
                ringSearch("ring_of_slow_falling"),
                ringSearch("ring_of_conduit_power"),
                ringSearch("ring_of_dolphins_grace"),
                ringSearch("ring_of_darkness")));

		if(ringAPI.isLoaded("sizeshiftingpotions"))
		{
			items.add(ringSearchModded("ring_of_growing"));
			items.add(ringSearchModded("ring_of_shrinking"));
			items.add(ringSearchModded("ring_of_thinning"));
			items.add(ringSearchModded("ring_of_widening"));
		}

		List<String> list = PRItemsMap.createNewFileOrLearn(ringAPI.configDir()).keySet().stream().toList();

		if(!list.isEmpty()) {
			for (String s : list) {
				String[] parts = s.split(":");
				if (parts.length == 2) {
					final String mod = parts[0];
					final String id = parts[1];
					final Item itemModded = ringSearchModded("ring_of_"+id);

					if(ringAPI.isLoaded(mod))
					{
						items.add(itemModded);
					}
				}
			}
		}

		Item[] array = new Item[items.size()];
		return items.toArray(array);
	}
}