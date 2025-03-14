package fr.samlegamer.potionring;

import fr.samlegamer.potionring.item.PRItemsRegistry;
import fr.samlegamer.potionring.item.PotionRingItem;
import fr.samlegamer.potionring.item.PotionRingItemModded;
import net.minecraft.item.Item;
import net.minecraft.potion.Effect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import java.util.List;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = PotionRing.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class PRClient
{
    @SubscribeEvent
    public static void itemColor(ColorHandlerEvent.Item event)
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

        List<String> list = (List<String>) PRItemsRegistry.createNewFileOrLearn(false);
        List<Integer> colors = (List<Integer>) PRItemsRegistry.createNewFileOrLearn(true);

        if(!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                String[] parts = list.get(i).split(":");
                if (parts.length == 2) {
                    final String mod = parts[0];
                    final String id = parts[1];
                    PotionRing.log.info("Registering " + mod + " " + id);
                    PotionRing.log.info("Color " + colors.get(i));
                    Item item = PotionRing.getItemFromConfig(mod, id);
                    if(item instanceof PotionRingItemModded)
                    {
                        PotionRing.log.info("Entrez dans le if Client Item réussis avec comme couleur : " + colors.get(i));

                        Effect eff = Registry.MOB_EFFECT.get(new ResourceLocation(mod, id));

                        PotionRingItemModded modItem = (PotionRingItemModded) item;
                        setColorToRing(event, modItem, mod, id);
                    }
                }
            }
        }
    }

    private static void setColorToRing(ColorHandlerEvent.Item event, PotionRingItem item)
    {
        if(item.eff != null)
        {
            event.getItemColors().register((itemStack, tintIndex) -> {
                if (tintIndex == 1) {
                    return item.eff.getColor();
                }
                return -1;
            }, item);
        }
    }

    private static void setColorToRing(ColorHandlerEvent.Item event, PotionRingItemModded item, String mod, String id)
    {
        event.getItemColors().register((itemStack, tintIndex) -> {

            Effect eff = Registry.MOB_EFFECT.get(new ResourceLocation(mod, id));
            if (tintIndex == 1) {
                return eff.getColor();
            }
            return -1;
        }, item);

    }
}
