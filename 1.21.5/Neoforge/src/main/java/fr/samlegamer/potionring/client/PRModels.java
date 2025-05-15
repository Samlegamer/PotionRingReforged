package fr.samlegamer.potionring.client;

import fr.samlegamer.potionring.PotionRing;
import fr.samlegamer.potionring.item.PRItemsRegistry;
import fr.samlegamer.potionring.item.PotionRingItem;
import net.minecraft.client.color.item.ItemTintSource;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

public class PRModels extends ModelProvider
{
    public PRModels(PackOutput output) {
        super(output, PotionRing.MODID);
    }

    /* Free to use in another project, convert int color effect to ARGB
     * If the color is not ARGB the textures layer don't show
     * since 1.20.6
     */
    private static int rgbToArgb(int rgb) {
        return 0xFF000000 | (rgb & 0xFFFFFF);
    }

    public void generateRingModded(ItemModelGenerators itemModels, Item item, int color) {
        itemModels.itemModelOutput.accept(item,
                ItemModelUtils.tintedModel(ModelTemplates.THREE_LAYERED_ITEM.create(ModelLocationUtils.getModelLocation(item),
                        TextureMapping.layered(
                                ResourceLocation.parse("potionring:item/gold_ring"),
                                ResourceLocation.parse("potionring:item/gem_color"),
                                ResourceLocation.parse("potionring:item/gem_light")), itemModels.modelOutput), ItemModelUtils.constantTint(0xFFFFFFFF),
                        ItemModelUtils.constantTint(rgbToArgb(color)),
                        ItemModelUtils.constantTint(0xFFFFFFFF)));
    }

    public void generateRingVanilla(ItemModelGenerators itemModels, PotionRingItem item) {

        int color = item.eff != null ? item.eff.value().getColor() : 0xFFFFFFFF;

        itemModels.itemModelOutput.accept(item,
                ItemModelUtils.tintedModel(ModelTemplates.THREE_LAYERED_ITEM.create(ModelLocationUtils.getModelLocation(item),
                        TextureMapping.layered(
                                ResourceLocation.parse("potionring:item/gold_ring"),
                                ResourceLocation.parse("potionring:item/gem_color"),
                                ResourceLocation.parse("potionring:item/gem_light")), itemModels.modelOutput), ItemModelUtils.constantTint(0xFFFFFFFF),
                        ItemModelUtils.constantTint(rgbToArgb(color)),
                        ItemModelUtils.constantTint(0xFFFFFFFF)));
    }
    @Override
    protected void registerModels(@NotNull BlockModelGenerators blockModels, @NotNull ItemModelGenerators itemModels)
    {
        generateRingVanilla(itemModels, PRItemsRegistry.POTION_RING.get());
        generateRingVanilla(itemModels, PRItemsRegistry.RING_OF_REGENERATION.get());
        generateRingVanilla(itemModels, PRItemsRegistry.RING_OF_HASTE.get());
        generateRingVanilla(itemModels, PRItemsRegistry.RING_OF_JUMP_BOOST.get());
        generateRingVanilla(itemModels, PRItemsRegistry.RING_OF_RESISTANCE.get());
        generateRingVanilla(itemModels, PRItemsRegistry.RING_OF_SPEED.get());
        generateRingVanilla(itemModels, PRItemsRegistry.RING_OF_STRENGTH.get());
        generateRingVanilla(itemModels, PRItemsRegistry.RING_OF_FIRE_RESISTANCE.get());
        generateRingVanilla(itemModels, PRItemsRegistry.RING_OF_INVISIBILITY.get());
        generateRingVanilla(itemModels, PRItemsRegistry.RING_OF_SLOWNESS.get());
        generateRingVanilla(itemModels, PRItemsRegistry.RING_OF_MINING_FATIGUE.get());
        generateRingVanilla(itemModels, PRItemsRegistry.RING_OF_NAUSEA.get());
        generateRingVanilla(itemModels, PRItemsRegistry.RING_OF_BLINDNESS.get());
        generateRingVanilla(itemModels, PRItemsRegistry.RING_OF_HUNGER.get());
        generateRingVanilla(itemModels, PRItemsRegistry.RING_OF_NIGHT_VISION.get());
        generateRingVanilla(itemModels, PRItemsRegistry.RING_OF_SATURATION.get());
        generateRingVanilla(itemModels, PRItemsRegistry.RING_OF_POISON.get());
        generateRingVanilla(itemModels, PRItemsRegistry.RING_OF_WATER_BREATHING.get());
        generateRingVanilla(itemModels, PRItemsRegistry.RING_OF_WEAKNESS.get());
        generateRingVanilla(itemModels, PRItemsRegistry.RING_OF_WITHER.get());
        generateRingVanilla(itemModels, PRItemsRegistry.RING_OF_GLOWING.get());
        generateRingVanilla(itemModels, PRItemsRegistry.RING_OF_LEVITATION.get());
        generateRingVanilla(itemModels, PRItemsRegistry.RING_OF_LUCK.get());
        generateRingVanilla(itemModels, PRItemsRegistry.RING_OF_UNLUCK.get());
        generateRingVanilla(itemModels, PRItemsRegistry.RING_OF_SLOW_FALLING.get());
        generateRingVanilla(itemModels, PRItemsRegistry.RING_OF_CONDUIT_POWER.get());
        generateRingVanilla(itemModels, PRItemsRegistry.RING_OF_DOLPHIN_GRACE.get());
        generateRingVanilla(itemModels, PRItemsRegistry.RING_OF_DARKNESS.get());

        generateRingModded(itemModels, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("potionring", "ring_of_example_effect")).get().value(), 15182205);
        generateRingModded(itemModels, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("potionring", "ring_of_another_effect")).get().value(), 12207722);

        generateRingModded(itemModels, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("potionring", "ring_of_growing")).get().value(), 14289002);
        generateRingModded(itemModels, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("potionring", "ring_of_shrinking")).get().value(), 13411432);
        generateRingModded(itemModels, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("potionring", "ring_of_thinning")).get().value(), 14922751);
        generateRingModded(itemModels, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("potionring", "ring_of_widening")).get().value(), 11796418);
    }
}
