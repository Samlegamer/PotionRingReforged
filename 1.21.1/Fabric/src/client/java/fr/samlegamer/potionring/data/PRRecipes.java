package fr.samlegamer.potionring.data;

import fr.samlegamer.potionring.item.PRItemsRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import java.util.concurrent.CompletableFuture;

public class PRRecipes extends FabricRecipeProvider
{
    public PRRecipes(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter consumer)
    {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BREWING, PRItemsRegistry.POTION_RING)
                .input('#', Items.GOLD_INGOT)
                .input('R', Blocks.LAPIS_BLOCK)
                .pattern("R# ")
                .pattern("# #")
                .pattern(" # ")
                .group("rings")
                .criterion("has_gold_ingot", FabricRecipeProvider.conditionsFromItem(Items.GOLD_INGOT))
                .criterion("has_lapis_block", FabricRecipeProvider.conditionsFromItem(Blocks.LAPIS_BLOCK))
                .offerTo(consumer);

        rings(consumer, PRItemsRegistry.RING_OF_HASTE, Items.EMERALD);
        rings(consumer, PRItemsRegistry.RING_OF_REGENERATION, Items.GHAST_TEAR);
        rings(consumer, PRItemsRegistry.RING_OF_RESISTANCE, Items.DIAMOND);
        rings(consumer, PRItemsRegistry.RING_OF_SPEED, Items.SUGAR);
        rings(consumer, PRItemsRegistry.RING_OF_STRENGTH, Items.BLAZE_POWDER);
        rings(consumer, PRItemsRegistry.RING_OF_JUMP_BOOST, Items.RABBIT_FOOT);

        rings(consumer, PRItemsRegistry.RING_OF_FIRE_RESISTANCE, Items.MAGMA_CREAM);
        ringsSpecial(consumer, PRItemsRegistry.RING_OF_INVISIBILITY, Items.FERMENTED_SPIDER_EYE, PRItemsRegistry.RING_OF_NIGHT_VISION);
        ringsSpecial(consumer, PRItemsRegistry.RING_OF_SLOWNESS, Items.FERMENTED_SPIDER_EYE, PRItemsRegistry.RING_OF_SPEED);
        ringsSpecial(consumer, PRItemsRegistry.RING_OF_MINING_FATIGUE, Items.FERMENTED_SPIDER_EYE, PRItemsRegistry.RING_OF_HASTE);
        rings(consumer, PRItemsRegistry.RING_OF_NAUSEA, Items.PUFFERFISH);
        rings(consumer, PRItemsRegistry.RING_OF_BLINDNESS, Items.SUSPICIOUS_STEW);
        rings(consumer, PRItemsRegistry.RING_OF_HUNGER, Items.ROTTEN_FLESH);
        rings(consumer, PRItemsRegistry.RING_OF_NIGHT_VISION, Items.GOLDEN_CARROT);
        ringsSpecial(consumer, PRItemsRegistry.RING_OF_SATURATION, Items.ENCHANTED_GOLDEN_APPLE, PRItemsRegistry.RING_OF_HUNGER);
        rings(consumer, PRItemsRegistry.RING_OF_POISON, Items.SPIDER_EYE);
        rings(consumer, PRItemsRegistry.RING_OF_WATER_BREATHING, Items.SPONGE);
        ringsSpecial(consumer, PRItemsRegistry.RING_OF_WEAKNESS, Items.FERMENTED_SPIDER_EYE, PRItemsRegistry.RING_OF_STRENGTH);
        rings(consumer, PRItemsRegistry.RING_OF_WITHER, Items.WITHER_ROSE);
        rings(consumer, PRItemsRegistry.RING_OF_GLOWING, Items.GLOWSTONE);
        rings(consumer, PRItemsRegistry.RING_OF_LEVITATION, Items.SHULKER_SHELL);
        rings(consumer, PRItemsRegistry.RING_OF_LUCK, Items.TROPICAL_FISH);
        ringsSpecial(consumer, PRItemsRegistry.RING_OF_UNLUCK, Items.FERMENTED_SPIDER_EYE, PRItemsRegistry.RING_OF_LUCK);
        rings(consumer, PRItemsRegistry.RING_OF_SLOW_FALLING, Items.PHANTOM_MEMBRANE);
        rings(consumer, PRItemsRegistry.RING_OF_CONDUIT_POWER, Items.CONDUIT);
        rings(consumer, PRItemsRegistry.RING_OF_DOLPHIN_GRACE, Items.HEART_OF_THE_SEA);
        rings(consumer, PRItemsRegistry.RING_OF_DARKNESS, Items.ECHO_SHARD);
    }

    public static void rings(RecipeExporter consumer, Item result, Item ingredient) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BREWING, result)
                .input('#', ingredient)
                .input('R', PRItemsRegistry.POTION_RING)
                .pattern(" # ")
                .pattern("#R#")
                .pattern(" # ")
                .group("rings")
                .criterion("has_ring", FabricRecipeProvider.conditionsFromItem(PRItemsRegistry.POTION_RING))
                .offerTo(consumer);
    }

    public static void ringsSpecial(RecipeExporter consumer, Item result, Item ingredient1, ItemConvertible ingredient2) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BREWING, result)
                .input('#', ingredient1)
                .input('R', ingredient2)
                .pattern(" # ")
                .pattern("#R#")
                .pattern(" # ")
                .group("rings")
                .criterion("has_potion_ring", FabricRecipeProvider.conditionsFromItem(PRItemsRegistry.POTION_RING))
                .offerTo(consumer);
    }
}