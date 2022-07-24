package net.projektcontingency.emojichat;

import net.md_5.bungee.api.chat.BaseComponent;
import net.projektcontingency.emojichat.emoji.Emoji;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.*;

import net.md_5.bungee.api.chat.TextComponent;

public class PlayerEvents implements Listener {
    private Map<String, String> processedMsgs;

    public PlayerEvents() {
        this.processedMsgs = new HashMap<>();
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        EmojiChat.getInstance().getPlayerHandler().loadPlayer(e.getPlayer());
    }

    public String processString(String msg, Player receiver) {
        if (!EmojiChat.getInstance().getPlayerHandler().isEnabled(receiver))
            return msg;

        if (this.processedMsgs.containsKey(msg))
            return this.processedMsgs.get(msg);


        String oldMsg = msg;
        for (Emoji emoji : EmojiChat.getInstance().getEmojis()) {
            msg = msg.replaceAll(emoji.getId(), emoji.getUnicode());
            if (emoji.getTextReplacement() == null) continue;

            while (msg.contains(emoji.getTextReplacement())) {
                int index = msg.indexOf(emoji.getTextReplacement());
                if (index - 1 > 0 && msg.charAt(index - 1) == '\\') {
                    msg = msg.substring(0, index-1) + msg.substring(index);
                    continue;
                }

                msg = msg.replace(emoji.getTextReplacement(), emoji.getUnicode());
            }
        }
        this.processedMsgs.put(oldMsg, msg);

        return msg;
    }

    public TextComponent processString(TextComponent msg, Player receiver) {
        List<BaseComponent> text = msg.getExtra();
        TextComponent tc = (TextComponent) text.get(0);
        tc.setText(processString(tc.getText(), receiver));
        text.set(0, tc);
        msg.setExtra(text);
        return msg;
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onChatMessage(AsyncPlayerChatEvent e) {
        if (!EmojiChat.getInstance().getPlayerHandler().isEnabled(e.getPlayer())) return;

        String message = e.getMessage();

        for (Emoji emoji : EmojiChat.getInstance().getEmojis()) {
            message = message.replaceAll(emoji.getId(), emoji.getUnicode());
            if (emoji.getTextReplacement() == null) continue;

            while (message.contains(emoji.getTextReplacement())) {
                int index = message.indexOf(emoji.getTextReplacement());
                
                if (index - 1 > 0 && message.charAt(index - 1) == '\\') {
                    message = message.substring(0, index - 1) + message.substring(index);
                    continue;
                }
                message = message.replace(emoji.getTextReplacement(), emoji.getUnicode());
            }
        }

        e.setMessage(message);
    }
}
