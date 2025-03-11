package fr.samlegamer.potionring.client;

import net.minecraft.item.Item;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

@OnlyIn(Dist.CLIENT)
public class RingModel {
    public static void register(Item item, Supplier<Integer> colorSupplier) {
        ItemModelsProperties.register(item, new ResourceLocation("custom_color"),
                (stack, world, entity) -> colorSupplier.get());

    }
}
