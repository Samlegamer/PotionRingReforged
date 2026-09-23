package fr.samlegamer.potionring.client;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import org.jspecify.annotations.NonNull;

public class PRModels extends FabricModelProvider
{
    public PRModels(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(@NonNull BlockModelGenerators blockStateModelGenerator) {
    }

    @Override
    public void generateItemModels(@NonNull ItemModelGenerators itemModels) {
        Models.modelsItem(itemModels);
    }
}
