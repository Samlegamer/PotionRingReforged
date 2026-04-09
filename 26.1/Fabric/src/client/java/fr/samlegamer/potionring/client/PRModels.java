package fr.samlegamer.potionring.client;

import fr.samlegamer.potionring.item.PRItemsRegistry;
import fr.samlegamer.potionring.item.PotionRingItem;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.color.item.ItemTintSource;
import net.minecraft.client.data.*;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import org.jspecify.annotations.NonNull;

public class PRModels extends FabricModelProvider
{
    public PRModels(FabricPackOutput output) {
        super(output);
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
                                new Material(Identifier.parse("potionring:item/gold_ring")),
                                new Material(Identifier.parse("potionring:item/gem_color")),
                                new Material(Identifier.parse("potionring:item/gem_light"))), itemModels.modelOutput), new ItemTintSource[]{
                        ItemModelUtils.constantTint(0xFFFFFFFF),
                        ItemModelUtils.constantTint(rgbToArgb(color)),
                        ItemModelUtils.constantTint(0xFFFFFFFF)}));
    }

    public void generateRingVanilla(ItemModelGenerators itemModels, PotionRingItem item) {

        int color = item.eff != null ? item.eff.value().getColor() : 0xFFFFFFFF;

        itemModels.itemModelOutput.accept(item,
                ItemModelUtils.tintedModel(ModelTemplates.THREE_LAYERED_ITEM.create(ModelLocationUtils.getModelLocation(item),
                        TextureMapping.layered(
                                new Material(Identifier.parse("potionring:item/gold_ring")),
                                new Material(Identifier.parse("potionring:item/gem_color")),
                                new Material(Identifier.parse("potionring:item/gem_light"))), itemModels.modelOutput), new ItemTintSource[]{
                        ItemModelUtils.constantTint(0xFFFFFFFF),
                        ItemModelUtils.constantTint(rgbToArgb(color)),
                        ItemModelUtils.constantTint(0xFFFFFFFF)}));
    }

    @Override
    public void generateBlockStateModels(@NonNull BlockModelGenerators blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(@NonNull ItemModelGenerators itemModels) {
        generateRingVanilla(itemModels, PRItemsRegistry.POTION_RING);
        generateRingVanilla(itemModels, PRItemsRegistry.RING_OF_REGENERATION);
        generateRingVanilla(itemModels, PRItemsRegistry.RING_OF_HASTE);
        generateRingVanilla(itemModels, PRItemsRegistry.RING_OF_JUMP_BOOST);
        generateRingVanilla(itemModels, PRItemsRegistry.RING_OF_RESISTANCE);
        generateRingVanilla(itemModels, PRItemsRegistry.RING_OF_SPEED);
        generateRingVanilla(itemModels, PRItemsRegistry.RING_OF_STRENGTH);
        generateRingVanilla(itemModels, PRItemsRegistry.RING_OF_FIRE_RESISTANCE);
        generateRingVanilla(itemModels, PRItemsRegistry.RING_OF_INVISIBILITY);
        generateRingVanilla(itemModels, PRItemsRegistry.RING_OF_SLOWNESS);
        generateRingVanilla(itemModels, PRItemsRegistry.RING_OF_MINING_FATIGUE);
        generateRingVanilla(itemModels, PRItemsRegistry.RING_OF_NAUSEA);
        generateRingVanilla(itemModels, PRItemsRegistry.RING_OF_BLINDNESS);
        generateRingVanilla(itemModels, PRItemsRegistry.RING_OF_HUNGER);
        generateRingVanilla(itemModels, PRItemsRegistry.RING_OF_NIGHT_VISION);
        generateRingVanilla(itemModels, PRItemsRegistry.RING_OF_SATURATION);
        generateRingVanilla(itemModels, PRItemsRegistry.RING_OF_POISON);
        generateRingVanilla(itemModels, PRItemsRegistry.RING_OF_WATER_BREATHING);
        generateRingVanilla(itemModels, PRItemsRegistry.RING_OF_WEAKNESS);
        generateRingVanilla(itemModels, PRItemsRegistry.RING_OF_WITHER);
        generateRingVanilla(itemModels, PRItemsRegistry.RING_OF_GLOWING);
        generateRingVanilla(itemModels, PRItemsRegistry.RING_OF_LEVITATION);
        generateRingVanilla(itemModels, PRItemsRegistry.RING_OF_LUCK);
        generateRingVanilla(itemModels, PRItemsRegistry.RING_OF_UNLUCK);
        generateRingVanilla(itemModels, PRItemsRegistry.RING_OF_SLOW_FALLING);
        generateRingVanilla(itemModels, PRItemsRegistry.RING_OF_CONDUIT_POWER);
        generateRingVanilla(itemModels, PRItemsRegistry.RING_OF_DOLPHIN_GRACE);
        generateRingVanilla(itemModels, PRItemsRegistry.RING_OF_DARKNESS);

        generateRingModded(itemModels, BuiltInRegistries.ITEM.get(Identifier.fromNamespaceAndPath("potionring", "ring_of_example_effect")).get().value(), 15182205);
        generateRingModded(itemModels, BuiltInRegistries.ITEM.get(Identifier.fromNamespaceAndPath("potionring", "ring_of_another_effect")).get().value(), 12207722);

        generateRingModded(itemModels, BuiltInRegistries.ITEM.get(Identifier.fromNamespaceAndPath("potionring", "ring_of_growing")).get().value(), 14289002);
        generateRingModded(itemModels, BuiltInRegistries.ITEM.get(Identifier.fromNamespaceAndPath("potionring", "ring_of_shrinking")).get().value(), 13411432);
        generateRingModded(itemModels, BuiltInRegistries.ITEM.get(Identifier.fromNamespaceAndPath("potionring", "ring_of_thinning")).get().value(), 14922751);
        generateRingModded(itemModels, BuiltInRegistries.ITEM.get(Identifier.fromNamespaceAndPath("potionring", "ring_of_widening")).get().value(), 11796418);
    }
}
