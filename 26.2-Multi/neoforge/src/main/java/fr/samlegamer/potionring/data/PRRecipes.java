package fr.samlegamer.potionring.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import org.jetbrains.annotations.NotNull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.concurrent.CompletableFuture;

public class PRRecipes extends Recipes
{
    public PRRecipes(HolderLookup.Provider registries, RecipeOutput output)
    {
        super(registries, output);
    }

    @ParametersAreNonnullByDefault
    protected void buildRecipes()
    {
        recipes();
        recipesModdedSSP(this.output.withConditions(new ModLoadedCondition("sizeshiftingpotions")));
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