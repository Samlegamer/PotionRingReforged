package fr.samlegamer.potionring.item;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class PotionRingItemModded extends TrinketItem
{
	private final String mod;
	private final String name;

	public PotionRingItemModded(String mod, String name) {
		super(new Settings().maxCount(1));
		this.mod = mod;
		this.name = name;
	}

	@Override
	public boolean canRepair(ItemStack stack, ItemStack ingredient) {
		return stack.getItem() == Items.GOLD_INGOT;
	}
	
	@Override
	public void tick(ItemStack stack, SlotReference slot, LivingEntity livingEntity)
	{
		StatusEffect eff = Registries.STATUS_EFFECT.get(new Identifier(mod, name));
		if(eff != null)
		{
			reloadEffect(livingEntity, eff);
		}
	}
	
	@Override
	public void onEquip(ItemStack stack, SlotReference slot, LivingEntity livingEntity)
	{
		StatusEffect eff = Registries.STATUS_EFFECT.get(new Identifier(mod, name));
		if(eff != null)
		{
			AddEffect(livingEntity, eff);
		}
	}

    @Override
	public void onUnequip(ItemStack stack, SlotReference slot, LivingEntity livingEntity)
    {
		StatusEffect eff = Registries.STATUS_EFFECT.get(new Identifier(mod, name));
		if(eff != null)
		{
			DeleteEffect(livingEntity, eff);
		}
    }
    
    private void AddEffect(LivingEntity livingEntity, StatusEffect mbEff)
    {
		if(TrinketsApi.getTrinketComponent(livingEntity).isPresent()) {
			StatusEffectInstance effectInstance = new StatusEffectInstance(mbEff, 240, TrinketsApi.getTrinketComponent(livingEntity).get().getEquipped(this).size() - 1, true, true);
			livingEntity.addStatusEffect(effectInstance);
		}
    }
    
    private void reloadEffect(LivingEntity livingEntity, StatusEffect mbEff)
	{
    	int baseDuration = 240;
		int minDuration = 100;

	    if (livingEntity.hasStatusEffect(mbEff)) {
	        StatusEffectInstance currentEffect = livingEntity.getStatusEffect(mbEff);
			if(currentEffect != null)
			{
				if(currentEffect.getDuration() <= minDuration)
				{
					currentEffect.duration = baseDuration;
					livingEntity.addStatusEffect(currentEffect);
				}
			}
	    }
		else if (!livingEntity.hasStatusEffect(mbEff) && TrinketsApi.getTrinketComponent(livingEntity).isPresent())
		{
			if(TrinketsApi.getTrinketComponent(livingEntity).get().getEquipped(this).size() == 1) {
				StatusEffectInstance eff = new StatusEffectInstance(mbEff, baseDuration, TrinketsApi.getTrinketComponent(livingEntity).get().getEquipped(this).size() - 1, true, true);
				livingEntity.addStatusEffect(eff);
			}
		}
	}
    
    private void DeleteEffect(LivingEntity livingEntity, StatusEffect mbEff)
    {
		StatusEffectInstance currentEffect = livingEntity.getStatusEffect(mbEff);

		if(currentEffect != null) {
			if (livingEntity.hasStatusEffect(mbEff) && currentEffect.getAmplifier() > 0) {
				currentEffect.amplifier = currentEffect.amplifier - 1;
				livingEntity.removeStatusEffect(mbEff);
				livingEntity.addStatusEffect(currentEffect);
			}
		}
    }
}