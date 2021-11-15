package pl.cmclient.example.helper;

import net.md_5.bungee.api.ChatColor;

public final class ChatHelper {

    public static String color(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }
}
