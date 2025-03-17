package fr.samlegamer.potionring.item;

import fr.samlegamer.potionring.PotionRing;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class PRTagsItemRegistry
{
    public static final TagKey<Item> POTION_RINGS = ItemTags.create(new ResourceLocation(PotionRing.MODID, "potion_rings"));

    public static void registerTags() {
    }
}
