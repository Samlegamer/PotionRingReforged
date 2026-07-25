package fr.samlegamer.potionring.util;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;

public interface RingAPI
{
    int findTheSize(LivingEntity livingEntity, Item item);
    boolean isPresent(LivingEntity livingEntity, Item item);
    boolean isLoaded(String modid);
    String configDir();
}