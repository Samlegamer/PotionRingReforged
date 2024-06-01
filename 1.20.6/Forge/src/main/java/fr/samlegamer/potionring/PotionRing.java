package fr.samlegamer.potionring;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import top.theillusivec4.curios.api.CuriosApi;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import fr.samlegamer.potionring.item.PRItemsRegistry;
import fr.samlegamer.potionring.item.PRTypes;
import fr.samlegamer.potionring.item.PotionRingItem;

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
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::addToTab);
		//PRItemsRegistry.addons();
		PRItemsRegistry.ITEMS_REGISTRY.register(FMLJavaModLoadingContext.get().getModEventBus());
		log.info("Potion Ring - REFORGED is Charged");
	}
	
	private void addToTab(BuildCreativeModeTabContentsEvent event)
	{
	    if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS)
	    {
	    	event.accept(PRItemsRegistry.POTION_RING);
	    	/*event.accept(PRItemsRegistry.RING_OF_REGENERATION);
	    	event.accept(PRItemsRegistry.RING_OF_HASTE);
	    	event.accept(PRItemsRegistry.RING_OF_JUMP_BOOST);
	    	event.accept(PRItemsRegistry.RING_OF_RESISTANCE);
	    	event.accept(PRItemsRegistry.RING_OF_SPEED);
	    	event.accept(PRItemsRegistry.RING_OF_STRENGH);
	    	if(ModList.get().isLoaded("sizeshiftingpotions"))
			{
		    	event.accept(PRItemsRegistry.ring_of_growing);
		    	event.accept(PRItemsRegistry.ring_of_shrinking);
		    	event.accept(PRItemsRegistry.ring_of_widening);
		    	event.accept(PRItemsRegistry.ring_of_thinning);
			}*/
	    }
	}
}