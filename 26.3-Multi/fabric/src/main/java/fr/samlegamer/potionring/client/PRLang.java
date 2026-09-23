package fr.samlegamer.potionring.client;

import fr.samlegamer.potionring.util.PRFunc;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.Item;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class PRLang extends FabricLanguageProvider
{
    public PRLang(FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider registryLookup, TranslationBuilder translationBuilder)
    {
        for(Map.Entry<Item, String> map : PRFunc.translations().entrySet()) {
            translationBuilder.add(map.getKey(), map.getValue());
        }
    }
}