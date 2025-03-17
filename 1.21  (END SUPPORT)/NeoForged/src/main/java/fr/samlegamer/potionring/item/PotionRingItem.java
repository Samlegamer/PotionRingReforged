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
	    return eff != PRTypes.none;
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
			reloadEffect(slotContext.entity(), Holder.direct(PotionRing.growing));
			break;
		case shrinking:
			reloadEffect(slotContext.entity(), Holder.direct(PotionRing.shrinking));
			break;
		case widening:
			reloadEffect(slotContext.entity(), Holder.direct(PotionRing.widening));
			break;
		case thinning:
			reloadEffect(slotContext.entity(), Holder.direct(PotionRing.thinning));
			break;
		case none:
			break;
		}
	}
	
	@Override
	public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack)
	{
		switch(eff)
		{
			case strength:			
				AddEffect(slotContext, MobEffects.DAMAGE_BOOST);
				break;
			case speed:
				AddEffect(slotContext, MobEffects.MOVEMENT_SPEED);
				break;
			case resistance:
				AddEffect(slotContext, MobEffects.DAMAGE_RESISTANCE);
				break;
			case jump:
				AddEffect(slotContext, MobEffects.JUMP);
				break;
			case haste:
				AddEffect(slotContext, MobEffects.DIG_SPEED);
				break;
			case regeneration:
				AddEffect(slotContext, MobEffects.REGENERATION);
				break;
			case growing:
				AddEffect(slotContext, Holder.direct(PotionRing.growing));
				break;
			case shrinking:
				AddEffect(slotContext, Holder.direct(PotionRing.shrinking));
				break;
			case widening:
				AddEffect(slotContext, Holder.direct(PotionRing.widening));
				break;
			case thinning:
				AddEffect(slotContext, Holder.direct(PotionRing.thinning));
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
			DeleteEffect(slotContext.entity(), Holder.direct(PotionRing.growing));
			break;
		case shrinking:
			DeleteEffect(slotContext.entity(), Holder.direct(PotionRing.shrinking));
			break;
		case widening:
			DeleteEffect(slotContext.entity(), Holder.direct(PotionRing.widening));
			break;
		case thinning:
			DeleteEffect(slotContext.entity(), Holder.direct(PotionRing.thinning));
			break;
		case none:
			break;
		}
    	    	
    	return eff.toString() != null;
    }
    
    private void AddEffect(SlotContext slotContext, Holder<MobEffect> mbEff)
    {
    	if(!slotContext.entity().hasEffect(mbEff))
		{
            MobEffectInstance effectInstance = new MobEffectInstance(mbEff, 240, 0);
            if(slotContext.entity().level().isClientSide()) effectInstance.getDuration();
            slotContext.entity().addEffect(effectInstance);
		}
		else if(CuriosApi.getCuriosInventory(slotContext.entity()).get().findCurios(this).size() == 2)
		{
			MobEffectInstance effectInstance = new MobEffectInstance(mbEff, 240, 1);
			if(slotContext.entity().level().isClientSide()) effectInstance.getDuration();
			slotContext.entity().addEffect(effectInstance);
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

	        if (CuriosApi.getCuriosInventory(livingEntity).get().findCurios(this).size() == 1) {
	            newDuration1 += currentDuration;
	        } else if (CuriosApi.getCuriosInventory(livingEntity).get().findCurios(this).size() == 2) {
	            newDuration2 += currentDuration;
	        }
	    }

	    MobEffectInstance effA1 = new MobEffectInstance(mbEff, newDuration1, 0, false, false);
	    MobEffectInstance effA2 = new MobEffectInstance(mbEff, newDuration2, 1, false, false);

	    if (CuriosApi.getCuriosInventory(livingEntity).get().findCurios(this).size() == 1) {
	        livingEntity.addEffect(effA1);
	    } else if (CuriosApi.getCuriosInventory(livingEntity).get().findCurios(this).size() == 2) {
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