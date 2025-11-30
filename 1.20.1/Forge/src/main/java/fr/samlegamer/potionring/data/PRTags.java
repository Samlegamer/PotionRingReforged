package fr.samlegamer.potionring.data;

import fr.samlegamer.potionring.PotionRing;
import fr.samlegamer.potionring.item.PRItemsRegistry;
import fr.samlegamer.potionring.item.PRTagsItemRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.concurrent.CompletableFuture;

public class PRTags extends ItemTagsProvider
{
    public PRTags(PackOutput p_255871_, CompletableFuture<HolderLookup.Provider> p_256035_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_255871_, p_256035_, p_275322_, PotionRing.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider)
    {
        this.tag(PRTagsItemRegistry.POTION_RINGS).add(PRItemsRegistry.POTION_RING.get(),
                PRItemsRegistry.RING_OF_REGENERATION.get(),
                PRItemsRegistry.RING_OF_HASTE.get(),
                PRItemsRegistry.RING_OF_JUMP_BOOST.get(),
                PRItemsRegistry.RING_OF_RESISTANCE.get(),
                PRItemsRegistry.RING_OF_SPEED.get(),
                PRItemsRegistry.RING_OF_STRENGTH.get(),
                PRItemsRegistry.RING_OF_FIRE_RESISTANCE.get(),
                PRItemsRegistry.RING_OF_INVISIBILITY.get(),
                PRItemsRegistry.RING_OF_SLOWNESS.get(),
                PRItemsRegistry.RING_OF_MINING_FATIGUE.get(),
                PRItemsRegistry.RING_OF_NAUSEA.get(),
                PRItemsRegistry.RING_OF_BLINDNESS.get(),
                PRItemsRegistry.RING_OF_HUNGER.get(),
                PRItemsRegistry.RING_OF_NIGHT_VISION.get(),
                PRItemsRegistry.RING_OF_SATURATION.get(),
                PRItemsRegistry.RING_OF_POISON.get(),
                PRItemsRegistry.RING_OF_WATER_BREATHING.get(),
                PRItemsRegistry.RING_OF_WEAKNESS.get(),
                PRItemsRegistry.RING_OF_WITHER.get(),
                PRItemsRegistry.RING_OF_GLOWING.get(),
                PRItemsRegistry.RING_OF_LEVITATION.get(),
                PRItemsRegistry.RING_OF_LUCK.get(),
                PRItemsRegistry.RING_OF_UNLUCK.get(),
                PRItemsRegistry.RING_OF_SLOW_FALLING.get(),
                PRItemsRegistry.RING_OF_CONDUIT_POWER.get(),
                PRItemsRegistry.RING_OF_DOLPHIN_GRACE.get(),
                PRItemsRegistry.RING_OF_DARKNESS.get(),
                BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(PotionRing.MODID, "ring_of_growing")),
                BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(PotionRing.MODID, "ring_of_shrinking")),
                BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(PotionRing.MODID, "ring_of_thinning")),
                BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(PotionRing.MODID, "ring_of_widening"))
        );

    }

    public static class PRBlockTags extends BlockTagsProvider
    {
        public PRBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
            super(output, lookupProvider, PotionRing.MODID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.@NotNull Provider provider) {

        }
    }
}