package fr.samlegamer.potionring.client;

import fr.samlegamer.potionring.PotionRing;
import fr.samlegamer.potionring.item.PRItemsRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.Objects;
import java.util.Optional;

public class PRModels extends FabricModelProvider
{
    public PRModels(FabricDataOutput dataGenerator) {
        super(dataGenerator);
    }

    private final TextureKey LAYER1 = TextureKey.of("layer1");
    private final TextureKey LAYER2 = TextureKey.of("layer2");

    private final Model RING_LAYERS = item("generated", TextureKey.LAYER0, LAYER1, LAYER2);

    private static Model item(String parent, TextureKey LAYER0, TextureKey LAYER1, TextureKey LAYER2) {
        return new Model(Optional.of(Identifier.of("item/" + parent)), Optional.empty(), LAYER0, LAYER1, LAYER2);
    }

    private void addRingModel(ItemModelGenerator itemModelGenerator, Item itemName)
    {
        TextureMap textureMap = new TextureMap().put(TextureKey.LAYER0, Identifier.of(PotionRing.MODID, "item/gold_ring"))
                .put(LAYER1, Identifier.of(PotionRing.MODID, "item/gem_color"))
                .put(LAYER2, Identifier.of(PotionRing.MODID, "item/gem_light"));

        String itemId = Objects.requireNonNull(Registries.ITEM.getId(itemName).getPath());
        RING_LAYERS.upload(Identifier.of(PotionRing.MODID, "item/"+itemId),
                textureMap, itemModelGenerator.writer);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator)
    {
        addRingModel(itemModelGenerator, PRItemsRegistry.POTION_RING);
        addRingModel(itemModelGenerator, PRItemsRegistry.RING_OF_REGENERATION);
        addRingModel(itemModelGenerator, PRItemsRegistry.RING_OF_HASTE);
        addRingModel(itemModelGenerator, PRItemsRegistry.RING_OF_JUMP_BOOST);
        addRingModel(itemModelGenerator, PRItemsRegistry.RING_OF_RESISTANCE);
        addRingModel(itemModelGenerator, PRItemsRegistry.RING_OF_SPEED);
        addRingModel(itemModelGenerator, PRItemsRegistry.RING_OF_STRENGTH);
        addRingModel(itemModelGenerator, PRItemsRegistry.RING_OF_FIRE_RESISTANCE);
        addRingModel(itemModelGenerator, PRItemsRegistry.RING_OF_INVISIBILITY);
        addRingModel(itemModelGenerator, PRItemsRegistry.RING_OF_SLOWNESS);
        addRingModel(itemModelGenerator, PRItemsRegistry.RING_OF_MINING_FATIGUE);
        addRingModel(itemModelGenerator, PRItemsRegistry.RING_OF_NAUSEA);
        addRingModel(itemModelGenerator, PRItemsRegistry.RING_OF_BLINDNESS);
        addRingModel(itemModelGenerator, PRItemsRegistry.RING_OF_HUNGER);
        addRingModel(itemModelGenerator, PRItemsRegistry.RING_OF_NIGHT_VISION);
        addRingModel(itemModelGenerator, PRItemsRegistry.RING_OF_SATURATION);
        addRingModel(itemModelGenerator, PRItemsRegistry.RING_OF_POISON);
        addRingModel(itemModelGenerator, PRItemsRegistry.RING_OF_WATER_BREATHING);
        addRingModel(itemModelGenerator, PRItemsRegistry.RING_OF_WEAKNESS);
        addRingModel(itemModelGenerator, PRItemsRegistry.RING_OF_WITHER);
        addRingModel(itemModelGenerator, PRItemsRegistry.RING_OF_GLOWING);
        addRingModel(itemModelGenerator, PRItemsRegistry.RING_OF_LEVITATION);
        addRingModel(itemModelGenerator, PRItemsRegistry.RING_OF_LUCK);
        addRingModel(itemModelGenerator, PRItemsRegistry.RING_OF_UNLUCK);
        addRingModel(itemModelGenerator, PRItemsRegistry.RING_OF_SLOW_FALLING);
        addRingModel(itemModelGenerator, PRItemsRegistry.RING_OF_CONDUIT_POWER);
        addRingModel(itemModelGenerator, PRItemsRegistry.RING_OF_DOLPHIN_GRACE);
        addRingModel(itemModelGenerator, PRItemsRegistry.RING_OF_DARKNESS);

        addRingModel(itemModelGenerator, Registries.ITEM.get(Identifier.of("potionring", "ring_of_example_effect")));
        addRingModel(itemModelGenerator, Registries.ITEM.get(Identifier.of("potionring", "ring_of_another_effect")));

        addRingModel(itemModelGenerator, Registries.ITEM.get(Identifier.of("potionring", "ring_of_growing")));
        addRingModel(itemModelGenerator, Registries.ITEM.get(Identifier.of("potionring", "ring_of_shrinking")));
        addRingModel(itemModelGenerator, Registries.ITEM.get(Identifier.of("potionring", "ring_of_thinning")));
        addRingModel(itemModelGenerator, Registries.ITEM.get(Identifier.of("potionring", "ring_of_widening")));
    }
}
