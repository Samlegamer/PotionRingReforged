package fr.samlegamer.potionring.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class RingOfSpeedItem extends Item implements ICurioItem
{
	public RingOfSpeedItem(Properties p_i48487_1_)
	{
		super(p_i48487_1_);
	}
	
	public boolean isFoil(ItemStack p_77636_1_)
	{
	      return true;
	}
	
	@Override
	public void curioTick(String identifier, int index, LivingEntity livingEntity, ItemStack stack)
	{
		
		if(!livingEntity.hasEffect(Effects.MOVEMENT_SPEED)) {
            EffectInstance effectInstance = new EffectInstance(Effects.MOVEMENT_SPEED, Integer.MAX_VALUE, 0, false, false);
            if(livingEntity.level.isClientSide) effectInstance.getDuration();
            livingEntity.addEffect(effectInstance);
		}
	}

    @Override
    public boolean canUnequip(String identifier, LivingEntity livingEntity, ItemStack stack)
    {
    	return livingEntity.removeEffect(Effects.MOVEMENT_SPEED);
    }
}