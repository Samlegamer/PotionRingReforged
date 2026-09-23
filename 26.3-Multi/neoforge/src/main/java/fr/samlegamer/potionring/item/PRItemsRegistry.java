package fr.samlegamer.potionring.item;

import fr.samlegamer.potionring.PotionRing;
import fr.samlegamer.potionring.util.RingAPI;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.neoforged.neoforge.registries.DeferredRegister;
import java.util.LinkedHashMap;
import java.util.Map;

public class PRItemsRegistry
{
	public static final DeferredRegister.Items ITEMS_REGISTRY = DeferredRegister.createItems(PotionRing.MODID);

	public static void registryVanillaRings()
	{
		LinkedHashMap<String, Holder<MobEffect>> map = PRItemsMap.itemsVanillaMap();
		ITEMS_REGISTRY.register("potion_ring", () -> new PotionRingItem("potion_ring", null));
		for(Map.Entry<String, Holder<MobEffect>> entry : map.entrySet())
		{
			String name = entry.getKey();
			Holder<MobEffect> effect = entry.getValue();
			ITEMS_REGISTRY.register("ring_of_"+name, () -> new PotionRingItem("ring_of_"+name, effect));
		}
	}

	public static void registryModdedCustom(RingAPI ringAPI)
	{
		LinkedHashMap<String, String> map = PRItemsMap.itemsModdedMap(ringAPI);
		for(Map.Entry<String, String> entry : map.entrySet())
		{
			String mod = entry.getValue();
			String name = entry.getKey();
			ITEMS_REGISTRY.register("ring_of_" + name, () -> new PotionRingItemModded(mod, name));
		}
	}
}