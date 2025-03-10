package fr.samlegamer.potionring;

import com.electronwill.nightconfig.core.file.FileConfig;
import fr.samlegamer.potionring.cfg.*;
import net.minecraft.client.Minecraft;
import net.minecraft.potion.Effect;
import net.minecraft.potion.Effects;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import fr.samlegamer.potionring.item.PRItemsRegistry;

@Mod(value = PotionRing.MODID)
public class PotionRing {
	public static final String MODID = "potionring";
	public static final Logger log = LogManager.getLogger();

	public PotionRing() {

		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, TutorialConfig.SPEC, "tutorialmod-common.toml");

		MinecraftForge.EVENT_BUS.register(CfgT.class);
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Configs.SERVER_CONFIG);
		//ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Configs.SPEC, "potionring1-common.toml");
		//Configs.init();

		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		PRItemsRegistry.registryVanillaRings();

//		MinecraftForge.EVENT_BUS.register(this);

		log.info("PR bool : " + TutorialConfig.example_string.get().toString());
		//MinecraftForge.EVENT_BUS.register(this);
		PRItemsRegistry.ITEMS_REGISTRY.register(bus);

		log.info("Potion Rings - REFORGED is Charged");
	}

	public static boolean getConfigFromType(Effect effect)
	{
		if(effect == Effects.FIRE_RESISTANCE)
		{
			return ConfigLoad.enableFireResistanceRing;
		}
		else
		{
			return true;
		}
	}

	/*public void onCommonSetup(FMLCommonSetupEvent event) {
		PRItemsRegistry.registryVanillaRings();
		System.out.println("Les anneaux ont été enregistrés après le chargement de la config !");
	}*/

	//@SubscribeEvent(priority = EventPriority.HIGHEST)
//	public static void onLoad(final ModConfig.Loading configEvent)
//	{
//		log.info("Config chargée : " + TutorialConfig.example_string.get());
//		ConfigLoad.enableFireResistanceRing = TutorialConfig.example_string.get();
//		log.info("PR bool : " + ConfigLoad.enableFireResistanceRing);
//
//	}
//
//	//@SubscribeEvent(priority = EventPriority.HIGHEST)
//	public static void onFileChange(final ModConfig.Reloading configEvent)
//	{
//		log.info("Config rechargée !");
//		ConfigLoad.enableFireResistanceRing = TutorialConfig.example_string.get();
//		log.info("PR bool : " + ConfigLoad.enableFireResistanceRing);
//
//
//	}

	private void enqueueIMC(final InterModEnqueueEvent event)
	{
		if (Configs.SERVER_CONFIG != null) {

			SlotTypePreset[] slots = {
					SlotTypePreset.HEAD, SlotTypePreset.NECKLACE, SlotTypePreset.BACK, SlotTypePreset.BODY,
					SlotTypePreset.HANDS, SlotTypePreset.RING, SlotTypePreset.CHARM
			};
			List<SlotTypeMessage.Builder> builders = new ArrayList<>();
			for (SlotTypePreset slot : slots) {
				SlotTypeMessage.Builder builder = slot.getMessageBuilder();
				if (slot == SlotTypePreset.RING) {
					builder.size(ConfigLoad.numberOfRing);
				}
				builders.add(builder);
			}
			for (SlotTypeMessage.Builder builder : builders) {
				SlotTypeMessage message = builder.build();
				InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE,
						() -> message);
			}
		}
	}
}