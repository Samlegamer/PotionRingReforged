package fr.samlegamer.potionring.cfg;

import net.minecraftforge.fml.config.ModConfig;

public class ConfigLoad
{
    public static int numberOfRing = 2;

    public static boolean enableFireResistanceRing = false;
    public static boolean enableNightVisionRing = false;
    public static boolean enableSaturationRing = false;
    public static boolean enablePoisonRing = false;
    public static boolean enableWaterBreathingRing = false;
    public static boolean enableInvisibilityRing = false;
    public static boolean enableSlownessRing = false;
    public static boolean enableMiningFatigueRing = false;
    public static boolean enableNauseaRing = false;
    public static boolean enableBlindnessRing = false;
    public static boolean enableHungerRing = false;
    public static boolean enableWeaknessRing = false;
    public static boolean enableWitherRing = false;
    public static boolean enableGlowingRing = false;
    public static boolean enableLevitationRing = false;
    public static boolean enableLuckRing = false;
    public static boolean enableUnluckRing = false;
    public static boolean enableSlowFallingRing = false;
    public static boolean enableConduitPowerRing = false;
    public static boolean enableDolphinsGraceRing = false;

    public static void serverInit(final ModConfig.ModConfigEvent config)
    {
        if (config.getConfig().getSpec() == Configs.SERVER_CONFIG)
        {
            try {
                numberOfRing = Configs.SERVER.numberOfRing.get();

                enableFireResistanceRing = Configs.SERVER.enableFireResistanceRing.get();
                enableNightVisionRing = Configs.SERVER.enableNightVisionRing.get();
                enableSaturationRing = Configs.SERVER.enableSaturationRing.get();
                enablePoisonRing = Configs.SERVER.enablePoisonRing.get();
                enableWaterBreathingRing = Configs.SERVER.enableWaterBreathingRing.get();
                enableInvisibilityRing = Configs.SERVER.enableInvisibilityRing.get();
                enableSlownessRing = Configs.SERVER.enableSlownessRing.get();
                enableMiningFatigueRing = Configs.SERVER.enableMiningFatigueRing.get();
                enableNauseaRing = Configs.SERVER.enableNauseaRing.get();
                enableBlindnessRing = Configs.SERVER.enableBlindnessRing.get();
                enableHungerRing = Configs.SERVER.enableHungerRing.get();
                enableWeaknessRing = Configs.SERVER.enableWeaknessRing.get();
                enableWitherRing = Configs.SERVER.enableWitherRing.get();
                enableGlowingRing = Configs.SERVER.enableGlowingRing.get();
                enableLevitationRing = Configs.SERVER.enableLevitationRing.get();
                enableLuckRing = Configs.SERVER.enableLuckRing.get();
                enableUnluckRing = Configs.SERVER.enableUnluckRing.get();
                enableSlowFallingRing = Configs.SERVER.enableSlowFallingRing.get();
                enableConduitPowerRing = Configs.SERVER.enableConduitPowerRing.get();
                enableDolphinsGraceRing = Configs.SERVER.enableDolphinsGraceRing.get();
            }
            catch (Exception ignored) {
            }
        }
    }
    /*public static void serverInit(final ModConfig config)
    {
        try {
            numberOfRing = Configs.SERVER.numberOfRing.get();

            enableFireResistanceRing = Configs.SERVER.enableFireResistanceRing.get();
            enableNightVisionRing = Configs.SERVER.enableNightVisionRing.get();
            enableSaturationRing = Configs.SERVER.enableSaturationRing.get();
            enablePoisonRing = Configs.SERVER.enablePoisonRing.get();
            enableWaterBreathingRing = Configs.SERVER.enableWaterBreathingRing.get();
            enableInvisibilityRing = Configs.SERVER.enableInvisibilityRing.get();
            enableSlownessRing = Configs.SERVER.enableSlownessRing.get();
            enableMiningFatigueRing = Configs.SERVER.enableMiningFatigueRing.get();
            enableNauseaRing = Configs.SERVER.enableNauseaRing.get();
            enableBlindnessRing = Configs.SERVER.enableBlindnessRing.get();
            enableHungerRing = Configs.SERVER.enableHungerRing.get();
            enableWeaknessRing = Configs.SERVER.enableWeaknessRing.get();
            enableWitherRing = Configs.SERVER.enableWitherRing.get();
            enableGlowingRing = Configs.SERVER.enableGlowingRing.get();
            enableLevitationRing = Configs.SERVER.enableLevitationRing.get();
            enableLuckRing = Configs.SERVER.enableLuckRing.get();
            enableUnluckRing = Configs.SERVER.enableUnluckRing.get();
            enableSlowFallingRing = Configs.SERVER.enableSlowFallingRing.get();
            enableConduitPowerRing = Configs.SERVER.enableConduitPowerRing.get();
            enableDolphinsGraceRing = Configs.SERVER.enableDolphinsGraceRing.get();
        }
        catch (Exception ignored) {
        }
    }*/
}
