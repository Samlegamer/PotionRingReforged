package fr.samlegamer.potionring.cfg;

import net.minecraftforge.common.ForgeConfigSpec;

public final class RingsConfig
{
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;

	public static final ForgeConfigSpec.ConfigValue<Integer> numberOfRingsSlots;

	static {
		BUILDER.push("Potions Rings REFORGED Config !");

		numberOfRingsSlots = BUILDER
				.comment("Define the number of rings slots registered (Default : 2 | INT ONLY) ")
				.defineInRange("Number Of Rings Slots", 2, 1, 255);

		BUILDER.pop();
		SPEC = BUILDER.build();
	}
}
