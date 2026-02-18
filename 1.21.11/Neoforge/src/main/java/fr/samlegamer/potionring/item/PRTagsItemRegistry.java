package fr.samlegamer.potionring.item;

import fr.samlegamer.potionring.PotionRing;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class PRTagsItemRegistry
{
    public static final TagKey<Item> POTION_RINGS = ItemTags.create(Identifier.fromNamespaceAndPath(PotionRing.MODID, "potion_rings"));

    public static void registerTags() {
    }
}
