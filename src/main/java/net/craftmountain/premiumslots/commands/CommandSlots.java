package net.craftmountain.premiumslots.commands;

import net.craftmountain.premiumslots.PremiumSlots;
import net.craftmountain.premiumslots.utilities.Utilities;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class CommandSlots implements PluginCommand {

    private String command;

    public CommandSlots(String command) {
        this.command = command;
    }

    @Override
    public void onCommand(CommandSender sender, String[] args) {
        if (!Utilities.hasPermission(sender, "ps.admin")) { //Should already have been checked by this point, but just in case
            sender.sendMessage(ChatColor.RED + "Sorry, you don't have access to this command!");
            return;
        }

        if (args.length < 2) {
            sender.sendMessage(ChatColor.RED + "Incorrect command usage! Use /ps slots <amount>");
        } else {
            if (Utilities.isValidInt(args[1])) {
                int newSlots = Integer.parseInt(args[1]);
                if (newSlots < 0) {
                    sender.sendMessage(ChatColor.RED + "Number must not be less than 0!");
                } else {
                    PremiumSlots plugin = PremiumSlots.getInstance();
                    plugin.getConfig().set("premium_slots", newSlots);
                    plugin.saveConfig();

                    sender.sendMessage(ChatColor.GREEN + "You have set the server to use " + newSlots + " premium slots!");
                }
            } else {
                sender.sendMessage(ChatColor.RED + "Invalid integer supplied!");
            }
        }
    }

    @Override
    public String getCommand() {
        return command;
    }

}
