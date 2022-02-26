package fr.samlegamer.potionring.item;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;

public class PotionRingItem extends TrinketItem
{
	private final EnumEffectTypes effects;
	private final boolean isFoil;
	
	public PotionRingItem(Settings settings, EnumEffectTypes eff, boolean foil)
	{
		super(settings);
		this.effects = eff;
		this.isFoil = foil;
	}
	
	@Override
	public boolean hasGlint(ItemStack stack)
	{
		return isFoil;
	}
	
	@Override
	public void tick(ItemStack stack, SlotReference slot, LivingEntity livingEntity)
	{
		switch(effects)
		{
		case STRENGTH:
			if(!livingEntity.hasStatusEffect(StatusEffects.STRENGTH))
			{
				StatusEffectInstance effectInstance = new StatusEffectInstance(StatusEffects.STRENGTH, Integer.MAX_VALUE, 0, false, false);
	            if(livingEntity.world.isClient) effectInstance.getDuration();
	            livingEntity.addStatusEffect(effectInstance);
			}
			else if(TrinketsApi.getTrinketComponent(livingEntity).get().getEquipped(this).size() >= 2)
			{
				StatusEffectInstance effectInstance = new StatusEffectInstance(StatusEffects.STRENGTH, Integer.MAX_VALUE, 1, true, false);
	            if(livingEntity.world.isClient) effectInstance.getDuration();
	            livingEntity.addStatusEffect(effectInstance);
			}
			break;
		case SPEED:
			if(!livingEntity.hasStatusEffect(StatusEffects.SPEED))
			{
				StatusEffectInstance effectInstance = new StatusEffectInstance(StatusEffects.SPEED, Integer.MAX_VALUE, 0, false, false);
	            if(livingEntity.world.isClient) effectInstance.getDuration();
	            livingEntity.addStatusEffect(effectInstance);
			}
			else if(TrinketsApi.getTrinketComponent(livingEntity).get().getEquipped(this).size() >= 2)
			{
				StatusEffectInstance effectInstance = new StatusEffectInstance(StatusEffects.SPEED, Integer.MAX_VALUE, 1, true, false);
	            if(livingEntity.world.isClient) effectInstance.getDuration();
	            livingEntity.addStatusEffect(effectInstance);
			}
			break;
		case RESISTANCE:
			if(!livingEntity.hasStatusEffect(StatusEffects.RESISTANCE))
			{
				StatusEffectInstance effectInstance = new StatusEffectInstance(StatusEffects.RESISTANCE, Integer.MAX_VALUE, 0, false, false);
	            if(livingEntity.world.isClient) effectInstance.getDuration();
	            livingEntity.addStatusEffect(effectInstance);
			}
			else if(TrinketsApi.getTrinketComponent(livingEntity).get().getEquipped(this).size() >= 2)
			{
				StatusEffectInstance effectInstance = new StatusEffectInstance(StatusEffects.RESISTANCE, Integer.MAX_VALUE, 1, true, false);
	            if(livingEntity.world.isClient) effectInstance.getDuration();
	            livingEntity.addStatusEffect(effectInstance);
			}
			break;
		case JUMP:
			if(!livingEntity.hasStatusEffect(StatusEffects.JUMP_BOOST))
			{
				StatusEffectInstance effectInstance = new StatusEffectInstance(StatusEffects.JUMP_BOOST, Integer.MAX_VALUE, 0, false, false);
	            if(livingEntity.world.isClient) effectInstance.getDuration();
	            livingEntity.addStatusEffect(effectInstance);
			}
			else if(TrinketsApi.getTrinketComponent(livingEntity).get().getEquipped(this).size() >= 2)
			{
				StatusEffectInstance effectInstance = new StatusEffectInstance(StatusEffects.JUMP_BOOST, Integer.MAX_VALUE, 1, true, false);
	            if(livingEntity.world.isClient) effectInstance.getDuration();
	            livingEntity.addStatusEffect(effectInstance);
			}
			break;
		case HASTE:
			if(!livingEntity.hasStatusEffect(StatusEffects.HASTE))
			{
				StatusEffectInstance effectInstance = new StatusEffectInstance(StatusEffects.HASTE, Integer.MAX_VALUE, 0, false, false);
	            if(livingEntity.world.isClient) effectInstance.getDuration();
	            livingEntity.addStatusEffect(effectInstance);
			}
			else if(TrinketsApi.getTrinketComponent(livingEntity).get().getEquipped(this).size() >= 2)
			{
				StatusEffectInstance effectInstance = new StatusEffectInstance(StatusEffects.HASTE, Integer.MAX_VALUE, 1, true, false);
	            if(livingEntity.world.isClient) effectInstance.getDuration();
	            livingEntity.addStatusEffect(effectInstance);
			}
			break;
		case REGENERATION:
			if(!livingEntity.hasStatusEffect(StatusEffects.REGENERATION))
			{
				StatusEffectInstance effectInstance = new StatusEffectInstance(StatusEffects.REGENERATION, Integer.MAX_VALUE, 0, false, false);
	            if(livingEntity.world.isClient) effectInstance.getDuration();
	            livingEntity.addStatusEffect(effectInstance);
			}
			else if(TrinketsApi.getTrinketComponent(livingEntity).get().getEquipped(this).size() >= 2)
			{
				StatusEffectInstance effectInstance = new StatusEffectInstance(StatusEffects.REGENERATION, Integer.MAX_VALUE, 1, true, false);
	            if(livingEntity.world.isClient) effectInstance.getDuration();
	            livingEntity.addStatusEffect(effectInstance);
			}
			break;
		case NONE:
			break;
		}
	}
	
	@Override
	public boolean canUnequip(ItemStack stack, SlotReference slot, LivingEntity livingEntity)
	{
		//return Trinket.super.canUnequip(stack, slot, entity);
    	switch(effects)
		{
		case STRENGTH:
			if(livingEntity.hasStatusEffect(StatusEffects.STRENGTH))
			{
				livingEntity.removeStatusEffect(StatusEffects.STRENGTH);
			}
			break;
		case SPEED:
			if(livingEntity.hasStatusEffect(StatusEffects.SPEED))
			{
				livingEntity.removeStatusEffect(StatusEffects.SPEED);
			}
			break;
		case RESISTANCE:
			if(livingEntity.hasStatusEffect(StatusEffects.RESISTANCE))
			{
				livingEntity.removeStatusEffect(StatusEffects.RESISTANCE);
			}
			break;
		case JUMP:
			if(livingEntity.hasStatusEffect(StatusEffects.JUMP_BOOST))
			{
				livingEntity.removeStatusEffect(StatusEffects.JUMP_BOOST);
			}
			break;
		case HASTE:
			if(livingEntity.hasStatusEffect(StatusEffects.HASTE))
			{
				livingEntity.removeStatusEffect(StatusEffects.HASTE);
			}
			break;
		case REGENERATION:
			if(livingEntity.hasStatusEffect(StatusEffects.REGENERATION))
			{
				livingEntity.removeStatusEffect(StatusEffects.REGENERATION);
			}
			break;
		case NONE:
			break;
		}
    	    	
    	return effects != null;
	}
}