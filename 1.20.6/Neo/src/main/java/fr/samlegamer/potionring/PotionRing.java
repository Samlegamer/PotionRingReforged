package fr.samlegamer.potionring;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import fr.samlegamer.potionring.item.PRItemsRegistry;

@Mod(value = PotionRing.MODID)
public class PotionRing
{
	public static final String MODID = "potionring";
	public static final Logger log = LogManager.getLogger();
	
	public static final DeferredRegister<MobEffect> growing = DeferredRegister.create(new ResourceLocation("growing"), "sizeshiftingpotions");
	public static final DeferredRegister<MobEffect> shrinking = DeferredRegister.create(new ResourceLocation("sizeshiftingpotions:shrinking"), "sizeshiftingpotions");
	public static final DeferredRegister<MobEffect> widening = DeferredRegister.create(new ResourceLocation("sizeshiftingpotions:widening"), "sizeshiftingpotions");
	public static final DeferredRegister<MobEffect> thinning = DeferredRegister.create(new ResourceLocation("sizeshiftingpotions:thinning"), "sizeshiftingpotions");
	
	public PotionRing(IEventBus modEventBus)
	{
		modEventBus.addListener(this::addToTab);
		//PRItemsRegistry.addons();
		PRItemsRegistry.ITEMS_REGISTRY.register(modEventBus);
		log.info("Potion Ring - REFORGED is Charged");
	}
	
	private void addToTab(BuildCreativeModeTabContentsEvent event)
	{
	    if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS)
	    {
	    	event.accept(PRItemsRegistry.POTION_RING);
	    	event.accept(PRItemsRegistry.RING_OF_REGENERATION);
	    	event.accept(PRItemsRegistry.RING_OF_HASTE);
	    	event.accept(PRItemsRegistry.RING_OF_JUMP_BOOST);
	    	event.accept(PRItemsRegistry.RING_OF_RESISTANCE);
	    	event.accept(PRItemsRegistry.RING_OF_SPEED);
	    	event.accept(PRItemsRegistry.RING_OF_STRENGH);
	    	/*if(ModList.get().isLoaded("sizeshiftingpotions"))
			{
		    	event.accept(PRItemsRegistry.ring_of_growing);
		    	event.accept(PRItemsRegistry.ring_of_shrinking);
		    	event.accept(PRItemsRegistry.ring_of_widening);
		    	event.accept(PRItemsRegistry.ring_of_thinning);
			}*/
	    }
	}
}