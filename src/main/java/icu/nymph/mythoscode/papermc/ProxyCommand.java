package icu.nymph.mythoscode.papermc;


import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import net.kyori.adventure.text.Component;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

import static org.bukkit.Bukkit.getLogger;
import static org.bukkit.Bukkit.getServer;

public class ProxyCommand implements CommandExecutor {
    // This method is called, when somebody uses our command
    @Override
    public boolean onCommand(@NotNull CommandSender sender, org.bukkit.command.@NotNull Command command, @NotNull String label, @NotNull String[] args) {
        String fullCommand  = label + " " + String.join(" ", args);

        if (sender instanceof Player player) {
            player.sendMessage(Component.text("你是玩家，执行命令: " + fullCommand));
            return true;
        }

        if (sender instanceof BlockCommandSender block) {
            Optional<Player> player = block.getBlock().getLocation().getNearbyPlayers(5).stream().findFirst();

            player.ifPresent(p -> {
                p.sendMessage(Component.text("你是最近的玩家，执行命令: " + fullCommand));

                ByteArrayDataOutput out = ByteStreams.newDataOutput();

                for (String arg : args) {
                    out.writeUTF(arg);
                }

                p.sendPluginMessage(JavaPlugin.getPlugin(ProxyCommandPlugin.class), "BungeeCord", out.toByteArray());
            });

            return player.isPresent();
        }
        getServer().getOnlinePlayers().forEach(player -> player.sendMessage("非玩家，无法执行命令: " + fullCommand));
        // If the player (or console) uses our command correct, we can return true
        return false;
    }
}