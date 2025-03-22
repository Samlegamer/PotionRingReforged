package fr.samlegamer.potionring.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import net.minecraft.command.argument.StatusEffectArgumentType;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.*;
import net.minecraft.util.Formatting;

public class PRGetColorCommand
{
    // net.minecraft.command.impl.EffectCommand
    // also net.minecraft.server.command.SeedCommand
    private static final SimpleCommandExceptionType ERROR_GIVE_FAILED = new SimpleCommandExceptionType(new TranslatableText("commands.effect.give.failed"));

    public PRGetColorCommand(CommandDispatcher<ServerCommandSource> dispatcher)
    {
        dispatcher.register(CommandManager.literal("potionring").then(CommandManager.literal("getColorEffect")
                .then(CommandManager.argument("effect", StatusEffectArgumentType.statusEffect())
                .executes((commandContext) ->
                        getColor(commandContext.getSource(), StatusEffectArgumentType.getStatusEffect(commandContext, "effect"))))));
    }

    private static int getColor(ServerCommandSource commandSource, StatusEffect effect) throws CommandSyntaxException {

        if(effect != null) {
            int color = effect.getColor();
            String hexColor = "#" + String.format("%06X", color);

            Text copy = Texts.bracketed((new LiteralText(hexColor)).styled((p_211752_2_) -> p_211752_2_.withColor(Formatting.GREEN).withClickEvent(new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, String.valueOf(color))).withHoverEvent(new HoverEvent(net.minecraft.text.HoverEvent.Action.SHOW_TEXT, new TranslatableText("chat.copy.click"))).withInsertion(hexColor)));
            commandSource.sendFeedback(new TranslatableText("Effect color: %s", copy), false);
            return color;
        }
        throw ERROR_GIVE_FAILED.create();
    }
}