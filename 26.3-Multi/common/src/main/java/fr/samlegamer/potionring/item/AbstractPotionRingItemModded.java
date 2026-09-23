package fr.samlegamer.potionring.item;

import fr.samlegamer.potionring.PotionRing;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public abstract class AbstractPotionRingItemModded extends Item
{
	protected final String mod;
	protected final String name;

	public AbstractPotionRingItemModded(String mod, String name) {
		super(new Properties().stacksTo(1).setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(PotionRing.MODID, "ring_of_"+name))));
		this.mod = mod;
		this.name = name;
	}

	public boolean isFoil(ItemStack p_77636_1_)
	{
        return false;
    }
}