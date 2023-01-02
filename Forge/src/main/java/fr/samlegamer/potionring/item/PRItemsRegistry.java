package fr.samlegamer.potionring.item;

import fr.samlegamer.potionring.PotionRing;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PRItemsRegistry
{
	public static final DeferredRegister<Item> ITEMS_REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, PotionRing.MODID);

	private static final Item.Properties PROP_RING = new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_BREWING);
	
	public static final RegistryObject<Item> POTION_RING = ITEMS_REGISTRY.register("potion_ring", () -> new PotionRingItem(PROP_RING, "none", false));
	public static final RegistryObject<Item> RING_OF_REGENERATION = ITEMS_REGISTRY.register("ring_of_regeneration", () -> new PotionRingItem(PROP_RING, "regeneration", true));
	public static final RegistryObject<Item> RING_OF_HASTE = ITEMS_REGISTRY.register("ring_of_haste", () -> new PotionRingItem(PROP_RING, "haste", true));
	public static final RegistryObject<Item> RING_OF_JUMP_BOOST = ITEMS_REGISTRY.register("ring_of_jump_boost", () -> new PotionRingItem(PROP_RING, "jump", true));
	public static final RegistryObject<Item> RING_OF_RESISTANCE = ITEMS_REGISTRY.register("ring_of_resistance", () -> new PotionRingItem(PROP_RING, "resistance", true));
	public static final RegistryObject<Item> RING_OF_SPEED = ITEMS_REGISTRY.register("ring_of_speed", () -> new PotionRingItem(PROP_RING, "speed", true));
	public static final RegistryObject<Item> RING_OF_STRENGH = ITEMS_REGISTRY.register("ring_of_strengh", () -> new PotionRingItem(PROP_RING, "strength", true));

	public static RegistryObject<Item> ring_of_growing, ring_of_shrinking, ring_of_widening, ring_of_thinning;

	public static void addons()
	{
		if(ModList.get().isLoaded("sizeshiftingpotions"))
		{
			PotionRing.log.info("Potion Ring - REFORGED : Charged SizeShiftingPotions Compat");
			ring_of_growing = ITEMS_REGISTRY.register("ring_of_growing", () -> new PotionRingItem(PROP_RING, "growing", true));
			ring_of_shrinking = ITEMS_REGISTRY.register("ring_of_shrinking", () -> new PotionRingItem(PROP_RING, "shrinking", true));
			ring_of_widening = ITEMS_REGISTRY.register("ring_of_widening", () -> new PotionRingItem(PROP_RING, "widening", true));
			ring_of_thinning = ITEMS_REGISTRY.register("ring_of_thinning", () -> new PotionRingItem(PROP_RING, "thinning", true));
		}
		
		if(!ModList.get().isLoaded("sizeshiftingpotions"))
		{
			ring_of_growing = ITEMS_REGISTRY.register("ring_of_growing", () -> new PotionRingItem(new Item.Properties().stacksTo(1), "growing", true));
			ring_of_shrinking = ITEMS_REGISTRY.register("ring_of_shrinking", () -> new PotionRingItem(new Item.Properties().stacksTo(1), "shrinking", true));
			ring_of_widening = ITEMS_REGISTRY.register("ring_of_widening", () -> new PotionRingItem(new Item.Properties().stacksTo(1), "widening", true));
			ring_of_thinning = ITEMS_REGISTRY.register("ring_of_thinning", () -> new PotionRingItem(new Item.Properties().stacksTo(1), "thinning", true));
		}
	}
}