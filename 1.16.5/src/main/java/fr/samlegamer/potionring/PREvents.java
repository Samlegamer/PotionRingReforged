package fr.samlegamer.potionring;

import fr.samlegamer.potionring.item.PRItemsRegistry;
import fr.samlegamer.potionring.item.PotionRingItem;
import fr.samlegamer.potionring.item.PotionRingItemModded;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.Effect;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryManager;
import top.theillusivec4.curios.api.event.SlotModifiersUpdatedEvent;
import java.util.List;

@Mod.EventBusSubscriber(modid = PotionRing.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PREvents
{
    @SubscribeEvent
    public static void registryModdedCustom(final RegistryEvent.Register<Item> event)
    {
//        final DeferredRegister<Item> IT = DeferredRegister.create(ForgeRegistries.ITEMS, PotionRing.MODID);

//        List<String> list = PRItemsRegistry.createNewFileOrLearn();
//
//        if(!list.isEmpty()) {
//            for (String s : list) {
//                String[] parts = s.split(":");
//                if (parts.length == 2) {
//                    final String mod = parts[0];
//                    final String id = parts[1];
//
//                    Item item = new PotionRingItemModded(mod, id);
//                    item.setRegistryName(new ResourceLocation(PotionRing.MODID, "ring_of_" + id));
//                    Effect effect = RegistryManager.ACTIVE.getRegistry(Registry.MOB_EFFECT_REGISTRY).getRaw(new ResourceLocation(mod, id));
//                    PotionRing.log.info("Get Effect from RegistryManager : " + effect);
//                    ForgeRegistries.ITEMS.register(item);
////							PotionRing.getEffectFromConfig(mod, id);
////					PotionRing.log.info("Registering effect " + effect);
////                    final RegistryObject<PotionRingItemModded> RING_BASE_POTION = IT.register
////                            ("ring_of_" + id, () -> new PotionRingItemModded(mod, id));
//
//                }
//            }
//        }

//        IT.register(bus);
    }


//    protected static PotionRingItemModded createBlockWoodOpti(String mod, String name, PotionRingItemModded item, ItemGroup tab)
//    {
//        item = new PotionRingItemModded(mod, name);
//        item.setRegistryName(name);
//        ForgeRegistries.ITEMS.register(item);
//        return item;
//    }


//    @SubscribeEvent
//    public static void setEffectOnLoad(FMLLoadCompleteEvent event)
//    {
//        List<String> list = PRItemsRegistry.createNewFileOrLearn();
//
//        if(!list.isEmpty()) {
//            for (String s : list) {
//                String[] parts = s.split(":");
//                if (parts.length == 2) {
//                    final String mod = parts[0];
//                    final String id = parts[1];
//                    if(ModList.get().isLoaded(mod))
//                    {
////                        Effect customEffect = ForgeRegistries.POTIONS.getValue(new ResourceLocation(mod, id));
////                        if(RegistryObject.of(new ResourceLocation(mod, id), ForgeRegistries.POTIONS).isPresent())
////                        {
////                            effect = RegistryObject.of(new ResourceLocation(mod, id), ForgeRegistries.POTIONS).get();
////                        }
////                        else
////                        {
////                            effect = null;
////                        }
////                        PotionRing.log.info("Registering effect via FMLLoadComplete " + customEffect);
//                        Item item = PotionRing.getItemFromConfig(mod, id);
//
////                        if(item instanceof PotionRingItemModded) {
////                            PotionRingItemModded potionRingItem = (PotionRingItemModded) item;
////                            potionRingItem.eff = customEffect;
////                        }
//                    }
//                }
//            }
//        }
//    }

}