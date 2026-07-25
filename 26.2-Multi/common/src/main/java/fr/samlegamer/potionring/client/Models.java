package fr.samlegamer.potionring.client;

import fr.samlegamer.potionring.item.AbstractPotionRingItem;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;
import static fr.samlegamer.potionring.util.PRFunc.ringSearch;
import static fr.samlegamer.potionring.util.PRFunc.ringSearchModded;

public class Models
{
    /* Free to use in another project, convert int color effect to ARGB
     * If the color is not ARGB the textures layer don't show
     * since 1.20.6
     */
    private static int rgbToArgb(int rgb) {
        return 0xFF000000 | (rgb & 0xFFFFFF);
    }

    public static void generateRingModded(ItemModelGenerators itemModels, Item item, int color) {
        itemModels.itemModelOutput.accept(item,
                ItemModelUtils.tintedModel(ModelTemplates.THREE_LAYERED_ITEM.create(ModelLocationUtils.getModelLocation(item),
                        TextureMapping.layered(
                                new Material(Identifier.parse("potionring:item/gold_ring")),
                                new Material(Identifier.parse("potionring:item/gem_color")),
                                new Material(Identifier.parse("potionring:item/gem_light"))), itemModels.modelOutput), ItemModelUtils.constantTint(0xFFFFFFFF),
                        ItemModelUtils.constantTint(rgbToArgb(color)),
                        ItemModelUtils.constantTint(0xFFFFFFFF)));
    }

    public static void generateRingVanilla(ItemModelGenerators itemModels, AbstractPotionRingItem item) {

        int color = item.eff != null ? item.eff.value().getColor() : 0xFFFFFFFF;

        itemModels.itemModelOutput.accept(item,
                ItemModelUtils.tintedModel(ModelTemplates.THREE_LAYERED_ITEM.create(ModelLocationUtils.getModelLocation(item),
                        TextureMapping.layered(
                                new Material(Identifier.parse("potionring:item/gold_ring")),
                                new Material(Identifier.parse("potionring:item/gem_color")),
                                new Material(Identifier.parse("potionring:item/gem_light"))), itemModels.modelOutput), ItemModelUtils.constantTint(0xFFFFFFFF),
                        ItemModelUtils.constantTint(rgbToArgb(color)),
                        ItemModelUtils.constantTint(0xFFFFFFFF)));
    }

    public static void modelsItem(@NotNull ItemModelGenerators itemModels)
    {
        generateRingVanilla(itemModels, ringSearch("potion_ring"));
        generateRingVanilla(itemModels, ringSearch("ring_of_regeneration"));
        generateRingVanilla(itemModels, ringSearch("ring_of_haste"));
        generateRingVanilla(itemModels, ringSearch("ring_of_jump_boost"));
        generateRingVanilla(itemModels, ringSearch("ring_of_resistance"));
        generateRingVanilla(itemModels, ringSearch("ring_of_speed"));
        generateRingVanilla(itemModels, ringSearch("ring_of_strength"));
        generateRingVanilla(itemModels, ringSearch("ring_of_fire_resistance"));
        generateRingVanilla(itemModels, ringSearch("ring_of_invisibility"));
        generateRingVanilla(itemModels, ringSearch("ring_of_slowness"));
        generateRingVanilla(itemModels, ringSearch("ring_of_mining_fatigue"));
        generateRingVanilla(itemModels, ringSearch("ring_of_nausea"));
        generateRingVanilla(itemModels, ringSearch("ring_of_blindness"));
        generateRingVanilla(itemModels, ringSearch("ring_of_hunger"));
        generateRingVanilla(itemModels, ringSearch("ring_of_night_vision"));
        generateRingVanilla(itemModels, ringSearch("ring_of_saturation"));
        generateRingVanilla(itemModels, ringSearch("ring_of_poison"));
        generateRingVanilla(itemModels, ringSearch("ring_of_water_breathing"));
        generateRingVanilla(itemModels, ringSearch("ring_of_weakness"));
        generateRingVanilla(itemModels, ringSearch("ring_of_wither"));
        generateRingVanilla(itemModels, ringSearch("ring_of_glowing"));
        generateRingVanilla(itemModels, ringSearch("ring_of_levitation"));
        generateRingVanilla(itemModels, ringSearch("ring_of_luck"));
        generateRingVanilla(itemModels, ringSearch("ring_of_unluck"));
        generateRingVanilla(itemModels, ringSearch("ring_of_slow_falling"));
        generateRingVanilla(itemModels, ringSearch("ring_of_conduit_power"));
        generateRingVanilla(itemModels, ringSearch("ring_of_dolphins_grace"));
        generateRingVanilla(itemModels, ringSearch("ring_of_darkness"));

        generateRingModded(itemModels, ringSearchModded("ring_of_example_effect"), 15182205);
        generateRingModded(itemModels, ringSearchModded("ring_of_another_effect"), 12207722);

        generateRingModded(itemModels, ringSearchModded("ring_of_growing"), 14289002);
        generateRingModded(itemModels, ringSearchModded("ring_of_shrinking"), 13411432);
        generateRingModded(itemModels, ringSearchModded("ring_of_thinning"), 14922751);
        generateRingModded(itemModels, ringSearchModded("ring_of_widening"), 11796418);
    }
}
