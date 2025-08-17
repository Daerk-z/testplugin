package tp.mike.tools;

import org.bukkit.ChatColor;

public class MessageColors {


    // color for messages in console
        
    public static  String coloredMessage(String message){
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}