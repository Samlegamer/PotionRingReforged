package fr.samlegamer.potionring.client;

import fr.samlegamer.potionring.PotionRing;
import fr.samlegamer.potionring.item.PRItemsRegistry;
import fr.samlegamer.potionring.item.PotionRingItem;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
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
        setColorToRing(PRItemsRegistry.RING_OF_DARKNESS);

        setColorToRing(Registries.ITEM.get(new Identifier(PotionRing.MODID, "ring_of_growing")), 14289002);
        setColorToRing(Registries.ITEM.get(new Identifier(PotionRing.MODID, "ring_of_shrinking")), 13411432);
        setColorToRing(Registries.ITEM.get(new Identifier(PotionRing.MODID, "ring_of_thinning")), 14922751);
        setColorToRing(Registries.ITEM.get(new Identifier(PotionRing.MODID, "ring_of_widening")), 11796418);

        List<String> list = (List<String>) PRItemsRegistry.createNewFileOrLearn(false);
        List<Integer> colors = (List<Integer>) PRItemsRegistry.createNewFileOrLearn(true);

        if(!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                String[] parts = list.get(i).split(":");
                if (parts.length == 2) {
                    final String mod = parts[0];
                    final String id = parts[1];

                    Item itemModded = Registries.ITEM.get(new Identifier(PotionRing.MODID, "ring_of_"+id));
                    setColorToRing(itemModded, colors.get(i));
                }
            }
        }
    }

    /* Free to use in another project, convert int color effect to ARGB
     * If the color is not ARGB the textures layer don't show
     * since 1.20.6
     */
    private static int rgbToArgb(int rgb) {
        return 0xFF000000 | (rgb & 0xFFFFFF);
    }

    private static void setColorToRing(PotionRingItem item)
    {
        if(item.eff != null)
        {
            int colorArgb = rgbToArgb(item.eff.value().getColor());

            ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {
                if (tintIndex == 1) {
                    return colorArgb;
                }
                return 0xFFFFFFFF;
            }, item);
        }
    }

    private static void setColorToRing(Item item, int color)
    {
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {
            int colorArgb = rgbToArgb(color);

            if (tintIndex == 1) {
                return colorArgb;
            }
            return 0xFFFFFFFF;
        }, item);
    }

}
