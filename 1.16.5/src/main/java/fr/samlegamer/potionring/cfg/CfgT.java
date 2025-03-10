package fr.samlegamer.potionring.cfg;

import fr.samlegamer.potionring.item.PRItemsRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class CfgT
{
    @SubscribeEvent
    public static void onLoad(final ModConfig.Loading configEvent)
    {
        System.out.println("Config chargée : " + TutorialConfig.example_string.get());
        ConfigLoad.enableFireResistanceRing = TutorialConfig.example_string.get();

        //ConfigLoad.enableFireResistanceRing = TutorialConfig.example_string.get();
    }

    @SubscribeEvent
    public static void onFileChange(final ModConfig.Reloading configEvent)
    {
        System.out.println("Config rechargée !");
		//ConfigLoad.enableFireResistanceRing = TutorialConfig.example_string.get();
    }
}
