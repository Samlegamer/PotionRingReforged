package fr.samlegamer.potionring.data;

import net.minecraft.advancements.Advancement;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.MultiRegistryBootstrap;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.crafting.Recipe;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Set;

public class PRRecipes extends Recipes
{
    public PRRecipes(BootstrapContext<Recipe<?>> recipeOutput, BootstrapContext<Advancement> advancementOutput) {
        super(recipeOutput, advancementOutput);
    }

    @ParametersAreNonnullByDefault
    protected void buildRecipes()
    {
        recipes();
        recipesModdedSSP(this.output.withConditions(new ModLoadedCondition("sizeshiftingpotions")));
    }

    public static MultiRegistryBootstrap create()
    {
        return new MultiRegistryBootstrap()
        {
            @Override
            public Set<ResourceKey<? extends Registry<?>>> requestedRegistries()
            {
                return Set.of(Registries.RECIPE, Registries.ADVANCEMENT);
            }

            @Override
            public void run(MultiRegistryBootstrap.BootstrapGetter registries)
            {
                new PRRecipes(registries.get(Registries.RECIPE), registries.get(Registries.ADVANCEMENT)).buildRecipes();
            }
        };
    }
}