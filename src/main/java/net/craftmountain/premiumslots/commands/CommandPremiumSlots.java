package net.craftmountain.premiumslots.commands;

import net.craftmountain.premiumslots.PremiumSlots;
import net.craftmountain.premiumslots.utilities.Utilities;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandPremiumSlots implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!Utilities.hasPermission(sender, "ps.admin")) {
            sender.sendMessage(ChatColor.RED + "Sorry, you don't have access to this command!");
        }

        if (args.length == 0) {
            String msg = ChatColor.GREEN + "-=PremiumSlots+ Commands=-\n"
                    + "/ps toggle " + ChatColor.WHITE + "Toggles the plugin\n"
                    + ChatColor.GREEN + "/ps reload " + ChatColor.WHITE + "Reloads the plugin config\n"
                    + ChatColor.GREEN + "/ps version " + ChatColor.WHITE + "Shows the plugin version\n"
                    + ChatColor.GREEN + "/ps slots " + ChatColor.WHITE + "Sets how many premium slots there are\n"
                    + ChatColor.GREEN + "/ps msg " + ChatColor.WHITE + "Sets the kick message for players w/o permission.";
            sender.sendMessage(msg);
        } else {
            PluginCommand executor = PremiumSlots.getInstance().getExecutor(args[0]);

            if (executor == null)
                sender.sendMessage(ChatColor.RED + "Unrecognized command! Type /ps for help.");
            else
                executor.onCommand(sender, args);
        }

        return true;
    }

}
