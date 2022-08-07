package fr.samlegamer.potionring.item;

import fr.samlegamer.potionring.PotionRing;
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
			AddEffect(livingEntity, MobEffects.DAMAGE_BOOST);
			break;
		case "speed":
			AddEffect(livingEntity, MobEffects.MOVEMENT_SPEED);
			break;
		case "resistance":
			AddEffect(livingEntity, MobEffects.DAMAGE_RESISTANCE);
			break;
		case "jump":
			AddEffect(livingEntity, MobEffects.JUMP);
			break;
		case "haste":
			AddEffect(livingEntity, MobEffects.DIG_SPEED);
			break;
		case "regeneration":
			AddEffect(livingEntity, MobEffects.REGENERATION);
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
			DeleteEffect(livingEntity, MobEffects.DAMAGE_BOOST);
			break;
		case "speed":
			DeleteEffect(livingEntity, MobEffects.MOVEMENT_SPEED);
			break;
		case "resistance":
			DeleteEffect(livingEntity, MobEffects.DAMAGE_RESISTANCE);
			break;
		case "jump":
			DeleteEffect(livingEntity, MobEffects.JUMP);
			break;
		case "haste":
			DeleteEffect(livingEntity, MobEffects.DIG_SPEED);
			break;
		case "regeneration":
			DeleteEffect(livingEntity, MobEffects.REGENERATION);
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
    
    private void AddEffect(LivingEntity livingEntity, MobEffect mbEff)
    {
    	if(!livingEntity.hasEffect(mbEff))
		{
            MobEffectInstance effectInstance = new MobEffectInstance(mbEff, Integer.MAX_VALUE, 0, false, false);
            if(livingEntity.level.isClientSide) effectInstance.getDuration();
            livingEntity.addEffect(effectInstance);
		}
		else if(CuriosApi.getCuriosHelper().findCurios(livingEntity, this).size() >= 2)
		{
			MobEffectInstance effectInstance = new MobEffectInstance(mbEff, Integer.MAX_VALUE, 1, true, false);
            if(livingEntity.level.isClientSide) effectInstance.getDuration();
            livingEntity.addEffect(effectInstance);
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