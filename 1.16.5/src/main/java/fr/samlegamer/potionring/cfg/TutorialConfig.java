package fr.samlegamer.potionring.cfg;

import net.minecraftforge.common.ForgeConfigSpec;

public final class TutorialConfig {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	
	public static final ForgeConfigSpec.ConfigValue<Integer> example_integer;
	public static final ForgeConfigSpec.BooleanValue example_string;
	
	static {
		BUILDER.push("Config for Tutorial Mod!");
		
		example_integer = BUILDER.comment("This is an integer. Default value is 3.").define("Example Integer", 3);
		example_string = BUILDER.comment("This is a string. Default value is \"Cy4\".").define("Example String", false);
		
		BUILDER.pop();
		SPEC = BUILDER.build();
	}
}
