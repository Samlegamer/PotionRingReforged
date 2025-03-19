package fr.samlegamer.potionring.item;

import com.google.common.collect.Lists;
import fr.samlegamer.potionring.PotionRing;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

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
	public static final DeferredRegister<Item> ITEMS_REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, PotionRing.MODID);

	public static final RegistryObject<PotionRingItem> POTION_RING = ITEMS_REGISTRY.register("potion_ring", () -> new PotionRingItem(null));
	public static final RegistryObject<PotionRingItem> RING_OF_REGENERATION = ITEMS_REGISTRY.register("ring_of_regeneration", () -> new PotionRingItem(MobEffects.REGENERATION));
	public static final RegistryObject<PotionRingItem> RING_OF_HASTE = ITEMS_REGISTRY.register("ring_of_haste", () -> new PotionRingItem(MobEffects.DIG_SPEED));
	public static final RegistryObject<PotionRingItem> RING_OF_JUMP_BOOST = ITEMS_REGISTRY.register("ring_of_jump_boost", () -> new PotionRingItem(MobEffects.JUMP));
	public static final RegistryObject<PotionRingItem> RING_OF_RESISTANCE = ITEMS_REGISTRY.register("ring_of_resistance", () -> new PotionRingItem(MobEffects.DAMAGE_RESISTANCE));
	public static final RegistryObject<PotionRingItem> RING_OF_SPEED = ITEMS_REGISTRY.register("ring_of_speed", () -> new PotionRingItem(MobEffects.MOVEMENT_SPEED));
	public static final RegistryObject<PotionRingItem> RING_OF_STRENGTH = ITEMS_REGISTRY.register("ring_of_strengh", () -> new PotionRingItem(MobEffects.DAMAGE_BOOST));

	// Config Update
	public static RegistryObject<PotionRingItem> RING_OF_FIRE_RESISTANCE, RING_OF_INVISIBILITY, RING_OF_SLOWNESS, RING_OF_MINING_FATIGUE, RING_OF_NAUSEA,
			RING_OF_BLINDNESS, RING_OF_HUNGER, RING_OF_NIGHT_VISION, RING_OF_SATURATION, RING_OF_POISON, RING_OF_WATER_BREATHING, RING_OF_WEAKNESS,
			RING_OF_WITHER, RING_OF_GLOWING, RING_OF_LEVITATION, RING_OF_LUCK, RING_OF_UNLUCK, RING_OF_SLOW_FALLING, RING_OF_CONDUIT_POWER,
			RING_OF_DOLPHIN_GRACE, RING_OF_DARKNESS;

	public static void registryVanillaRings()
	{
		RING_OF_FIRE_RESISTANCE = ITEMS_REGISTRY.register("ring_of_fire_resistance", () -> new PotionRingItem(MobEffects.FIRE_RESISTANCE));
		RING_OF_INVISIBILITY = ITEMS_REGISTRY.register("ring_of_invisibility", () -> new PotionRingItem(MobEffects.INVISIBILITY));
		RING_OF_SLOWNESS = ITEMS_REGISTRY.register("ring_of_slowness", () -> new PotionRingItem(MobEffects.MOVEMENT_SLOWDOWN));
		RING_OF_MINING_FATIGUE = ITEMS_REGISTRY.register("ring_of_mining_fatigue", () -> new PotionRingItem(MobEffects.DIG_SLOWDOWN));
		RING_OF_NAUSEA = ITEMS_REGISTRY.register("ring_of_nausea", () -> new PotionRingItem(MobEffects.CONFUSION));
		RING_OF_BLINDNESS = ITEMS_REGISTRY.register("ring_of_blindness", () -> new PotionRingItem(MobEffects.BLINDNESS));
		RING_OF_HUNGER = ITEMS_REGISTRY.register("ring_of_hunger", () -> new PotionRingItem(MobEffects.HUNGER));
		RING_OF_NIGHT_VISION = ITEMS_REGISTRY.register("ring_of_night_vision", () -> new PotionRingItem(MobEffects.NIGHT_VISION));
		RING_OF_SATURATION = ITEMS_REGISTRY.register("ring_of_saturation", () -> new PotionRingItem(MobEffects.SATURATION));
		RING_OF_POISON = ITEMS_REGISTRY.register("ring_of_poison", () -> new PotionRingItem(MobEffects.POISON));
		RING_OF_WATER_BREATHING = ITEMS_REGISTRY.register("ring_of_water_breathing", () -> new PotionRingItem(MobEffects.WATER_BREATHING));
		RING_OF_WEAKNESS = ITEMS_REGISTRY.register("ring_of_weakness", () -> new PotionRingItem(MobEffects.WEAKNESS));
		RING_OF_WITHER = ITEMS_REGISTRY.register("ring_of_wither", () -> new PotionRingItem(MobEffects.WITHER));
		RING_OF_GLOWING = ITEMS_REGISTRY.register("ring_of_glowing", () -> new PotionRingItem(MobEffects.GLOWING));
		RING_OF_LEVITATION = ITEMS_REGISTRY.register("ring_of_levitation", () -> new PotionRingItem(MobEffects.LEVITATION));
		RING_OF_LUCK = ITEMS_REGISTRY.register("ring_of_luck", () -> new PotionRingItem(MobEffects.LUCK));
		RING_OF_UNLUCK = ITEMS_REGISTRY.register("ring_of_unluck", () -> new PotionRingItem(MobEffects.UNLUCK));
		RING_OF_SLOW_FALLING = ITEMS_REGISTRY.register("ring_of_slow_falling", () -> new PotionRingItem(MobEffects.SLOW_FALLING));
		RING_OF_CONDUIT_POWER = ITEMS_REGISTRY.register("ring_of_conduit_power", () -> new PotionRingItem(MobEffects.CONDUIT_POWER));
		RING_OF_DOLPHIN_GRACE = ITEMS_REGISTRY.register("ring_of_dolphins_grace", () -> new PotionRingItem(MobEffects.DOLPHINS_GRACE));
		RING_OF_DARKNESS = ITEMS_REGISTRY.register("ring_of_darkness", () -> new PotionRingItem(MobEffects.DARKNESS));
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
        final DeferredRegister<Item> IT = DeferredRegister.create(ForgeRegistries.ITEMS, PotionRing.MODID);

		List<String> list = (List<String>) createNewFileOrLearn(false);

		if(!list.isEmpty()) {
            for (String s : list) {
                String[] parts = s.split(":");
                if (parts.length == 2) {
                    final String mod = parts[0];
                    final String id = parts[1];

                    final RegistryObject<PotionRingItemModded> RING_BASE_POTION = IT.register
                            ("ring_of_" + id, () -> new PotionRingItemModded(mod, id));
                }
            }
		}

        IT.register(bus);
	}
}