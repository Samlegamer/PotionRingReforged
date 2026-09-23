package fr.samlegamer.potionring.item;

import eu.pb4.trinkets.api.TrinketSlotAccess;
import eu.pb4.trinkets.api.callback.TrinketCallback;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import java.util.Optional;
import static fr.samlegamer.potionring.PotionRingFabric.RING_API_FABRIC;
import static fr.samlegamer.potionring.util.PRFunc.reloadMobEffect;
import static fr.samlegamer.potionring.util.PRFunc.AddMobEffect;
import static fr.samlegamer.potionring.util.PRFunc.DeleteMobEffect;

public class PotionRingItemModded extends AbstractPotionRingItemModded implements TrinketCallback
{
	public PotionRingItemModded(String mod, String name) {
		super(mod, name);
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
				reloadMobEffect(RING_API_FABRIC, livingEntity, eff, this);
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
				AddMobEffect(RING_API_FABRIC, livingEntity, eff, this);
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
				DeleteMobEffect(livingEntity, eff);
			}
		}
    }
}