package fr.samlegamer.potionring.item;

import com.google.common.collect.Lists;
import fr.samlegamer.potionring.PotionRing;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.loading.FMLPaths;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
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
	public static final DeferredRegister.Items ITEMS_REGISTRY = DeferredRegister.createItems(PotionRing.MODID);

	public static final DeferredHolder<Item, PotionRingItem> POTION_RING = ITEMS_REGISTRY.register("potion_ring", () -> new PotionRingItem("potion_ring", null));
	public static final DeferredHolder<Item, PotionRingItem> RING_OF_REGENERATION = ITEMS_REGISTRY.register("ring_of_regeneration", () -> new PotionRingItem("ring_of_regeneration", MobEffects.REGENERATION));
	public static final DeferredHolder<Item, PotionRingItem> RING_OF_HASTE = ITEMS_REGISTRY.register("ring_of_haste", () -> new PotionRingItem("ring_of_haste", MobEffects.HASTE));
	public static final DeferredHolder<Item, PotionRingItem> RING_OF_JUMP_BOOST = ITEMS_REGISTRY.register("ring_of_jump_boost", () -> new PotionRingItem("ring_of_jump_boost", MobEffects.JUMP_BOOST));
	public static final DeferredHolder<Item, PotionRingItem> RING_OF_RESISTANCE = ITEMS_REGISTRY.register("ring_of_resistance", () -> new PotionRingItem("ring_of_resistance", MobEffects.RESISTANCE));
	public static final DeferredHolder<Item, PotionRingItem> RING_OF_SPEED = ITEMS_REGISTRY.register("ring_of_speed", () -> new PotionRingItem("ring_of_speed", MobEffects.SPEED));
	public static final DeferredHolder<Item, PotionRingItem> RING_OF_STRENGTH = ITEMS_REGISTRY.register("ring_of_strengh", () -> new PotionRingItem("ring_of_strengh", MobEffects.STRENGTH));

	// Config Update
	public static DeferredHolder<Item, PotionRingItem> RING_OF_FIRE_RESISTANCE, RING_OF_INVISIBILITY, RING_OF_SLOWNESS, RING_OF_MINING_FATIGUE, RING_OF_NAUSEA,
			RING_OF_BLINDNESS, RING_OF_HUNGER, RING_OF_NIGHT_VISION, RING_OF_SATURATION, RING_OF_POISON, RING_OF_WATER_BREATHING, RING_OF_WEAKNESS,
			RING_OF_WITHER, RING_OF_GLOWING, RING_OF_LEVITATION, RING_OF_LUCK, RING_OF_UNLUCK, RING_OF_SLOW_FALLING, RING_OF_CONDUIT_POWER,
			RING_OF_DOLPHIN_GRACE, RING_OF_DARKNESS;

	public static void registryVanillaRings()
	{
		RING_OF_FIRE_RESISTANCE = ITEMS_REGISTRY.register("ring_of_fire_resistance", () -> new PotionRingItem("ring_of_fire_resistance", MobEffects.FIRE_RESISTANCE));
		RING_OF_INVISIBILITY = ITEMS_REGISTRY.register("ring_of_invisibility", () -> new PotionRingItem("ring_of_invisibility", MobEffects.INVISIBILITY));
		RING_OF_SLOWNESS = ITEMS_REGISTRY.register("ring_of_slowness", () -> new PotionRingItem("ring_of_slowness", MobEffects.SLOWNESS));
		RING_OF_MINING_FATIGUE = ITEMS_REGISTRY.register("ring_of_mining_fatigue", () -> new PotionRingItem("ring_of_mining_fatigue", MobEffects.MINING_FATIGUE));
		RING_OF_NAUSEA = ITEMS_REGISTRY.register("ring_of_nausea", () -> new PotionRingItem("ring_of_nausea", MobEffects.NAUSEA));
		RING_OF_BLINDNESS = ITEMS_REGISTRY.register("ring_of_blindness", () -> new PotionRingItem("ring_of_blindness", MobEffects.BLINDNESS));
		RING_OF_HUNGER = ITEMS_REGISTRY.register("ring_of_hunger", () -> new PotionRingItem("ring_of_hunger", MobEffects.HUNGER));
		RING_OF_NIGHT_VISION = ITEMS_REGISTRY.register("ring_of_night_vision", () -> new PotionRingItem("ring_of_night_vision", MobEffects.NIGHT_VISION));
		RING_OF_SATURATION = ITEMS_REGISTRY.register("ring_of_saturation", () -> new PotionRingItem("ring_of_saturation", MobEffects.SATURATION));
		RING_OF_POISON = ITEMS_REGISTRY.register("ring_of_poison", () -> new PotionRingItem("ring_of_poison", MobEffects.POISON));
		RING_OF_WATER_BREATHING = ITEMS_REGISTRY.register("ring_of_water_breathing", () -> new PotionRingItem("ring_of_water_breathing", MobEffects.WATER_BREATHING));
		RING_OF_WEAKNESS = ITEMS_REGISTRY.register("ring_of_weakness", () -> new PotionRingItem("ring_of_weakness", MobEffects.WEAKNESS));
		RING_OF_WITHER = ITEMS_REGISTRY.register("ring_of_wither", () -> new PotionRingItem("ring_of_wither", MobEffects.WITHER));
		RING_OF_GLOWING = ITEMS_REGISTRY.register("ring_of_glowing", () -> new PotionRingItem("ring_of_glowing", MobEffects.GLOWING));
		RING_OF_LEVITATION = ITEMS_REGISTRY.register("ring_of_levitation", () -> new PotionRingItem("ring_of_levitation", MobEffects.LEVITATION));
		RING_OF_LUCK = ITEMS_REGISTRY.register("ring_of_luck", () -> new PotionRingItem("ring_of_luck", MobEffects.LUCK));
		RING_OF_UNLUCK = ITEMS_REGISTRY.register("ring_of_unluck", () -> new PotionRingItem("ring_of_unluck", MobEffects.UNLUCK));
		RING_OF_SLOW_FALLING = ITEMS_REGISTRY.register("ring_of_slow_falling", () -> new PotionRingItem("ring_of_slow_falling", MobEffects.SLOW_FALLING));
		RING_OF_CONDUIT_POWER = ITEMS_REGISTRY.register("ring_of_conduit_power", () -> new PotionRingItem("ring_of_conduit_power", MobEffects.CONDUIT_POWER));
		RING_OF_DOLPHIN_GRACE = ITEMS_REGISTRY.register("ring_of_dolphins_grace", () -> new PotionRingItem("ring_of_dolphins_grace", MobEffects.DOLPHINS_GRACE));
		RING_OF_DARKNESS = ITEMS_REGISTRY.register("ring_of_darkness", () -> new PotionRingItem("ring_of_darkness", MobEffects.DARKNESS));
	}

	public static List<?> createNewFileOrLearn(boolean returnColor)
	{
		Path file = Paths.get(FMLPaths.CONFIGDIR.get().toString(), "potionring.txt");

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

	public static void registryModdedCustom(IEventBus bus)
	{
        final DeferredRegister.Items IT = DeferredRegister.createItems(PotionRing.MODID);

		// Rings for Size Shifting Potions
		final DeferredHolder<Item, PotionRingItemModded> RING_OF_GROWING = IT.register
				("ring_of_growing", () -> new PotionRingItemModded("sizeshiftingpotions", "growing"));

		final DeferredHolder<Item, PotionRingItemModded> RING_OF_SHRINKING = IT.register
				("ring_of_shrinking", () -> new PotionRingItemModded("sizeshiftingpotions", "shrinking"));

		final DeferredHolder<Item, PotionRingItemModded> RING_OF_THINNING = IT.register
				("ring_of_thinning", () -> new PotionRingItemModded("sizeshiftingpotions", "thinning"));

		final DeferredHolder<Item, PotionRingItemModded> RING_OF_WIDENING = IT.register
				("ring_of_widening", () -> new PotionRingItemModded("sizeshiftingpotions", "widening"));

		List<String> list = (List<String>) createNewFileOrLearn(false);

		if(!list.isEmpty()) {
            for (String s : list) {
                String[] parts = s.split(":");
                if (parts.length == 2) {
                    final String mod = parts[0];
                    final String id = parts[1];

                    final DeferredHolder<Item, PotionRingItemModded> RING_BASE_POTION = IT.register
                            ("ring_of_" + id, () -> new PotionRingItemModded(mod, id));
                }
            }
		}

        IT.register(bus);
	}
}