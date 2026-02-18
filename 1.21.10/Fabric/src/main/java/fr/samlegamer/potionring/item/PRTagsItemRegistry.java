package fr.samlegamer.potionring.item;

import fr.samlegamer.potionring.PotionRing;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class PRTagsItemRegistry
{
    public static final TagKey<Item> POTION_RINGS = TagKey.of(RegistryKeys.ITEM, Identifier.of(PotionRing.MODID, "potion_rings"));

    public static void registerTags() {
    }
}
