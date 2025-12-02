package fr.samlegamer.potionring.client;

import fr.samlegamer.potionring.item.PRItemsRegistry;
import fr.samlegamer.potionring.item.PotionRingItem;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.*;
import net.minecraft.client.render.item.tint.TintSource;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class PRModels extends FabricModelProvider
{
    public PRModels(FabricDataOutput output) {
        super(output);
    }

    /* Free to use in another project, convert int color effect to ARGB
     * If the color is not ARGB the textures layer don't show
     * since 1.20.6
     */
    private static int rgbToArgb(int rgb) {
        return 0xFF000000 | (rgb & 0xFFFFFF);
    }

    public void generateRingModded(ItemModelGenerator itemModels, Item item, int color) {
        itemModels.output.accept(item,
                ItemModels.tinted(Models.GENERATED_THREE_LAYERS.upload(ModelIds.getItemModelId(item),
                        TextureMap.layered(
                                Identifier.of("potionring:item/gold_ring"),
                                Identifier.of("potionring:item/gem_color"),
                                Identifier.of("potionring:item/gem_light")), itemModels.modelCollector), new TintSource[]{
                        ItemModels.constantTintSource(0xFFFFFFFF),
                        ItemModels.constantTintSource(rgbToArgb(color)),
                        ItemModels.constantTintSource(0xFFFFFFFF)}));
    }

    public void generateRingVanilla(ItemModelGenerator itemModels, PotionRingItem item) {

        int color = item.eff != null ? item.eff.value().getColor() : 0xFFFFFFFF;

        itemModels.output.accept(item,
                ItemModels.tinted(Models.GENERATED_THREE_LAYERS.upload(ModelIds.getItemModelId(item),
                        TextureMap.layered(
                                Identifier.of("potionring:item/gold_ring"),
                                Identifier.of("potionring:item/gem_color"),
                                Identifier.of("potionring:item/gem_light")), itemModels.modelCollector), new TintSource[]{
                        ItemModels.constantTintSource(0xFFFFFFFF),
                        ItemModels.constantTintSource(rgbToArgb(color)),
                        ItemModels.constantTintSource(0xFFFFFFFF)}));
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModels) {
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

        generateRingModded(itemModels, Registries.ITEM.get(Identifier.of("potionring", "ring_of_example_effect")), 15182205);
        generateRingModded(itemModels, Registries.ITEM.get(Identifier.of("potionring", "ring_of_another_effect")), 12207722);

        generateRingModded(itemModels, Registries.ITEM.get(Identifier.of("potionring", "ring_of_growing")), 14289002);
        generateRingModded(itemModels, Registries.ITEM.get(Identifier.of("potionring", "ring_of_shrinking")), 13411432);
        generateRingModded(itemModels, Registries.ITEM.get(Identifier.of("potionring", "ring_of_thinning")), 14922751);
        generateRingModded(itemModels, Registries.ITEM.get(Identifier.of("potionring", "ring_of_widening")), 11796418);
    }
}
