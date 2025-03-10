package fr.samlegamer.potionring.cfg;

import net.minecraftforge.common.ForgeConfigSpec;

public class PRConfig
{
    public final ForgeConfigSpec.IntValue numberOfRing;

    public final ForgeConfigSpec.BooleanValue enableFireResistanceRing;
    public final ForgeConfigSpec.BooleanValue enableNightVisionRing;
    public final ForgeConfigSpec.BooleanValue enableSaturationRing;
    public final ForgeConfigSpec.BooleanValue enablePoisonRing;
    public final ForgeConfigSpec.BooleanValue enableWaterBreathingRing;
    public final ForgeConfigSpec.BooleanValue enableInvisibilityRing;
    public final ForgeConfigSpec.BooleanValue enableSlownessRing;
    public final ForgeConfigSpec.BooleanValue enableMiningFatigueRing;
    public final ForgeConfigSpec.BooleanValue enableNauseaRing;
    public final ForgeConfigSpec.BooleanValue enableBlindnessRing;
    public final ForgeConfigSpec.BooleanValue enableHungerRing;
    public final ForgeConfigSpec.BooleanValue enableWeaknessRing;
    public final ForgeConfigSpec.BooleanValue enableWitherRing;
    public final ForgeConfigSpec.BooleanValue enableGlowingRing;
    public final ForgeConfigSpec.BooleanValue enableLevitationRing;
    public final ForgeConfigSpec.BooleanValue enableLuckRing;
    public final ForgeConfigSpec.BooleanValue enableUnluckRing;
    public final ForgeConfigSpec.BooleanValue enableSlowFallingRing;
    public final ForgeConfigSpec.BooleanValue enableConduitPowerRing;
    public final ForgeConfigSpec.BooleanValue enableDolphinsGraceRing;

    public PRConfig(final ForgeConfigSpec.Builder builder)
    {
        builder.comment("Potion Rings Config file");
        builder.push("Curios");
        builder.comment("Set the number of rings in curios menu (int Default 2 Slots)");
        numberOfRing = builder.defineInRange("numberOfRing", 2, 1, Integer.MAX_VALUE);
        builder.pop();

        builder.push("Vanilla Rings");

        builder.comment("Enable Fire Resistance Ring (true or false)");
        enableFireResistanceRing = builder.define("Enable Fire Resistance Ring", false);

        builder.comment("Enable Night Vision Ring (true or false)");
        enableNightVisionRing = builder.define("Enable Night Vision Ring", false);

        builder.comment("Enable Saturation Ring (true or false)");
        enableSaturationRing = builder.define("Enable Saturation Ring", false);

        builder.comment("Enable Poison Ring (true or false)");
        enablePoisonRing = builder.define("Enable Poison Ring", false);

        builder.comment("Enable Water Breathing Ring (true or false)");
        enableWaterBreathingRing = builder.define("Enable Water Breathing Ring", false);

        builder.comment("Enable Invisibility Ring (true or false)");
        enableInvisibilityRing = builder.define("Enable Invisibility Ring", false);

        builder.comment("Enable Slowness Ring (true or false)");
        enableSlownessRing = builder.define("Enable Slowness Ring", false);

        builder.comment("Enable Mining Fatigue Ring (true or false)");
        enableMiningFatigueRing = builder.define("Enable Mining Fatigue Ring", false);

        builder.comment("Enable Nausea Ring (true or false)");
        enableNauseaRing = builder.define("Enable Nausea Ring", false);

        builder.comment("Enable Blindness Ring (true or false)");
        enableBlindnessRing = builder.define("Enable Blindness Ring", false);

        builder.comment("Enable Hunger Ring (true or false)");
        enableHungerRing = builder.define("Enable Hunger Ring", false);

        builder.comment("Enable Weakness Ring (true or false)");
        enableWeaknessRing = builder.define("Enable Weakness Ring", false);

        builder.comment("Enable Wither Ring (true or false)");
        enableWitherRing = builder.define("Enable Wither Ring", false);

        builder.comment("Enable Glowing Ring (true or false)");
        enableGlowingRing = builder.define("Enable Glowing Ring", false);

        builder.comment("Enable Levitation Ring (true or false)");
        enableLevitationRing = builder.define("Enable Levitation Ring", false);

        builder.comment("Enable Luck Ring (true or false)");
        enableLuckRing = builder.define("Enable Luck Ring", false);

        builder.comment("Enable Unluck Ring (true or false)");
        enableUnluckRing = builder.define("Enable Unluck Ring", false);

        builder.comment("Enable Slow Falling Ring (true or false)");
        enableSlowFallingRing = builder.define("Enable Slow Falling Ring", false);

        builder.comment("Enable ConduitPower Ring (true or false)");
        enableConduitPowerRing = builder.define("Enable ConduitPower Ring", false);

        builder.comment("Enable DolphinsGraceRing (true or false)");
        enableDolphinsGraceRing = builder.define("Enable DolphinsGraceRing", false);

        builder.pop();
    }
}
