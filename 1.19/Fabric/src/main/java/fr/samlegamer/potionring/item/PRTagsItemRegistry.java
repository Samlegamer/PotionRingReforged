package fr.samlegamer.potionring.item;

import fr.samlegamer.potionring.PotionRing;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class PRTagsItemRegistry
{
    public static final TagKey<Item> POTION_RINGS = TagKey.of(Registry.ITEM_KEY, new Identifier(PotionRing.MODID, "potion_rings"));

    public static void registerTags() {
    }
}
