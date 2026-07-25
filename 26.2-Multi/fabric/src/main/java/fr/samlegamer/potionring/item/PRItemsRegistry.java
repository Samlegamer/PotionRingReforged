package fr.samlegamer.potionring.item;

import fr.samlegamer.potionring.PotionRing;
import fr.samlegamer.potionring.util.RingAPI;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;
import java.util.LinkedHashMap;
import java.util.Map;

public class PRItemsRegistry
{
	public static void registryVanillaRings()
	{
		LinkedHashMap<String, Holder<MobEffect>> map = PRItemsMap.itemsVanillaMap();
		registerPotionRings("potion_ring", null);
		for(Map.Entry<String, Holder<MobEffect>> entry : map.entrySet())
		{
			String name = entry.getKey();
			Holder<MobEffect> effect = entry.getValue();
			registerPotionRings("ring_of_" + name, effect);
		}
	}

	public static void registryModdedCustom(RingAPI ringAPI)
	{
		LinkedHashMap<String, String> map = PRItemsMap.itemsModdedMap(ringAPI);
		for(Map.Entry<String, String> entry : map.entrySet())
		{
			String mod = entry.getValue();
			String name = entry.getKey();
			PotionRingItemModded potionRingItemModded = new PotionRingItemModded(mod, name);
			registerPotionRingsModded("ring_of_" + name, potionRingItemModded);
		}
	}

	public static void registerPotionRings(String name, Holder<MobEffect> effectRegistryEntry) {
        AbstractPotionRingItem potionRing = new PotionRingItem(name, effectRegistryEntry);
		Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(PotionRing.MODID, name), potionRing);
	}

	public static void registerPotionRingsModded(String name, PotionRingItemModded potionRing) {
		Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(PotionRing.MODID, name), potionRing);
	}
}