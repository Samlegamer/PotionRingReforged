package fr.samlegamer.potionring.data;

import fr.samlegamer.potionring.PotionRing;
import fr.samlegamer.potionring.item.PRItemsRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.concurrent.CompletableFuture;

public class PRRecipes extends RecipeProvider
{
    public PRRecipes(HolderLookup.Provider registries, RecipeOutput output)
    {
        super(registries, output);
    }

    @Override
    @ParametersAreNonnullByDefault
    protected void buildRecipes()
    {
        shaped(RecipeCategory.BREWING, PRItemsRegistry.POTION_RING.get())
                .define('#', Items.GOLD_INGOT)
                .define('R', Blocks.LAPIS_BLOCK)
                .pattern("R# ")
                .pattern("# #")
                .pattern(" # ")
                .group("rings")
                .unlockedBy("has_gold_ingot", has(Items.GOLD_INGOT))
                .unlockedBy("has_lapis_block", has(Blocks.LAPIS_BLOCK))
                .save(this.output);

        rings(this.output, PRItemsRegistry.RING_OF_HASTE.get(), Items.EMERALD);
        rings(this.output, PRItemsRegistry.RING_OF_REGENERATION.get(), Items.GHAST_TEAR);
        rings(this.output, PRItemsRegistry.RING_OF_RESISTANCE.get(), Items.DIAMOND);
        rings(this.output, PRItemsRegistry.RING_OF_SPEED.get(), Items.SUGAR);
        rings(this.output, PRItemsRegistry.RING_OF_STRENGTH.get(), Items.BLAZE_POWDER);
        rings(this.output, PRItemsRegistry.RING_OF_JUMP_BOOST.get(), Items.RABBIT_FOOT);

        rings(this.output, PRItemsRegistry.RING_OF_FIRE_RESISTANCE.get(), Items.MAGMA_CREAM);
        ringsSpecial(this.output, PRItemsRegistry.RING_OF_INVISIBILITY.get(), Items.FERMENTED_SPIDER_EYE, PRItemsRegistry.RING_OF_NIGHT_VISION.get());
        ringsSpecial(this.output, PRItemsRegistry.RING_OF_SLOWNESS.get(), Items.FERMENTED_SPIDER_EYE, PRItemsRegistry.RING_OF_SPEED.get());
        ringsSpecial(this.output, PRItemsRegistry.RING_OF_MINING_FATIGUE.get(), Items.FERMENTED_SPIDER_EYE, PRItemsRegistry.RING_OF_HASTE.get());
        rings(this.output, PRItemsRegistry.RING_OF_NAUSEA.get(), Items.PUFFERFISH);
        rings(this.output, PRItemsRegistry.RING_OF_BLINDNESS.get(), Items.SUSPICIOUS_STEW);
        rings(this.output, PRItemsRegistry.RING_OF_HUNGER.get(), Items.ROTTEN_FLESH);
        rings(this.output, PRItemsRegistry.RING_OF_NIGHT_VISION.get(), Items.GOLDEN_CARROT);
        ringsSpecial(this.output, PRItemsRegistry.RING_OF_SATURATION.get(), Items.ENCHANTED_GOLDEN_APPLE, PRItemsRegistry.RING_OF_HUNGER.get());
        rings(this.output, PRItemsRegistry.RING_OF_POISON.get(), Items.SPIDER_EYE);
        rings(this.output, PRItemsRegistry.RING_OF_WATER_BREATHING.get(), Items.SPONGE);
        ringsSpecial(this.output, PRItemsRegistry.RING_OF_WEAKNESS.get(), Items.FERMENTED_SPIDER_EYE, PRItemsRegistry.RING_OF_STRENGTH.get());
        rings(this.output, PRItemsRegistry.RING_OF_WITHER.get(), Items.WITHER_ROSE);
        rings(this.output, PRItemsRegistry.RING_OF_GLOWING.get(), Items.GLOWSTONE);
        rings(this.output, PRItemsRegistry.RING_OF_LEVITATION.get(), Items.SHULKER_SHELL);
        rings(this.output, PRItemsRegistry.RING_OF_LUCK.get(), Items.TROPICAL_FISH);
        ringsSpecial(this.output, PRItemsRegistry.RING_OF_UNLUCK.get(), Items.FERMENTED_SPIDER_EYE, PRItemsRegistry.RING_OF_LUCK.get());
        rings(this.output, PRItemsRegistry.RING_OF_SLOW_FALLING.get(), Items.PHANTOM_MEMBRANE);
        rings(this.output, PRItemsRegistry.RING_OF_CONDUIT_POWER.get(), Items.CONDUIT);
        rings(this.output, PRItemsRegistry.RING_OF_DOLPHIN_GRACE.get(), Items.HEART_OF_THE_SEA);
        rings(this.output, PRItemsRegistry.RING_OF_DARKNESS.get(), Items.ECHO_SHARD);

        ringsLoaded(this.output, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(PotionRing.MODID, "ring_of_growing")).get().value(),
                Items.CRIMSON_FUNGUS, "sizeshiftingpotions");

