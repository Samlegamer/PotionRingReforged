package fr.samlegamer.potionring.client;

import fr.samlegamer.potionring.PotionRing;
import fr.samlegamer.potionring.item.PRItemsRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.client.MinecraftClient;
import net.minecraft.data.client.*;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.Objects;
import java.util.Optional;

public class PRModels extends FabricModelProvider
{
    public PRModels(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    private final TextureKey LAYER1 = TextureKey.of("layer1");
    private final TextureKey LAYER2 = TextureKey.of("layer2");

    private final Model RING_LAYERS = item("generated", TextureKey.LAYER0, LAYER1, LAYER2);

    private static Model item(String parent, TextureKey LAYER0, TextureKey LAYER1, TextureKey LAYER2) {
        return new Model(Optional.of(new Identifier("item/" + parent)), Optional.empty(), LAYER0, LAYER1, LAYER2);
    }

    private void addRingModel(ItemModelGenerator itemModelGenerator, Item itemName)
    {
        TextureMap textureMap = new TextureMap().put(TextureKey.LAYER0, new Identifier(PotionRing.MODID, "item/gold_ring"))
                .put(LAYER1, new Identifier(PotionRing.MODID, "item/gem_color"))
                .put(LAYER2, new Identifier(PotionRing.MODID, "item/gem_light"));
        
        RING_LAYERS.upload(new Identifier(PotionRing.MODID, "item/"+itemName.toString()),
                textureMap, itemModelGenerator.writer);
//        Models.GENERATED.upload()
//        itemModelGenerator.register(itemName, new Model()
//                .parent(model)
//                .texture("layer0", modid + ":item/gold_ring")
//                .texture("layer1", modid + ":item/gem_color")
//                .texture("layer2", modid + ":item/gem_light");
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

        addRingModel(itemModelGenerator, Registry.ITEM.get(new Identifier("potionring", "ring_of_example_effect")));
        addRingModel(itemModelGenerator, Registry.ITEM.get(new Identifier("potionring", "ring_of_another_effect")));

        addRingModel(itemModelGenerator, Registry.ITEM.get(new Identifier("potionring", "ring_of_growing")));
        addRingModel(itemModelGenerator, Registry.ITEM.get(new Identifier("potionring", "ring_of_shrinking")));
        addRingModel(itemModelGenerator, Registry.ITEM.get(new Identifier("potionring", "ring_of_thinning")));
        addRingModel(itemModelGenerator, Registry.ITEM.get(new Identifier("potionring", "ring_of_widening")));
    }
}
