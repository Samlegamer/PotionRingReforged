package fr.samlegamer.potionring.item;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;

public class PotionRingItem extends TrinketItem
{
	private final EnumEffectTypes effects;
	
	public PotionRingItem(Settings settings, EnumEffectTypes eff)
	{
		super(settings);
		this.effects = eff;
	}
	
	@Override
	public boolean hasGlint(ItemStack stack)
	{
		return effects != EnumEffectTypes.NONE;
	}
	
	@Override
	public void tick(ItemStack stack, SlotReference slot, LivingEntity livingEntity)
	{
		switch(effects)
		{
			case STRENGTH:
				reloadEffect(livingEntity, StatusEffects.STRENGTH);
				break;
			case SPEED:
				reloadEffect(livingEntity, StatusEffects.SPEED);
				break;
			case RESISTANCE:
				reloadEffect(livingEntity, StatusEffects.RESISTANCE);
				break;
			case JUMP:
				reloadEffect(livingEntity, StatusEffects.JUMP_BOOST);
				break;
			case HASTE:
				reloadEffect(livingEntity, StatusEffects.HASTE);
				break;
			case REGENERATION:
				reloadEffect(livingEntity, StatusEffects.REGENERATION);
				break;
			case GROWING:
				reloadEffect(livingEntity, me.ultrusmods.sizeshiftingpotions.register.SizeShiftingPotionsEffects.GROWING);
				break;
			case SHRINKING:
				reloadEffect(livingEntity, me.ultrusmods.sizeshiftingpotions.register.SizeShiftingPotionsEffects.SHRINKING);
				break;
			case WIDENING:
				reloadEffect(livingEntity, me.ultrusmods.sizeshiftingpotions.register.SizeShiftingPotionsEffects.WIDENING);
				break;
			case THINNING:
				reloadEffect(livingEntity, me.ultrusmods.sizeshiftingpotions.register.SizeShiftingPotionsEffects.THINNING);
				break;
			case NONE:
				break;
		}
	}
	
	@Override
	public void onEquip(ItemStack stack, SlotReference slot, LivingEntity livingEntity)
	{
		switch(effects)
		{
			case STRENGTH:
				AddEffect(livingEntity, StatusEffects.STRENGTH);
				break;
			case SPEED:
				AddEffect(livingEntity, StatusEffects.SPEED);
				break;
			case RESISTANCE:
				AddEffect(livingEntity, StatusEffects.RESISTANCE);
				break;
			case JUMP:
				AddEffect(livingEntity, StatusEffects.JUMP_BOOST);
				break;
			case HASTE:
				AddEffect(livingEntity, StatusEffects.HASTE);
				break;
			case REGENERATION:
				AddEffect(livingEntity, StatusEffects.REGENERATION);
				break;
			case GROWING:
				AddEffect(livingEntity, me.ultrusmods.sizeshiftingpotions.register.SizeShiftingPotionsEffects.GROWING);
				break;
			case SHRINKING:
				AddEffect(livingEntity, me.ultrusmods.sizeshiftingpotions.register.SizeShiftingPotionsEffects.SHRINKING);
				break;
			case WIDENING:
				AddEffect(livingEntity, me.ultrusmods.sizeshiftingpotions.register.SizeShiftingPotionsEffects.WIDENING);
				break;
			case THINNING:
				AddEffect(livingEntity, me.ultrusmods.sizeshiftingpotions.register.SizeShiftingPotionsEffects.THINNING);
				break;
			case NONE:
				break;
		}
	}
	
	@Override
	public boolean canUnequip(ItemStack stack, SlotReference slot, LivingEntity livingEntity)
	{
    	switch(effects)
		{
			case STRENGTH:
				DeleteEffect(livingEntity, StatusEffects.STRENGTH);
				break;
			case SPEED:
				DeleteEffect(livingEntity, StatusEffects.SPEED);
				break;
			case RESISTANCE:
				DeleteEffect(livingEntity, StatusEffects.RESISTANCE);
				break;
			case JUMP:
				DeleteEffect(livingEntity, StatusEffects.JUMP_BOOST);
				break;
			case HASTE:
				DeleteEffect(livingEntity, StatusEffects.HASTE);
				break;
			case REGENERATION:
				DeleteEffect(livingEntity, StatusEffects.REGENERATION);
				break;
			case GROWING:
				DeleteEffect(livingEntity, me.ultrusmods.sizeshiftingpotions.register.SizeShiftingPotionsEffects.GROWING);
				break;
			case SHRINKING:
				DeleteEffect(livingEntity, me.ultrusmods.sizeshiftingpotions.register.SizeShiftingPotionsEffects.SHRINKING);
				break;
			case WIDENING:
				DeleteEffect(livingEntity, me.ultrusmods.sizeshiftingpotions.register.SizeShiftingPotionsEffects.WIDENING);
				break;
			case THINNING:
				DeleteEffect(livingEntity, me.ultrusmods.sizeshiftingpotions.register.SizeShiftingPotionsEffects.THINNING);
				break;
			case NONE:
				break;
		}
    	return effects != null;
	}
	
	
	private void AddEffect(LivingEntity livingEntity, StatusEffect mbEff)
    {
		if(!livingEntity.hasStatusEffect(mbEff))
		{
			StatusEffectInstance effectInstance = new StatusEffectInstance(mbEff, 240, 0, false, false);
            if(livingEntity.getWorld().isClient()) effectInstance.getDuration();
            	{livingEntity.addStatusEffect(effectInstance);}
		}
		else if(TrinketsApi.getTrinketComponent(livingEntity).get().getEquipped(this).size() == 2)
		{
			StatusEffectInstance effectInstance = new StatusEffectInstance(mbEff, 240, 1, false, false);
            if(livingEntity.getWorld().isClient()) effectInstance.getDuration();
            	{livingEntity.addStatusEffect(effectInstance);}
		}
    }
	
	private void reloadEffect(LivingEntity livingEntity, StatusEffect mbEff)
	{
    	int baseDuration = 240;
	    int newDuration1 = baseDuration;
	    int newDuration2 = baseDuration;

	    if (livingEntity.hasStatusEffect(mbEff)) {
	    	StatusEffectInstance currentEffect = livingEntity.getStatusEffect(mbEff);
	        int currentDuration = currentEffect.getDuration();

	        if (TrinketsApi.getTrinketComponent(livingEntity).get().getEquipped(this).size() == 1) {
	            newDuration1 += currentDuration;
	        } else if (TrinketsApi.getTrinketComponent(livingEntity).get().getEquipped(this).size() == 2) {
	            newDuration2 += currentDuration;
	        }
	    }

	    StatusEffectInstance effA1 = new StatusEffectInstance(mbEff, newDuration1, 0, false, false);
	    StatusEffectInstance effA2 = new StatusEffectInstance(mbEff, newDuration2, 1, false, false);

	    if (TrinketsApi.getTrinketComponent(livingEntity).get().getEquipped(this).size() == 1) {
	        livingEntity.addStatusEffect(effA1);
	    } else if (TrinketsApi.getTrinketComponent(livingEntity).get().getEquipped(this).size() == 2) {
	        livingEntity.addStatusEffect(effA2);
	    }
	}
    
    private void DeleteEffect(LivingEntity livingEntity, StatusEffect mbEff)
    {
    	if(livingEntity.hasStatusEffect(mbEff))
		{
			livingEntity.removeStatusEffect(mbEff);
		}
    }
}