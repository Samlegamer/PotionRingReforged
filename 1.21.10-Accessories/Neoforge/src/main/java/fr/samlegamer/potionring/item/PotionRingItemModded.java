package fr.samlegamer.potionring.item;

import fr.samlegamer.potionring.PotionRing;
import io.wispforest.accessories.api.core.AccessoryItem;
import io.wispforest.accessories.api.slot.SlotReference;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;
import javax.annotation.Nonnull;

public class PotionRingItemModded extends AccessoryItem
{
	private final String mod;
	private final String name;

	public PotionRingItemModded(String mod, String name) {
		super(new Properties().stacksTo(1).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PotionRing.MODID, "ring_of_"+name))));
		this.mod = mod;
		this.name = name;
	}

	@Override
	public boolean isCombineRepairable(ItemStack stack) {
		return stack.getItem() == Items.GOLD_INGOT;
	}

	@Override
	public boolean canGrindstoneRepair(@NotNull ItemStack stack) {
		return true;
	}

	public boolean isFoil(@Nonnull ItemStack p_77636_1_)
	{
        return false;
    }
	
	@Override
	public void tick(ItemStack stack, SlotReference reference)
	{
		Holder<MobEffect> eff = BuiltInRegistries.MOB_EFFECT.wrapAsHolder(BuiltInRegistries.MOB_EFFECT.get(ResourceLocation.fromNamespaceAndPath(mod, name)).get().value());
		if(eff != null)
		{
			reloadMobEffect(reference, eff);
		}
	}
	
	@Override
	public void onEquip(ItemStack stack, SlotReference reference)
	{
		Holder<MobEffect> eff = BuiltInRegistries.MOB_EFFECT.wrapAsHolder(BuiltInRegistries.MOB_EFFECT.get(ResourceLocation.fromNamespaceAndPath(mod, name)).get().value());
		if(eff != null)
		{
			AddMobEffect(reference, eff);
		}
	}

    @Override
    public void onUnequip(ItemStack stack, SlotReference reference)
    {
		Holder<MobEffect> eff = BuiltInRegistries.MOB_EFFECT.wrapAsHolder(BuiltInRegistries.MOB_EFFECT.get(ResourceLocation.fromNamespaceAndPath(mod, name)).get().value());
		if(eff != null)
		{
			DeleteMobEffect(reference, eff);
		}
    }

	private void AddMobEffect(SlotReference slotReference, Holder<MobEffect> mbEff)
	{
		MobEffectInstance effectInstance = new MobEffectInstance(mbEff, mbEff == MobEffects.NIGHT_VISION ? 500 : 240, slotReference.slotContainer().getAccessories().countItem(this) - 1, true, true);
		slotReference.entity().addEffect(effectInstance);
	}

	private void reloadMobEffect(SlotReference slotReference, Holder<MobEffect> mbEff)
	{
		int baseDuration = mbEff == MobEffects.NIGHT_VISION ? 500 : 240;
		int minDuration = mbEff == MobEffects.NIGHT_VISION ? 240 : 100;

		if (slotReference.entity().hasEffect(mbEff)) {
			MobEffectInstance currentMobEffect = slotReference.entity().getEffect(mbEff);
			if(currentMobEffect != null)
			{
				if(currentMobEffect.getDuration() <= minDuration)
				{
					currentMobEffect.duration = baseDuration;
					slotReference.entity().addEffect(currentMobEffect);
				}
			}
		}
		else if (!slotReference.entity().hasEffect(mbEff))
		{
			if(slotReference.slotContainer().getAccessories().countItem(this) == 1) {
				MobEffectInstance eff = new MobEffectInstance(mbEff, baseDuration, slotReference.slotContainer().getAccessories().countItem(this) - 1, true, true);
				slotReference.entity().addEffect(eff);
			}
		}
	}

	private void DeleteMobEffect(SlotReference slotReference, Holder<MobEffect> mbEff)
	{
		MobEffectInstance currentMobEffect = slotReference.entity().getEffect(mbEff);

		if(currentMobEffect != null) {
			if (slotReference.entity().hasEffect(mbEff) && currentMobEffect.getAmplifier() > 0) {
				currentMobEffect.amplifier = currentMobEffect.amplifier - 1;
				slotReference.entity().removeEffect(mbEff);
				slotReference.entity().addEffect(currentMobEffect);
			}
		}
	}
}