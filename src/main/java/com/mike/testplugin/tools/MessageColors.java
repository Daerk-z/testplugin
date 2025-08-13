package com.mike.testplugin.tools;

import org.bukkit.ChatColor;

public class MessageColors {

    public static  String coloredMessage(String message){
        return ChatColor.translateAlternateColorCodes('&',message);
    }
}