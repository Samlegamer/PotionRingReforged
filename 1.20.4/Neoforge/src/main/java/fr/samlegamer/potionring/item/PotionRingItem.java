package fr.samlegamer.potionring.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;
import javax.annotation.Nonnull;

public class PotionRingItem extends Item implements ICurioItem
{
	public final MobEffect eff;

	public PotionRingItem(MobEffect effect)
	{
		super(new Properties().stacksTo(1));
		this.eff = effect;
	}

	@Override
	public boolean isValidRepairItem(@Nonnull ItemStack p_82789_1_, ItemStack p_82789_2_)
	{
        return p_82789_2_.getItem() == Items.GOLD_INGOT;
    }

	@Override
	public boolean isRepairable(@Nonnull ItemStack stack) {
		return true;
	}

	public boolean isFoil(@Nonnull ItemStack p_77636_1_)
	{
        return false;
    }
	
	@Override
	public void curioTick(SlotContext slotContext, ItemStack stack)
	{
		if(eff != null)
		{
			reloadMobEffect(slotContext.entity(), eff);
		}
	}
	
	@Override
	public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack)
	{
		if(eff != null)
		{
			AddMobEffect(slotContext.entity(), eff);
		}
	}

    @Override
    public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack)
    {
		if(eff != null)
		{
			DeleteMobEffect(slotContext.entity(), eff);
		}
    }
    
    private void AddMobEffect(LivingEntity livingEntity, MobEffect mbEff)
    {
		if(CuriosApi.getCuriosInventory(livingEntity).isPresent()) {
			MobEffectInstance effectInstance = new MobEffectInstance(mbEff, mbEff == MobEffects.NIGHT_VISION ? 500 : 240, CuriosApi.getCuriosInventory(livingEntity).get().findCurios(this).size() - 1, true, true);
			livingEntity.addEffect(effectInstance);
		}
    }
    
    private void reloadMobEffect(LivingEntity livingEntity, MobEffect mbEff)
	{
    	int baseDuration = mbEff == MobEffects.NIGHT_VISION ? 500 : 240;
		int minDuration = mbEff == MobEffects.NIGHT_VISION ? 240 : 100;

	    if (livingEntity.hasEffect(mbEff)) {
	        MobEffectInstance currentMobEffect = livingEntity.getEffect(mbEff);
			if(currentMobEffect != null)
			{
				if(currentMobEffect.getDuration() <= minDuration)
				{
					currentMobEffect.duration = baseDuration;
					livingEntity.addEffect(currentMobEffect);
				}
			}
	    }
		else if (!livingEntity.hasEffect(mbEff) && CuriosApi.getCuriosInventory(livingEntity).isPresent())
		{
			if(CuriosApi.getCuriosInventory(livingEntity).get().findCurios(this).size() == 1) {
				MobEffectInstance eff = new MobEffectInstance(mbEff, baseDuration, CuriosApi.getCuriosInventory(livingEntity).get().findCurios(this).size() - 1, true, true);
				livingEntity.addEffect(eff);
			}
		}
	}
    
    private void DeleteMobEffect(LivingEntity livingEntity, MobEffect mbEff)
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