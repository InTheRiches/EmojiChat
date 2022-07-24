package net.projektcontingency.emojichat.commands;

import net.projektcontingency.emojichat.EmojiChat;
import net.projektcontingency.emojichat.PlayerHandler;
import net.projektcontingency.emojichat.emoji.Emoji;
import net.projektcontingency.titanium.internal.Translations;
import net.projektcontingency.titanium.internal.Unicode;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class EmojiCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;

        if (args.length == 0) {
            StringBuilder msg = new StringBuilder();
            sender.sendMessage(Unicode.DIVIDER.getText());

            for (Emoji emoji : EmojiChat.getInstance().getEmojis())
                sender.sendMessage(ChatColor.WHITE + emoji.getUnicode() + ChatColor.YELLOW + ": " + emoji.getId());

            sender.sendMessage(Unicode.DIVIDER.getText());
            return true;
        }

        switch(args[0]) {
            case "enable" -> {
                if (EmojiChat.getInstance().getPlayerHandler().isEnabled((Player) sender)) {
                    sender.sendMessage(Unicode.DIVIDER.getText());
                    sender.sendMessage(Translations.EMOJIS_ALREADY_ENABLED.getText());
                    sender.sendMessage(Unicode.DIVIDER.getText());
                    return true;
                }

                EmojiChat.getInstance().getPlayerHandler().enable((Player) sender);

                if (args.length == 2 && Objects.equals(args[1], "silent"))
                    return true;

                sender.sendMessage(Unicode.DIVIDER.getText());
                sender.sendMessage(Translations.EMOJIS_ENABLED.getText());
                sender.sendMessage(Unicode.DIVIDER.getText());
            }
            case "disable" -> {
                if (!EmojiChat.getInstance().getPlayerHandler().isEnabled((Player) sender)) {
                    sender.sendMessage(Unicode.DIVIDER.getText());
                    sender.sendMessage(Translations.EMOJIS_ALREADY_DISABLED.getText());
                    sender.sendMessage(Unicode.DIVIDER.getText());
                    return true;
                }

                EmojiChat.getInstance().getPlayerHandler().disable((Player) sender);

                if (args.length == 2 && Objects.equals(args[1], "silent"))
                    return true;

                sender.sendMessage(Unicode.DIVIDER.getText());
                sender.sendMessage(Translations.EMOJIS_DISABLED.getText());
                sender.sendMessage(Unicode.DIVIDER.getText());
            }
        }
        return true;
    }
}
