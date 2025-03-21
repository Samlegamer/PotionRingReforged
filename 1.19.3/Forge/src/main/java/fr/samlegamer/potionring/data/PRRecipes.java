package fr.samlegamer.potionring.data;

import fr.samlegamer.potionring.PotionRing;
import fr.samlegamer.potionring.item.PRItemsRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Consumer;

public class PRRecipes extends RecipeProvider
{
    public PRRecipes(PackOutput p_248933_) {
        super(p_248933_);
    }

    @Override
    @ParametersAreNonnullByDefault
    protected void buildRecipes(Consumer<FinishedRecipe> consumer)
    {
        ShapedRecipeBuilder.shaped(RecipeCategory.BREWING, PRItemsRegistry.POTION_RING.get())
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
        rings(consumer, PRItemsRegistry.RING_OF_DARKNESS.get(), Items.ECHO_SHARD);

        ringsLoaded(consumer, BuiltInRegistries.ITEM.get(new ResourceLocation(PotionRing.MODID, "ring_of_growing")),
                Items.CRIMSON_FUNGUS, "sizeshiftingpotions");

        ringsLoaded(consumer, BuiltInRegistries.ITEM.get(new ResourceLocation(PotionRing.MODID, "ring_of_shrinking")),
                Items.WARPED_FUNGUS, "sizeshiftingpotions");

        ringsSpecialLoaded(consumer, BuiltInRegistries.ITEM.get(new ResourceLocation(PotionRing.MODID, "ring_of_thinning")),
                Items.FERMENTED_SPIDER_EYE, BuiltInRegistries.ITEM.get(new ResourceLocation(PotionRing.MODID, "ring_of_shrinking")), "sizeshiftingpotions");

        ringsSpecialLoaded(consumer, BuiltInRegistries.ITEM.get(new ResourceLocation(PotionRing.MODID, "ring_of_widening")),
                Items.FERMENTED_SPIDER_EYE, BuiltInRegistries.ITEM.get(new ResourceLocation(PotionRing.MODID, "ring_of_growing")), "sizeshiftingpotions");

    }

    public static void rings(Consumer<FinishedRecipe> consumer, ItemLike result, ItemLike ingredient) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BREWING, result)
                .define('#', ingredient)
                .define('R', PRItemsRegistry.POTION_RING.get())
                .pattern(" # ")
                .pattern("#R#")
                .pattern(" # ")
                .group("rings")
                .unlockedBy("has_ring", has(PRItemsRegistry.POTION_RING.get()))
                .save(consumer);
    }

    public static void ringsSpecial(Consumer<FinishedRecipe> consumer, ItemLike result, ItemLike ingredient1, ItemLike ingredient2) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BREWING, result)
                .define('#', ingredient1)
                .define('R', ingredient2)
                .pattern(" # ")
                .pattern("#R#")
                .pattern(" # ")
                .group("rings")
                .unlockedBy("has_potion_ring", has(PRItemsRegistry.POTION_RING.get())).save(consumer);
    }

    public static void ringsLoaded(Consumer<FinishedRecipe> consumer, ItemLike result, ItemLike ingredient, String loaded) {
        ConditionalRecipe.builder().addCondition(new ModLoadedCondition(loaded)).addRecipe(
                        ShapedRecipeBuilder.shaped(RecipeCategory.BREWING, result)
                                .define('#', ingredient)
                                .define('R', PRItemsRegistry.POTION_RING.get())
                                .pattern(" # ")
                                .pattern("#R#")
                                .pattern(" # ")
                                .group("rings")
                                .unlockedBy("has_ring", has(PRItemsRegistry.POTION_RING.get()))::save)
                .build(consumer, new ResourceLocation(PotionRing.MODID, result.asItem().toString()));
    }

    public static void ringsSpecialLoaded(Consumer<FinishedRecipe> consumer, ItemLike result, ItemLike ingredient1, ItemLike ingredient2, String loaded) {
        ConditionalRecipe.builder().addCondition(new ModLoadedCondition(loaded)).addRecipe(
                        ShapedRecipeBuilder.shaped(RecipeCategory.BREWING, result)
                                .define('#', ingredient1)
                                .define('R', ingredient2)
                                .pattern(" # ")
                                .pattern("#R#")
                                .pattern(" # ")
                                .group("rings")
                                .unlockedBy("has_potion_ring", has(PRItemsRegistry.POTION_RING.get()))::save)
                .build(consumer, new ResourceLocation(PotionRing.MODID, result.asItem().toString()));
    }
}