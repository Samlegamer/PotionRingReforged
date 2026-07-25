package fr.samlegamer.potionring.client;

import fr.samlegamer.potionring.PotionRing;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.data.PackOutput;
import org.jetbrains.annotations.NotNull;

public class PRModels extends ModelProvider
{
    public PRModels(PackOutput output) {
        super(output, PotionRing.MODID);
    }

    @Override
    protected void registerModels(@NotNull BlockModelGenerators blockModels, @NotNull ItemModelGenerators itemModels)
    {
        Models.modelsItem(itemModels);
    }
}
