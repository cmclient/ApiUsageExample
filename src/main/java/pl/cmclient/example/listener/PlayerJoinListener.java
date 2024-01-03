package pl.cmclient.example.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import pl.cmclient.example.BukkitPlugin;
import pl.cmclient.example.helper.ChatHelper;

public class PlayerJoinListener implements Listener {

    private final BukkitPlugin plugin;

    public PlayerJoinListener(BukkitPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        this.plugin.getServer().getScheduler().runTaskLaterAsynchronously(this.plugin, () -> {
            if (this.plugin.getApi().getVerified().contains(event.getPlayer().getName())) {
                event.getPlayer().sendTitle(ChatHelper.color("&a✓ &eCMClient"),
                        ChatHelper.color("&a✓ &7Thank you for using the &eCMClient&7!"));
            }
        }, 25L);
    }
}
