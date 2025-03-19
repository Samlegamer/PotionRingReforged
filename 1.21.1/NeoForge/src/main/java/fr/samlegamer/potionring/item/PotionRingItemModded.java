package fr.samlegamer.potionring.item;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;
import javax.annotation.Nonnull;

public class PotionRingItemModded extends Item implements ICurioItem
{
	private final String mod;
	private final String name;

	public PotionRingItemModded(String mod, String name) {
		super(new Properties().stacksTo(1));
		this.mod = mod;
		this.name = name;
	}

	@Override
	public boolean isValidRepairItem(@Nonnull ItemStack p_82789_1_, ItemStack p_82789_2_)
	{
        return p_82789_2_.getItem() == Items.GOLD_INGOT;
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
	public void curioTick(SlotContext slotContext, ItemStack stack)
	{
		MobEffect eff = BuiltInRegistries.MOB_EFFECT.get(ResourceLocation.fromNamespaceAndPath(mod, name));
		if(eff != null)
		{
			reloadEffect(slotContext.entity(), eff);
		}
	}
	
	@Override
	public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack)
	{
		MobEffect eff = BuiltInRegistries.MOB_EFFECT.get(ResourceLocation.fromNamespaceAndPath(mod, name));
		if(eff != null)
		{
			AddEffect(slotContext.entity(), eff);
		}
	}

    @Override
    public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack)
    {
		MobEffect eff = BuiltInRegistries.MOB_EFFECT.get(ResourceLocation.fromNamespaceAndPath(mod, name));
		if(eff != null)
		{
			DeleteEffect(slotContext.entity(), eff);
		}
    }
    
    private void AddEffect(LivingEntity livingEntity, MobEffect mbEff)
    {
		if(CuriosApi.getCuriosInventory(livingEntity).isPresent())
		{
			MobEffectInstance effectInstance = new MobEffectInstance(Holder.direct(mbEff), 240, CuriosApi.getCuriosInventory(livingEntity).get().findCurios(this).size() - 1, true, true);
			livingEntity.addEffect(effectInstance);
		}
    }
    
    private void reloadEffect(LivingEntity livingEntity, MobEffect mbEff)
	{
    	int baseDuration = 240;
		int minDuration = 100;

	    if (livingEntity.hasEffect(Holder.direct(mbEff))) {
	        MobEffectInstance currentEffect = livingEntity.getEffect(Holder.direct(mbEff));
			if(currentEffect != null)
			{
				if(currentEffect.getDuration() <= minDuration)
				{
					currentEffect.duration = baseDuration;
					livingEntity.addEffect(currentEffect);
				}
			}
	    }
		else if (!livingEntity.hasEffect(Holder.direct(mbEff)) && CuriosApi.getCuriosInventory(livingEntity).isPresent())
		{
			if(CuriosApi.getCuriosInventory(livingEntity).get().findCurios(this).size() == 1)
			{
				MobEffectInstance eff = new MobEffectInstance(Holder.direct(mbEff), baseDuration, CuriosApi.getCuriosInventory(livingEntity).get().findCurios(this).size() - 1, true, true);
				livingEntity.addEffect(eff);
			}
		}
	}
    
    private void DeleteEffect(LivingEntity livingEntity, MobEffect mbEff)
    {
		MobEffectInstance currentEffect = livingEntity.getEffect(Holder.direct(mbEff));

		if(currentEffect != null) {
			if (livingEntity.hasEffect(Holder.direct(mbEff)) && currentEffect.getAmplifier() > 0) {
				currentEffect.amplifier = currentEffect.amplifier - 1;
				livingEntity.removeEffect(Holder.direct(mbEff));
				livingEntity.addEffect(currentEffect);
			}
		}
    }
}