package fr.samlegamer.potionring.item;

import eu.pb4.trinkets.api.TrinketSlotAccess;
import eu.pb4.trinkets.api.callback.TrinketCallback;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import static fr.samlegamer.potionring.PotionRingFabric.RING_API_FABRIC;
import static fr.samlegamer.potionring.util.PRFunc.reloadMobEffect;
import static fr.samlegamer.potionring.util.PRFunc.AddMobEffect;
import static fr.samlegamer.potionring.util.PRFunc.DeleteMobEffect;

public class PotionRingItem extends AbstractPotionRingItem implements TrinketCallback
{
	public PotionRingItem(String name, Holder<MobEffect> effect)
	{
		super(name, effect);
	}

	@Override
	public void tick(ItemStack stack, TrinketSlotAccess slot, LivingEntity livingEntity)
	{
		if(eff != null)
		{
			reloadMobEffect(RING_API_FABRIC, livingEntity, eff, this);
		}
	}
	
	@Override
	public void onEquip(ItemStack stack, TrinketSlotAccess slot, LivingEntity livingEntity)
	{
		if(eff != null)
		{
			AddMobEffect(RING_API_FABRIC, livingEntity, eff, this);
		}
	}

	@Override
	public void onUnequip(ItemStack stack, TrinketSlotAccess slot, LivingEntity livingEntity)
    {
		if(eff != null)
		{
			DeleteMobEffect(livingEntity, eff);
		}
    }
}