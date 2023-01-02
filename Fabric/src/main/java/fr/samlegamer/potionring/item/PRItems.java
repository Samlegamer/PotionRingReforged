package fr.samlegamer.potionring.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import static fr.samlegamer.potionring.PotionRing.MODID;

public class PRItems
{
	public static final Item POTION_RING = new PotionRingItem(new Item.Settings().maxCount(1), EnumEffectTypes.NONE, false);
	public static final Item RING_OF_REGENERATION = new PotionRingItem(new Item.Settings().maxCount(1), EnumEffectTypes.REGENERATION, true);
	public static final Item RING_OF_HASTE = new PotionRingItem(new Item.Settings().maxCount(1), EnumEffectTypes.HASTE, true);
	public static final Item RING_OF_JUMP_BOOST = new PotionRingItem(new Item.Settings().maxCount(1), EnumEffectTypes.JUMP, true);
	public static final Item RING_OF_RESISTANCE = new PotionRingItem(new Item.Settings().maxCount(1), EnumEffectTypes.RESISTANCE, true);
	public static final Item RING_OF_SPEED = new PotionRingItem(new Item.Settings().maxCount(1), EnumEffectTypes.SPEED, true);
	public static final Item RING_OF_STRENGH = new PotionRingItem(new Item.Settings().maxCount(1), EnumEffectTypes.STRENGTH, true);

	//Sizeshiftingpotions Compat
	public static final Item RING_OF_GROWING = new PotionRingItem(new Item.Settings().maxCount(1), EnumEffectTypes.GROWING, true);
	public static final Item RING_OF_SHRINKING = new PotionRingItem(new Item.Settings().maxCount(1), EnumEffectTypes.SHRINKING, true);
	public static final Item RING_OF_WIDENING = new PotionRingItem(new Item.Settings().maxCount(1), EnumEffectTypes.WIDENING, true);
	public static final Item RING_OF_THINNING = new PotionRingItem(new Item.Settings().maxCount(1), EnumEffectTypes.THINNING, true);
	
	public static void registry()
	{
		Registry.register(Registries.ITEM, new Identifier(MODID, "potion_ring"), POTION_RING);
		Registry.register(Registries.ITEM, new Identifier(MODID, "ring_of_regeneration"), RING_OF_REGENERATION);
		Registry.register(Registries.ITEM, new Identifier(MODID, "ring_of_haste"), RING_OF_HASTE);
		Registry.register(Registries.ITEM, new Identifier(MODID, "ring_of_jump_boost"), RING_OF_JUMP_BOOST);
		Registry.register(Registries.ITEM, new Identifier(MODID, "ring_of_resistance"), RING_OF_RESISTANCE);
		Registry.register(Registries.ITEM, new Identifier(MODID, "ring_of_speed"), RING_OF_SPEED);
		Registry.register(Registries.ITEM, new Identifier(MODID, "ring_of_strengh"), RING_OF_STRENGH);
		Registry.register(Registries.ITEM, new Identifier(MODID, "ring_of_growing"), RING_OF_GROWING);
		Registry.register(Registries.ITEM, new Identifier(MODID, "ring_of_shrinking"), RING_OF_SHRINKING);
		Registry.register(Registries.ITEM, new Identifier(MODID, "ring_of_widening"), RING_OF_WIDENING);
		Registry.register(Registries.ITEM, new Identifier(MODID, "ring_of_thinning"), RING_OF_THINNING);
	}
}