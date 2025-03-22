package fr.samlegamer.potionring.item;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.entry.RegistryEntry;

public class PotionRingItem extends TrinketItem
{
	public final RegistryEntry<StatusEffect> eff;

	public PotionRingItem(RegistryEntry<StatusEffect> effect)
	{
		super(new Settings().maxCount(1));
		this.eff = effect;
	}

	@Override
	public boolean canRepair(ItemStack stack, ItemStack ingredient) {
		return stack.getItem() == Items.GOLD_INGOT;
	}

	@Override
	public void tick(ItemStack stack, SlotReference slot, LivingEntity livingEntity)
	{
		if(eff != null)
		{
			reloadMobEffect(livingEntity, eff);
		}
	}
	
	@Override
	public void onEquip(ItemStack stack, SlotReference slot, LivingEntity livingEntity)
	{
		if(eff != null)
		{
			AddMobEffect(livingEntity, eff);
		}
	}

	@Override
	public void onUnequip(ItemStack stack, SlotReference slot, LivingEntity entity)
    {
		if(eff != null)
		{
			DeleteMobEffect(entity, eff);
		}
    }
    
    private void AddMobEffect(LivingEntity livingEntity, RegistryEntry<StatusEffect> mbEff)
    {
		if(TrinketsApi.getTrinketComponent(livingEntity).isPresent()) {
			StatusEffectInstance effectInstance = new StatusEffectInstance(mbEff, mbEff == StatusEffects.NIGHT_VISION ? 500 : 240, TrinketsApi.getTrinketComponent(livingEntity).get().getEquipped(this).size() - 1, true, true);
			livingEntity.addStatusEffect(effectInstance);
		}
    }
    
    private void reloadMobEffect(LivingEntity livingEntity, RegistryEntry<StatusEffect> mbEff)
	{
    	int baseDuration = mbEff == StatusEffects.NIGHT_VISION ? 500 : 240;
		int minDuration = mbEff == StatusEffects.NIGHT_VISION ? 240 : 100;

	    if (livingEntity.hasStatusEffect(mbEff)) {
			StatusEffectInstance currentMobEffect = livingEntity.getStatusEffect(mbEff);
			if(currentMobEffect != null)
			{
				if(currentMobEffect.getDuration() <= minDuration)
				{
					currentMobEffect.duration = baseDuration;
					livingEntity.addStatusEffect(currentMobEffect);
				}
			}
	    }
		else if (!livingEntity.hasStatusEffect(mbEff) && TrinketsApi.getTrinketComponent(livingEntity).isPresent())
		{
			if(TrinketsApi.getTrinketComponent(livingEntity).get().getEquipped(this).size() == 1)
			{
				StatusEffectInstance eff = new StatusEffectInstance(mbEff, baseDuration, TrinketsApi.getTrinketComponent(livingEntity).get().getEquipped(this).size() - 1, true, true);
				livingEntity.addStatusEffect(eff);
			}
		}
	}
    
    private void DeleteMobEffect(LivingEntity livingEntity, RegistryEntry<StatusEffect> mbEff)
    {
		StatusEffectInstance currentMobEffect = livingEntity.getStatusEffect(mbEff);

		if(currentMobEffect != null) {
			if (livingEntity.hasStatusEffect(mbEff) && currentMobEffect.getAmplifier() > 0) {
				currentMobEffect.amplifier = currentMobEffect.amplifier - 1;
				livingEntity.removeStatusEffect(mbEff);
				livingEntity.addStatusEffect(currentMobEffect);
			}
		}
    }
}