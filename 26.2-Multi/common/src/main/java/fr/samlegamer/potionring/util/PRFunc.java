package fr.samlegamer.potionring.util;

import fr.samlegamer.potionring.PotionRing;
import fr.samlegamer.potionring.item.AbstractPotionRingItem;
import fr.samlegamer.potionring.item.AbstractPotionRingItemModded;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PRFunc
{
    public static ResourceKey<Item>[] tags() {
        List<ResourceKey<Item>> list = List.of(
                ringSearch("potion_ring").builtInRegistryHolder().key(),
                ringSearch("ring_of_haste").builtInRegistryHolder().key(),
                ringSearch("ring_of_jump_boost").builtInRegistryHolder().key(),
                ringSearch("ring_of_resistance").builtInRegistryHolder().key(),
                ringSearch("ring_of_speed").builtInRegistryHolder().key(),
                ringSearch("ring_of_strength").builtInRegistryHolder().key(),
                ringSearch("ring_of_regeneration").builtInRegistryHolder().key(),
                ringSearch("ring_of_fire_resistance").builtInRegistryHolder().key(),
                ringSearch("ring_of_invisibility").builtInRegistryHolder().key(),
                ringSearch("ring_of_slowness").builtInRegistryHolder().key(),
                ringSearch("ring_of_mining_fatigue").builtInRegistryHolder().key(),
                ringSearch("ring_of_nausea").builtInRegistryHolder().key(),
                ringSearch("ring_of_blindness").builtInRegistryHolder().key(),
                ringSearch("ring_of_hunger").builtInRegistryHolder().key(),
                ringSearch("ring_of_saturation").builtInRegistryHolder().key(),
                ringSearch("ring_of_night_vision").builtInRegistryHolder().key(),
                ringSearch("ring_of_poison").builtInRegistryHolder().key(),
                ringSearch("ring_of_water_breathing").builtInRegistryHolder().key(),
                ringSearch("ring_of_weakness").builtInRegistryHolder().key(),
                ringSearch("ring_of_wither").builtInRegistryHolder().key(),
                ringSearch("ring_of_glowing").builtInRegistryHolder().key(),
                ringSearch("ring_of_levitation").builtInRegistryHolder().key(),
                ringSearch("ring_of_luck").builtInRegistryHolder().key(),
                ringSearch("ring_of_unluck").builtInRegistryHolder().key(),
                ringSearch("ring_of_slow_falling").builtInRegistryHolder().key(),
                ringSearch("ring_of_conduit_power").builtInRegistryHolder().key(),
                ringSearch("ring_of_dolphins_grace").builtInRegistryHolder().key(),
                ringSearch("ring_of_darkness").builtInRegistryHolder().key(),
                ringSearchModded("ring_of_growing").builtInRegistryHolder().key(),
                ringSearchModded("ring_of_shrinking").builtInRegistryHolder().key(),
                ringSearchModded("ring_of_thinning").builtInRegistryHolder().key(),
                ringSearchModded("ring_of_widening").builtInRegistryHolder().key());
        ResourceKey<Item>[] array = new ResourceKey[list.size()];
        return list.toArray(array);
    }

    public static Map<Item, String> translations() {
        Map<Item, String> map = new LinkedHashMap<>();

        map.put(ringSearch("potion_ring"), "Potion Ring");
        map.put(ringSearch("ring_of_haste"), "Ring of Haste");
        map.put(ringSearch("ring_of_jump_boost"), "Ring of Jump Boost");
        map.put(ringSearch("ring_of_resistance"), "Ring of Resistance");
        map.put(ringSearch("ring_of_speed"), "Ring of Speed");
        map.put(ringSearch("ring_of_strength"), "Ring of Strength");
        map.put(ringSearch("ring_of_regeneration"), "Ring of Regeneration");

        map.put(ringSearch("ring_of_fire_resistance"), "Ring of Fire Resistance");
        map.put(ringSearch("ring_of_invisibility"), "Ring of Invisibility");
        map.put(ringSearch("ring_of_slowness"), "Ring of Slowness");
        map.put(ringSearch("ring_of_mining_fatigue"), "Ring of Mining Fatigue");
        map.put(ringSearch("ring_of_nausea"), "Ring of Nausea");
        map.put(ringSearch("ring_of_blindness"), "Ring of Blindness");
        map.put(ringSearch("ring_of_hunger"), "Ring of Hunger");
        map.put(ringSearch("ring_of_saturation"), "Ring of Saturation");
        map.put(ringSearch("ring_of_night_vision"), "Ring of Night Vision");
        map.put(ringSearch("ring_of_poison"), "Ring of Poison");
        map.put(ringSearch("ring_of_water_breathing"), "Ring of Water Breathing");
        map.put(ringSearch("ring_of_weakness"), "Ring of Weakness");
        map.put(ringSearch("ring_of_wither"), "Ring of Wither");
        map.put(ringSearch("ring_of_glowing"), "Ring of Glowing");
        map.put(ringSearch("ring_of_levitation"), "Ring of Levitation");
        map.put(ringSearch("ring_of_luck"), "Ring of Luck");
        map.put(ringSearch("ring_of_unluck"), "Ring of Bad Luck");
        map.put(ringSearch("ring_of_slow_falling"), "Ring of Slow Falling");
        map.put(ringSearch("ring_of_conduit_power"), "Ring of Conduit Power");
        map.put(ringSearch("ring_of_dolphins_grace"), "Ring of Dolphin Grace");
        map.put(ringSearch("ring_of_darkness"), "Ring of Darkness");

        map.put(ringSearchModded("ring_of_example_effect"), "Ring of Example Effect");
        map.put(ringSearchModded("ring_of_another_effect"), "Ring of Another Effect");

        map.put(ringSearchModded("ring_of_growing"), "Ring of Growing");
        map.put(ringSearchModded("ring_of_shrinking"), "Ring of Shrinking");
        map.put(ringSearchModded("ring_of_thinning"), "Ring of Thinning");
        map.put(ringSearchModded("ring_of_widening"), "Ring of Widening");
        return map;
    }

    public static void AddMobEffect(RingAPI ringAPI, LivingEntity livingEntity, Holder<MobEffect> mbEff, Item item)
    {
        if(ringAPI.isPresent(livingEntity, item)) {
            MobEffectInstance effectInstance = new MobEffectInstance(mbEff, mbEff == MobEffects.NIGHT_VISION ? 500 : 240, ringAPI.findTheSize(livingEntity, item) - 1, true, true);
            livingEntity.addEffect(effectInstance);
        }
    }

    public static void reloadMobEffect(RingAPI ringAPI, LivingEntity livingEntity, Holder<MobEffect> mbEff, Item item)
    {
        int baseDuration = mbEff == MobEffects.NIGHT_VISION ? 500 : 240;
        int minDuration = mbEff == MobEffects.NIGHT_VISION ? 240 : 100;

        if (livingEntity.hasEffect(mbEff)) {
            MobEffectInstance currentMobEffect = livingEntity.getEffect(mbEff);
            if(currentMobEffect != null)
            {
                int ringAmplifier = 0;
                if (ringAPI.isPresent(livingEntity, item)) {
                    ringAmplifier = ringAPI.findTheSize(livingEntity, item) - 1;
                }

                if (currentMobEffect.getAmplifier() > ringAmplifier) {
                    return;
                }

                if(currentMobEffect.getDuration() <= minDuration)
                {
                    currentMobEffect.duration = baseDuration;
                    livingEntity.addEffect(currentMobEffect);
                }
            }
        }
        else if (!livingEntity.hasEffect(mbEff) && ringAPI.isPresent(livingEntity, item))
        {
            if(ringAPI.findTheSize(livingEntity, item) == 1) {
                MobEffectInstance eff = new MobEffectInstance(mbEff, baseDuration, ringAPI.findTheSize(livingEntity, item) - 1, true, true);
                livingEntity.addEffect(eff);
            }
        }
    }

    public static void DeleteMobEffect(LivingEntity livingEntity, Holder<MobEffect> mbEff)
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

    public static AbstractPotionRingItem ringSearch(String name)
    {
        if(BuiltInRegistries.ITEM.get(Identifier.fromNamespaceAndPath(PotionRing.MODID, name)).isPresent())
        {
            Item item = BuiltInRegistries.ITEM.get(Identifier.fromNamespaceAndPath(PotionRing.MODID, name)).get().value();
            if (item instanceof AbstractPotionRingItem potionRingItem) {
                return potionRingItem;
            }
        }
        return new AbstractPotionRingItem("none", MobEffects.BAD_OMEN) {};
    }

    public static AbstractPotionRingItemModded ringSearchModded(String name)
    {
        if(BuiltInRegistries.ITEM.get(Identifier.fromNamespaceAndPath(PotionRing.MODID, name)).isPresent())
        {
            Item item = BuiltInRegistries.ITEM.get(Identifier.fromNamespaceAndPath(PotionRing.MODID, name)).get().value();
            if (item instanceof AbstractPotionRingItemModded potionRingItem) {
                return potionRingItem;
            }
        }
        return new AbstractPotionRingItemModded("none", "a_effect") {};
    }
}