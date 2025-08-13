package com.mike.testplugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.mike.testplugin.tools.MessageColors;

public class testplugin extends JavaPlugin {

    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(MessageColors.coloredMessage("&aTestPlugin has been enabled."));
    }
    
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(MessageColors.coloredMessage("&cTestPlugin has been disabled."));
    }
}
