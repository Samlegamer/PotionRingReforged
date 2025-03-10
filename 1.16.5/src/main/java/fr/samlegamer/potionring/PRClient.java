package fr.samlegamer.potionring;

import fr.samlegamer.potionring.cfg.ConfigLoad;
import fr.samlegamer.potionring.item.PRItemsRegistry;
import fr.samlegamer.potionring.item.PotionRingItem;
import net.minecraft.potion.Effects;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = PotionRing.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class PRClient
{
    @SubscribeEvent
    public static void itemColor(ColorHandlerEvent.Item event)
    {
        setColorToRing(event, PRItemsRegistry.RING_OF_HASTE);
        setColorToRing(event, PRItemsRegistry.RING_OF_REGENERATION);
        setColorToRing(event, PRItemsRegistry.RING_OF_SPEED);
        setColorToRing(event, PRItemsRegistry.RING_OF_RESISTANCE);
        setColorToRing(event, PRItemsRegistry.RING_OF_STRENGTH);
        setColorToRing(event, PRItemsRegistry.RING_OF_JUMP_BOOST);

        setColorToRing(event, PRItemsRegistry.RING_OF_FIRE_RESISTANCE, PotionRing.getConfigFromType(Effects.FIRE_RESISTANCE));
        setColorToRing(event, PRItemsRegistry.RING_OF_INVISIBILITY, ConfigLoad.enableInvisibilityRing);
        setColorToRing(event, PRItemsRegistry.RING_OF_SLOWNESS, ConfigLoad.enableSlownessRing);
        setColorToRing(event, PRItemsRegistry.RING_OF_MINING_FATIGUE, ConfigLoad.enableMiningFatigueRing);
        setColorToRing(event, PRItemsRegistry.RING_OF_NAUSEA, ConfigLoad.enableNauseaRing);
        setColorToRing(event, PRItemsRegistry.RING_OF_BLINDNESS, ConfigLoad.enableBlindnessRing);
        setColorToRing(event, PRItemsRegistry.RING_OF_HUNGER, ConfigLoad.enableHungerRing);
        setColorToRing(event, PRItemsRegistry.RING_OF_SATURATION, ConfigLoad.enableSaturationRing);
        setColorToRing(event, PRItemsRegistry.RING_OF_NIGHT_VISION, ConfigLoad.enableNightVisionRing);
        setColorToRing(event, PRItemsRegistry.RING_OF_POISON, ConfigLoad.enablePoisonRing);
        setColorToRing(event, PRItemsRegistry.RING_OF_WATER_BREATHING, ConfigLoad.enableWaterBreathingRing);
        setColorToRing(event, PRItemsRegistry.RING_OF_WEAKNESS, ConfigLoad.enableWeaknessRing);
        setColorToRing(event, PRItemsRegistry.RING_OF_WITHER, ConfigLoad.enableWitherRing);
        setColorToRing(event, PRItemsRegistry.RING_OF_GLOWING, ConfigLoad.enableGlowingRing);
        setColorToRing(event, PRItemsRegistry.RING_OF_LEVITATION, ConfigLoad.enableLevitationRing);
        setColorToRing(event, PRItemsRegistry.RING_OF_LUCK, ConfigLoad.enableLuckRing);
        setColorToRing(event, PRItemsRegistry.RING_OF_UNLUCK, ConfigLoad.enableUnluckRing);
        setColorToRing(event, PRItemsRegistry.RING_OF_SLOW_FALLING, ConfigLoad.enableSlowFallingRing);
        setColorToRing(event, PRItemsRegistry.RING_OF_CONDUIT_POWER, ConfigLoad.enableConduitPowerRing);
        setColorToRing(event, PRItemsRegistry.RING_OF_DOLPHIN_GRACE, ConfigLoad.enableDolphinsGraceRing);
    }

    private static void setColorToRing(ColorHandlerEvent.Item event, RegistryObject<PotionRingItem> item)
    {
        setColorToRing(event, item, true);
    }

    private static void setColorToRing(ColorHandlerEvent.Item event, RegistryObject<PotionRingItem> item, boolean config)
    {
        if(config && item.get().eff != null)
        {
            event.getItemColors().register((itemStack, tintIndex) -> {
                if (tintIndex == 1) {
                    return item.get().eff.getColor();
                }
                return -1;
            }, item::get);
        }
    }
}
