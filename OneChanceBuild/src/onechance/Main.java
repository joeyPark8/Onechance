package onechance;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
    boolean start = false;

    @Override
    public void onEnable() {
        System.out.println("One Chance is activated");
    }

    @Override
    public void onDisable() {
        System.out.println("One Chance is deactivated");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("/oc")) {
            if (args.length == 0) {
                System.out.println("One Chance plugin by Semin. :D");
            }
            else if (args[0].equalsIgnoreCase("start")) {
                if (start == false) {
                    start = true;
                    sender.sendMessage(ChatColor.LIGHT_PURPLE + "oc is started");
                }
                else {
                    sender.sendMessage(ChatColor.RED + "oc is already started");
                }
            }
            else if (args[0].equalsIgnoreCase("end")) {
                if (start == true) {
                    start = false;
                    sender.sendMessage(ChatColor.LIGHT_PURPLE + "oc is ended");
                }
                else {
                    sender.sendMessage(ChatColor.RED + "oc isn't started");
                }
            }
        }
        return true;
    }

    public void onBreak(BlockBreakEvent e) {
        if (start == true) {
            e.setCancelled(true);
        }
    }

}
