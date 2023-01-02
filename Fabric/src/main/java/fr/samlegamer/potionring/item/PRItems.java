package fr.samlegamer.potionring.item;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import static fr.samlegamer.potionring.PotionRing.MODID;

public class PRItems
{
	public static final Item POTION_RING = new PotionRingItem(new Item.Settings().maxCount(1).group(ItemGroup.BREWING), EnumEffectTypes.NONE, false);
	public static final Item RING_OF_REGENERATION = new PotionRingItem(new Item.Settings().maxCount(1).group(ItemGroup.BREWING), EnumEffectTypes.REGENERATION, true);
	public static final Item RING_OF_HASTE = new PotionRingItem(new Item.Settings().maxCount(1).group(ItemGroup.BREWING), EnumEffectTypes.HASTE, true);
	public static final Item RING_OF_JUMP_BOOST = new PotionRingItem(new Item.Settings().maxCount(1).group(ItemGroup.BREWING), EnumEffectTypes.JUMP, true);
	public static final Item RING_OF_RESISTANCE = new PotionRingItem(new Item.Settings().maxCount(1).group(ItemGroup.BREWING), EnumEffectTypes.RESISTANCE, true);
	public static final Item RING_OF_SPEED = new PotionRingItem(new Item.Settings().maxCount(1).group(ItemGroup.BREWING), EnumEffectTypes.SPEED, true);
	public static final Item RING_OF_STRENGH = new PotionRingItem(new Item.Settings().maxCount(1).group(ItemGroup.BREWING), EnumEffectTypes.STRENGTH, true);

	//Modded
	public static Item RING_OF_GROWING;
	public static Item RING_OF_SHRINKING;
	public static Item RING_OF_WIDENING;
	public static Item RING_OF_THINNING;

	public static void moddedCompat()
	{
		if(FabricLoader.getInstance().isModLoaded("sizeshiftingpotions"))
		{
			RING_OF_GROWING = new PotionRingItem(new Item.Settings().maxCount(1).group(ItemGroup.BREWING), EnumEffectTypes.GROWING, true);
			RING_OF_SHRINKING = new PotionRingItem(new Item.Settings().maxCount(1).group(ItemGroup.BREWING), EnumEffectTypes.SHRINKING, true);
			RING_OF_WIDENING = new PotionRingItem(new Item.Settings().maxCount(1).group(ItemGroup.BREWING), EnumEffectTypes.WIDENING, true);
			RING_OF_THINNING = new PotionRingItem(new Item.Settings().maxCount(1).group(ItemGroup.BREWING), EnumEffectTypes.THINNING, true);
		}
		
		if(!FabricLoader.getInstance().isModLoaded("sizeshiftingpotions"))
		{
			RING_OF_GROWING = new PotionRingItem(new Item.Settings().maxCount(1), EnumEffectTypes.GROWING, true);
			RING_OF_SHRINKING = new PotionRingItem(new Item.Settings().maxCount(1), EnumEffectTypes.SHRINKING, true);
			RING_OF_WIDENING = new PotionRingItem(new Item.Settings().maxCount(1), EnumEffectTypes.WIDENING, true);
			RING_OF_THINNING = new PotionRingItem(new Item.Settings().maxCount(1), EnumEffectTypes.THINNING, true);
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