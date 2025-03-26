package fr.samlegamer.potionring.data;

import fr.samlegamer.potionring.item.PRItemsRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.data.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import java.util.concurrent.CompletableFuture;

public class PRRecipes extends FabricRecipeProvider
{
    public PRRecipes(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter)
    {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {

            public void rings(RegistryEntryLookup<Item> itemLookup, RecipeExporter consumer, Item result, Item ingredient) {
                ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.BREWING, result)
                        .input('#', ingredient)
                        .input('R', PRItemsRegistry.POTION_RING)
                        .pattern(" # ")
                        .pattern("#R#")
                        .pattern(" # ")
                        .group("rings")
                        .criterion("has_ring", conditionsFromItem(PRItemsRegistry.POTION_RING))
                        .offerTo(consumer);
            }

            public void ringsSpecial(RegistryEntryLookup<Item> itemLookup, RecipeExporter consumer, Item result, Item ingredient1, ItemConvertible ingredient2) {
                ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.BREWING, result)
                        .input('#', ingredient1)
                        .input('R', ingredient2)
                        .pattern(" # ")
                        .pattern("#R#")
                        .pattern(" # ")
                        .group("rings")
                        .criterion("has_potion_ring", conditionsFromItem(PRItemsRegistry.POTION_RING))
                        .offerTo(consumer);
            }

            @Override
            public void generate() {
                final RegistryEntryLookup<Item> itemLookup = wrapperLookup.getOrThrow(RegistryKeys.ITEM);

                ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.BREWING, PRItemsRegistry.POTION_RING)
                        .input('#', Items.GOLD_INGOT)
                        .input('R', Blocks.LAPIS_BLOCK)
                        .pattern("R# ")
                        .pattern("# #")
                        .pattern(" # ")
                        .group("rings")
                        .criterion("has_gold_ingot", conditionsFromItem(Items.GOLD_INGOT))
                        .criterion("has_lapis_block", conditionsFromItem(Blocks.LAPIS_BLOCK))
                        .offerTo(recipeExporter);

                rings(itemLookup, recipeExporter, PRItemsRegistry.RING_OF_HASTE, Items.EMERALD);
                rings(itemLookup, recipeExporter, PRItemsRegistry.RING_OF_REGENERATION, Items.GHAST_TEAR);
                rings(itemLookup, recipeExporter, PRItemsRegistry.RING_OF_RESISTANCE, Items.DIAMOND);
                rings(itemLookup, recipeExporter, PRItemsRegistry.RING_OF_SPEED, Items.SUGAR);
                rings(itemLookup, recipeExporter, PRItemsRegistry.RING_OF_STRENGTH, Items.BLAZE_POWDER);
                rings(itemLookup, recipeExporter, PRItemsRegistry.RING_OF_JUMP_BOOST, Items.RABBIT_FOOT);

                rings(itemLookup, recipeExporter, PRItemsRegistry.RING_OF_FIRE_RESISTANCE, Items.MAGMA_CREAM);
                ringsSpecial(itemLookup, recipeExporter, PRItemsRegistry.RING_OF_INVISIBILITY, Items.FERMENTED_SPIDER_EYE, PRItemsRegistry.RING_OF_NIGHT_VISION);
                ringsSpecial(itemLookup, recipeExporter, PRItemsRegistry.RING_OF_SLOWNESS, Items.FERMENTED_SPIDER_EYE, PRItemsRegistry.RING_OF_SPEED);
                ringsSpecial(itemLookup, recipeExporter, PRItemsRegistry.RING_OF_MINING_FATIGUE, Items.FERMENTED_SPIDER_EYE, PRItemsRegistry.RING_OF_HASTE);
                rings(itemLookup, recipeExporter, PRItemsRegistry.RING_OF_NAUSEA, Items.PUFFERFISH);
                rings(itemLookup, recipeExporter, PRItemsRegistry.RING_OF_BLINDNESS, Items.SUSPICIOUS_STEW);
                rings(itemLookup, recipeExporter, PRItemsRegistry.RING_OF_HUNGER, Items.ROTTEN_FLESH);
                rings(itemLookup, recipeExporter, PRItemsRegistry.RING_OF_NIGHT_VISION, Items.GOLDEN_CARROT);
                ringsSpecial(itemLookup, recipeExporter, PRItemsRegistry.RING_OF_SATURATION, Items.ENCHANTED_GOLDEN_APPLE, PRItemsRegistry.RING_OF_HUNGER);
                rings(itemLookup, recipeExporter, PRItemsRegistry.RING_OF_POISON, Items.SPIDER_EYE);
                rings(itemLookup, recipeExporter, PRItemsRegistry.RING_OF_WATER_BREATHING, Items.SPONGE);
                ringsSpecial(itemLookup, recipeExporter, PRItemsRegistry.RING_OF_WEAKNESS, Items.FERMENTED_SPIDER_EYE, PRItemsRegistry.RING_OF_STRENGTH);
                rings(itemLookup, recipeExporter, PRItemsRegistry.RING_OF_WITHER, Items.WITHER_ROSE);
                rings(itemLookup, recipeExporter, PRItemsRegistry.RING_OF_GLOWING, Items.GLOWSTONE);
                rings(itemLookup, recipeExporter, PRItemsRegistry.RING_OF_LEVITATION, Items.SHULKER_SHELL);
                rings(itemLookup, recipeExporter, PRItemsRegistry.RING_OF_LUCK, Items.TROPICAL_FISH);
                ringsSpecial(itemLookup, recipeExporter, PRItemsRegistry.RING_OF_UNLUCK, Items.FERMENTED_SPIDER_EYE, PRItemsRegistry.RING_OF_LUCK);
                rings(itemLookup, recipeExporter, PRItemsRegistry.RING_OF_SLOW_FALLING, Items.PHANTOM_MEMBRANE);
                rings(itemLookup, recipeExporter, PRItemsRegistry.RING_OF_CONDUIT_POWER, Items.CONDUIT);
                rings(itemLookup, recipeExporter, PRItemsRegistry.RING_OF_DOLPHIN_GRACE, Items.HEART_OF_THE_SEA);
                rings(itemLookup, recipeExporter, PRItemsRegistry.RING_OF_DARKNESS, Items.ECHO_SHARD);
            }
        };
    }



    @Override
    public String getName() {
        return "Potions Rings Recipes";
    }
}