package tp.mike;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import tp.mike.tools.MessageColors;

public class TestPlugin extends JavaPlugin {

    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(MessageColors.coloredMessage("&aTestPlugin has been enabled."));
    }
    
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(MessageColors.coloredMessage("&cTestPlugin has been disabled."));
    }
}
