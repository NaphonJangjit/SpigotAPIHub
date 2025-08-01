package net.heeheehub.apihub.APIHub;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import net.heeheehub.apihub.APIHub.development.APIHub;
import net.heeheehub.apihub.APIHub.utils.ColorFormat;

public class APIHubManager extends JavaPlugin {
    
	private static final String PLUGIN_PREFIX = ColorFormat.format("&7[&aAPIHub&7] &r");

    @Override
    public void onEnable() {
        APIHub.registerHandler("APIHub", new HealthCheck());
        Bukkit.getConsoleSender().sendMessage(ColorFormat.format(PLUGIN_PREFIX + "&aAPIHub Enabled"));
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ColorFormat.format(PLUGIN_PREFIX + "&cAPIHub Disabled"));
    }
	
}
