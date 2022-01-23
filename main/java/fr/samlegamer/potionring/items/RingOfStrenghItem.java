package fr.samlegamer.potionring.items;

import javax.annotation.Nonnull;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class RingOfStrenghItem extends Item implements ICurioItem
{
	public RingOfStrenghItem(Properties p_i48487_1_)
	{
		super(p_i48487_1_);
	}
	
	public boolean isFoil(ItemStack p_77636_1_)
	{
	      return true;
	}
		
	@Override
	public void curioTick(String identifier, int index, @Nonnull LivingEntity livingEntity, ItemStack stack)
	{		
		if(!livingEntity.hasEffect(Effects.DAMAGE_BOOST))
		{
            EffectInstance effectInstance = new EffectInstance(Effects.DAMAGE_BOOST, Integer.MAX_VALUE, 0, true, false);
            if(livingEntity.level.isClientSide) effectInstance.getDuration();
            livingEntity.addEffect(effectInstance);
		}
		else if(CuriosApi.getCuriosHelper().findCurios(livingEntity, this).size() >= 2)
		{
            EffectInstance effectInstance = new EffectInstance(Effects.DAMAGE_BOOST, Integer.MAX_VALUE, 1, true, false);
            if(livingEntity.level.isClientSide) effectInstance.getDuration();
            livingEntity.addEffect(effectInstance);
		}
	}
    	
    	@Override
    	public boolean isValidRepairItem(ItemStack p_82789_1_, ItemStack p_82789_2_)
    	{
    		return p_82789_1_.getItem() == Items.GOLD_INGOT;
    	}
	
    @Override
    public boolean canUnequip(String identifier, LivingEntity livingEntity, ItemStack stack)
    {
    	return livingEntity.removeEffect(Effects.DAMAGE_BOOST);
    }
}