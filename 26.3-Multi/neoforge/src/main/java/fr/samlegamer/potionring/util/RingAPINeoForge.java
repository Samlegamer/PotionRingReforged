package fr.samlegamer.potionring.util;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLPaths;
import top.theillusivec4.curios.api.CuriosApi;

public class RingAPINeoForge implements RingAPI
{
    @Override
    public int findTheSize(LivingEntity livingEntity, Item item) {
        return CuriosApi.getCuriosInventory(livingEntity).get().findCurios(item).size();
    }

    @Override
    public boolean isPresent(LivingEntity livingEntity, Item item) {
        return CuriosApi.getCuriosInventory(livingEntity).isPresent();
    }

    @Override
    public boolean isLoaded(String modid) {
        return ModList.get().isLoaded(modid);
    }

    @Override
    public String configDir() {
        return FMLPaths.CONFIGDIR.get().toString();
    }
}