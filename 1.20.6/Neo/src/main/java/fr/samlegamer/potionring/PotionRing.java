package fr.samlegamer.potionring;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import fr.samlegamer.potionring.item.PRItemsRegistry;

@Mod(value = PotionRing.MODID)
public class PotionRing
{
	public static final String MODID = "potionring";
	public static final Logger log = LogManager.getLogger();
	
	public static final MobEffect growing = BuiltInRegistries.MOB_EFFECT.get(new ResourceLocation("sizeshiftingpotions", "growing"));
	public static final MobEffect shrinking = BuiltInRegistries.MOB_EFFECT.get(new ResourceLocation("sizeshiftingpotions", "shrinking"));
	public static final MobEffect widening = BuiltInRegistries.MOB_EFFECT.get(new ResourceLocation("sizeshiftingpotions", "widening"));
	public static final MobEffect thinning = BuiltInRegistries.MOB_EFFECT.get(new ResourceLocation("sizeshiftingpotions", "thinning"));
	
	public PotionRing(IEventBus modEventBus)
	{
		modEventBus.addListener(this::addToTab);
		PRItemsRegistry.addons();
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
	    	if(ModList.get().isLoaded("sizeshiftingpotions"))
			{
		    	event.accept(PRItemsRegistry.ring_of_growing);
		    	event.accept(PRItemsRegistry.ring_of_shrinking);
		    	event.accept(PRItemsRegistry.ring_of_widening);
		    	event.accept(PRItemsRegistry.ring_of_thinning);
			}
	    }
	}
}