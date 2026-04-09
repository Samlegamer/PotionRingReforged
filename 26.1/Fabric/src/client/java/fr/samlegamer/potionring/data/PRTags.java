package fr.samlegamer.potionring.data;

import fr.samlegamer.potionring.PotionRing;
import fr.samlegamer.potionring.item.PRItemsRegistry;
import fr.samlegamer.potionring.item.PRTagsItemRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import java.util.concurrent.CompletableFuture;

public class PRTags extends FabricTagsProvider.ItemTagsProvider
{
    public PRTags(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        this.valueLookupBuilder(PRTagsItemRegistry.POTION_RINGS).add(PRItemsRegistry.POTION_RING,
                PRItemsRegistry.RING_OF_REGENERATION,
                PRItemsRegistry.RING_OF_HASTE,
                PRItemsRegistry.RING_OF_JUMP_BOOST,
                PRItemsRegistry.RING_OF_RESISTANCE,
                PRItemsRegistry.RING_OF_SPEED,
                PRItemsRegistry.RING_OF_STRENGTH,
                PRItemsRegistry.RING_OF_FIRE_RESISTANCE,
                PRItemsRegistry.RING_OF_INVISIBILITY,
                PRItemsRegistry.RING_OF_SLOWNESS,
                PRItemsRegistry.RING_OF_MINING_FATIGUE,
                PRItemsRegistry.RING_OF_NAUSEA,
                PRItemsRegistry.RING_OF_BLINDNESS,
                PRItemsRegistry.RING_OF_HUNGER,
                PRItemsRegistry.RING_OF_NIGHT_VISION,
                PRItemsRegistry.RING_OF_SATURATION,
                PRItemsRegistry.RING_OF_POISON,
                PRItemsRegistry.RING_OF_WATER_BREATHING,
                PRItemsRegistry.RING_OF_WEAKNESS,
                PRItemsRegistry.RING_OF_WITHER,
                PRItemsRegistry.RING_OF_GLOWING,
                PRItemsRegistry.RING_OF_LEVITATION,
                PRItemsRegistry.RING_OF_LUCK,
                PRItemsRegistry.RING_OF_UNLUCK,
                PRItemsRegistry.RING_OF_SLOW_FALLING,
                PRItemsRegistry.RING_OF_CONDUIT_POWER,
                PRItemsRegistry.RING_OF_DOLPHIN_GRACE,
                PRItemsRegistry.RING_OF_DARKNESS,
                BuiltInRegistries.ITEM.get(Identifier.fromNamespaceAndPath(PotionRing.MODID, "ring_of_growing")).get().value(),
                BuiltInRegistries.ITEM.get(Identifier.fromNamespaceAndPath(PotionRing.MODID, "ring_of_shrinking")).get().value(),
                BuiltInRegistries.ITEM.get(Identifier.fromNamespaceAndPath(PotionRing.MODID, "ring_of_thinning")).get().value(),
                BuiltInRegistries.ITEM.get(Identifier.fromNamespaceAndPath(PotionRing.MODID, "ring_of_widening")).get().value()
        );
    }
}