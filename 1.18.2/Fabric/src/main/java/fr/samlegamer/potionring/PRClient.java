package fr.samlegamer.potionring;

import fr.samlegamer.potionring.item.PRItemsRegistry;
import fr.samlegamer.potionring.item.PotionRingItem;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.List;

public class PRClient implements ClientModInitializer
{
    @Override
    public void onInitializeClient()
    {
        setColorToRing(PRItemsRegistry.RING_OF_HASTE);
        setColorToRing(PRItemsRegistry.RING_OF_REGENERATION);
        setColorToRing(PRItemsRegistry.RING_OF_SPEED);
        setColorToRing(PRItemsRegistry.RING_OF_RESISTANCE);
        setColorToRing(PRItemsRegistry.RING_OF_STRENGTH);
        setColorToRing(PRItemsRegistry.RING_OF_JUMP_BOOST);

        setColorToRing(PRItemsRegistry.RING_OF_FIRE_RESISTANCE);
        setColorToRing(PRItemsRegistry.RING_OF_INVISIBILITY);
        setColorToRing(PRItemsRegistry.RING_OF_SLOWNESS);
        setColorToRing(PRItemsRegistry.RING_OF_MINING_FATIGUE);
        setColorToRing(PRItemsRegistry.RING_OF_NAUSEA);
        setColorToRing(PRItemsRegistry.RING_OF_BLINDNESS);
        setColorToRing(PRItemsRegistry.RING_OF_HUNGER);
        setColorToRing(PRItemsRegistry.RING_OF_SATURATION);
        setColorToRing(PRItemsRegistry.RING_OF_NIGHT_VISION);
        setColorToRing(PRItemsRegistry.RING_OF_POISON);
        setColorToRing(PRItemsRegistry.RING_OF_WATER_BREATHING);
        setColorToRing(PRItemsRegistry.RING_OF_WEAKNESS);
        setColorToRing(PRItemsRegistry.RING_OF_WITHER);
        setColorToRing(PRItemsRegistry.RING_OF_GLOWING);
        setColorToRing(PRItemsRegistry.RING_OF_LEVITATION);
        setColorToRing(PRItemsRegistry.RING_OF_LUCK);
        setColorToRing(PRItemsRegistry.RING_OF_UNLUCK);
        setColorToRing(PRItemsRegistry.RING_OF_SLOW_FALLING);
        setColorToRing(PRItemsRegistry.RING_OF_CONDUIT_POWER);
        setColorToRing(PRItemsRegistry.RING_OF_DOLPHIN_GRACE);

        setColorToRing(Registry.ITEM.get(new Identifier(PotionRing.MODID, "ring_of_growing")), 14289002);
        setColorToRing(Registry.ITEM.get(new Identifier(PotionRing.MODID, "ring_of_shrinking")), 13411432);
        setColorToRing(Registry.ITEM.get(new Identifier(PotionRing.MODID, "ring_of_thinning")), 14922751);
        setColorToRing(Registry.ITEM.get(new Identifier(PotionRing.MODID, "ring_of_widening")), 11796418);

        List<String> list = (List<String>) PRItemsRegistry.createNewFileOrLearn(false);
        List<Integer> colors = (List<Integer>) PRItemsRegistry.createNewFileOrLearn(true);

        if(!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                String[] parts = list.get(i).split(":");
                if (parts.length == 2) {
                    final String mod = parts[0];
                    final String id = parts[1];

                    Item itemModded = Registry.ITEM.get(new Identifier(PotionRing.MODID, "ring_of_"+id));
                    setColorToRing(itemModded, colors.get(i));
                }
            }
        }
    }

    private static void setColorToRing(PotionRingItem item)
    {
        if(item.eff != null)
        {
            ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {
                if (tintIndex == 1) {
                    return item.eff.getColor();
                }
                return -1;
            }, item);
        }
    }

    private static void setColorToRing(Item item, int color)
    {
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {
            if (tintIndex == 1) {
                return color;
            }
            return -1;
        }, item);
    }

}
