package fr.samlegamer.potionring.data;

import fr.samlegamer.potionring.client.PRLang;
import fr.samlegamer.potionring.client.PRModels;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class PRDataGen implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		fabricDataGenerator.addProvider(PRLang::new);
		fabricDataGenerator.addProvider(PRModels::new);
		fabricDataGenerator.addProvider(PRRecipes::new);
		fabricDataGenerator.addProvider(PRTags::new);

	}
}
