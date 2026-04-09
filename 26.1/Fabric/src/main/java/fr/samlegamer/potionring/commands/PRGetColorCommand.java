package fr.samlegamer.potionring.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.ResourceArgument;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.HoverEvent;
import net.minecraft.world.effect.MobEffect;

public class PRGetColorCommand
{
    // net.minecraft.command.impl.EffectCommand
    // also net.minecraft.server.command.SeedCommand
    private static final SimpleCommandExceptionType ERROR_GIVE_FAILED = new SimpleCommandExceptionType(Component.translatable("commands.effect.give.failed"));

    public PRGetColorCommand(CommandDispatcher<CommandSourceStack> dispatcher, CommandBuildContext registryAccess)
    {
        dispatcher.register(Commands.literal("potionring").then(Commands.literal("getColorEffect")
                .then(Commands.argument("effect", ResourceArgument.resource(registryAccess, Registries.MOB_EFFECT))
                .executes((commandContext) ->
                        getColor(commandContext.getSource(), ResourceArgument.getMobEffect(commandContext, "effect"))))));
    }

    private static int getColor(CommandSourceStack commandSource, Holder.Reference<MobEffect> effect) throws CommandSyntaxException {

        if(effect != null) {
            int color = effect.value().getColor();
            String hexColor = "#" + String.format("%06X", color);

            Component styledHex = Component.literal(hexColor).withStyle((style) ->
                    style.withColor(ChatFormatting.GREEN)
                         .withClickEvent(new ClickEvent.CopyToClipboard(String.valueOf(color)))
                         .withHoverEvent(new HoverEvent.ShowText(Component.translatable("chat.copy.click")))
                         .withInsertion(hexColor));

            commandSource.sendSuccess(() -> Component.literal("Effect color: ").append(styledHex), false);
            return color;
        }
        throw ERROR_GIVE_FAILED.create();
    }
}