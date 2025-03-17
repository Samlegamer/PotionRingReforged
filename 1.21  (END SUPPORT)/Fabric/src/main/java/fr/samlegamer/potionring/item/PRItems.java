package fr.samlegamer.potionring.item;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import static fr.samlegamer.potionring.PotionRing.MODID;

import fr.samlegamer.potionring.PotionRing;

public class PRItems
{
	private static final Item.Settings RING = new Item.Settings().maxCount(1);

	public static final Item POTION_RING = new PotionRingItem(RING, EnumEffectTypes.NONE);
	public static final Item RING_OF_REGENERATION = new PotionRingItem(RING, EnumEffectTypes.REGENERATION);
	public static final Item RING_OF_HASTE = new PotionRingItem(RING, EnumEffectTypes.HASTE);
	public static final Item RING_OF_JUMP_BOOST = new PotionRingItem(RING, EnumEffectTypes.JUMP);
	public static final Item RING_OF_RESISTANCE = new PotionRingItem(RING, EnumEffectTypes.RESISTANCE);
	public static final Item RING_OF_SPEED = new PotionRingItem(RING, EnumEffectTypes.SPEED);
	public static final Item RING_OF_STRENGH = new PotionRingItem(RING, EnumEffectTypes.STRENGTH);

	public static Item RING_OF_GROWING;
	public static Item RING_OF_SHRINKING;
	public static Item RING_OF_WIDENING;
	public static Item RING_OF_THINNING;

	public static void moddedCompat()
	{
		if(FabricLoader.getInstance().isModLoaded("sizeshiftingpotions"))
		{
			PotionRing.LOGGER.info("Size Shifting Potions Compat is Charged !");
			RING_OF_GROWING = new PotionRingItem(RING, EnumEffectTypes.GROWING);
			RING_OF_SHRINKING = new PotionRingItem(RING, EnumEffectTypes.SHRINKING);
			RING_OF_WIDENING = new PotionRingItem(RING, EnumEffectTypes.WIDENING);
			RING_OF_THINNING = new PotionRingItem(RING, EnumEffectTypes.THINNING);
		}
		else
		{
			RING_OF_GROWING = new PotionRingItem(RING, EnumEffectTypes.NONE);
			RING_OF_SHRINKING = new PotionRingItem(RING, EnumEffectTypes.NONE);
			RING_OF_WIDENING = new PotionRingItem(RING, EnumEffectTypes.NONE);
			RING_OF_THINNING = new PotionRingItem(RING, EnumEffectTypes.NONE);
		}
	}
	
	public static void registry()
	{
		Registry.register(Registries.ITEM, Identifier.of(MODID, "potion_ring"), POTION_RING);
		Registry.register(Registries.ITEM, Identifier.of(MODID, "ring_of_regeneration"), RING_OF_REGENERATION);
		Registry.register(Registries.ITEM, Identifier.of(MODID, "ring_of_haste"), RING_OF_HASTE);
		Registry.register(Registries.ITEM, Identifier.of(MODID, "ring_of_jump_boost"), RING_OF_JUMP_BOOST);
		Registry.register(Registries.ITEM, Identifier.of(MODID, "ring_of_resistance"), RING_OF_RESISTANCE);
		Registry.register(Registries.ITEM, Identifier.of(MODID, "ring_of_speed"), RING_OF_SPEED);
		Registry.register(Registries.ITEM, Identifier.of(MODID, "ring_of_strengh"), RING_OF_STRENGH);
		Registry.register(Registries.ITEM, Identifier.of(MODID, "ring_of_growing"), RING_OF_GROWING);
		Registry.register(Registries.ITEM, Identifier.of(MODID, "ring_of_shrinking"), RING_OF_SHRINKING);
		Registry.register(Registries.ITEM, Identifier.of(MODID, "ring_of_widening"), RING_OF_WIDENING);
		Registry.register(Registries.ITEM, Identifier.of(MODID, "ring_of_thinning"), RING_OF_THINNING);
	}
}