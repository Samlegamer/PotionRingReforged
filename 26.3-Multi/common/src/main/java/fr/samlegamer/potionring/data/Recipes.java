package fr.samlegamer.potionring.data;

import net.minecraft.advancements.Advancement;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import static fr.samlegamer.potionring.util.PRFunc.ringSearch;
import static fr.samlegamer.potionring.util.PRFunc.ringSearchModded;

public abstract class Recipes extends RecipeProvider
{
    protected Recipes(BootstrapContext<Recipe<?>> recipeOutput, BootstrapContext<Advancement> advancementOutput) {
        super(recipeOutput, advancementOutput);
    }

    public void recipes()
    {
        shaped(RecipeCategory.BREWING, ringSearch("potion_ring"))
                .define('#', Items.GOLD_INGOT)
                .define('R', Blocks.LAPIS_BLOCK)
                .pattern("R# ")
                .pattern("# #")
                .pattern(" # ")
                .group("rings")
                .unlockedBy("has_gold_ingot", has(Items.GOLD_INGOT))
                .unlockedBy("has_lapis_block", has(Blocks.LAPIS_BLOCK))
                .save(this.output);

        rings(this.output, ringSearch("ring_of_haste"), Items.EMERALD);
        rings(this.output, ringSearch("ring_of_regeneration"), Items.GHAST_TEAR);
        rings(this.output, ringSearch("ring_of_resistance"), Items.DIAMOND);
        rings(this.output, ringSearch("ring_of_speed"), Items.SUGAR);
        rings(this.output, ringSearch("ring_of_strength"), Items.BLAZE_POWDER);
        rings(this.output, ringSearch("ring_of_jump_boost"), Items.RABBIT_FOOT);

        rings(this.output, ringSearch("ring_of_fire_resistance"), Items.MAGMA_CREAM);
        ringsSpecial(this.output, ringSearch("ring_of_invisibility"), Items.FERMENTED_SPIDER_EYE, ringSearch("ring_of_night_vision"));
        ringsSpecial(this.output, ringSearch("ring_of_slowness"), Items.FERMENTED_SPIDER_EYE, ringSearch("ring_of_speed"));
        ringsSpecial(this.output, ringSearch("ring_of_mining_fatigue"), Items.FERMENTED_SPIDER_EYE, ringSearch("ring_of_haste"));
        rings(this.output, ringSearch("ring_of_nausea"), Items.PUFFERFISH);
        rings(this.output, ringSearch("ring_of_blindness"), Items.SUSPICIOUS_STEW);
        rings(this.output, ringSearch("ring_of_hunger"), Items.ROTTEN_FLESH);
        rings(this.output, ringSearch("ring_of_night_vision"), Items.GOLDEN_CARROT);
        ringsSpecial(this.output, ringSearch("ring_of_saturation"), Items.ENCHANTED_GOLDEN_APPLE, ringSearch("ring_of_hunger"));
        rings(this.output, ringSearch("ring_of_poison"), Items.SPIDER_EYE);
        rings(this.output, ringSearch("ring_of_water_breathing"), Items.SPONGE);
        ringsSpecial(this.output, ringSearch("ring_of_weakness"), Items.FERMENTED_SPIDER_EYE, ringSearch("ring_of_strength"));
        rings(this.output, ringSearch("ring_of_wither"), Items.WITHER_ROSE);
        rings(this.output, ringSearch("ring_of_glowing"), Items.GLOWSTONE);
        rings(this.output, ringSearch("ring_of_levitation"), Items.SHULKER_SHELL);
        rings(this.output, ringSearch("ring_of_luck"), Items.TROPICAL_FISH);
        ringsSpecial(this.output, ringSearch("ring_of_unluck"), Items.FERMENTED_SPIDER_EYE, ringSearch("ring_of_luck"));
        rings(this.output, ringSearch("ring_of_slow_falling"), Items.PHANTOM_MEMBRANE);
        rings(this.output, ringSearch("ring_of_conduit_power"), Items.CONDUIT);
        rings(this.output, ringSearch("ring_of_dolphins_grace"), Items.HEART_OF_THE_SEA);
        rings(this.output, ringSearch("ring_of_darkness"), Items.ECHO_SHARD);


    }

    public void recipesModdedSSP(RecipeOutput consumer)
    {
        rings(consumer, ringSearchModded("ring_of_growing"),
                Items.CRIMSON_FUNGUS);

        rings(consumer, ringSearchModded("ring_of_shrinking"),
                Items.WARPED_FUNGUS);

        ringsSpecial(consumer, ringSearchModded("ring_of_thinning"),
                Items.FERMENTED_SPIDER_EYE, ringSearchModded("ring_of_shrinking"));

        ringsSpecial(consumer, ringSearchModded("ring_of_widening"),
                Items.FERMENTED_SPIDER_EYE, ringSearchModded("ring_of_growing"));
    }

    public void rings(RecipeOutput consumer, ItemLike result, ItemLike ingredient) {
        shaped(RecipeCategory.BREWING, result)
                .define('#', ingredient)
                .define('R', ringSearch("potion_ring"))
                .pattern(" # ")
                .pattern("#R#")
                .pattern(" # ")
                .group("rings")
                .unlockedBy("has_ring", has(ringSearch("potion_ring")))
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
                .unlockedBy("has_potion_ring", has(ringSearch("potion_ring")))
                .save(consumer);
    }
}