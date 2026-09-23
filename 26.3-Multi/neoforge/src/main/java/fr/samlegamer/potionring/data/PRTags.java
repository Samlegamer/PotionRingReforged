package fr.samlegamer.potionring.data;

import fr.samlegamer.potionring.PotionRing;
import fr.samlegamer.potionring.item.PRTagsItemRegistry;
import fr.samlegamer.potionring.util.PRFunc;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ItemTagsProvider;
import org.jetbrains.annotations.NotNull;
import java.util.concurrent.CompletableFuture;

public class PRTags extends ItemTagsProvider
{
    public PRTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, PotionRing.MODID);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider)
    {
        this.tag(PRTagsItemRegistry.POTION_RINGS).add(PRFunc.tags());
    }
}