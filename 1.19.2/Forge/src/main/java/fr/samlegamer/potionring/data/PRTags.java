package fr.samlegamer.potionring.data;

import fr.samlegamer.potionring.PotionRing;
import fr.samlegamer.potionring.item.PRItemsRegistry;
import fr.samlegamer.potionring.item.PRTagsItemRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;

public class PRTags extends ItemTagsProvider
{
    public PRTags(DataGenerator p_i232552_1_, @Nullable ExistingFileHelper p_i244820_3_) {
        super(p_i232552_1_, new PRBlockTags(p_i232552_1_, p_i244820_3_), PotionRing.MODID, p_i244820_3_);
    }

    @Override
    protected void addTags()
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
                ForgeRegistries.ITEMS.getValue(new ResourceLocation(PotionRing.MODID, "ring_of_growing")),
                ForgeRegistries.ITEMS.getValue(new ResourceLocation(PotionRing.MODID, "ring_of_shrinking")),
                ForgeRegistries.ITEMS.getValue(new ResourceLocation(PotionRing.MODID, "ring_of_thinning")),
                ForgeRegistries.ITEMS.getValue(new ResourceLocation(PotionRing.MODID, "ring_of_widening"))
        );

    }

    static class PRBlockTags extends BlockTagsProvider
    {
        public PRBlockTags(DataGenerator p_i48256_1_, @Nullable ExistingFileHelper p_i244820_3_) {
            super(p_i48256_1_, PotionRing.MODID, p_i244820_3_);
        }

        @Override
        protected void addTags() {
        }
    }
}