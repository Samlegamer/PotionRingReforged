package fr.samlegamer.potionring.data;

import fr.samlegamer.potionring.PotionRing;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
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
                Recipes recipes = new Recipes(registries, output) {
                    @Override
                    public void buildRecipes() {
                    }
                };
                RecipeOutput outputCondition = withConditions(this.output, ResourceConditions.allModsLoaded("sizeshiftingpotions"));
                recipes.recipes();
                recipes.recipesModdedSSP(outputCondition);
            }
        };
    }

    @Override
    public @NonNull String getName() {
        return PotionRing.MODID + " Recipes";
    }
}