package fr.samlegamer.potionring;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import fr.samlegamer.potionring.item.PRItemsRegistry;

@Mod(value = PotionRing.MODID)
@Mod.EventBusSubscriber(modid = PotionRing.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PotionRing
{
	public static final String MODID = "potionring";
	public static final Logger log = LogManager.getLogger();
	
	public static final RegistryObject<MobEffect> growing = RegistryObject.create(new ResourceLocation("sizeshiftingpotions:growing"), ForgeRegistries.MOB_EFFECTS);
	public static final RegistryObject<MobEffect> shrinking = RegistryObject.create(new ResourceLocation("sizeshiftingpotions:shrinking"), ForgeRegistries.MOB_EFFECTS);
	public static final RegistryObject<MobEffect> widening = RegistryObject.create(new ResourceLocation("sizeshiftingpotions:widening"), ForgeRegistries.MOB_EFFECTS);
	public static final RegistryObject<MobEffect> thinning = RegistryObject.create(new ResourceLocation("sizeshiftingpotions:thinning"), ForgeRegistries.MOB_EFFECTS);

	public PotionRing()
	{
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		PRItemsRegistry.ITEMS_REGISTRY.register(bus);
		PRItemsRegistry.addons();
		log.info("Potion Ring - REFORGED is Charged");
	}
		
	private void enqueueIMC(final InterModEnqueueEvent event)
	{
		SlotTypePreset[] slots = {
				SlotTypePreset.HEAD, SlotTypePreset.NECKLACE, SlotTypePreset.BACK, SlotTypePreset.BODY,
				SlotTypePreset.HANDS, SlotTypePreset.RING, SlotTypePreset.CHARM
		};
		List<SlotTypeMessage.Builder> builders = new ArrayList<>();
		for (SlotTypePreset slot : slots) {
			SlotTypeMessage.Builder builder = slot.getMessageBuilder();
			if (slot == SlotTypePreset.RING) {
				builder.size(2);
			}
			builders.add(builder);
		}
		for (SlotTypeMessage.Builder builder : builders) {
			SlotTypeMessage message = builder.build();
			InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE,
					()->message);
		}
	}
}