        ringsLoaded(this.output, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(PotionRing.MODID, "ring_of_shrinking")).get().value(),
                Items.WARPED_FUNGUS, "sizeshiftingpotions");

        ringsSpecialLoaded(this.output, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(PotionRing.MODID, "ring_of_thinning")).get().value(),
                Items.FERMENTED_SPIDER_EYE, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(PotionRing.MODID, "ring_of_shrinking")).get().value(), "sizeshiftingpotions");

        ringsSpecialLoaded(this.output, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(PotionRing.MODID, "ring_of_widening")).get().value(),
                Items.FERMENTED_SPIDER_EYE, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(PotionRing.MODID, "ring_of_growing")).get().value(), "sizeshiftingpotions");

    }

    public void rings(RecipeOutput consumer, ItemLike result, ItemLike ingredient) {
        shaped(RecipeCategory.BREWING, result)
                .define('#', ingredient)
                .define('R', PRItemsRegistry.POTION_RING.get())
                .pattern(" # ")
                .pattern("#R#")
                .pattern(" # ")
                .group("rings")
                .unlockedBy("has_ring", has(PRItemsRegistry.POTION_RING.get()))
                .save(consumer);
    }

    public void ringsSpecial(RecipeOutput consumer, ItemLike result, ItemLike ingredient1, ItemLike ingredient2) {
        shaped(RecipeCategory.BREWING, result)
                .define('#', ingredient1)
                .define('R', ingredient2)
                .pattern(" # ")
                .pattern("#R#")
                .pattern(" # ")
                .group("rings")
                .unlockedBy("has_potion_ring", has(PRItemsRegistry.POTION_RING.get())).save(consumer);
    }

    public void ringsLoaded(RecipeOutput consumer, ItemLike result, ItemLike ingredient, String loaded) {

        shaped(RecipeCategory.BREWING, result)
                .define('#', ingredient)
                .define('R', PRItemsRegistry.POTION_RING.get())
                .pattern(" # ")
                .pattern("#R#")
                .pattern(" # ")
                .group("rings")
                .unlockedBy("has_ring", has(PRItemsRegistry.POTION_RING.get()))
                .save(consumer.withConditions(new ModLoadedCondition(loaded)));
    }

    public void ringsSpecialLoaded(RecipeOutput consumer, ItemLike result, ItemLike ingredient1, ItemLike ingredient2, String loaded) {
        shaped(RecipeCategory.BREWING, result)
                .define('#', ingredient1)
                .define('R', ingredient2)
                .pattern(" # ")
                .pattern("#R#")
                .pattern(" # ")
                .group("rings")
                .unlockedBy("has_potion_ring", has(PRItemsRegistry.POTION_RING.get())).save(consumer.withConditions(new ModLoadedCondition(loaded)));
    }

    public static class Runner extends RecipeProvider.Runner
    {
        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected @NotNull RecipeProvider createRecipeProvider(HolderLookup.@NotNull Provider provider, @NotNull RecipeOutput recipeOutput) {
            return new PRRecipes(provider, recipeOutput);
        }

        @Override
        public @NotNull String getName() {
            return "Potions Ring REFORGED Recipes";
        }
    }
}