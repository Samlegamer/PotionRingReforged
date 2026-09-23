package fr.samlegamer.potionring.item;

import fr.samlegamer.potionring.PotionRing;
import fr.samlegamer.potionring.util.RingAPI;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.List;

public class PRItemsMap
{
	public static LinkedHashMap<String, Holder<MobEffect>> itemsVanillaMap()
	{
		LinkedHashMap<String, Holder<MobEffect>> map = new LinkedHashMap<>();
		map.put("regeneration", MobEffects.REGENERATION);
		map.put("haste", MobEffects.HASTE);
		map.put("jump_boost", MobEffects.JUMP_BOOST);
		map.put("resistance", MobEffects.RESISTANCE);
		map.put("speed", MobEffects.SPEED);
		map.put("strength", MobEffects.STRENGTH);
		map.put("fire_resistance", MobEffects.FIRE_RESISTANCE);
		map.put("invisibility", MobEffects.INVISIBILITY);
		map.put("slowness", MobEffects.SLOWNESS);
		map.put("mining_fatigue", MobEffects.MINING_FATIGUE);
		map.put("nausea", MobEffects.NAUSEA);
		map.put("blindness", MobEffects.BLINDNESS);
		map.put("hunger", MobEffects.HUNGER);
		map.put("night_vision", MobEffects.NIGHT_VISION);
		map.put("saturation", MobEffects.SATURATION);
		map.put("poison", MobEffects.POISON);
		map.put("water_breathing", MobEffects.WATER_BREATHING);
		map.put("weakness", MobEffects.WEAKNESS);
		map.put("wither", MobEffects.WITHER);
		map.put("glowing", MobEffects.GLOWING);
		map.put("levitation", MobEffects.LEVITATION);
		map.put("luck", MobEffects.LUCK);
		map.put("unluck", MobEffects.UNLUCK);
		map.put("slow_falling", MobEffects.SLOW_FALLING);
		map.put("conduit_power", MobEffects.CONDUIT_POWER);
		map.put("dolphins_grace", MobEffects.DOLPHINS_GRACE);
		map.put("darkness", MobEffects.DARKNESS);
		return map;
	}

	public static LinkedHashMap<String, String> itemsModdedMap(RingAPI ringAPI)
	{
		String ssp_id = "sizeshiftingpotions";
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		List<String> list = createNewFileOrLearn(ringAPI.configDir()).keySet().stream().toList();

		map.put("growing", ssp_id);
		map.put("shrinking", ssp_id);
		map.put("thinning", ssp_id);
		map.put("widening", ssp_id);

		if(!list.isEmpty()) {
            for (String s : list) {
                String[] parts = s.split(":");
                if (parts.length == 2) {
                    final String mod = parts[0];
                    final String id = parts[1];

					map.put(id, mod);
                }
            }
		}

		return map;
	}

	public static LinkedHashMap<String, Integer> createNewFileOrLearn(String configDir)
	{
		Path file = Paths.get(configDir, "potionring.txt");
		LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

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

		try(BufferedReader bufferedReader = Files.newBufferedReader(file, StandardCharsets.UTF_8))
		{
			for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine())
			{
				String[] parts = line.split("#");
				if (parts.length == 2) {
					final int color = Integer.parseInt(parts[1]);
					final String modAndId = parts[0];

					map.put(modAndId, color);
				}
			}
		}
		catch (IOException e)
		{
			PotionRing.log.warn("Error reading potionring.txt");
		}

		return map;
	}
}