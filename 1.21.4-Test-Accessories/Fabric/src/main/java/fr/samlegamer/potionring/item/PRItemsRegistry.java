package fr.samlegamer.potionring.item;

import com.google.common.collect.Lists;
import fr.samlegamer.potionring.PotionRing;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class PRItemsRegistry
{
	// Config Update
	public static PotionRingItem POTION_RING, RING_OF_REGENERATION, RING_OF_HASTE, RING_OF_JUMP_BOOST, RING_OF_RESISTANCE, RING_OF_SPEED, RING_OF_STRENGTH,
			RING_OF_FIRE_RESISTANCE, RING_OF_INVISIBILITY, RING_OF_SLOWNESS, RING_OF_MINING_FATIGUE, RING_OF_NAUSEA,
			RING_OF_BLINDNESS, RING_OF_HUNGER, RING_OF_NIGHT_VISION, RING_OF_SATURATION, RING_OF_POISON, RING_OF_WATER_BREATHING, RING_OF_WEAKNESS,
			RING_OF_WITHER, RING_OF_GLOWING, RING_OF_LEVITATION, RING_OF_LUCK, RING_OF_UNLUCK, RING_OF_SLOW_FALLING, RING_OF_CONDUIT_POWER,
			RING_OF_DOLPHIN_GRACE, RING_OF_DARKNESS;

	public static PotionRingItem registerPotionRings(String name, PotionRingItem potionRing) {
		Registry.register(Registries.ITEM, Identifier.of(PotionRing.MODID, name), potionRing);
		return potionRing;
	}

	public static PotionRingItemModded registerPotionRingsModded(String name, PotionRingItemModded potionRing) {
		Registry.register(Registries.ITEM, Identifier.of(PotionRing.MODID, name), potionRing);
		return potionRing;
	}

	public static void registryVanillaRings()
	{
		POTION_RING = registerPotionRings("potion_ring", new PotionRingItem("potion_ring", null));
		RING_OF_REGENERATION = registerPotionRings("ring_of_regeneration", new PotionRingItem("ring_of_regeneration", StatusEffects.REGENERATION));
		RING_OF_HASTE = registerPotionRings("ring_of_haste", new PotionRingItem("ring_of_haste", StatusEffects.HASTE));
		RING_OF_JUMP_BOOST = registerPotionRings("ring_of_jump_boost", new PotionRingItem("ring_of_jump_boost", StatusEffects.JUMP_BOOST));
		RING_OF_RESISTANCE = registerPotionRings("ring_of_resistance", new PotionRingItem("ring_of_resistance", StatusEffects.RESISTANCE));
		RING_OF_SPEED = registerPotionRings("ring_of_speed", new PotionRingItem("ring_of_speed", StatusEffects.SPEED));
		RING_OF_STRENGTH = registerPotionRings("ring_of_strength", new PotionRingItem("ring_of_strength", StatusEffects.STRENGTH));

		RING_OF_FIRE_RESISTANCE = registerPotionRings("ring_of_fire_resistance", new PotionRingItem("ring_of_fire_resistance", StatusEffects.FIRE_RESISTANCE));
		RING_OF_INVISIBILITY = registerPotionRings("ring_of_invisibility", new PotionRingItem("ring_of_invisibility", StatusEffects.INVISIBILITY));
		RING_OF_SLOWNESS = registerPotionRings("ring_of_slowness", new PotionRingItem("ring_of_slowness", StatusEffects.SLOWNESS));
		RING_OF_MINING_FATIGUE = registerPotionRings("ring_of_mining_fatigue", new PotionRingItem("ring_of_mining_fatigue", StatusEffects.MINING_FATIGUE));
		RING_OF_NAUSEA = registerPotionRings("ring_of_nausea", new PotionRingItem("ring_of_nausea", StatusEffects.NAUSEA));
		RING_OF_BLINDNESS = registerPotionRings("ring_of_blindness", new PotionRingItem("ring_of_blindness", StatusEffects.BLINDNESS));
		RING_OF_HUNGER = registerPotionRings("ring_of_hunger", new PotionRingItem("ring_of_hunger", StatusEffects.HUNGER));
		RING_OF_NIGHT_VISION = registerPotionRings("ring_of_night_vision", new PotionRingItem("ring_of_night_vision", StatusEffects.NIGHT_VISION));
		RING_OF_SATURATION = registerPotionRings("ring_of_saturation", new PotionRingItem("ring_of_saturation", StatusEffects.SATURATION));
		RING_OF_POISON = registerPotionRings("ring_of_poison", new PotionRingItem("ring_of_poison", StatusEffects.POISON));
		RING_OF_WATER_BREATHING = registerPotionRings("ring_of_water_breathing", new PotionRingItem("ring_of_water_breathing", StatusEffects.WATER_BREATHING));
		RING_OF_WEAKNESS = registerPotionRings("ring_of_weakness", new PotionRingItem("ring_of_weakness", StatusEffects.WEAKNESS));
		RING_OF_WITHER = registerPotionRings("ring_of_wither", new PotionRingItem("ring_of_wither", StatusEffects.WITHER));
		RING_OF_GLOWING = registerPotionRings("ring_of_glowing", new PotionRingItem("ring_of_glowing", StatusEffects.GLOWING));
		RING_OF_LEVITATION = registerPotionRings("ring_of_levitation", new PotionRingItem("ring_of_levitation", StatusEffects.LEVITATION));
		RING_OF_LUCK = registerPotionRings("ring_of_luck", new PotionRingItem("ring_of_luck", StatusEffects.LUCK));
		RING_OF_UNLUCK = registerPotionRings("ring_of_unluck", new PotionRingItem("ring_of_unluck", StatusEffects.UNLUCK));
		RING_OF_SLOW_FALLING = registerPotionRings("ring_of_slow_falling", new PotionRingItem("ring_of_slow_falling", StatusEffects.SLOW_FALLING));
		RING_OF_CONDUIT_POWER = registerPotionRings("ring_of_conduit_power", new PotionRingItem("ring_of_conduit_power", StatusEffects.CONDUIT_POWER));
		RING_OF_DOLPHIN_GRACE = registerPotionRings("ring_of_dolphins_grace", new PotionRingItem("ring_of_dolphins_grace", StatusEffects.DOLPHINS_GRACE));
		RING_OF_DARKNESS = registerPotionRings("ring_of_darkness", new PotionRingItem("ring_of_darkness", StatusEffects.DARKNESS));
	}

	public static List<?> createNewFileOrLearn(boolean returnColor)
	{
		Path file = Paths.get(FabricLoader.getInstance().getConfigDir().toString(), "potionring.txt");

		if (!Files.exists(file))
		{
			try(BufferedWriter bufferedWriter = Files.newBufferedWriter(file, StandardCharsets.UTF_8))
			{
				bufferedWriter.write("examplemod:example_effect#15182205");
				bufferedWriter.newLine();
				bufferedWriter.write("examplemod:another_effect#12207722");
			}
			catch (IOException e)
			{
				PotionRing.log.warn("Error while creating potionring.txt");
			}
		}

		List<String> lines = Lists.newArrayList();
		List<Integer> colors = Lists.newArrayList();

		try(BufferedReader bufferedReader = Files.newBufferedReader(file, StandardCharsets.UTF_8))
		{
			for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine())
			{
				String[] parts = line.split("#");
				if (parts.length == 2) {
					final int color = Integer.parseInt(parts[1]);
					final String modAndId = parts[0];

					colors.add(color);
					lines.add(modAndId);
				}
			}
		}
		catch (IOException e)
		{
			PotionRing.log.warn("Error reading potionring.txt");
		}

		if(returnColor)
		{
			return colors;
		}

		return lines;
	}

	public static PotionRingItemModded RING_OF_GROWING, RING_OF_SHRINKING, RING_OF_THINNING, RING_OF_WIDENING;

	public static void registryModdedCustom()
	{
		// Rings for Size Shifting Potions
		RING_OF_GROWING = registerPotionRingsModded
				("ring_of_growing", new PotionRingItemModded("sizeshiftingpotions", "growing"));

		RING_OF_SHRINKING = registerPotionRingsModded
				("ring_of_shrinking", new PotionRingItemModded("sizeshiftingpotions", "shrinking"));

		RING_OF_THINNING = registerPotionRingsModded
				("ring_of_thinning", new PotionRingItemModded("sizeshiftingpotions", "thinning"));

		RING_OF_WIDENING = registerPotionRingsModded
				("ring_of_widening", new PotionRingItemModded("sizeshiftingpotions", "widening"));

		List<String> list = (List<String>) createNewFileOrLearn(false);

		if(!list.isEmpty()) {
            for (String s : list) {
                String[] parts = s.split(":");
                if (parts.length == 2) {
                    final String mod = parts[0];
                    final String id = parts[1];

                    final PotionRingItemModded RING_BASE_POTION = registerPotionRingsModded("ring_of_" + id, new PotionRingItemModded(mod, id));
                }
            }
		}
	}
}