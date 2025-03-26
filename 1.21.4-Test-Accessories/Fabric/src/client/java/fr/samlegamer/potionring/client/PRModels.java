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
    public PRModels(FabricDataOutput dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

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
        itemModels.output.accept(item,
                ItemModels.tinted(Models.GENERATED_THREE_LAYERS.upload(ModelIds.getItemModelId(item),
                        TextureMap.layered(
                                Identifier.of("potionring:item/gold_ring"),
                                Identifier.of("potionring:item/gem_color"),
                                Identifier.of("potionring:item/gem_light")), itemModels.modelCollector), new TintSource[]{
                        ItemModels.constantTintSource(0xFFFFFFFF),
                        ItemModels.constantTintSource(rgbToArgb(item.eff != null ? item.eff.value().getColor() : 0xFFFFFFFF)),
                        ItemModels.constantTintSource(0xFFFFFFFF)}));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator)
    {
        generateRingVanilla(itemModelGenerator, PRItemsRegistry.POTION_RING);
        generateRingVanilla(itemModelGenerator, PRItemsRegistry.RING_OF_REGENERATION);
        generateRingVanilla(itemModelGenerator, PRItemsRegistry.RING_OF_HASTE);
        generateRingVanilla(itemModelGenerator, PRItemsRegistry.RING_OF_JUMP_BOOST);
        generateRingVanilla(itemModelGenerator, PRItemsRegistry.RING_OF_RESISTANCE);
        generateRingVanilla(itemModelGenerator, PRItemsRegistry.RING_OF_SPEED);
        generateRingVanilla(itemModelGenerator, PRItemsRegistry.RING_OF_STRENGTH);
        generateRingVanilla(itemModelGenerator, PRItemsRegistry.RING_OF_FIRE_RESISTANCE);
        generateRingVanilla(itemModelGenerator, PRItemsRegistry.RING_OF_INVISIBILITY);
        generateRingVanilla(itemModelGenerator, PRItemsRegistry.RING_OF_SLOWNESS);
        generateRingVanilla(itemModelGenerator, PRItemsRegistry.RING_OF_MINING_FATIGUE);
        generateRingVanilla(itemModelGenerator, PRItemsRegistry.RING_OF_NAUSEA);
        generateRingVanilla(itemModelGenerator, PRItemsRegistry.RING_OF_BLINDNESS);
        generateRingVanilla(itemModelGenerator, PRItemsRegistry.RING_OF_HUNGER);
        generateRingVanilla(itemModelGenerator, PRItemsRegistry.RING_OF_NIGHT_VISION);
        generateRingVanilla(itemModelGenerator, PRItemsRegistry.RING_OF_SATURATION);
        generateRingVanilla(itemModelGenerator, PRItemsRegistry.RING_OF_POISON);
        generateRingVanilla(itemModelGenerator, PRItemsRegistry.RING_OF_WATER_BREATHING);
        generateRingVanilla(itemModelGenerator, PRItemsRegistry.RING_OF_WEAKNESS);
        generateRingVanilla(itemModelGenerator, PRItemsRegistry.RING_OF_WITHER);
        generateRingVanilla(itemModelGenerator, PRItemsRegistry.RING_OF_GLOWING);
        generateRingVanilla(itemModelGenerator, PRItemsRegistry.RING_OF_LEVITATION);
        generateRingVanilla(itemModelGenerator, PRItemsRegistry.RING_OF_LUCK);
        generateRingVanilla(itemModelGenerator, PRItemsRegistry.RING_OF_UNLUCK);
        generateRingVanilla(itemModelGenerator, PRItemsRegistry.RING_OF_SLOW_FALLING);
        generateRingVanilla(itemModelGenerator, PRItemsRegistry.RING_OF_CONDUIT_POWER);
        generateRingVanilla(itemModelGenerator, PRItemsRegistry.RING_OF_DOLPHIN_GRACE);
        generateRingVanilla(itemModelGenerator, PRItemsRegistry.RING_OF_DARKNESS);

        generateRingModded(itemModelGenerator, Registries.ITEM.get(Identifier.of("potionring", "ring_of_example_effect")), 15182205);
        generateRingModded(itemModelGenerator, Registries.ITEM.get(Identifier.of("potionring", "ring_of_another_effect")), 12207722);

        generateRingModded(itemModelGenerator, Registries.ITEM.get(Identifier.of("potionring", "ring_of_growing")), 14289002);
        generateRingModded(itemModelGenerator, Registries.ITEM.get(Identifier.of("potionring", "ring_of_shrinking")), 13411432);
        generateRingModded(itemModelGenerator, Registries.ITEM.get(Identifier.of("potionring", "ring_of_thinning")), 14922751);
        generateRingModded(itemModelGenerator, Registries.ITEM.get(Identifier.of("potionring", "ring_of_widening")), 11796418);
    }
}
