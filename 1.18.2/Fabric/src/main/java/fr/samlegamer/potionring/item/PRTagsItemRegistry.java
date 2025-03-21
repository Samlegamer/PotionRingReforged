package fr.samlegamer.potionring.item;

import fr.samlegamer.potionring.PotionRing;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;

public class PRTagsItemRegistry
{
    public static final TagKey<Item> POTION_RINGS = ItemTags.create(new ResourceLocation(PotionRing.MODID, "potion_rings"));

    public static void registerTags() {
    }
}
