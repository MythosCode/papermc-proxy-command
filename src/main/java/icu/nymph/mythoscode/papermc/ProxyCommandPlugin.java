package icu.nymph.mythoscode.papermc;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class ProxyCommandPlugin extends JavaPlugin implements Listener {
    private static final String PLUGIN_ENABLED = "Plugin ProxyCommand is enabled";
    private static final String PLUGIN_DISABLED = "Plugin ProxyCommand is disabled";

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        // Register our command "ProxyCommand" (set an instance of your command class as executor)
        this.getCommand(ProxyCommand.class.getSimpleName()).setExecutor(new ProxyCommand());
        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage(Component.text(PLUGIN_ENABLED));
    }
}