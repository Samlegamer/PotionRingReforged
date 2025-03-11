package fr.samlegamer.potionring.cfg;

import fr.samlegamer.potionring.PotionRing;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.config.ModConfig;

public class CfgT
{
    @SubscribeEvent
    public static void onLoad(final ModConfig.Loading configEvent)
    {
        System.out.println("Config chargée : " + TutorialConfig.example_string.get());
        for(String i : TutorialConfig.exampleList.get())
        {
            PotionRing.log.info(i);
        }
        //ConfigLoad.enableFireResistanceRing = TutorialConfig.example_string.get();
    }

    @SubscribeEvent
    public static void onFileChange(final ModConfig.Reloading configEvent)
    {
        System.out.println("Config rechargée !");
		//ConfigLoad.enableFireResistanceRing = TutorialConfig.example_string.get();
    }
}
