package fr.samlegamer.potionring.item;

import fr.samlegamer.potionring.PotionRing;
import io.wispforest.accessories.api.AccessoryItem;
import io.wispforest.accessories.api.slot.SlotReference;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class PotionRingItemModded extends AccessoryItem
{
	private final String mod;
	private final String name;

	public PotionRingItemModded(String mod, String name) {
		super(new Settings().maxCount(1).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(PotionRing.MODID, "ring_of_"+name))));
		this.mod = mod;
		this.name = name;
	}

	@Override
	public void tick(ItemStack stack, SlotReference reference)
	{
		StatusEffect st = Registries.STATUS_EFFECT.get(Identifier.of(mod, name));
		if(st != null)
		{
			RegistryEntry<StatusEffect> eff = Registries.STATUS_EFFECT.getEntry(st);
			if(eff != null)
			{
				reloadMobEffect(reference, eff);
			}
		}
	}

	@Override
	public void onEquip(ItemStack stack, SlotReference reference)
	{
		StatusEffect st = Registries.STATUS_EFFECT.get(Identifier.of(mod, name));
		if(st != null) {
			RegistryEntry<StatusEffect> eff = Registries.STATUS_EFFECT.getEntry(st);
			if (eff != null) {
				AddMobEffect(reference, eff);
			}
		}
	}

    @Override
	public void onUnequip(ItemStack stack, SlotReference reference)
    {
		StatusEffect st = Registries.STATUS_EFFECT.get(Identifier.of(mod, name));
		if(st != null) {
			RegistryEntry<StatusEffect> eff = Registries.STATUS_EFFECT.getEntry(st);
			if (eff != null) {
				DeleteMobEffect(reference, eff);
			}
		}
    }

	private void AddMobEffect(SlotReference slotReference, RegistryEntry<StatusEffect> mbEff)
	{
		StatusEffectInstance effectInstance = new StatusEffectInstance(mbEff, mbEff == StatusEffects.NIGHT_VISION ? 500 : 240, slotReference.slotContainer().getAccessories().count(this) - 1, true, true);
		slotReference.entity().addStatusEffect(effectInstance);
	}

	private void reloadMobEffect(SlotReference slotReference, RegistryEntry<StatusEffect> mbEff)
	{
		int baseDuration = mbEff == StatusEffects.NIGHT_VISION ? 500 : 240;
		int minDuration = mbEff == StatusEffects.NIGHT_VISION ? 240 : 100;

		if (slotReference.entity().hasStatusEffect(mbEff)) {
			StatusEffectInstance currentMobEffect = slotReference.entity().getStatusEffect(mbEff);
			if(currentMobEffect != null)
			{
				if(currentMobEffect.getDuration() <= minDuration)
				{
					currentMobEffect.duration = baseDuration;
					slotReference.entity().addStatusEffect(currentMobEffect);
				}
			}
		}
		else if (!slotReference.entity().hasStatusEffect(mbEff))
		{
			if(slotReference.slotContainer().getAccessories().count(this) == 1) {
				StatusEffectInstance eff = new StatusEffectInstance(mbEff, baseDuration, slotReference.slotContainer().getAccessories().count(this) - 1, true, true);
				slotReference.entity().addStatusEffect(eff);
			}
		}
	}

	private void DeleteMobEffect(SlotReference slotReference, RegistryEntry<StatusEffect> mbEff)
	{
		StatusEffectInstance currentMobEffect = slotReference.entity().getStatusEffect(mbEff);

		if(currentMobEffect != null) {
			if (slotReference.entity().hasStatusEffect(mbEff) && currentMobEffect.getAmplifier() > 0) {
				currentMobEffect.amplifier = currentMobEffect.amplifier - 1;
				slotReference.entity().removeStatusEffect(mbEff);
				slotReference.entity().addStatusEffect(currentMobEffect);
			}
		}
	}
}