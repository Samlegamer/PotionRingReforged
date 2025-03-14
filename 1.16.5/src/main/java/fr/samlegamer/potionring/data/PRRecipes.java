package fr.samlegamer.potionring.data;

import fr.samlegamer.potionring.item.PRItemsRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.item.Items;
import net.minecraft.util.IItemProvider;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Consumer;

public class PRRecipes extends RecipeProvider
{
    public PRRecipes(DataGenerator generator) {
        super(generator);
    }

    @Override
    @ParametersAreNonnullByDefault
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer)
    {
        ShapedRecipeBuilder.shaped(PRItemsRegistry.POTION_RING.get())
                .define('#', Items.GOLD_INGOT)
                .define('R', Blocks.LAPIS_BLOCK)
                .pattern("R# ")
                .pattern("# #")
                .pattern(" # ")
                .group("rings")
                .unlockedBy("has_gold_ingot", has(Items.GOLD_INGOT))
                .unlockedBy("has_lapis_block", has(Blocks.LAPIS_BLOCK))
                .save(consumer);

        rings(consumer, PRItemsRegistry.RING_OF_HASTE.get(), Items.EMERALD);
        rings(consumer, PRItemsRegistry.RING_OF_REGENERATION.get(), Items.GHAST_TEAR);
        rings(consumer, PRItemsRegistry.RING_OF_RESISTANCE.get(), Items.DIAMOND);
        rings(consumer, PRItemsRegistry.RING_OF_SPEED.get(), Items.SUGAR);
        rings(consumer, PRItemsRegistry.RING_OF_STRENGTH.get(), Items.BLAZE_POWDER);
        rings(consumer, PRItemsRegistry.RING_OF_JUMP_BOOST.get(), Items.RABBIT_FOOT);

        rings(consumer, PRItemsRegistry.RING_OF_FIRE_RESISTANCE.get(), Items.MAGMA_CREAM);
        ringsSpecial(consumer, PRItemsRegistry.RING_OF_INVISIBILITY.get(), Items.FERMENTED_SPIDER_EYE, PRItemsRegistry.RING_OF_NIGHT_VISION.get());
        ringsSpecial(consumer, PRItemsRegistry.RING_OF_SLOWNESS.get(), Items.FERMENTED_SPIDER_EYE, PRItemsRegistry.RING_OF_SPEED.get());
        ringsSpecial(consumer, PRItemsRegistry.RING_OF_MINING_FATIGUE.get(), Items.FERMENTED_SPIDER_EYE, PRItemsRegistry.RING_OF_HASTE.get());
        rings(consumer, PRItemsRegistry.RING_OF_NAUSEA.get(), Items.PUFFERFISH);
        rings(consumer, PRItemsRegistry.RING_OF_BLINDNESS.get(), Items.SUSPICIOUS_STEW);
        rings(consumer, PRItemsRegistry.RING_OF_HUNGER.get(), Items.ROTTEN_FLESH);
        rings(consumer, PRItemsRegistry.RING_OF_NIGHT_VISION.get(), Items.GOLDEN_CARROT);
        ringsSpecial(consumer, PRItemsRegistry.RING_OF_SATURATION.get(), Items.ENCHANTED_GOLDEN_APPLE, PRItemsRegistry.RING_OF_HUNGER.get());
        rings(consumer, PRItemsRegistry.RING_OF_POISON.get(), Items.SPIDER_EYE);
        rings(consumer, PRItemsRegistry.RING_OF_WATER_BREATHING.get(), Items.SPONGE);
        ringsSpecial(consumer, PRItemsRegistry.RING_OF_WEAKNESS.get(), Items.FERMENTED_SPIDER_EYE, PRItemsRegistry.RING_OF_STRENGTH.get());
        rings(consumer, PRItemsRegistry.RING_OF_WITHER.get(), Items.WITHER_ROSE);
        rings(consumer, PRItemsRegistry.RING_OF_GLOWING.get(), Items.GLOWSTONE);
        rings(consumer, PRItemsRegistry.RING_OF_LEVITATION.get(), Items.SHULKER_SHELL);
        rings(consumer, PRItemsRegistry.RING_OF_LUCK.get(), Items.TROPICAL_FISH);
        ringsSpecial(consumer, PRItemsRegistry.RING_OF_UNLUCK.get(), Items.FERMENTED_SPIDER_EYE, PRItemsRegistry.RING_OF_LUCK.get());
        rings(consumer, PRItemsRegistry.RING_OF_SLOW_FALLING.get(), Items.PHANTOM_MEMBRANE);
        rings(consumer, PRItemsRegistry.RING_OF_CONDUIT_POWER.get(), Items.CONDUIT);
        rings(consumer, PRItemsRegistry.RING_OF_DOLPHIN_GRACE.get(), Items.HEART_OF_THE_SEA);
    }

    public static void rings(Consumer<IFinishedRecipe> consumer, IItemProvider result, IItemProvider ingredient) {
        ShapedRecipeBuilder.shaped(result)
                .define('#', ingredient)
                .define('R', PRItemsRegistry.POTION_RING.get())
                .pattern(" # ")
                .pattern("#R#")
                .pattern(" # ")
                .group("rings")
                .unlockedBy("has_ring", has(PRItemsRegistry.POTION_RING.get()))
                .save(consumer);
    }

    public static void ringsSpecial(Consumer<IFinishedRecipe> consumer, IItemProvider result, IItemProvider ingredient1, IItemProvider ingredient2) {
        ShapedRecipeBuilder.shaped(result)
                .define('#', ingredient1)
                .define('R', ingredient2)
                .pattern(" # ")
                .pattern("#R#")
                .pattern(" # ")
                .group("rings")
                .unlockedBy("has_potion_ring", has(PRItemsRegistry.POTION_RING.get())).save(consumer);
    }
}