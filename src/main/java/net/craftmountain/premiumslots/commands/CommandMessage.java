package net.craftmountain.premiumslots.commands;

import net.craftmountain.premiumslots.PremiumSlots;
import net.craftmountain.premiumslots.utilities.Utilities;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class CommandMessage implements PluginCommand {

    private String command;

    public CommandMessage(String command) {
        this.command = command;
    }

    @Override
    public void onCommand(CommandSender sender, String[] args) {
        if (!Utilities.hasPermission(sender, "ps.admin")) { //Should already have been checked by this point, but just in case
            sender.sendMessage(ChatColor.RED + "Sorry, you don't have access to this command!");
            return;
        }

        if (args.length < 2) {
            sender.sendMessage(ChatColor.RED + "Incorrect command usage! Use /ps msg <message>");
        } else {
            StringBuilder msg = new StringBuilder();
            for (int i=1; i<args.length; i++) {
                msg.append(args[i]).append(" ");
            }
            msg = new StringBuilder(msg.substring(0, msg.length() - 1));

            PremiumSlots plugin = PremiumSlots.getInstance();
            plugin.getConfig().set("denied_access_message", msg.toString());
            plugin.saveConfig();

            sender.sendMessage(ChatColor.GREEN + "You have successfully updated the kick message!");
        }
    }

    @Override
    public String getCommand() {
        return command;
    }

}
