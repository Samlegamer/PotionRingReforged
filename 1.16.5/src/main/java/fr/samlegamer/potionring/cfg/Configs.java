package fr.samlegamer.potionring.cfg;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public final class Configs
{
    public static final ForgeConfigSpec SERVER_CONFIG;

    public static final PRConfig SERVER;

    static
    {
        {
            final Pair<PRConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(PRConfig::new);
            SERVER = specPair.getLeft();
            SERVER_CONFIG = specPair.getRight();


        }
        //SERVER_CONFIG = SERVER.builder.build();

    }

    /*public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static ForgeConfigSpec SPEC;

    public static ForgeConfigSpec.ConfigValue<Integer> example_integer;
    public static ForgeConfigSpec.ConfigValue<Boolean> example_string;

    public static void init() {
        BUILDER.push("Config for Tutorial Mod!");

        example_integer = BUILDER.comment("This is an integer. Default value is 3.").define("Example Integer", 3);
        example_string = BUILDER.comment("This is a string. Default value is \"Cy4\".").define("Example String", false);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }*/
}