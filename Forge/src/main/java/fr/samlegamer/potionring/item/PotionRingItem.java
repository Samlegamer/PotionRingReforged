package fr.samlegamer.potionring.item;

import fr.samlegamer.potionring.PotionRing;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import top.theillusivec4.curios.api.CuriosApi;
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
			reloadEffect(livingEntity, Effects.DAMAGE_BOOST);
			break;
		case "speed":
			reloadEffect(livingEntity, Effects.MOVEMENT_SPEED);
			break;
		case "resistance":
			reloadEffect(livingEntity, Effects.DAMAGE_RESISTANCE);
			break;
		case "jump":
			reloadEffect(livingEntity, Effects.JUMP);
			break;
		case "haste":
			reloadEffect(livingEntity, Effects.DIG_SPEED);
			break;
		case "regeneration":
			reloadEffect(livingEntity, Effects.REGENERATION);
			break;
		case "growing":
			reloadEffect(livingEntity, PotionRing.growing.get());
			break;
		case "shrinking":
			reloadEffect(livingEntity, PotionRing.shrinking.get());
			break;
		case "widening":
			reloadEffect(livingEntity, PotionRing.widening.get());
			break;
		case "thinning":
			reloadEffect(livingEntity, PotionRing.thinning.get());
			break;
		case "none":
			break;
		}
	}
	
	@Override
	public void onEquip(String identifier, int index, LivingEntity livingEntity, ItemStack stack)
	{
		switch(eff)
		{
		case "strength":			
			AddEffect(livingEntity, Effects.DAMAGE_BOOST);
			break;
		case "speed":
			AddEffect(livingEntity, Effects.MOVEMENT_SPEED);
			break;
		case "resistance":
			AddEffect(livingEntity, Effects.DAMAGE_RESISTANCE);
			break;
		case "jump":
			AddEffect(livingEntity, Effects.JUMP);
			break;
		case "haste":
			AddEffect(livingEntity, Effects.DIG_SPEED);
			break;
		case "regeneration":
			AddEffect(livingEntity, Effects.REGENERATION);
			break;
		case "growing":
			AddEffect(livingEntity, PotionRing.growing.get());
			break;
		case "shrinking":
			AddEffect(livingEntity, PotionRing.shrinking.get());
			break;
		case "widening":
			AddEffect(livingEntity, PotionRing.widening.get());
			break;
		case "thinning":
			AddEffect(livingEntity, PotionRing.thinning.get());
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
			DeleteEffect(livingEntity, Effects.DAMAGE_BOOST);
			break;
		case "speed":
			DeleteEffect(livingEntity, Effects.MOVEMENT_SPEED);
			break;
		case "resistance":
			DeleteEffect(livingEntity, Effects.DAMAGE_RESISTANCE);
			break;
		case "jump":
			DeleteEffect(livingEntity, Effects.JUMP);
			break;
		case "haste":
			DeleteEffect(livingEntity, Effects.DIG_SPEED);
			break;
		case "regeneration":
			DeleteEffect(livingEntity, Effects.REGENERATION);
			break;
		case "growing":
			DeleteEffect(livingEntity, PotionRing.growing.get());
			break;
		case "shrinking":
			DeleteEffect(livingEntity, PotionRing.shrinking.get());
			break;
		case "widening":
			DeleteEffect(livingEntity, PotionRing.widening.get());
			break;
		case "thinning":
			DeleteEffect(livingEntity, PotionRing.thinning.get());
			break;
		case "none":
			break;
		}
    	    	
    	return eff.toString() != null;
    }
    
    private void AddEffect(LivingEntity livingEntity, Effect mbEff)
    {
    	if(!livingEntity.hasEffect(mbEff))
		{
    		EffectInstance effectInstance = new EffectInstance(mbEff, 240, 0, false, false);
            if(livingEntity.level.isClientSide) effectInstance.getDuration();
            livingEntity.addEffect(effectInstance);
		}
		else if(CuriosApi.getCuriosHelper().findCurios(livingEntity, this).size() == 2)
		{
			EffectInstance effectInstance = new EffectInstance(mbEff, 240, 1, true, false);
            if(livingEntity.level.isClientSide) effectInstance.getDuration();
            livingEntity.addEffect(effectInstance);
		}
    }
    
    private void reloadEffect(LivingEntity livingEntity, Effect mbEff)
	{
    	EffectInstance effA1 = new EffectInstance(mbEff, 240, 0, false, false);
    	EffectInstance effA2 = new EffectInstance(mbEff, 240, 1, false, false);

		if(!livingEntity.hasEffect(mbEff) && CuriosApi.getCuriosHelper().findCurios(livingEntity, this).size() == 1)
		{
			livingEntity.addEffect(effA1);
		}
		else if(!livingEntity.hasEffect(mbEff) && CuriosApi.getCuriosHelper().findCurios(livingEntity, this).size() == 2)
		{
			livingEntity.addEffect(effA2);
		}
	}
    
    private void DeleteEffect(LivingEntity livingEntity, Effect mbEff)
    {
    	if(livingEntity.hasEffect(mbEff))
		{
			livingEntity.removeEffect(mbEff);
		}
    }
}