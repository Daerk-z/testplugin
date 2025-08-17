package tp.mike.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import tp.mike.tools.MessageColors;

public class PlayerListener implements Listener{
    // censor words
    @EventHandler
    public void OnChat(AsyncPlayerChatEvent event){
        
        Player player = event.getPlayer();
        String message = event.getMessage();

        if(message.toLowerCase().contains("blyat")){

            event.setCancelled(true);

            player.sendMessage(MessageColors.coloredMessage( "&cWhat a blyat"));
        }
    }

    @EventHandler
    public void OnJoin(PlayerJoinEvent event){
        // World spawn
        Player player = event.getPlayer();

        player.sendMessage(MessageColors.coloredMessage( "&cWelcome to the server"));
        Location location = new Location(Bukkit.getWorld("World"), 2.5, 78, 79.5, 90, 0);
        player.teleport(location);
    }

    @EventHandler
    public void OnBlockBreak(BlockBreakEvent event){
        Player player = event.getPlayer();

        if(player.getWorld().getName().equals("World") && !player.hasPermission("testplugin.admin")){
            event.setCancelled(true);
            player.sendMessage(MessageColors.coloredMessage( "&cYou cant break anything bro"));
        }
    }
}
