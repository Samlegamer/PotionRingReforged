package fr.samlegamer.potionring.items;

import fr.samlegamer.potionring.PotionRing;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class PRItemsRegistry
{
	public static final DeferredRegister<Item> ITEMS_REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, PotionRing.MODID);

	public static final RegistryObject<Item> POTION_RING = ITEMS_REGISTRY.register("potion_ring", () -> new PotionRingItem(new Item.Properties().stacksTo(1).tab(ItemGroup.TAB_BREWING)));
	public static final RegistryObject<Item> RING_OF_REGENERATION = ITEMS_REGISTRY.register("ring_of_regeneration", () -> new RingOfRegenerationItem(new Item.Properties().stacksTo(1).tab(ItemGroup.TAB_BREWING)));
	public static final RegistryObject<Item> RING_OF_HASTE = ITEMS_REGISTRY.register("ring_of_haste", () -> new RingOfHasteItem(new Item.Properties().stacksTo(1).tab(ItemGroup.TAB_BREWING)));
	public static final RegistryObject<Item> RING_OF_JUMP_BOOST = ITEMS_REGISTRY.register("ring_of_jump_boost", () -> new RingOfJumpBoostItem(new Item.Properties().stacksTo(1).tab(ItemGroup.TAB_BREWING)));
	public static final RegistryObject<Item> RING_OF_RESISTANCE = ITEMS_REGISTRY.register("ring_of_resistance", () -> new RingOfResistanceItem(new Item.Properties().stacksTo(1).tab(ItemGroup.TAB_BREWING)));
	public static final RegistryObject<Item> RING_OF_SPEED = ITEMS_REGISTRY.register("ring_of_speed", () -> new RingOfSpeedItem(new Item.Properties().stacksTo(1).tab(ItemGroup.TAB_BREWING)));
	public static final RegistryObject<Item> RING_OF_STRENGH = ITEMS_REGISTRY.register("ring_of_strengh", () -> new RingOfStrenghItem(new Item.Properties().stacksTo(1).tab(ItemGroup.TAB_BREWING)));
}