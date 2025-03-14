package fr.samlegamer.potionring.cfg;

import net.minecraftforge.common.ForgeConfigSpec;

public final class RingsConfig
{
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;

//	public static ForgeConfigSpec.ConfigValue<List<? extends String>> listOfModdedEffects;
	public static final ForgeConfigSpec.ConfigValue<Integer> numberOfRingsSlots;

	static {
		BUILDER.push("Potions Rings REFORGED Config !");

//		listOfModdedEffects = BUILDER
//				.comment("Define the list of Modded Effects for multiples Mods! (Default \"examplemod:example_effect\", \"examplemod:another_effect\" | List of String), more information in https://github.com/Samlegamer/PotionRingReforged/wiki").
//				defineList("List of Modded Effects", Lists.newArrayList("examplemod:example_effect", "examplemod:another_effect"),  o -> o instanceof String);
		numberOfRingsSlots = BUILDER
				.comment("Define the number of rings slots registered (Default : 2 | INT ONLY) ")
				.defineInRange("Number Of Rings Slots", 2, 1, 255);

		//tuto:example_effect;lycanitesmobs:leech;

		BUILDER.pop();
		SPEC = BUILDER.build();
	}
}
