package fr.samlegamer.potionring.data;

import fr.samlegamer.potionring.PotionRing;
import fr.samlegamer.potionring.item.PRItemsRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class PRRecipes extends FabricRecipeProvider
{
    public PRRecipes(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected @NonNull RecipeProvider createRecipeProvider(HolderLookup.@NonNull Provider registries, @NonNull RecipeOutput output) {
        return new RecipeProvider(registries, output) {
            @Override
            public void buildRecipes() {
                shaped(RecipeCategory.BREWING, PRItemsRegistry.POTION_RING)
                        .define('#', Items.GOLD_INGOT)
                        .define('R', Blocks.LAPIS_BLOCK)
                        .pattern("R# ")
                        .pattern("# #")
                        .pattern(" # ")
                        .group("rings")
                        .unlockedBy("has_gold_ingot", has(Items.GOLD_INGOT))
                        .unlockedBy("has_lapis_block", has(Blocks.LAPIS_BLOCK))
                        .save(this.output);

                rings(this.output, PRItemsRegistry.RING_OF_HASTE, Items.EMERALD);
                rings(this.output, PRItemsRegistry.RING_OF_REGENERATION, Items.GHAST_TEAR);
                rings(this.output, PRItemsRegistry.RING_OF_RESISTANCE, Items.DIAMOND);
                rings(this.output, PRItemsRegistry.RING_OF_SPEED, Items.SUGAR);
                rings(this.output, PRItemsRegistry.RING_OF_STRENGTH, Items.BLAZE_POWDER);
                rings(this.output, PRItemsRegistry.RING_OF_JUMP_BOOST, Items.RABBIT_FOOT);

                rings(this.output, PRItemsRegistry.RING_OF_FIRE_RESISTANCE, Items.MAGMA_CREAM);
                ringsSpecial(this.output, PRItemsRegistry.RING_OF_INVISIBILITY, Items.FERMENTED_SPIDER_EYE, PRItemsRegistry.RING_OF_NIGHT_VISION);
                ringsSpecial(this.output, PRItemsRegistry.RING_OF_SLOWNESS, Items.FERMENTED_SPIDER_EYE, PRItemsRegistry.RING_OF_SPEED);
                ringsSpecial(this.output, PRItemsRegistry.RING_OF_MINING_FATIGUE, Items.FERMENTED_SPIDER_EYE, PRItemsRegistry.RING_OF_HASTE);
                rings(this.output, PRItemsRegistry.RING_OF_NAUSEA, Items.PUFFERFISH);
                rings(this.output, PRItemsRegistry.RING_OF_BLINDNESS, Items.SUSPICIOUS_STEW);
                rings(this.output, PRItemsRegistry.RING_OF_HUNGER, Items.ROTTEN_FLESH);
                rings(this.output, PRItemsRegistry.RING_OF_NIGHT_VISION, Items.GOLDEN_CARROT);
                ringsSpecial(this.output, PRItemsRegistry.RING_OF_SATURATION, Items.ENCHANTED_GOLDEN_APPLE, PRItemsRegistry.RING_OF_HUNGER);
                rings(this.output, PRItemsRegistry.RING_OF_POISON, Items.SPIDER_EYE);
                rings(this.output, PRItemsRegistry.RING_OF_WATER_BREATHING, Items.SPONGE);
                ringsSpecial(this.output, PRItemsRegistry.RING_OF_WEAKNESS, Items.FERMENTED_SPIDER_EYE, PRItemsRegistry.RING_OF_STRENGTH);
                rings(this.output, PRItemsRegistry.RING_OF_WITHER, Items.WITHER_ROSE);
                rings(this.output, PRItemsRegistry.RING_OF_GLOWING, Items.GLOWSTONE);
                rings(this.output, PRItemsRegistry.RING_OF_LEVITATION, Items.SHULKER_SHELL);
                rings(this.output, PRItemsRegistry.RING_OF_LUCK, Items.TROPICAL_FISH);
                ringsSpecial(this.output, PRItemsRegistry.RING_OF_UNLUCK, Items.FERMENTED_SPIDER_EYE, PRItemsRegistry.RING_OF_LUCK);
                rings(this.output, PRItemsRegistry.RING_OF_SLOW_FALLING, Items.PHANTOM_MEMBRANE);
                rings(this.output, PRItemsRegistry.RING_OF_CONDUIT_POWER, Items.CONDUIT);
                rings(this.output, PRItemsRegistry.RING_OF_DOLPHIN_GRACE, Items.HEART_OF_THE_SEA);
                rings(this.output, PRItemsRegistry.RING_OF_DARKNESS, Items.ECHO_SHARD);

                ringsLoaded(this.output, BuiltInRegistries.ITEM.get(Identifier.fromNamespaceAndPath(PotionRing.MODID, "ring_of_growing")).get().value(),
                        Items.CRIMSON_FUNGUS, "sizeshiftingpotions");

                ringsLoaded(this.output, BuiltInRegistries.ITEM.get(Identifier.fromNamespaceAndPath(PotionRing.MODID, "ring_of_shrinking")).get().value(),
                        Items.WARPED_FUNGUS, "sizeshiftingpotions");

                ringsSpecialLoaded(this.output, BuiltInRegistries.ITEM.get(Identifier.fromNamespaceAndPath(PotionRing.MODID, "ring_of_thinning")).get().value(),
                        Items.FERMENTED_SPIDER_EYE, BuiltInRegistries.ITEM.get(Identifier.fromNamespaceAndPath(PotionRing.MODID, "ring_of_shrinking")).get().value(), "sizeshiftingpotions");

                ringsSpecialLoaded(this.output, BuiltInRegistries.ITEM.get(Identifier.fromNamespaceAndPath(PotionRing.MODID, "ring_of_widening")).get().value(),
                        Items.FERMENTED_SPIDER_EYE, BuiltInRegistries.ITEM.get(Identifier.fromNamespaceAndPath(PotionRing.MODID, "ring_of_growing")).get().value(), "sizeshiftingpotions");
            }

            public void rings(RecipeOutput output, Item result, Item ingredient) {
                shaped(RecipeCategory.BREWING, result)
                        .define('#', ingredient)
                        .define('R', PRItemsRegistry.POTION_RING)
                        .pattern(" # ")
                        .pattern("#R#")
                        .pattern(" # ")
                        .group("rings")
                        .unlockedBy("has_ring", has(PRItemsRegistry.POTION_RING))
                        .save(output);
            }

            public void ringsSpecial(RecipeOutput output, Item result, Item ingredient1, ItemLike ingredient2) {
                shaped(RecipeCategory.BREWING, result)
                        .define('#', ingredient1)
                        .define('R', ingredient2)
                        .pattern(" # ")
                        .pattern("#R#")
                        .pattern(" # ")
                        .group("rings")
                        .unlockedBy("has_potion_ring", has(PRItemsRegistry.POTION_RING))
                        .save(output);
            }

            public void ringsLoaded(RecipeOutput output, Item result, Item ingredient, String loaded) {
                var recipeExporter = withConditions(output, ResourceConditions.allModsLoaded(loaded));

                shaped(RecipeCategory.BREWING, result)
                        .define('#', ingredient)
                        .define('R', PRItemsRegistry.POTION_RING)
                        .pattern(" # ")
                        .pattern("#R#")
                        .pattern(" # ")
                        .group("rings")
                        .unlockedBy("has_ring", has(PRItemsRegistry.POTION_RING))
                        .save(recipeExporter);
            }

            public void ringsSpecialLoaded(RecipeOutput output, Item result, Item ingredient1, Item ingredient2, String loaded) {
                var recipeExporter = withConditions(output, ResourceConditions.allModsLoaded(loaded));

                shaped(RecipeCategory.BREWING, result)
                        .define('#', ingredient1)
                        .define('R', ingredient2)
                        .pattern(" # ")
                        .pattern("#R#")
                        .pattern(" # ")
                        .group("rings")
                        .unlockedBy("has_potion_ring", has(PRItemsRegistry.POTION_RING))
                        .save(recipeExporter);
            }

        };
    }

    @Override
    public @NonNull String getName() {
        return PotionRing.MODID + " Recipes";
    }
}