package fr.samlegamer.potionring;

import fr.samlegamer.potionring.commands.PRGetColorCommand;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;

@Mod.EventBusSubscriber(modid = PotionRing.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PREvents
{
    @SubscribeEvent
    public static void setCommands(RegisterCommandsEvent event)
    {
        new PRGetColorCommand(event.getDispatcher());

        ConfigCommand.register(event.getDispatcher());
    }
}