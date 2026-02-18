package fr.samlegamer.potionring.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.command.argument.RegistryEntryReferenceArgumentType;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.*;
import net.minecraft.util.Formatting;

public class PRGetColorCommand
{
    // net.minecraft.command.impl.EffectCommand
    // also net.minecraft.server.command.SeedCommand
    private static final SimpleCommandExceptionType ERROR_GIVE_FAILED = new SimpleCommandExceptionType(Text.translatable("commands.effect.give.failed"));

    public PRGetColorCommand(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess registryAccess)
    {
        dispatcher.register(CommandManager.literal("potionring").then(CommandManager.literal("getColorEffect")
                .then(CommandManager.argument("effect", RegistryEntryReferenceArgumentType.registryEntry(registryAccess, RegistryKeys.STATUS_EFFECT))
                .executes((commandContext) ->
                        getColor(commandContext.getSource(), RegistryEntryReferenceArgumentType.getStatusEffect(commandContext, "effect"))))));
    }

    private static int getColor(ServerCommandSource commandSource, RegistryEntry.Reference<StatusEffect> effect) throws CommandSyntaxException {

        if(effect != null) {
            int color = effect.value().getColor();
            String hexColor = "#" + String.format("%06X", color);

            Text copy = Texts.bracketed(Text.literal(hexColor).styled((p_392614_) -> p_392614_.withColor(Formatting.GREEN).withClickEvent(new ClickEvent.CopyToClipboard(String.valueOf(color))).withHoverEvent(new HoverEvent.ShowText(Text.translatable("chat.copy.click"))).withInsertion(hexColor)));

            commandSource.sendFeedback(() -> Text.translatable("Effect color: %s", copy), false);
            return color;
        }
        throw ERROR_GIVE_FAILED.create();
    }
}