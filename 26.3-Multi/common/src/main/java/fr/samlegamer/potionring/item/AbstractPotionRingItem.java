package fr.samlegamer.potionring.item;

import fr.samlegamer.potionring.PotionRing;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public abstract class AbstractPotionRingItem extends Item
{
	public final Holder<MobEffect> eff;

	public AbstractPotionRingItem(String name, Holder<MobEffect> effect)
	{
		super(new Properties().stacksTo(1).setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(PotionRing.MODID, name))));
		this.eff = effect;
	}

	public boolean isFoil(ItemStack p_77636_1_)
	{
        return false;
    }
}