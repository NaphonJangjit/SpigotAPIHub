package net.heeheehub.apihub.APIHub.utils;

import org.bukkit.ChatColor;

public class ColorFormat {

    public static String format(String str){
        return ChatColor.translateAlternateColorCodes('&', str);
    }

}
