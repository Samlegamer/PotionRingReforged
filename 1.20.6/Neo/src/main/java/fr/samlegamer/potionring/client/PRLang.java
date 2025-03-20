package fr.samlegamer.potionring.client;

import fr.samlegamer.potionring.PotionRing;
import fr.samlegamer.potionring.item.PRItemsRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class PRLang extends LanguageProvider
{
    public PRLang(PackOutput output) {
        super(output, PotionRing.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add(PRItemsRegistry.POTION_RING.get(), "Potion Ring");
        add(PRItemsRegistry.RING_OF_HASTE.get(), "Ring of Haste");
        add(PRItemsRegistry.RING_OF_JUMP_BOOST.get(), "Ring of Jump Boost");
        add(PRItemsRegistry.RING_OF_RESISTANCE.get(), "Ring of Resistance");
        add(PRItemsRegistry.RING_OF_SPEED.get(), "Ring of Speed");
        add(PRItemsRegistry.RING_OF_STRENGTH.get(), "Ring of Strength");
        add(PRItemsRegistry.RING_OF_REGENERATION.get(), "Ring of Regeneration");

        add(PRItemsRegistry.RING_OF_FIRE_RESISTANCE.get(), "Ring of Fire Resistance");
        add(PRItemsRegistry.RING_OF_INVISIBILITY.get(), "Ring of Invisibility");
        add(PRItemsRegistry.RING_OF_SLOWNESS.get(), "Ring of Slowness");
        add(PRItemsRegistry.RING_OF_MINING_FATIGUE.get(), "Ring of Mining Fatigue");
        add(PRItemsRegistry.RING_OF_NAUSEA.get(), "Ring of Nausea");
        add(PRItemsRegistry.RING_OF_BLINDNESS.get(), "Ring of Blindness");
        add(PRItemsRegistry.RING_OF_HUNGER.get(), "Ring of Hunger");
        add(PRItemsRegistry.RING_OF_SATURATION.get(), "Ring of Saturation");
        add(PRItemsRegistry.RING_OF_NIGHT_VISION.get(), "Ring of Night Vision");
        add(PRItemsRegistry.RING_OF_POISON.get(), "Ring of Poison");
        add(PRItemsRegistry.RING_OF_WATER_BREATHING.get(), "Ring of Water Breathing");
        add(PRItemsRegistry.RING_OF_WEAKNESS.get(), "Ring of Weakness");
        add(PRItemsRegistry.RING_OF_WITHER.get(), "Ring of Wither");
        add(PRItemsRegistry.RING_OF_GLOWING.get(), "Ring of Glowing");
        add(PRItemsRegistry.RING_OF_LEVITATION.get(), "Ring of Levitation");
        add(PRItemsRegistry.RING_OF_LUCK.get(), "Ring of Luck");
        add(PRItemsRegistry.RING_OF_UNLUCK.get(), "Ring of Bad Luck");
        add(PRItemsRegistry.RING_OF_SLOW_FALLING.get(), "Ring of Slow Falling");
        add(PRItemsRegistry.RING_OF_CONDUIT_POWER.get(), "Ring of Conduit Power");
        add(PRItemsRegistry.RING_OF_DOLPHIN_GRACE.get(), "Ring of Dolphin Grace");
        add(PRItemsRegistry.RING_OF_DARKNESS.get(), "Ring of Darkness");

        add(BuiltInRegistries.ITEM.get(new ResourceLocation("potionring", "ring_of_example_effect")), "Ring of Example Effect");
        add(BuiltInRegistries.ITEM.get(new ResourceLocation("potionring", "ring_of_another_effect")), "Ring of Another Effect");
    }
}
