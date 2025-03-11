package fr.samlegamer.potionring.data;

import fr.samlegamer.potionring.item.PRItemsRegistry;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;

public class PRTags extends ItemTagsProvider
{
    public PRTags(DataGenerator p_i232552_1_, BlockTagsProvider p_i232552_2_) {
        super(p_i232552_1_, p_i232552_2_);
    }

    @Override
    protected void addTags()
    {
        ITag.INamedTag<Item> curiosRingTag = ItemTags.bind("curios:ring");

        tag(curiosRingTag).add(PRItemsRegistry.POTION_RING.get(),
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
                PRItemsRegistry.RING_OF_DOLPHIN_GRACE.get()
        );

    }
}