package fr.samlegamer.potionring.data;

import fr.samlegamer.potionring.item.PRTagsItemRegistry;
import fr.samlegamer.potionring.util.PRFunc;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class PRTags extends FabricTagsProvider.ItemTagsProvider
{
    public PRTags(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        this.tag(PRTagsItemRegistry.POTION_RINGS).add(PRFunc.tags());
    }
}