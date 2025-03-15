package fr.samlegamer.potionring.item;

import fr.samlegamer.potionring.PotionRing;
import net.minecraft.item.Item;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;

public class PRTagsItemRegistry
{
    public static final Tags.IOptionalNamedTag<Item> POTION_RINGS = ItemTags.createOptional(new ResourceLocation(PotionRing.MODID, "potion_rings"));

    public static void registerTags() {
    }
}
