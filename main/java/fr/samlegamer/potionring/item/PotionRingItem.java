package fr.samlegamer.potionring.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class PotionRingItem extends Item implements ICurioItem
{
	public String eff;
	public boolean isFoil;
	
	public PotionRingItem(Properties p_41383_, String effect, boolean foil)
	{
		super(p_41383_);
		this.eff = effect;
		this.isFoil = foil;
	}
	
	public boolean isFoil(ItemStack p_77636_1_)
	{
	      return isFoil;
	}
	
	@Override
	public void curioTick(String identifier, int index, LivingEntity livingEntity, ItemStack stack)
	{
		switch(eff)
		{
		case "strength":
			if(!livingEntity.hasEffect(MobEffects.DAMAGE_BOOST))
			{
	            MobEffectInstance effectInstance = new MobEffectInstance(MobEffects.DAMAGE_BOOST, Integer.MAX_VALUE, 0, false, false);
	            if(livingEntity.level.isClientSide) effectInstance.getDuration();
	            livingEntity.addEffect(effectInstance);
			}
			break;
		case "speed":
			if(!livingEntity.hasEffect(MobEffects.MOVEMENT_SPEED))
			{
	            MobEffectInstance effectInstance = new MobEffectInstance(MobEffects.MOVEMENT_SPEED, Integer.MAX_VALUE, 0, false, false);
	            if(livingEntity.level.isClientSide) effectInstance.getDuration();
	            livingEntity.addEffect(effectInstance);
			}
			break;
		case "resistance":
			if(!livingEntity.hasEffect(MobEffects.DAMAGE_RESISTANCE))
			{
	            MobEffectInstance effectInstance = new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 0, false, false);
	            if(livingEntity.level.isClientSide) effectInstance.getDuration();
	            livingEntity.addEffect(effectInstance);
			}
			break;
		case "jump":
			if(!livingEntity.hasEffect(MobEffects.JUMP))
			{
	            MobEffectInstance effectInstance = new MobEffectInstance(MobEffects.JUMP, Integer.MAX_VALUE, 0, false, false);
	            if(livingEntity.level.isClientSide) effectInstance.getDuration();
	            livingEntity.addEffect(effectInstance);
			}
			break;
		case "haste":
			if(!livingEntity.hasEffect(MobEffects.DIG_SPEED))
			{
	            MobEffectInstance effectInstance = new MobEffectInstance(MobEffects.DIG_SPEED, Integer.MAX_VALUE, 0, false, false);
	            if(livingEntity.level.isClientSide) effectInstance.getDuration();
	            livingEntity.addEffect(effectInstance);
			}
			break;
		case "regeneration":
			if(!livingEntity.hasEffect(MobEffects.REGENERATION))
			{
	            MobEffectInstance effectInstance = new MobEffectInstance(MobEffects.REGENERATION, Integer.MAX_VALUE, 0, false, false);
	            if(livingEntity.level.isClientSide) effectInstance.getDuration();
	            livingEntity.addEffect(effectInstance);
			}
			break;
		case "none":
			break;
		}
	}

    @Override
    public boolean canUnequip(String identifier, LivingEntity livingEntity, ItemStack stack)
    {
    	switch(eff)
		{
		case "strength":
			if(livingEntity.hasEffect(MobEffects.DAMAGE_BOOST))
			{
				livingEntity.removeEffect(MobEffects.DAMAGE_BOOST);
			}
			break;
		case "speed":
			if(livingEntity.hasEffect(MobEffects.MOVEMENT_SPEED))
			{
				livingEntity.removeEffect(MobEffects.MOVEMENT_SPEED);
			}
			break;
		case "resistance":
			if(livingEntity.hasEffect(MobEffects.DAMAGE_RESISTANCE))
			{
				livingEntity.removeEffect(MobEffects.DAMAGE_RESISTANCE);
			}
			break;
		case "jump":
			if(livingEntity.hasEffect(MobEffects.JUMP))
			{
				livingEntity.removeEffect(MobEffects.JUMP);
			}
			break;
		case "haste":
			if(livingEntity.hasEffect(MobEffects.DIG_SPEED))
			{
				livingEntity.removeEffect(MobEffects.DIG_SPEED);
			}
			break;
		case "regeneration":
			if(livingEntity.hasEffect(MobEffects.REGENERATION))
			{
				livingEntity.removeEffect(MobEffects.REGENERATION);
			}
			break;
		case "none":
			break;
		}
    	    	
    	return eff.toString() != null;
    }
}