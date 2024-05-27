package fr.samlegamer.potionring.item;

import fr.samlegamer.potionring.PotionRing;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class PotionRingItem extends Item implements ICurioItem
{
	public PRTypes eff;
	
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
	public void curioTick(SlotContext slotContext, ItemStack stack)
	{
		switch(eff)
		{
		case strength:			
			reloadEffect(slotContext.entity(), MobEffects.DAMAGE_BOOST);
			break;
		case speed:
			reloadEffect(slotContext.entity(), MobEffects.MOVEMENT_SPEED);
			break;
		case resistance:
			reloadEffect(slotContext.entity(), MobEffects.DAMAGE_RESISTANCE);
			break;
		case jump:
			reloadEffect(slotContext.entity(), MobEffects.JUMP);
			break;
		case haste:
			reloadEffect(slotContext.entity(), MobEffects.DIG_SPEED);
			break;
		case regeneration:
			reloadEffect(slotContext.entity(), MobEffects.REGENERATION);
			break;
		case growing:
			reloadEffect(slotContext.entity(), Holder.direct(PotionRing.growing.get()));
			break;
		case shrinking:
			reloadEffect(slotContext.entity(), Holder.direct(PotionRing.shrinking.get()));
			break;
		case widening:
			reloadEffect(slotContext.entity(), Holder.direct(PotionRing.widening.get()));
			break;
		case thinning:
			reloadEffect(slotContext.entity(), Holder.direct(PotionRing.thinning.get()));
			break;
		case none:
			break;
		}
	}
	
	@Override
	public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack)
	{
        MobEffectInstance effectInstance = new MobEffectInstance(MobEffects.JUMP, 240, 0);
        slotContext.entity().addEffect(effectInstance, slotContext.entity());

		switch(eff)
		{
		case strength:			
			AddEffect(slotContext.entity(), MobEffects.DAMAGE_BOOST);
			break;
		case speed:
			AddEffect(slotContext.entity(), MobEffects.MOVEMENT_SPEED);
			break;
		case resistance:
			AddEffect(slotContext.entity(), MobEffects.DAMAGE_RESISTANCE);
			break;
		case jump:
			AddEffect(slotContext.entity(), MobEffects.JUMP);
			break;
		case haste:
			AddEffect(slotContext.entity(), MobEffects.DIG_SPEED);
			break;
		case regeneration:
			AddEffect(slotContext.entity(), MobEffects.REGENERATION);
			break;
		case growing:
			AddEffect(slotContext.entity(), Holder.direct(PotionRing.growing.get()));
			break;
		case shrinking:
			AddEffect(slotContext.entity(), Holder.direct(PotionRing.shrinking.get()));
			break;
		case widening:
			AddEffect(slotContext.entity(), Holder.direct(PotionRing.widening.get()));
			break;
		case thinning:
			AddEffect(slotContext.entity(), Holder.direct(PotionRing.thinning.get()));
			break;
		case none:
			break;
		}
	}

    @Override
    public boolean canUnequip(SlotContext slotContext, ItemStack stack)
    {
    	switch(eff)
		{
		case strength:
			DeleteEffect(slotContext.entity(), MobEffects.DAMAGE_BOOST);
			break;
		case speed:
			DeleteEffect(slotContext.entity(), MobEffects.MOVEMENT_SPEED);
			break;
		case resistance:
			DeleteEffect(slotContext.entity(), MobEffects.DAMAGE_RESISTANCE);
			break;
		case jump:
			DeleteEffect(slotContext.entity(), MobEffects.JUMP);
			break;
		case haste:
			DeleteEffect(slotContext.entity(), MobEffects.DIG_SPEED);
			break;
		case regeneration:
			DeleteEffect(slotContext.entity(), MobEffects.REGENERATION);
			break;
		case growing:
			DeleteEffect(slotContext.entity(), Holder.direct(PotionRing.growing.get()));
			break;
		case shrinking:
			DeleteEffect(slotContext.entity(), Holder.direct(PotionRing.shrinking.get()));
			break;
		case widening:
			DeleteEffect(slotContext.entity(), Holder.direct(PotionRing.widening.get()));
			break;
		case thinning:
			DeleteEffect(slotContext.entity(), Holder.direct(PotionRing.thinning.get()));
			break;
		case none:
			break;
		}
    	    	
    	return eff.toString() != null;
    }
    
    private void AddEffect(LivingEntity livingEntity, Holder<MobEffect> mbEff)
    {
    	if(!livingEntity.hasEffect(mbEff))
		{
            MobEffectInstance effectInstance = new MobEffectInstance(mbEff, 240, 0);
            livingEntity.addEffect(effectInstance, livingEntity);
		}
		else if(CuriosApi.getCuriosInventory(livingEntity).resolve().get().findCurios(this).size() == 2)
		{
			MobEffectInstance effectInstance = new MobEffectInstance(mbEff, 240, 1);
            livingEntity.addEffect(effectInstance, livingEntity);
		}
    }
    
    private void reloadEffect(LivingEntity livingEntity, Holder<MobEffect> mbEff)
	{
    	int baseDuration = 240;
	    int newDuration1 = baseDuration;
	    int newDuration2 = baseDuration;

	    if (livingEntity.hasEffect(mbEff)) {
	    	MobEffectInstance currentEffect = livingEntity.getEffect(mbEff);
	        int currentDuration = currentEffect.getDuration();

	        if (CuriosApi.getCuriosInventory(livingEntity).resolve().get().findCurios(this).size() == 1) {
	            newDuration1 += currentDuration;
	        } else if (CuriosApi.getCuriosInventory(livingEntity).resolve().get().findCurios(this).size() == 2) {
	            newDuration2 += currentDuration;
	        }
	    }

	    MobEffectInstance effA1 = new MobEffectInstance(mbEff, newDuration1, 0, false, false);
	    MobEffectInstance effA2 = new MobEffectInstance(mbEff, newDuration2, 1, false, false);

	    if (CuriosApi.getCuriosInventory(livingEntity).resolve().get().findCurios(this).size() == 1) {
	        livingEntity.addEffect(effA1);
	    } else if (CuriosApi.getCuriosInventory(livingEntity).resolve().get().findCurios(this).size() == 2) {
	        livingEntity.addEffect(effA2);
	    }
	}
    
    private void DeleteEffect(LivingEntity livingEntity, Holder<MobEffect> mbEff)
    {
    	if(livingEntity.hasEffect(mbEff))
		{
			livingEntity.removeEffect(mbEff);
		}
    }
}