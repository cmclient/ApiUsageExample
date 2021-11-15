package pl.cmclient.example;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import pl.cmclient.api.AuthApi;
import pl.cmclient.example.listener.PlayerJoinListener;

public class BukkitPlugin extends JavaPlugin {

    private AuthApi api;

    public AuthApi getApi() {
        return api;
    }

    @Override
    public void onEnable() {
        Plugin api = this.getServer().getPluginManager().getPlugin("CMClientApi");
        if (api == null) {
            this.getLogger().warning("The CMClientApi plugin is missing! Install the plugin on bungeecord and on the subservers where you want to use the api.");
            return;
        }
        this.api = (AuthApi) api;
        this.getServer().getPluginManager().registerEvents(new PlayerJoinListener(this), this);
    }
}
