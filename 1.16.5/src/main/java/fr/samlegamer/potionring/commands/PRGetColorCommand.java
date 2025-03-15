package fr.samlegamer.potionring.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.PotionArgument;
import net.minecraft.potion.Effect;
import net.minecraft.util.text.*;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;

public class PRGetColorCommand
{
    // net.minecraft.command.impl.EffectCommand
    private static final SimpleCommandExceptionType ERROR_GIVE_FAILED = new SimpleCommandExceptionType(new TranslationTextComponent("commands.effect.give.failed"));

    public PRGetColorCommand(CommandDispatcher<CommandSource> dispatcher)
    {
        dispatcher.register(Commands.literal("potionring").then(Commands.literal("getColorEffect")
                .then(Commands.argument("effect", PotionArgument.effect())
                .executes((commandContext) ->
                        getColor(commandContext.getSource(), PotionArgument.getEffect(commandContext, "effect"))))));
    }


    private static int getColor(CommandSource commandSource, Effect effect) throws CommandSyntaxException {

        if(effect != null) {
            int color = effect.getColor();
            String hexColor = "#" + String.format("%06X", color);

            ITextComponent copy = TextComponentUtils.wrapInSquareBrackets((new StringTextComponent(hexColor)).withStyle((p_211752_2_) -> p_211752_2_.withColor(TextFormatting.GREEN).withClickEvent(new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, String.valueOf(color))).withHoverEvent(new HoverEvent(net.minecraft.util.text.event.HoverEvent.Action.SHOW_TEXT, new TranslationTextComponent("chat.copy.click"))).withInsertion(hexColor)));
            commandSource.sendSuccess(new TranslationTextComponent("Effect color: %s", copy), false);
            return color;
        }
        throw ERROR_GIVE_FAILED.create();
    }
}