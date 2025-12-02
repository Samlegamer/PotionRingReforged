package fr.samlegamer.potionring.data;

import fr.samlegamer.potionring.PotionRing;
import fr.samlegamer.potionring.item.PRItemsRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions;
import net.minecraft.block.Blocks;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class PRRecipes extends FabricRecipeProvider
{
    public PRRecipes(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                createShaped(RecipeCategory.BREWING, PRItemsRegistry.POTION_RING)
                        .input('#', Items.GOLD_INGOT)
                        .input('R', Blocks.LAPIS_BLOCK)
                        .pattern("R# ")
                        .pattern("# #")
                        .pattern(" # ")
                        .group("rings")
                        .criterion("has_gold_ingot", conditionsFromItem(Items.GOLD_INGOT))
                        .criterion("has_lapis_block", conditionsFromItem(Blocks.LAPIS_BLOCK))
                        .offerTo(exporter);

                rings(exporter, PRItemsRegistry.RING_OF_HASTE, Items.EMERALD);
                rings(exporter, PRItemsRegistry.RING_OF_REGENERATION, Items.GHAST_TEAR);
                rings(exporter, PRItemsRegistry.RING_OF_RESISTANCE, Items.DIAMOND);
                rings(exporter, PRItemsRegistry.RING_OF_SPEED, Items.SUGAR);
                rings(exporter, PRItemsRegistry.RING_OF_STRENGTH, Items.BLAZE_POWDER);
                rings(exporter, PRItemsRegistry.RING_OF_JUMP_BOOST, Items.RABBIT_FOOT);

                rings(exporter, PRItemsRegistry.RING_OF_FIRE_RESISTANCE, Items.MAGMA_CREAM);
                ringsSpecial(exporter, PRItemsRegistry.RING_OF_INVISIBILITY, Items.FERMENTED_SPIDER_EYE, PRItemsRegistry.RING_OF_NIGHT_VISION);
                ringsSpecial(exporter, PRItemsRegistry.RING_OF_SLOWNESS, Items.FERMENTED_SPIDER_EYE, PRItemsRegistry.RING_OF_SPEED);
                ringsSpecial(exporter, PRItemsRegistry.RING_OF_MINING_FATIGUE, Items.FERMENTED_SPIDER_EYE, PRItemsRegistry.RING_OF_HASTE);
                rings(exporter, PRItemsRegistry.RING_OF_NAUSEA, Items.PUFFERFISH);
                rings(exporter, PRItemsRegistry.RING_OF_BLINDNESS, Items.SUSPICIOUS_STEW);
                rings(exporter, PRItemsRegistry.RING_OF_HUNGER, Items.ROTTEN_FLESH);
                rings(exporter, PRItemsRegistry.RING_OF_NIGHT_VISION, Items.GOLDEN_CARROT);
                ringsSpecial(exporter, PRItemsRegistry.RING_OF_SATURATION, Items.ENCHANTED_GOLDEN_APPLE, PRItemsRegistry.RING_OF_HUNGER);
                rings(exporter, PRItemsRegistry.RING_OF_POISON, Items.SPIDER_EYE);
                rings(exporter, PRItemsRegistry.RING_OF_WATER_BREATHING, Items.SPONGE);
                ringsSpecial(exporter, PRItemsRegistry.RING_OF_WEAKNESS, Items.FERMENTED_SPIDER_EYE, PRItemsRegistry.RING_OF_STRENGTH);
                rings(exporter, PRItemsRegistry.RING_OF_WITHER, Items.WITHER_ROSE);
                rings(exporter, PRItemsRegistry.RING_OF_GLOWING, Items.GLOWSTONE);
                rings(exporter, PRItemsRegistry.RING_OF_LEVITATION, Items.SHULKER_SHELL);
                rings(exporter, PRItemsRegistry.RING_OF_LUCK, Items.TROPICAL_FISH);
                ringsSpecial(exporter, PRItemsRegistry.RING_OF_UNLUCK, Items.FERMENTED_SPIDER_EYE, PRItemsRegistry.RING_OF_LUCK);
                rings(exporter, PRItemsRegistry.RING_OF_SLOW_FALLING, Items.PHANTOM_MEMBRANE);
                rings(exporter, PRItemsRegistry.RING_OF_CONDUIT_POWER, Items.CONDUIT);
                rings(exporter, PRItemsRegistry.RING_OF_DOLPHIN_GRACE, Items.HEART_OF_THE_SEA);
                rings(exporter, PRItemsRegistry.RING_OF_DARKNESS, Items.ECHO_SHARD);

                ringsLoaded(exporter, Registries.ITEM.get(Identifier.of(PotionRing.MODID, "ring_of_growing")),
                        Items.CRIMSON_FUNGUS, "sizeshiftingpotions");

                ringsLoaded(exporter, Registries.ITEM.get(Identifier.of(PotionRing.MODID, "ring_of_shrinking")),
                        Items.WARPED_FUNGUS, "sizeshiftingpotions");

                ringsSpecialLoaded(exporter, Registries.ITEM.get(Identifier.of(PotionRing.MODID, "ring_of_thinning")),
                        Items.FERMENTED_SPIDER_EYE, Registries.ITEM.get(Identifier.of(PotionRing.MODID, "ring_of_shrinking")), "sizeshiftingpotions");

                ringsSpecialLoaded(exporter, Registries.ITEM.get(Identifier.of(PotionRing.MODID, "ring_of_widening")),
                        Items.FERMENTED_SPIDER_EYE, Registries.ITEM.get(Identifier.of(PotionRing.MODID, "ring_of_growing")), "sizeshiftingpotions");
            }

            public void rings(RecipeExporter exporter, Item result, Item ingredient) {
                createShaped(RecipeCategory.BREWING, result)
                        .input('#', ingredient)
                        .input('R', PRItemsRegistry.POTION_RING)
                        .pattern(" # ")
                        .pattern("#R#")
                        .pattern(" # ")
                        .group("rings")
                        .criterion("has_ring", conditionsFromItem(PRItemsRegistry.POTION_RING))
                        .offerTo(exporter);
            }

            public void ringsSpecial(RecipeExporter exporter, Item result, Item ingredient1, ItemConvertible ingredient2) {
                createShaped(RecipeCategory.BREWING, result)
                        .input('#', ingredient1)
                        .input('R', ingredient2)
                        .pattern(" # ")
                        .pattern("#R#")
                        .pattern(" # ")
                        .group("rings")
                        .criterion("has_potion_ring", conditionsFromItem(PRItemsRegistry.POTION_RING))
                        .offerTo(exporter);
            }

            public void ringsLoaded(RecipeExporter consumer, Item result, Item ingredient, String loaded) {
                var recipeExporter = withConditions(consumer, ResourceConditions.allModsLoaded(loaded));

                createShaped(RecipeCategory.BREWING, result)
                        .input('#', ingredient)
                        .input('R', PRItemsRegistry.POTION_RING)
                        .pattern(" # ")
                        .pattern("#R#")
                        .pattern(" # ")
                        .group("rings")
                        .criterion("has_ring", conditionsFromItem(PRItemsRegistry.POTION_RING))
                        .offerTo(recipeExporter);
            }

            public void ringsSpecialLoaded(RecipeExporter consumer, Item result, Item ingredient1, Item ingredient2, String loaded) {
                var recipeExporter = withConditions(consumer, ResourceConditions.allModsLoaded(loaded));

                createShaped(RecipeCategory.BREWING, result)
                        .input('#', ingredient1)
                        .input('R', ingredient2)
                        .pattern(" # ")
                        .pattern("#R#")
                        .pattern(" # ")
                        .group("rings")
                        .criterion("has_potion_ring", conditionsFromItem(PRItemsRegistry.POTION_RING))
                        .offerTo(recipeExporter);
            }

        };
    }

    @Override
    public String getName() {
        return PotionRing.MODID + " Recipes";
    }
}