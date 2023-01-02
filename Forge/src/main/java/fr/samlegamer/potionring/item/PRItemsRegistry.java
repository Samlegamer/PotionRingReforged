package fr.samlegamer.potionring.item;

import fr.samlegamer.potionring.PotionRing;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PRItemsRegistry
{
	public static final DeferredRegister<Item> ITEMS_REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, PotionRing.MODID);

	public static final RegistryObject<Item> POTION_RING = ITEMS_REGISTRY.register("potion_ring", () -> new PotionRingItem(new Item.Properties().stacksTo(1), "none", false));
	public static final RegistryObject<Item> RING_OF_REGENERATION = ITEMS_REGISTRY.register("ring_of_regeneration", () -> new PotionRingItem(new Item.Properties().stacksTo(1), "regeneration", true));
	public static final RegistryObject<Item> RING_OF_HASTE = ITEMS_REGISTRY.register("ring_of_haste", () -> new PotionRingItem(new Item.Properties().stacksTo(1), "haste", true));
	public static final RegistryObject<Item> RING_OF_JUMP_BOOST = ITEMS_REGISTRY.register("ring_of_jump_boost", () -> new PotionRingItem(new Item.Properties().stacksTo(1), "jump", true));
	public static final RegistryObject<Item> RING_OF_RESISTANCE = ITEMS_REGISTRY.register("ring_of_resistance", () -> new PotionRingItem(new Item.Properties().stacksTo(1), "resistance", true));
	public static final RegistryObject<Item> RING_OF_SPEED = ITEMS_REGISTRY.register("ring_of_speed", () -> new PotionRingItem(new Item.Properties().stacksTo(1), "speed", true));
	public static final RegistryObject<Item> RING_OF_STRENGH = ITEMS_REGISTRY.register("ring_of_strengh", () -> new PotionRingItem(new Item.Properties().stacksTo(1), "strength", true));
	
	public static final RegistryObject<Item> ring_of_growing = ITEMS_REGISTRY.register("ring_of_growing", () -> new PotionRingItem(new Item.Properties().stacksTo(1), "growing", true));
	public static final RegistryObject<Item> ring_of_shrinking = ITEMS_REGISTRY.register("ring_of_shrinking", () -> new PotionRingItem(new Item.Properties().stacksTo(1), "shrinking", true));
	public static final RegistryObject<Item> ring_of_widening = ITEMS_REGISTRY.register("ring_of_widening", () -> new PotionRingItem(new Item.Properties().stacksTo(1), "widening", true));
	public static final RegistryObject<Item> ring_of_thinning = ITEMS_REGISTRY.register("ring_of_thinning", () -> new PotionRingItem(new Item.Properties().stacksTo(1), "thinning", true));
}