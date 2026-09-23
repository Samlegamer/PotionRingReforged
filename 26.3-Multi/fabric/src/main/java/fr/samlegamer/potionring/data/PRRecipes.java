package fr.samlegamer.potionring.data;

import fr.samlegamer.potionring.PotionRing;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions;
import net.minecraft.advancements.Advancement;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.item.crafting.Recipe;
import org.jspecify.annotations.NonNull;
import java.util.concurrent.CompletableFuture;

public class PRRecipes extends FabricRecipeProvider
{
    public PRRecipes(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, BootstrapContext<Recipe<?>> recipes, BootstrapContext<Advancement> advancements) {
        return new RecipeProvider(recipes, advancements) {
            @Override
            public void buildRecipes() {
                Recipes r = new Recipes(recipes, advancements) {
                    @Override
                    public void buildRecipes() {
                    }
                };
                RecipeOutput outputCondition = withConditions(this.output, ResourceConditions.allModsLoaded("sizeshiftingpotions"));
                r.recipes();
                r.recipesModdedSSP(outputCondition);
            }
        };
    }

    @Override
    public @NonNull String getName() {
        return PotionRing.MODID + " Recipes";
    }
}