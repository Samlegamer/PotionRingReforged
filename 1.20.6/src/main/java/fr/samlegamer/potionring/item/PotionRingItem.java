package fr.samlegamer.potionring.item;

import fr.samlegamer.potionring.PotionRing;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;
import top.theillusivec4.curios.api.type.capability.ICuriosItemHandler;

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
			reloadEffect(slotContext, MobEffects.DAMAGE_BOOST);
			break;
		case speed:
			reloadEffect(slotContext, MobEffects.MOVEMENT_SPEED);
			break;
		case resistance:
			reloadEffect(slotContext, MobEffects.DAMAGE_RESISTANCE);
			break;
		case jump:
			reloadEffect(slotContext, MobEffects.JUMP);
			break;
		case haste:
			reloadEffect(slotContext, MobEffects.DIG_SPEED);
			break;
		case regeneration:
			reloadEffect(slotContext, MobEffects.REGENERATION);
			break;
		case growing:
			reloadEffect(slotContext, Holder.direct(PotionRing.growing.get()));
			break;
		case shrinking:
			reloadEffect(slotContext, Holder.direct(PotionRing.shrinking.get()));
			break;
		case widening:
			reloadEffect(slotContext, Holder.direct(PotionRing.widening.get()));
			break;
		case thinning:
			reloadEffect(slotContext, Holder.direct(PotionRing.thinning.get()));
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
				AddEffect(slotContext, Holder.direct(PotionRing.growing.get()));
				break;
			case shrinking:
				AddEffect(slotContext, Holder.direct(PotionRing.shrinking.get()));
				break;
			case widening:
				AddEffect(slotContext, Holder.direct(PotionRing.widening.get()));
				break;
			case thinning:
				AddEffect(slotContext, Holder.direct(PotionRing.thinning.get()));
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
			DeleteEffect(slotContext, MobEffects.DAMAGE_BOOST);
			break;
		case speed:
			DeleteEffect(slotContext, MobEffects.MOVEMENT_SPEED);
			break;
		case resistance:
			DeleteEffect(slotContext, MobEffects.DAMAGE_RESISTANCE);
			break;
		case jump:
			DeleteEffect(slotContext, MobEffects.JUMP);
			break;
		case haste:
			DeleteEffect(slotContext, MobEffects.DIG_SPEED);
			break;
		case regeneration:
			DeleteEffect(slotContext, MobEffects.REGENERATION);
			break;
		case growing:
			DeleteEffect(slotContext, Holder.direct(PotionRing.growing.get()));
			break;
		case shrinking:
			DeleteEffect(slotContext, Holder.direct(PotionRing.shrinking.get()));
			break;
		case widening:
			DeleteEffect(slotContext, Holder.direct(PotionRing.widening.get()));
			break;
		case thinning:
			DeleteEffect(slotContext, Holder.direct(PotionRing.thinning.get()));
			break;
		case none:
			break;
		}
    	    	
    	return eff.toString() != null;
    }
    
    private void AddEffect(SlotContext slotContext, Holder<MobEffect> mbEff)
    {
    	ICuriosItemHandler curiosInventory = CuriosApi.getCuriosInventory(slotContext.entity()).get();

    	if(!slotContext.entity().hasEffect(mbEff))
		{
            MobEffectInstance effectInstance = new MobEffectInstance(mbEff, 240, 0);
            if(slotContext.entity().level().isClientSide()) effectInstance.getDuration();
            slotContext.entity().addEffect(effectInstance);
		}
		else if(curiosInventory.findCurios(this).size() == 2)
		{
			MobEffectInstance effectInstance = new MobEffectInstance(mbEff, 240, 1);
			if(slotContext.entity().level().isClientSide()) effectInstance.getDuration();
			slotContext.entity().addEffect(effectInstance);
		}
    }
    
    private void reloadEffect(SlotContext slotContext, Holder<MobEffect> mbEff)
	{
    	ICuriosItemHandler curiosInventory = CuriosApi.getCuriosInventory(slotContext.entity()).get();
    	int baseDuration = 240;
	    int newDuration1 = baseDuration;
	    int newDuration2 = baseDuration;

	    if (slotContext.entity().hasEffect(mbEff)) {
	    	MobEffectInstance currentEffect = slotContext.entity().getEffect(mbEff);
	        int currentDuration = currentEffect.getDuration();

	        if (curiosInventory.findCurios(this).size() == 1) {
	            newDuration1 += currentDuration;
	        } else if (curiosInventory.findCurios(this).size() == 2) {
	            newDuration2 += currentDuration;
	        }
	    }

	    MobEffectInstance effA1 = new MobEffectInstance(mbEff, newDuration1, 0, false, false);
	    MobEffectInstance effA2 = new MobEffectInstance(mbEff, newDuration2, 1, false, false);

	    if (curiosInventory.findCurios(this).size() == 1) {
	    	slotContext.entity().addEffect(effA1);
	    } else if (curiosInventory.findCurios(this).size() == 2) {
	    	slotContext.entity().addEffect(effA2);
	    }
	}
    
    private void DeleteEffect(SlotContext slotContext, Holder<MobEffect> mbEff)
    {
    	if(slotContext.entity().hasEffect(mbEff))
		{
    		slotContext.entity().removeEffect(mbEff);
		}
    }
}