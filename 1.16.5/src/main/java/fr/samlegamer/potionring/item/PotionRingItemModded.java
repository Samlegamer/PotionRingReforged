package fr.samlegamer.potionring.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.ModList;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import javax.annotation.Nonnull;

public class PotionRingItemModded extends Item implements ICurioItem
{
	private final String mod;
	private final String name;

	public PotionRingItemModded(String mod, String name) {
		super(ModList.get().isLoaded(mod) ? new Properties().stacksTo(1).tab(ItemGroup.TAB_BREWING) : new Properties().stacksTo(1));
		this.mod = mod;
		this.name = name;
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
	public void curioTick(String identifier, int index, LivingEntity livingEntity, ItemStack stack)
	{
		Effect eff = Registry.MOB_EFFECT.get(new ResourceLocation(mod, name));
		if(eff != null)
		{
			reloadEffect(livingEntity, eff);
		}
	}
	
	@Override
	public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack)
	{
		Effect eff = Registry.MOB_EFFECT.get(new ResourceLocation(mod, name));
		if(eff != null)
		{
			AddEffect(slotContext.getWearer(), eff);
		}
	}

    @Override
    public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack)
    {
		Effect eff = Registry.MOB_EFFECT.get(new ResourceLocation(mod, name));
		if(eff != null)
		{
			DeleteEffect(slotContext.getWearer(), eff);
		}
    }
    
    private void AddEffect(LivingEntity livingEntity, Effect mbEff)
    {
		EffectInstance effectInstance = new EffectInstance(mbEff, 240, CuriosApi.getCuriosHelper().findCurios(livingEntity, this).size() - 1, true, true);
		livingEntity.addEffect(effectInstance);
    }
    
    private void reloadEffect(LivingEntity livingEntity, Effect mbEff)
	{
    	int baseDuration = 240;
		int minDuration = 100;

	    if (livingEntity.hasEffect(mbEff)) {
	        EffectInstance currentEffect = livingEntity.getEffect(mbEff);
			if(currentEffect != null)
			{
                int ringAmplifier = 0;
                if (CuriosApi.getCuriosHelper() != null) {
                    ringAmplifier = CuriosApi.getCuriosHelper().findCurios(livingEntity, this).size() - 1;
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
		else if (!livingEntity.hasEffect(mbEff) && CuriosApi.getCuriosHelper().findCurios(livingEntity, this).size() == 1)
		{
			EffectInstance eff = new EffectInstance(mbEff, baseDuration, CuriosApi.getCuriosHelper().findCurios(livingEntity, this).size() - 1, true, true);
			livingEntity.addEffect(eff);
		}
	}
    
    private void DeleteEffect(LivingEntity livingEntity, Effect mbEff)
    {
		EffectInstance currentEffect = livingEntity.getEffect(mbEff);

		if(currentEffect != null) {
			if (livingEntity.hasEffect(mbEff) && currentEffect.getAmplifier() > 0) {
				currentEffect.amplifier = currentEffect.amplifier - 1;
				livingEntity.removeEffect(mbEff);
				livingEntity.addEffect(currentEffect);
			}
		}
    }
}