package fr.samlegamer.potionring.item;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

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
		StatusEffect GROWING = Registry.STATUS_EFFECT.get(new Identifier("sizeshiftingpotions", "growing"));
		StatusEffect SHRINKING = Registry.STATUS_EFFECT.get(new Identifier("sizeshiftingpotions", "shrinking"));
		StatusEffect WIDENING = Registry.STATUS_EFFECT.get(new Identifier("sizeshiftingpotions", "widening"));
		StatusEffect THINNING = Registry.STATUS_EFFECT.get(new Identifier("sizeshiftingpotions", "thinning"));

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
				AddEffect(livingEntity, GROWING);
				break;
			case SHRINKING:
				AddEffect(livingEntity, SHRINKING);
				break;
			case WIDENING:
				AddEffect(livingEntity, WIDENING);
				break;
			case THINNING:
				AddEffect(livingEntity, THINNING);
				break;
			case NONE:
				break;
		}
	}
	
	@Override
	public boolean canUnequip(ItemStack stack, SlotReference slot, LivingEntity livingEntity)
	{
		StatusEffect GROWING = Registry.STATUS_EFFECT.get(new Identifier("sizeshiftingpotions", "growing"));
		StatusEffect SHRINKING = Registry.STATUS_EFFECT.get(new Identifier("sizeshiftingpotions", "shrinking"));
		StatusEffect WIDENING = Registry.STATUS_EFFECT.get(new Identifier("sizeshiftingpotions", "widening"));
		StatusEffect THINNING = Registry.STATUS_EFFECT.get(new Identifier("sizeshiftingpotions", "thinning"));

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
				DeleteEffect(livingEntity, GROWING);
				break;
			case SHRINKING:
				DeleteEffect(livingEntity, SHRINKING);
				break;
			case WIDENING:
				DeleteEffect(livingEntity, WIDENING);
				break;
			case THINNING:
				DeleteEffect(livingEntity, THINNING);
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
			StatusEffectInstance effectInstance = new StatusEffectInstance(mbEff, Integer.MAX_VALUE, 0, false, false);
            if(livingEntity.world.isClient) effectInstance.getDuration();
            livingEntity.addStatusEffect(effectInstance);
		}
		else if(TrinketsApi.getTrinketComponent(livingEntity).get().getEquipped(this).size() >= 2)
		{
			StatusEffectInstance effectInstance = new StatusEffectInstance(mbEff, Integer.MAX_VALUE, 1, true, false);
            if(livingEntity.world.isClient) effectInstance.getDuration();
            livingEntity.addStatusEffect(effectInstance);
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