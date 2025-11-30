package fr.samlegamer.potionring.client;

import fr.samlegamer.potionring.PotionRing;
import fr.samlegamer.potionring.item.PRItemsRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;
import java.util.Objects;

public class PRModels extends ItemModelProvider
{
    private final ModelFile model = getExistingFile(mcLoc("item/generated"));

    public PRModels(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, PotionRing.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels()
    {
        addRingModel(PRItemsRegistry.POTION_RING.get());
        addRingModel(PRItemsRegistry.RING_OF_REGENERATION.get());
        addRingModel(PRItemsRegistry.RING_OF_HASTE.get());
        addRingModel(PRItemsRegistry.RING_OF_JUMP_BOOST.get());
        addRingModel(PRItemsRegistry.RING_OF_RESISTANCE.get());
        addRingModel(PRItemsRegistry.RING_OF_SPEED.get());
        addRingModel(PRItemsRegistry.RING_OF_STRENGTH.get());
        addRingModel(PRItemsRegistry.RING_OF_FIRE_RESISTANCE.get());
        addRingModel(PRItemsRegistry.RING_OF_INVISIBILITY.get());
        addRingModel(PRItemsRegistry.RING_OF_SLOWNESS.get());
        addRingModel(PRItemsRegistry.RING_OF_MINING_FATIGUE.get());
        addRingModel(PRItemsRegistry.RING_OF_NAUSEA.get());
        addRingModel(PRItemsRegistry.RING_OF_BLINDNESS.get());
        addRingModel(PRItemsRegistry.RING_OF_HUNGER.get());
        addRingModel(PRItemsRegistry.RING_OF_NIGHT_VISION.get());
        addRingModel(PRItemsRegistry.RING_OF_SATURATION.get());
        addRingModel(PRItemsRegistry.RING_OF_POISON.get());
        addRingModel(PRItemsRegistry.RING_OF_WATER_BREATHING.get());
        addRingModel(PRItemsRegistry.RING_OF_WEAKNESS.get());
        addRingModel(PRItemsRegistry.RING_OF_WITHER.get());
        addRingModel(PRItemsRegistry.RING_OF_GLOWING.get());
        addRingModel(PRItemsRegistry.RING_OF_LEVITATION.get());
        addRingModel(PRItemsRegistry.RING_OF_LUCK.get());
        addRingModel(PRItemsRegistry.RING_OF_UNLUCK.get());
        addRingModel(PRItemsRegistry.RING_OF_SLOW_FALLING.get());
        addRingModel(PRItemsRegistry.RING_OF_CONDUIT_POWER.get());
        addRingModel(PRItemsRegistry.RING_OF_DOLPHIN_GRACE.get());
        addRingModel(PRItemsRegistry.RING_OF_DARKNESS.get());

        addRingModel(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("potionring", "ring_of_example_effect")));
        addRingModel(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("potionring", "ring_of_another_effect")));

        addRingModel(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("potionring", "ring_of_growing")));
        addRingModel(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("potionring", "ring_of_shrinking")));
        addRingModel(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("potionring", "ring_of_thinning")));
        addRingModel(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("potionring", "ring_of_widening")));
    }

    private void addRingModel(@Nonnull Item itemName)
    {
        String itemId = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(itemName)).getPath();

        getBuilder(itemId)
                .parent(model)
                .texture("layer0", modid + ":item/gold_ring")
                .texture("layer1", modid + ":item/gem_color")
                .texture("layer2", modid + ":item/gem_light");
    }
}
