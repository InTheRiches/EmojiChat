package net.projektcontingency.emojichat;

import net.projektcontingency.emojichat.commands.EmojiCommand;
import net.projektcontingency.emojichat.emoji.*;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class EmojiChat extends JavaPlugin {

    private static EmojiChat instance;

    private List<Emoji> emojis;

    private PlayerHandler playerHandler;
    private PlayerEvents playerEvents;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;

        this.loadEmojis();
        this.registerEvents();
        this.registerCommands();

        this.playerHandler = new PlayerHandler();
    }

    private void registerCommands() {
        this.getCommand("emojis").setExecutor(new EmojiCommand());
    }

    private void registerEvents() {
        this.playerEvents = new PlayerEvents();
        this.getServer().getPluginManager().registerEvents(this.playerEvents, this);
    }

    private void loadEmojis() {
        this.emojis = new ArrayList<>();

        this.emojis.add(new Smile());
        this.emojis.add(new SlightSmile());
        this.emojis.add(new Neutral());
        this.emojis.add(new Cold());
        this.emojis.add(new Cry());
        this.emojis.add(new Angel());
        this.emojis.add(new Angry());
        this.emojis.add(new Devil());
        this.emojis.add(new InLove());
        this.emojis.add(new Sad());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static EmojiChat getInstance() {
        return instance;
    }

    public PlayerHandler getPlayerHandler() {
        return playerHandler;
    }

    public List<Emoji> getEmojis() {
        return emojis;
    }

    public PlayerEvents getPlayerEvents() {
        return playerEvents;
    }
}
