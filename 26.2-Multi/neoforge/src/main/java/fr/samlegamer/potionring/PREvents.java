package fr.samlegamer.potionring;

import fr.samlegamer.potionring.commands.PRGetColorCommand;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.server.command.ConfigCommand;

@EventBusSubscriber(modid = PotionRing.MODID)
public class PREvents
{
    @SubscribeEvent
    public static void setCommands(RegisterCommandsEvent event)
    {
        new PRGetColorCommand(event.getDispatcher(), event.getBuildContext());

        ConfigCommand.register(event.getDispatcher());
    }
}