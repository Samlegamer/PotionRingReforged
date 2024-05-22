package fr.samlegamer.potionring.item;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import static fr.samlegamer.potionring.PotionRing.MODID;

import fr.samlegamer.potionring.PotionRing;

public class PRItems
{
	public static final Item POTION_RING = new PotionRingItem(new Item.Settings().maxCount(1).group(ItemGroup.BREWING), EnumEffectTypes.NONE);
	public static final Item RING_OF_REGENERATION = new PotionRingItem(new Item.Settings().maxCount(1).group(ItemGroup.BREWING), EnumEffectTypes.REGENERATION);
	public static final Item RING_OF_HASTE = new PotionRingItem(new Item.Settings().maxCount(1).group(ItemGroup.BREWING), EnumEffectTypes.HASTE);
	public static final Item RING_OF_JUMP_BOOST = new PotionRingItem(new Item.Settings().maxCount(1).group(ItemGroup.BREWING), EnumEffectTypes.JUMP);
	public static final Item RING_OF_RESISTANCE = new PotionRingItem(new Item.Settings().maxCount(1).group(ItemGroup.BREWING), EnumEffectTypes.RESISTANCE);
	public static final Item RING_OF_SPEED = new PotionRingItem(new Item.Settings().maxCount(1).group(ItemGroup.BREWING), EnumEffectTypes.SPEED);
	public static final Item RING_OF_STRENGH = new PotionRingItem(new Item.Settings().maxCount(1).group(ItemGroup.BREWING), EnumEffectTypes.STRENGTH);

	//Modded
	public static Item RING_OF_GROWING;
	public static Item RING_OF_SHRINKING;
	public static Item RING_OF_WIDENING;
	public static Item RING_OF_THINNING;

	public static void moddedCompat()
	{
		if(FabricLoader.getInstance().isModLoaded("sizeshiftingpotions"))
		{
			PotionRing.LOGGER.info("Size Shifting Potions Compat is Charged !");
			RING_OF_GROWING = new PotionRingItem(new Item.Settings().maxCount(1).group(ItemGroup.BREWING), EnumEffectTypes.GROWING);
			RING_OF_SHRINKING = new PotionRingItem(new Item.Settings().maxCount(1).group(ItemGroup.BREWING), EnumEffectTypes.SHRINKING);
			RING_OF_WIDENING = new PotionRingItem(new Item.Settings().maxCount(1).group(ItemGroup.BREWING), EnumEffectTypes.WIDENING);
			RING_OF_THINNING = new PotionRingItem(new Item.Settings().maxCount(1).group(ItemGroup.BREWING), EnumEffectTypes.THINNING);
		}
		else
		{
			RING_OF_GROWING = new PotionRingItem(new Item.Settings().maxCount(1), EnumEffectTypes.NONE);
			RING_OF_SHRINKING = new PotionRingItem(new Item.Settings().maxCount(1), EnumEffectTypes.NONE);
			RING_OF_WIDENING = new PotionRingItem(new Item.Settings().maxCount(1), EnumEffectTypes.NONE);
			RING_OF_THINNING = new PotionRingItem(new Item.Settings().maxCount(1), EnumEffectTypes.NONE);
		}
	}
	
	public static void registry()
	{
		Registry.register(Registry.ITEM, new Identifier(MODID, "potion_ring"), POTION_RING);
		Registry.register(Registry.ITEM, new Identifier(MODID, "ring_of_regeneration"), RING_OF_REGENERATION);
		Registry.register(Registry.ITEM, new Identifier(MODID, "ring_of_haste"), RING_OF_HASTE);
		Registry.register(Registry.ITEM, new Identifier(MODID, "ring_of_jump_boost"), RING_OF_JUMP_BOOST);
		Registry.register(Registry.ITEM, new Identifier(MODID, "ring_of_resistance"), RING_OF_RESISTANCE);
		Registry.register(Registry.ITEM, new Identifier(MODID, "ring_of_speed"), RING_OF_SPEED);
		Registry.register(Registry.ITEM, new Identifier(MODID, "ring_of_strengh"), RING_OF_STRENGH);
		
		Registry.register(Registry.ITEM, new Identifier(MODID, "ring_of_growing"), RING_OF_GROWING);
		Registry.register(Registry.ITEM, new Identifier(MODID, "ring_of_shrinking"), RING_OF_SHRINKING);
		Registry.register(Registry.ITEM, new Identifier(MODID, "ring_of_widening"), RING_OF_WIDENING);
		Registry.register(Registry.ITEM, new Identifier(MODID, "ring_of_thinning"), RING_OF_THINNING);
	}
}