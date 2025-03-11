package fr.samlegamer.potionring.cfg;

import net.minecraftforge.common.ForgeConfigSpec;
import java.util.Arrays;
import java.util.List;

public final class TutorialConfig {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	
	public static final ForgeConfigSpec.ConfigValue<Integer> example_integer;
	public static final ForgeConfigSpec.BooleanValue example_string;
	public static final ForgeConfigSpec.ConfigValue<List<String>> exampleList;

	static {
		BUILDER.push("Config for Tutorial Mod!");

		exampleList = BUILDER.comment("This is a  list string. Default value is \"Cy4\".").define("Example list str",
				Arrays.asList("tuto:example_effect", "lycanitesmobs:leech"));
		example_integer = BUILDER.comment("This is an integer. Default value is 3.").define("Example Integer", 3);
		example_string = BUILDER.comment("This is a string. Default value is \"Cy4\".").define("Example String", false);

		//tuto:example_effect;lycanitesmobs:leech;

		BUILDER.pop();
		SPEC = BUILDER.build();
	}
}
