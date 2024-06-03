package fr.samlegamer.potionring.item;

import fr.samlegamer.potionring.PotionRing;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class PRItemsRegistry
{
	public static final DeferredRegister.Items ITEMS_REGISTRY = DeferredRegister.createItems(PotionRing.MODID);

	public static final Item.Properties RING = new Item.Properties().stacksTo(1);
	
	public static final DeferredItem<Item> POTION_RING = ITEMS_REGISTRY.register("potion_ring", () -> new PotionRingItem(RING, PRTypes.none));
	public static final DeferredItem<Item> RING_OF_REGENERATION = ITEMS_REGISTRY.register("ring_of_regeneration", () -> new PotionRingItem(RING, PRTypes.regeneration));
	public static final DeferredItem<Item> RING_OF_HASTE = ITEMS_REGISTRY.register("ring_of_haste", () -> new PotionRingItem(RING, PRTypes.haste));
	public static final DeferredItem<Item> RING_OF_JUMP_BOOST = ITEMS_REGISTRY.register("ring_of_jump_boost", () -> new PotionRingItem(RING, PRTypes.jump));
	public static final DeferredItem<Item> RING_OF_RESISTANCE = ITEMS_REGISTRY.register("ring_of_resistance", () -> new PotionRingItem(RING, PRTypes.resistance));
	public static final DeferredItem<Item> RING_OF_SPEED = ITEMS_REGISTRY.register("ring_of_speed", () -> new PotionRingItem(RING, PRTypes.speed));
	public static final DeferredItem<Item> RING_OF_STRENGH = ITEMS_REGISTRY.register("ring_of_strengh", () -> new PotionRingItem(RING, PRTypes.strength));

	/*public static RegistryObject<Item> ring_of_growing, ring_of_shrinking, ring_of_widening, ring_of_thinning;

	public static void addons()
	{
		if(ModList.get().isLoaded("sizeshiftingpotions"))
		{
			PotionRing.log.info("Potion Ring - REFORGED : Charged SizeShiftingPotions Compat");
			ring_of_growing = ITEMS_REGISTRY.register("ring_of_growing", () -> new PotionRingItem(RING, PRTypes.growing));
			ring_of_shrinking = ITEMS_REGISTRY.register("ring_of_shrinking", () -> new PotionRingItem(RING, PRTypes.shrinking));
			ring_of_widening = ITEMS_REGISTRY.register("ring_of_widening", () -> new PotionRingItem(RING, PRTypes.widening));
			ring_of_thinning = ITEMS_REGISTRY.register("ring_of_thinning", () -> new PotionRingItem(RING, PRTypes.thinning));
		}
		else
		{
			ring_of_growing = ITEMS_REGISTRY.register("ring_of_growing", () -> new PotionRingItem(new Item.Properties().stacksTo(1), PRTypes.none));
			ring_of_shrinking = ITEMS_REGISTRY.register("ring_of_shrinking", () -> new PotionRingItem(new Item.Properties().stacksTo(1), PRTypes.none));
			ring_of_widening = ITEMS_REGISTRY.register("ring_of_widening", () -> new PotionRingItem(new Item.Properties().stacksTo(1), PRTypes.none));
			ring_of_thinning = ITEMS_REGISTRY.register("ring_of_thinning", () -> new PotionRingItem(new Item.Properties().stacksTo(1), PRTypes.none));
		}
	}*/
}