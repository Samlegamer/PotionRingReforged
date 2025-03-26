package fr.samlegamer.potionring.client;

import fr.samlegamer.potionring.PotionRing;
import fr.samlegamer.potionring.item.PRItemsRegistry;
import io.wispforest.accessories.api.client.AccessoriesRendererRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import java.util.List;

public class PRClient implements ClientModInitializer
{
    @Override
    public void onInitializeClient()
    {
        AccessoriesRendererRegistry.registerNoRenderer(PRItemsRegistry.RING_OF_HASTE);
        AccessoriesRendererRegistry.registerNoRenderer(PRItemsRegistry.RING_OF_REGENERATION);
        AccessoriesRendererRegistry.registerNoRenderer(PRItemsRegistry.RING_OF_SPEED);
        AccessoriesRendererRegistry.registerNoRenderer(PRItemsRegistry.RING_OF_RESISTANCE);
        AccessoriesRendererRegistry.registerNoRenderer(PRItemsRegistry.RING_OF_STRENGTH);
        AccessoriesRendererRegistry.registerNoRenderer(PRItemsRegistry.RING_OF_JUMP_BOOST);

        AccessoriesRendererRegistry.registerNoRenderer(PRItemsRegistry.RING_OF_FIRE_RESISTANCE);
        AccessoriesRendererRegistry.registerNoRenderer(PRItemsRegistry.RING_OF_INVISIBILITY);
        AccessoriesRendererRegistry.registerNoRenderer(PRItemsRegistry.RING_OF_SLOWNESS);
        AccessoriesRendererRegistry.registerNoRenderer(PRItemsRegistry.RING_OF_MINING_FATIGUE);
        AccessoriesRendererRegistry.registerNoRenderer(PRItemsRegistry.RING_OF_NAUSEA);
        AccessoriesRendererRegistry.registerNoRenderer(PRItemsRegistry.RING_OF_BLINDNESS);
        AccessoriesRendererRegistry.registerNoRenderer(PRItemsRegistry.RING_OF_HUNGER);
        AccessoriesRendererRegistry.registerNoRenderer(PRItemsRegistry.RING_OF_SATURATION);
        AccessoriesRendererRegistry.registerNoRenderer(PRItemsRegistry.RING_OF_NIGHT_VISION);
        AccessoriesRendererRegistry.registerNoRenderer(PRItemsRegistry.RING_OF_POISON);
        AccessoriesRendererRegistry.registerNoRenderer(PRItemsRegistry.RING_OF_WATER_BREATHING);
        AccessoriesRendererRegistry.registerNoRenderer(PRItemsRegistry.RING_OF_WEAKNESS);
        AccessoriesRendererRegistry.registerNoRenderer(PRItemsRegistry.RING_OF_WITHER);
        AccessoriesRendererRegistry.registerNoRenderer(PRItemsRegistry.RING_OF_GLOWING);
        AccessoriesRendererRegistry.registerNoRenderer(PRItemsRegistry.RING_OF_LEVITATION);
        AccessoriesRendererRegistry.registerNoRenderer(PRItemsRegistry.RING_OF_LUCK);
        AccessoriesRendererRegistry.registerNoRenderer(PRItemsRegistry.RING_OF_UNLUCK);
        AccessoriesRendererRegistry.registerNoRenderer(PRItemsRegistry.RING_OF_SLOW_FALLING);
        AccessoriesRendererRegistry.registerNoRenderer(PRItemsRegistry.RING_OF_CONDUIT_POWER);
        AccessoriesRendererRegistry.registerNoRenderer(PRItemsRegistry.RING_OF_DOLPHIN_GRACE);
        AccessoriesRendererRegistry.registerNoRenderer(PRItemsRegistry.RING_OF_DARKNESS);

        AccessoriesRendererRegistry.registerNoRenderer(Registries.ITEM.get(Identifier.of(PotionRing.MODID, "ring_of_growing")));
        AccessoriesRendererRegistry.registerNoRenderer(Registries.ITEM.get(Identifier.of(PotionRing.MODID, "ring_of_shrinking")));
        AccessoriesRendererRegistry.registerNoRenderer(Registries.ITEM.get(Identifier.of(PotionRing.MODID, "ring_of_thinning")));
        AccessoriesRendererRegistry.registerNoRenderer(Registries.ITEM.get(Identifier.of(PotionRing.MODID, "ring_of_widening")));

        List<String> list = (List<String>) PRItemsRegistry.createNewFileOrLearn(false);
        List<Integer> colors = (List<Integer>) PRItemsRegistry.createNewFileOrLearn(true);

        if(!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                String[] parts = list.get(i).split(":");
                if (parts.length == 2) {
                    final String mod = parts[0];
                    final String id = parts[1];

                    Item itemModded = Registries.ITEM.get(Identifier.of(PotionRing.MODID, "ring_of_"+id));
                    AccessoriesRendererRegistry.registerNoRenderer(itemModded);
                }
            }
        }
    }
}