package fr.samlegamer.potionring.client;

import fr.samlegamer.potionring.PotionRing;
import fr.samlegamer.potionring.util.PRFunc;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.data.LanguageProvider;

import java.util.Map;

public class PRLang extends LanguageProvider
{
    public PRLang(PackOutput output) {
        super(output, PotionRing.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        for(Map.Entry<Item, String> map : PRFunc.translations().entrySet()) {
            add(map.getKey(), map.getValue());
        }
    }
}
