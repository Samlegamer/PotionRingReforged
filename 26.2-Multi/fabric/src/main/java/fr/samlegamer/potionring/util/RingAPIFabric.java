package fr.samlegamer.potionring.util;

import eu.pb4.trinkets.api.TrinketsApi;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;

public class RingAPIFabric implements RingAPI
{
    @Override
    public int findTheSize(LivingEntity livingEntity, Item item) {
        return TrinketsApi.getAttachment(livingEntity).equipped(item, false).size();
    }

    @Override
    public boolean isPresent(LivingEntity livingEntity, Item item) {
        return TrinketsApi.getAttachment(livingEntity).isEquipped(item);
    }

    @Override
    public boolean isLoaded(String modid) {
        return FabricLoader.getInstance().isModLoaded(modid);
    }

    @Override
    public String configDir() {
        return FabricLoader.getInstance().getConfigDir().toString();
    }
}