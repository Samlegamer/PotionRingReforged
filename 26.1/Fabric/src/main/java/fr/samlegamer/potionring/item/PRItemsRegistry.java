package fr.samlegamer.potionring.item;

import com.google.common.collect.Lists;
import fr.samlegamer.potionring.PotionRing;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;

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

	public static PotionRingItem registerPotionRings(String name, Holder<MobEffect> effectRegistryEntry) {
        PotionRingItem potionRing = new PotionRingItem(name, effectRegistryEntry);
		Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(PotionRing.MODID, name), potionRing);
		return potionRing;
	}

	public static PotionRingItemModded registerPotionRingsModded(String name, PotionRingItemModded potionRing) {
		Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(PotionRing.MODID, name), potionRing);
		return potionRing;
	}

	public static void registryVanillaRings()
	{
		POTION_RING = registerPotionRings("potion_ring", null);
		RING_OF_REGENERATION = registerPotionRings("ring_of_regeneration", MobEffects.REGENERATION);
		RING_OF_HASTE = registerPotionRings("ring_of_haste", MobEffects.HASTE);
		RING_OF_JUMP_BOOST = registerPotionRings("ring_of_jump_boost", MobEffects.JUMP_BOOST);
		RING_OF_RESISTANCE = registerPotionRings("ring_of_resistance", MobEffects.RESISTANCE);
		RING_OF_SPEED = registerPotionRings("ring_of_speed", MobEffects.SPEED);
		RING_OF_STRENGTH = registerPotionRings("ring_of_strengh", MobEffects.STRENGTH);

		RING_OF_FIRE_RESISTANCE = registerPotionRings("ring_of_fire_resistance", MobEffects.FIRE_RESISTANCE);
		RING_OF_INVISIBILITY = registerPotionRings("ring_of_invisibility", MobEffects.INVISIBILITY);
		RING_OF_SLOWNESS = registerPotionRings("ring_of_slowness", MobEffects.SLOWNESS);
		RING_OF_MINING_FATIGUE = registerPotionRings("ring_of_mining_fatigue", MobEffects.MINING_FATIGUE);
		RING_OF_NAUSEA = registerPotionRings("ring_of_nausea", MobEffects.NAUSEA);
		RING_OF_BLINDNESS = registerPotionRings("ring_of_blindness", MobEffects.BLINDNESS);
		RING_OF_HUNGER = registerPotionRings("ring_of_hunger", MobEffects.HUNGER);
		RING_OF_NIGHT_VISION = registerPotionRings("ring_of_night_vision", MobEffects.NIGHT_VISION);
		RING_OF_SATURATION = registerPotionRings("ring_of_saturation", MobEffects.SATURATION);
		RING_OF_POISON = registerPotionRings("ring_of_poison", MobEffects.POISON);
		RING_OF_WATER_BREATHING = registerPotionRings("ring_of_water_breathing", MobEffects.WATER_BREATHING);
		RING_OF_WEAKNESS = registerPotionRings("ring_of_weakness", MobEffects.WEAKNESS);
		RING_OF_WITHER = registerPotionRings("ring_of_wither", MobEffects.WITHER);
		RING_OF_GLOWING = registerPotionRings("ring_of_glowing", MobEffects.GLOWING);
		RING_OF_LEVITATION = registerPotionRings("ring_of_levitation", MobEffects.LEVITATION);
		RING_OF_LUCK = registerPotionRings("ring_of_luck", MobEffects.LUCK);
		RING_OF_UNLUCK = registerPotionRings("ring_of_unluck", MobEffects.UNLUCK);
		RING_OF_SLOW_FALLING = registerPotionRings("ring_of_slow_falling", MobEffects.SLOW_FALLING);
		RING_OF_CONDUIT_POWER = registerPotionRings("ring_of_conduit_power", MobEffects.CONDUIT_POWER);
		RING_OF_DOLPHIN_GRACE = registerPotionRings("ring_of_dolphins_grace", MobEffects.DOLPHINS_GRACE);
		RING_OF_DARKNESS = registerPotionRings("ring_of_darkness", MobEffects.DARKNESS);
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