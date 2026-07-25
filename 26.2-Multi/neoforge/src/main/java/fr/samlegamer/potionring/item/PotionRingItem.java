package fr.samlegamer.potionring.item;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;
import static fr.samlegamer.potionring.PotionRingNeoForge.RING_API_NEO_FORGE;
import static fr.samlegamer.potionring.util.PRFunc.reloadMobEffect;
import static fr.samlegamer.potionring.util.PRFunc.AddMobEffect;
import static fr.samlegamer.potionring.util.PRFunc.DeleteMobEffect;

public class PotionRingItem extends AbstractPotionRingItem implements ICurioItem
{
	public PotionRingItem(String name, Holder<MobEffect> effect)
	{
		super(name, effect);
	}

	@Override
	public boolean isCombineRepairable(ItemStack stack) {
		return stack.getItem() == Items.GOLD_INGOT;
	}

	@Override
	public boolean canGrindstoneRepair(@NotNull ItemStack stack) {
		return true;
	}

	@Override
	public void curioTick(SlotContext slotContext, ItemStack stack)
	{
		if(eff != null)
		{
			reloadMobEffect(RING_API_NEO_FORGE, slotContext.entity(), eff, this);
		}
	}
	
	@Override
	public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack)
	{
		if(eff != null)
		{
			AddMobEffect(RING_API_NEO_FORGE, slotContext.entity(), eff, this);
		}
	}

    @Override
    public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack)
    {
		if(eff != null)
		{
			DeleteMobEffect(slotContext.entity(), eff);
		}
    }
}