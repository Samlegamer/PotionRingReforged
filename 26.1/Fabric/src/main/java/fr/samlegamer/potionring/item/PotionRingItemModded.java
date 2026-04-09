package fr.samlegamer.potionring.item;

import eu.pb4.trinkets.api.TrinketSlotAccess;
import eu.pb4.trinkets.api.TrinketsApi;
import eu.pb4.trinkets.api.callback.TrinketCallback;
import fr.samlegamer.potionring.PotionRing;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import java.util.Optional;

public class PotionRingItemModded extends Item implements TrinketCallback
{
	private final String mod;
	private final String name;

	public PotionRingItemModded(String mod, String name) {
		super(new Properties().stacksTo(1).setId(
				ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(PotionRing.MODID, "ring_of_" + name))
		));
		this.mod = mod;
		this.name = name;
	}

	@Override
	public void tick(ItemStack stack, TrinketSlotAccess slot, LivingEntity livingEntity)
	{
		Optional<Holder.Reference<MobEffect>> st = BuiltInRegistries.MOB_EFFECT.get(Identifier.fromNamespaceAndPath(mod, name));
		if(st.isPresent())
		{
			Holder<MobEffect> eff = BuiltInRegistries.MOB_EFFECT.wrapAsHolder(st.get().value());
			if(eff != null)
			{
				reloadEffect(livingEntity, eff);
			}
		}
	}
	
	@Override
	public void onEquip(ItemStack stack, TrinketSlotAccess slot, LivingEntity livingEntity)
	{
		Optional<Holder.Reference<MobEffect>> st = BuiltInRegistries.MOB_EFFECT.get(Identifier.fromNamespaceAndPath(mod, name));
		if(st.isPresent()) {
			Holder<MobEffect> eff = BuiltInRegistries.MOB_EFFECT.wrapAsHolder(st.get().value());
			if (eff != null) {
				AddEffect(livingEntity, eff);
			}
		}
	}

    @Override
	public void onUnequip(ItemStack stack, TrinketSlotAccess slot, LivingEntity livingEntity)
    {
		Optional<Holder.Reference<MobEffect>> st = BuiltInRegistries.MOB_EFFECT.get(Identifier.fromNamespaceAndPath(mod, name));
		if(st.isPresent()) {
			Holder<MobEffect> eff = BuiltInRegistries.MOB_EFFECT.wrapAsHolder(st.get().value());
			if (eff != null) {
				DeleteEffect(livingEntity, eff);
			}
		}
    }
    
    private void AddEffect(LivingEntity livingEntity, Holder<MobEffect> mbEff)
    {
		if(TrinketsApi.getAttachment(livingEntity).isEquipped(this)) {
			MobEffectInstance effectInstance = new MobEffectInstance(mbEff, 240, TrinketsApi.getAttachment(livingEntity).getEquipped(this).size() - 1, true, true);
			livingEntity.addEffect(effectInstance);
		}
    }
    
    private void reloadEffect(LivingEntity livingEntity, Holder<MobEffect> mbEff)
	{
    	int baseDuration = 240;
		int minDuration = 100;

	    if (livingEntity.hasEffect(mbEff)) {
	        MobEffectInstance currentEffect = livingEntity.getEffect(mbEff);
			if(currentEffect != null)
			{
                int ringAmplifier = 0;
                if (TrinketsApi.getAttachment(livingEntity).isEquipped(this)) {
                    ringAmplifier = TrinketsApi.getAttachment(livingEntity).getEquipped(this).size() - 1;
                }

                if (currentEffect.getAmplifier() > ringAmplifier) {
                    return;
                }

				if(currentEffect.getDuration() <= minDuration)
				{
					currentEffect.duration = baseDuration;
					livingEntity.addEffect(currentEffect);
				}
			}
	    }
		else if (!livingEntity.hasEffect(mbEff) && TrinketsApi.getAttachment(livingEntity).isEquipped(this))
		{
			if(TrinketsApi.getAttachment(livingEntity).getEquipped(this).size() == 1) {
				MobEffectInstance eff = new MobEffectInstance(mbEff, baseDuration, TrinketsApi.getAttachment(livingEntity).getEquipped(this).size() - 1, true, true);
				livingEntity.addEffect(eff);
			}
		}
	}
    
    private void DeleteEffect(LivingEntity livingEntity, Holder<MobEffect> mbEff)
    {
		MobEffectInstance currentEffect = livingEntity.getEffect(mbEff);

		if(currentEffect != null) {
			if (livingEntity.hasEffect(mbEff) && currentEffect.getAmplifier() > 0) {
				currentEffect.amplifier = currentEffect.amplifier - 1;
				livingEntity.removeEffect(mbEff);
				livingEntity.addEffect(currentEffect);
			}
		}
    }
}