package fr.samlegamer.potionring.client;

import fr.samlegamer.potionring.item.PRItemsRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class PRLang extends FabricLanguageProvider
{
    public PRLang(FabricDataOutput dataOutput) {
        super(dataOutput, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder)
    {
        translationBuilder.add(PRItemsRegistry.POTION_RING, "Potion Ring");
        translationBuilder.add(PRItemsRegistry.RING_OF_HASTE, "Ring of Haste");
        translationBuilder.add(PRItemsRegistry.RING_OF_JUMP_BOOST, "Ring of Jump Boost");
        translationBuilder.add(PRItemsRegistry.RING_OF_RESISTANCE, "Ring of Resistance");
        translationBuilder.add(PRItemsRegistry.RING_OF_SPEED, "Ring of Speed");
        translationBuilder.add(PRItemsRegistry.RING_OF_STRENGTH, "Ring of Strength");
        translationBuilder.add(PRItemsRegistry.RING_OF_REGENERATION, "Ring of Regeneration");

        translationBuilder.add(PRItemsRegistry.RING_OF_FIRE_RESISTANCE, "Ring of Fire Resistance");
        translationBuilder.add(PRItemsRegistry.RING_OF_INVISIBILITY, "Ring of Invisibility");
        translationBuilder.add(PRItemsRegistry.RING_OF_SLOWNESS, "Ring of Slowness");
        translationBuilder.add(PRItemsRegistry.RING_OF_MINING_FATIGUE, "Ring of Mining Fatigue");
        translationBuilder.add(PRItemsRegistry.RING_OF_NAUSEA, "Ring of Nausea");
        translationBuilder.add(PRItemsRegistry.RING_OF_BLINDNESS, "Ring of Blindness");
        translationBuilder.add(PRItemsRegistry.RING_OF_HUNGER, "Ring of Hunger");
        translationBuilder.add(PRItemsRegistry.RING_OF_SATURATION, "Ring of Saturation");
        translationBuilder.add(PRItemsRegistry.RING_OF_NIGHT_VISION, "Ring of Night Vision");
        translationBuilder.add(PRItemsRegistry.RING_OF_POISON, "Ring of Poison");
        translationBuilder.add(PRItemsRegistry.RING_OF_WATER_BREATHING, "Ring of Water Breathing");
        translationBuilder.add(PRItemsRegistry.RING_OF_WEAKNESS, "Ring of Weakness");
        translationBuilder.add(PRItemsRegistry.RING_OF_WITHER, "Ring of Wither");
        translationBuilder.add(PRItemsRegistry.RING_OF_GLOWING, "Ring of Glowing");
        translationBuilder.add(PRItemsRegistry.RING_OF_LEVITATION, "Ring of Levitation");
        translationBuilder.add(PRItemsRegistry.RING_OF_LUCK, "Ring of Luck");
        translationBuilder.add(PRItemsRegistry.RING_OF_UNLUCK, "Ring of Bad Luck");
        translationBuilder.add(PRItemsRegistry.RING_OF_SLOW_FALLING, "Ring of Slow Falling");
        translationBuilder.add(PRItemsRegistry.RING_OF_CONDUIT_POWER, "Ring of Conduit Power");
        translationBuilder.add(PRItemsRegistry.RING_OF_DOLPHIN_GRACE, "Ring of Dolphin Grace");
        translationBuilder.add(PRItemsRegistry.RING_OF_DARKNESS, "Ring of Darkness");

        translationBuilder.add(Registries.ITEM.get(new Identifier("potionring", "ring_of_example_effect")), "Ring of Example Effect");
        translationBuilder.add(Registries.ITEM.get(new Identifier("potionring", "ring_of_another_effect")), "Ring of Another Effect");

        translationBuilder.add(Registries.ITEM.get(new Identifier("potionring", "ring_of_growing")), "Ring of Growing");
        translationBuilder.add(Registries.ITEM.get(new Identifier("potionring", "ring_of_shrinking")), "Ring of Shrinking");
        translationBuilder.add(Registries.ITEM.get(new Identifier("potionring", "ring_of_thinning")), "Ring of Thinning");
        translationBuilder.add(Registries.ITEM.get(new Identifier("potionring", "ring_of_widening")), "Ring of Widening");
    }
}