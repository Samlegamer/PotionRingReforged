package fr.samlegamer.potionring;

import fr.samlegamer.potionring.item.PRItemsRegistry;
import fr.samlegamer.potionring.item.PotionRingItem;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import java.util.List;

@Mod.EventBusSubscriber(modid = PotionRing.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class PRClient
{
    /* Free to use in another project, convert int color effect to ARGB
    * If the color is not ARGB the textures layer don't show
    * since 1.20.6
    */
    private static int rgbToArgb(int rgb) {
        return 0xFF000000 | (rgb & 0xFFFFFF);
    }

    @SubscribeEvent
    public static void itemColor(RegisterColorHandlersEvent.Item event)
    {
        setColorToRing(event, PRItemsRegistry.RING_OF_HASTE.get());
        setColorToRing(event, PRItemsRegistry.RING_OF_REGENERATION.get());
        setColorToRing(event, PRItemsRegistry.RING_OF_SPEED.get());
        setColorToRing(event, PRItemsRegistry.RING_OF_RESISTANCE.get());
        setColorToRing(event, PRItemsRegistry.RING_OF_STRENGTH.get());
        setColorToRing(event, PRItemsRegistry.RING_OF_JUMP_BOOST.get());

        setColorToRing(event, PRItemsRegistry.RING_OF_FIRE_RESISTANCE.get());
        setColorToRing(event, PRItemsRegistry.RING_OF_INVISIBILITY.get());
        setColorToRing(event, PRItemsRegistry.RING_OF_SLOWNESS.get());
        setColorToRing(event, PRItemsRegistry.RING_OF_MINING_FATIGUE.get());
        setColorToRing(event, PRItemsRegistry.RING_OF_NAUSEA.get());
        setColorToRing(event, PRItemsRegistry.RING_OF_BLINDNESS.get());
        setColorToRing(event, PRItemsRegistry.RING_OF_HUNGER.get());
        setColorToRing(event, PRItemsRegistry.RING_OF_SATURATION.get());
        setColorToRing(event, PRItemsRegistry.RING_OF_NIGHT_VISION.get());
        setColorToRing(event, PRItemsRegistry.RING_OF_POISON.get());
        setColorToRing(event, PRItemsRegistry.RING_OF_WATER_BREATHING.get());
        setColorToRing(event, PRItemsRegistry.RING_OF_WEAKNESS.get());
        setColorToRing(event, PRItemsRegistry.RING_OF_WITHER.get());
        setColorToRing(event, PRItemsRegistry.RING_OF_GLOWING.get());
        setColorToRing(event, PRItemsRegistry.RING_OF_LEVITATION.get());
        setColorToRing(event, PRItemsRegistry.RING_OF_LUCK.get());
        setColorToRing(event, PRItemsRegistry.RING_OF_UNLUCK.get());
        setColorToRing(event, PRItemsRegistry.RING_OF_SLOW_FALLING.get());
        setColorToRing(event, PRItemsRegistry.RING_OF_CONDUIT_POWER.get());
        setColorToRing(event, PRItemsRegistry.RING_OF_DOLPHIN_GRACE.get());
        setColorToRing(event, PRItemsRegistry.RING_OF_DARKNESS.get());

        List<String> list = (List<String>) PRItemsRegistry.createNewFileOrLearn(false);
        List<Integer> colors = (List<Integer>) PRItemsRegistry.createNewFileOrLearn(true);

        if(!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                String[] parts = list.get(i).split(":");
                if (parts.length == 2) {
                    final String mod = parts[0];
                    final String id = parts[1];

                    Item itemModded = BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(PotionRing.MODID, "ring_of_"+id));
                    setColorToRing(event, itemModded, colors.get(i));
                }
            }
        }
    }

    private static void setColorToRing(RegisterColorHandlersEvent.Item event, PotionRingItem item)
    {
        if(item.eff != null)
        {
            int colorArgb = rgbToArgb(item.eff.get().getColor());

            event.register((itemStack, tintIndex) -> {
                if (tintIndex == 1) {
                    return colorArgb;
                }
                return 0xFFFFFFFF;
            }, item);
        }
    }

    private static void setColorToRing(RegisterColorHandlersEvent.Item event, Item item, int color)
    {
        int colorArgb = rgbToArgb(color);

        event.register((itemStack, tintIndex) -> {
            if (tintIndex == 1) {
                return colorArgb;
            }
            return 0xFFFFFFFF;
        }, item);
    }
}