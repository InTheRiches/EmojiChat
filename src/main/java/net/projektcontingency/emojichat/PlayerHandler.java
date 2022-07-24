package net.projektcontingency.emojichat;

import net.projektcontingency.titanium.Titanium;
import net.projektcontingency.titanium.database.Database;
import net.projektcontingency.titanium.internal.Pair;
import org.bson.Document;
import org.bukkit.entity.Player;

import javax.imageio.metadata.IIOMetadataNode;
import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.Map;

public class PlayerHandler {
    private Map<Player, Boolean> players;

    public PlayerHandler() {
        this.players = new HashMap<>();
    }

    public void loadPlayer(Player player) {
        players.put(player, (Boolean) Titanium.getInstance().getDatabase().getFirstDocumentValue(new Pair<>("id", player.getUniqueId()), "main", "emoji-chat"));
    }

    public void enable(Player player) {
        players.replace(player, true);
        Titanium.getInstance().getDatabase().setFirstDocumentValue(new Pair<>("id", player.getUniqueId()), "main", "emoji-chat", true);
    }

    public void disable(Player player) {
        players.replace(player, false);
        Titanium.getInstance().getDatabase().setFirstDocumentValue(new Pair<>("id", player.getUniqueId()), "main", "emoji-chat", false);
    }


    public boolean isEnabled(Player player) {
        return players.get(player);
    }
}
