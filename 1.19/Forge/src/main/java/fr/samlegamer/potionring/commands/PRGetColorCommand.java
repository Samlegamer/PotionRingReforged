package fr.samlegamer.potionring.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.MobEffectArgument;
import net.minecraft.network.chat.*;
import net.minecraft.world.effect.MobEffect;

public class PRGetColorCommand
{
    // net.minecraft.command.impl.EffectCommand
    private static final SimpleCommandExceptionType ERROR_GIVE_FAILED = new SimpleCommandExceptionType(Component.translatable("commands.effect.give.failed"));

    public PRGetColorCommand(CommandDispatcher<CommandSourceStack> dispatcher)
    {
        dispatcher.register(Commands.literal("potionring").then(Commands.literal("getColorEffect")
                .then(Commands.argument("effect", MobEffectArgument.effect())
                .executes((commandContext) ->
                        getColor(commandContext.getSource(), MobEffectArgument.getEffect(commandContext, "effect"))))));
    }

    private static int getColor(CommandSourceStack commandSource, MobEffect effect) throws CommandSyntaxException {

        if(effect != null) {
            int color = effect.getColor();
            String hexColor = "#" + String.format("%06X", color);

            Component copy = ComponentUtils.wrapInSquareBrackets((Component.literal(hexColor)).withStyle((p_211752_2_) -> p_211752_2_.withColor(ChatFormatting.GREEN).withClickEvent(new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, String.valueOf(color))).withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, Component.translatable("chat.copy.click"))).withInsertion(hexColor)));
            commandSource.sendSuccess(Component.translatable("Effect color: %s", copy), false);
            return color;
        }
        throw ERROR_GIVE_FAILED.create();
    }
}