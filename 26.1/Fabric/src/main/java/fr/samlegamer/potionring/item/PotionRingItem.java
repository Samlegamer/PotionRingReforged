package fr.samlegamer.potionring.item;

import eu.pb4.trinkets.api.TrinketSlotAccess;
import eu.pb4.trinkets.api.TrinketsApi;
import eu.pb4.trinkets.api.callback.TrinketCallback;
import fr.samlegamer.potionring.PotionRing;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class PotionRingItem extends Item implements TrinketCallback
{
	public final Holder<MobEffect> eff;

	public PotionRingItem(String name, Holder<MobEffect> effect)
	{
		super(new Properties().stacksTo(1).setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(PotionRing.MODID, name))));
		this.eff = effect;
	}

	@Override
	public void tick(ItemStack stack, TrinketSlotAccess slot, LivingEntity livingEntity)
	{
		if(eff != null)
		{
			reloadMobEffect(livingEntity, eff, slot);
		}
	}
	
	@Override
	public void onEquip(ItemStack stack, TrinketSlotAccess slot, LivingEntity livingEntity)
	{
		if(eff != null)
		{
			AddMobEffect(livingEntity, eff);
		}
	}

	@Override
	public void onUnequip(ItemStack stack, TrinketSlotAccess slot, LivingEntity livingEntity)
    {
		if(eff != null)
		{
			DeleteMobEffect(livingEntity, eff);
		}
    }
    
    private void AddMobEffect(LivingEntity livingEntity, Holder<MobEffect> mbEff)
    {
		if(TrinketsApi.getAttachment(livingEntity).isEquipped(this)) {
			MobEffectInstance effectInstance = new MobEffectInstance(mbEff, mbEff == MobEffects.NIGHT_VISION ? 500 : 240, TrinketsApi.getAttachment(livingEntity).getEquipped(this).size() - 1, true, true);
			livingEntity.addEffect(effectInstance);
		}
    }
    
    private void reloadMobEffect(LivingEntity livingEntity, Holder<MobEffect> mbEff, TrinketSlotAccess slot)
	{
		int baseDuration = mbEff == MobEffects.NIGHT_VISION ? 500 : 240;
		int minDuration = mbEff == MobEffects.NIGHT_VISION ? 240 : 100;

		if (livingEntity.hasEffect(mbEff)) {
			MobEffectInstance currentMobEffect = livingEntity.getEffect(mbEff);
			if (currentMobEffect != null) {
				int ringAmplifier = 0;
				if (TrinketsApi.getAttachment(livingEntity).isEquipped(this)) {
					ringAmplifier = TrinketsApi.getAttachment(livingEntity).getEquipped(this).size() - 1;
				}

				if (currentMobEffect.getAmplifier() > ringAmplifier) {
					return;
				}

				if (currentMobEffect.getDuration() <= minDuration) {
					currentMobEffect.duration = baseDuration;
					livingEntity.addEffect(currentMobEffect);
				}
			}
		} else if (!livingEntity.hasEffect(mbEff) && TrinketsApi.getAttachment(livingEntity).isEquipped(this)) {
			if (TrinketsApi.getAttachment(livingEntity).getEquipped(this).size() == 1) {
				MobEffectInstance eff = new MobEffectInstance(mbEff, baseDuration, TrinketsApi.getAttachment(livingEntity).getEquipped(this).size() - 1, true, true);
				livingEntity.addEffect(eff);
			}
		}
	}
    
    private void DeleteMobEffect(LivingEntity livingEntity, Holder<MobEffect> mbEff)
    {
		MobEffectInstance currentMobEffect = livingEntity.getEffect(mbEff);

		if(currentMobEffect != null) {
			if (livingEntity.hasEffect(mbEff) && currentMobEffect.getAmplifier() > 0) {
				currentMobEffect.amplifier = currentMobEffect.amplifier - 1;
				livingEntity.removeEffect(mbEff);
				livingEntity.addEffect(currentMobEffect);
			}
		}
    }
}