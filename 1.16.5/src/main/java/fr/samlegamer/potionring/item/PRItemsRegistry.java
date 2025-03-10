package fr.samlegamer.potionring.item;

import com.electronwill.nightconfig.core.file.FileConfig;
import fr.samlegamer.potionring.PotionRing;
import fr.samlegamer.potionring.cfg.ConfigLoad;
import fr.samlegamer.potionring.cfg.TutorialConfig;
import net.minecraft.item.Item;
import net.minecraft.potion.Effects;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.nio.file.Path;

public class PRItemsRegistry
{
	public static final DeferredRegister<Item> ITEMS_REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, PotionRing.MODID);

	public static final RegistryObject<PotionRingItem> POTION_RING = ITEMS_REGISTRY.register("potion_ring", () -> new PotionRingItem(null));
	public static final RegistryObject<PotionRingItem> RING_OF_REGENERATION = ITEMS_REGISTRY.register("ring_of_regeneration", () -> new PotionRingItem(Effects.REGENERATION));
	public static final RegistryObject<PotionRingItem> RING_OF_HASTE = ITEMS_REGISTRY.register("ring_of_haste", () -> new PotionRingItem(Effects.DIG_SPEED));
	public static final RegistryObject<PotionRingItem> RING_OF_JUMP_BOOST = ITEMS_REGISTRY.register("ring_of_jump_boost", () -> new PotionRingItem(Effects.JUMP));
	public static final RegistryObject<PotionRingItem> RING_OF_RESISTANCE = ITEMS_REGISTRY.register("ring_of_resistance", () -> new PotionRingItem(Effects.DAMAGE_RESISTANCE));
	public static final RegistryObject<PotionRingItem> RING_OF_SPEED = ITEMS_REGISTRY.register("ring_of_speed", () -> new PotionRingItem(Effects.MOVEMENT_SPEED));
	public static final RegistryObject<PotionRingItem> RING_OF_STRENGTH = ITEMS_REGISTRY.register("ring_of_strengh", () -> new PotionRingItem(Effects.DAMAGE_BOOST));

	// Config Update
	public static RegistryObject<PotionRingItem> RING_OF_FIRE_RESISTANCE, RING_OF_INVISIBILITY, RING_OF_SLOWNESS, RING_OF_MINING_FATIGUE, RING_OF_NAUSEA,
			RING_OF_BLINDNESS, RING_OF_HUNGER, RING_OF_NIGHT_VISION, RING_OF_SATURATION, RING_OF_POISON, RING_OF_WATER_BREATHING, RING_OF_WEAKNESS,
			RING_OF_WITHER, RING_OF_GLOWING, RING_OF_LEVITATION, RING_OF_LUCK, RING_OF_UNLUCK, RING_OF_SLOW_FALLING, RING_OF_CONDUIT_POWER,
			RING_OF_DOLPHIN_GRACE;

	public static void registryVanillaRings()
	{
		ITEMS_REGISTRY.register("ring_of_fire_resistance", () -> new PotionRingItem(
				Effects.FIRE_RESISTANCE, ConfigLoad.enableFireResistanceRing
		));
		//RING_OF_FIRE_RESISTANCE = ITEMS_REGISTRY.register("ring_of_fire_resistance", () -> new PotionRingItem(Effects.FIRE_RESISTANCE, TutorialConfig.example_string.get()));
		RING_OF_INVISIBILITY = ITEMS_REGISTRY.register("ring_of_invisibility", () -> new PotionRingItem(Effects.INVISIBILITY, ConfigLoad.enableInvisibilityRing));
		RING_OF_SLOWNESS = ITEMS_REGISTRY.register("ring_of_slowness", () -> new PotionRingItem(Effects.MOVEMENT_SLOWDOWN, ConfigLoad.enableSlownessRing));
		RING_OF_MINING_FATIGUE = ITEMS_REGISTRY.register("ring_of_mining_fatigue", () -> new PotionRingItem(Effects.DIG_SLOWDOWN, ConfigLoad.enableMiningFatigueRing));
		RING_OF_NAUSEA = ITEMS_REGISTRY.register("ring_of_nausea", () -> new PotionRingItem(Effects.CONFUSION, ConfigLoad.enableNauseaRing));
		RING_OF_BLINDNESS = ITEMS_REGISTRY.register("ring_of_blindness", () -> new PotionRingItem(Effects.BLINDNESS, ConfigLoad.enableBlindnessRing));
		RING_OF_HUNGER = ITEMS_REGISTRY.register("ring_of_hunger", () -> new PotionRingItem(Effects.HUNGER, ConfigLoad.enableHungerRing));
		RING_OF_NIGHT_VISION = ITEMS_REGISTRY.register("ring_of_night_vision", () -> new PotionRingItem(Effects.NIGHT_VISION, ConfigLoad.enableNightVisionRing));
		RING_OF_SATURATION = ITEMS_REGISTRY.register("ring_of_saturation", () -> new PotionRingItem(Effects.SATURATION, ConfigLoad.enableSaturationRing));
		RING_OF_POISON = ITEMS_REGISTRY.register("ring_of_poison", () -> new PotionRingItem(Effects.POISON, ConfigLoad.enablePoisonRing));
		RING_OF_WATER_BREATHING = ITEMS_REGISTRY.register("ring_of_water_breathing", () -> new PotionRingItem(Effects.WATER_BREATHING, ConfigLoad.enableWaterBreathingRing));
		RING_OF_WEAKNESS = ITEMS_REGISTRY.register("ring_of_weakness", () -> new PotionRingItem(Effects.WEAKNESS, ConfigLoad.enableWeaknessRing));
		RING_OF_WITHER = ITEMS_REGISTRY.register("ring_of_wither", () -> new PotionRingItem(Effects.WITHER, ConfigLoad.enableWitherRing));
		RING_OF_GLOWING = ITEMS_REGISTRY.register("ring_of_glowing", () -> new PotionRingItem(Effects.GLOWING, ConfigLoad.enableGlowingRing));
		RING_OF_LEVITATION = ITEMS_REGISTRY.register("ring_of_levitation", () -> new PotionRingItem(Effects.LEVITATION, ConfigLoad.enableLevitationRing));
		RING_OF_LUCK = ITEMS_REGISTRY.register("ring_of_luck", () -> new PotionRingItem(Effects.LUCK, ConfigLoad.enableLuckRing));
		RING_OF_UNLUCK = ITEMS_REGISTRY.register("ring_of_unluck", () -> new PotionRingItem(Effects.UNLUCK, ConfigLoad.enableUnluckRing));
		RING_OF_SLOW_FALLING = ITEMS_REGISTRY.register("ring_of_slow_falling", () -> new PotionRingItem(Effects.SLOW_FALLING, ConfigLoad.enableSlowFallingRing));
		RING_OF_CONDUIT_POWER = ITEMS_REGISTRY.register("ring_of_conduit_power", () -> new PotionRingItem(Effects.CONDUIT_POWER, ConfigLoad.enableConduitPowerRing));
		RING_OF_DOLPHIN_GRACE = ITEMS_REGISTRY.register("ring_of_dolphins_grace", () -> new PotionRingItem(Effects.DOLPHINS_GRACE, ConfigLoad.enableDolphinsGraceRing));
	}
}