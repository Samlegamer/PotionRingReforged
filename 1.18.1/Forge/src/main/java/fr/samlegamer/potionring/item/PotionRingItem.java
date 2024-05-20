package fr.samlegamer.potionring.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class PotionRingItem extends Item implements ICurioItem
{
	public PRTypes eff;
	public boolean isFoil;
	
	public PotionRingItem(Properties p_41383_, PRTypes effect)
	{
		super(p_41383_);
		this.eff = effect;
		
	}
	
	public boolean isFoil(ItemStack p_77636_1_)
	{
		if(eff != PRTypes.none)
		{
			return true;
		}
	    return false;
	}
	
	@Override
	public void curioTick(String identifier, int index, LivingEntity livingEntity, ItemStack stack)
	{
		switch(eff)
		{
		case strength:			
			reloadEffect(livingEntity, MobEffects.DAMAGE_BOOST);
			break;
		case speed:
			reloadEffect(livingEntity, MobEffects.MOVEMENT_SPEED);
			break;
		case resistance:
			reloadEffect(livingEntity, MobEffects.DAMAGE_RESISTANCE);
			break;
		case jump:
			reloadEffect(livingEntity, MobEffects.JUMP);
			break;
		case haste:
			reloadEffect(livingEntity, MobEffects.DIG_SPEED);
			break;
		case regeneration:
			reloadEffect(livingEntity, MobEffects.REGENERATION);
			break;
		default:
			break;
		}
	}
	
	@Override
	public void onEquip(String identifier, int index, LivingEntity livingEntity, ItemStack stack)
	{
		switch(eff)
		{
		case strength:			
			AddEffect(livingEntity, MobEffects.DAMAGE_BOOST);
			break;
		case speed:
			AddEffect(livingEntity, MobEffects.MOVEMENT_SPEED);
			break;
		case resistance:
			AddEffect(livingEntity, MobEffects.DAMAGE_RESISTANCE);
			break;
		case jump:
			AddEffect(livingEntity, MobEffects.JUMP);
			break;
		case haste:
			AddEffect(livingEntity, MobEffects.DIG_SPEED);
			break;
		case regeneration:
			AddEffect(livingEntity, MobEffects.REGENERATION);
			break;
		default:
			break;
		}
	}

    @Override
    public boolean canUnequip(String identifier, LivingEntity livingEntity, ItemStack stack)
    {
    	switch(eff)
		{
		case strength:
			DeleteEffect(livingEntity, MobEffects.DAMAGE_BOOST);
			break;
		case speed:
			DeleteEffect(livingEntity, MobEffects.MOVEMENT_SPEED);
			break;
		case resistance:
			DeleteEffect(livingEntity, MobEffects.DAMAGE_RESISTANCE);
			break;
		case jump:
			DeleteEffect(livingEntity, MobEffects.JUMP);
			break;
		case haste:
			DeleteEffect(livingEntity, MobEffects.DIG_SPEED);
			break;
		case regeneration:
			DeleteEffect(livingEntity, MobEffects.REGENERATION);
			break;
		default:
			break;
		}
    	    	
    	return eff.toString() != null;
    }
    
    private void AddEffect(LivingEntity livingEntity, MobEffect mbEff)
    {
    	if(!livingEntity.hasEffect(mbEff))
		{
    		MobEffectInstance effectInstance = new MobEffectInstance(mbEff, 240, 0, false, false);
            if(livingEntity.level.isClientSide) effectInstance.getDuration();
            livingEntity.addEffect(effectInstance);
		}
		else if(CuriosApi.getCuriosHelper().findCurios(livingEntity, this).size() == 2)
		{
			MobEffectInstance effectInstance = new MobEffectInstance(mbEff, 240, 1, true, false);
            if(livingEntity.level.isClientSide) effectInstance.getDuration();
            livingEntity.addEffect(effectInstance);
		}
    }
    
    private void reloadEffect(LivingEntity livingEntity, MobEffect mbEff)
	{
    	int baseDuration = 240;
	    int newDuration1 = baseDuration;
	    int newDuration2 = baseDuration;

	    if (livingEntity.hasEffect(mbEff)) {
	    	MobEffectInstance currentEffect = livingEntity.getEffect(mbEff);
	        int currentDuration = currentEffect.getDuration();

	        if (CuriosApi.getCuriosHelper().findCurios(livingEntity, this).size() == 1) {
	            newDuration1 += currentDuration;
	        } else if (CuriosApi.getCuriosHelper().findCurios(livingEntity, this).size() == 2) {
	            newDuration2 += currentDuration;
	        }
	    }

	    MobEffectInstance effA1 = new MobEffectInstance(mbEff, newDuration1, 0, false, false);
	    MobEffectInstance effA2 = new MobEffectInstance(mbEff, newDuration2, 1, false, false);

	    if (CuriosApi.getCuriosHelper().findCurios(livingEntity, this).size() == 1) {
	        livingEntity.addEffect(effA1);
	    } else if (CuriosApi.getCuriosHelper().findCurios(livingEntity, this).size() == 2) {
	        livingEntity.addEffect(effA2);
	    }
	}
    
    private void DeleteEffect(LivingEntity livingEntity, MobEffect mbEff)
    {
    	if(livingEntity.hasEffect(mbEff))
		{
			livingEntity.removeEffect(mbEff);
		}
    }
}