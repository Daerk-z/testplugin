package tp.mike.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import tp.mike.TestPlugin;
import tp.mike.tools.MessageColors;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

// This class is intended to handle main commands for the TestPlugin.
public class MainCommand implements CommandExecutor {

    private TestPlugin plugin;

    public MainCommand(TestPlugin plugin) {

        // Constructor can be used for initialization if needed
        this.plugin = plugin;

    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {

        // Handle the command logic here
        if(!(sender instanceof Player)) {
            //console
            sender.sendMessage(MessageColors.coloredMessage(
                 "&cThis command can only be run by a player!"));
            return true;
        }

        //player
        Player player = (Player) sender;

        // Check if the command has arguments
        if (args.length >= 1) {
            if(args[0].equalsIgnoreCase("welcome")){
                sender.sendMessage(MessageColors.coloredMessage("&7- Welcome" + player.getName()));
            }
            else if(args[0].equalsIgnoreCase("date")){
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String date = dateFormat.format(new Date());
                sender.sendMessage(MessageColors.coloredMessage("&7- Date:" + date));
            }
            else if(args[0].equalsIgnoreCase("get")){

            }
            else{
                help(sender);
            }
        }
        else{
            help(sender);
        }

            sender.sendMessage(MessageColors.coloredMessage(
                 "&cYou just used the main command of TestPlugin!"));

        return true; 
    }
    // Help messages
    public void help(CommandSender sender){
        sender.sendMessage(MessageColors.coloredMessage( "&f&lTestPlugin Commands: "));
        sender.sendMessage(MessageColors.coloredMessage( "&7- /TestPlugin welcome"));
        sender.sendMessage(MessageColors.coloredMessage( "&7- /TestPlugin date"));
        sender.sendMessage(MessageColors.coloredMessage( "&7- /TestPlugin get <author/version>"));
    }
    // Sub command for get
    public void subCommandGet(CommandSender sender, String[] args){

        if (!sender.hasPermission("testplugin.get")){
            sender.sendMessage(MessageColors.coloredMessage("You do not have permission to use this command"));
            return;
        }

        if(args.length == 1) {

            sender.sendMessage(MessageColors.coloredMessage("You have to use /TestPlugin get <author/version>"));
            return;
        }

        if(args[1].equalsIgnoreCase("author")) {
                sender.sendMessage(MessageColors.coloredMessage(
                    "The author of this plugin is:" + plugin.getDescription().getAuthors()));
        }
        else if(args[1].equalsIgnoreCase("version")){
            sender.sendMessage(MessageColors.coloredMessage(
                    "The version of this plugin is:" + plugin.getDescription().getVersion()));
        }
        else{
                sender.sendMessage(MessageColors.coloredMessage("You have to use /TestPlugin get <author/version>"));
        }
    }
}
