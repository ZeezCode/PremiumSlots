package net.craftmountain.premiumslots.commands;

import net.craftmountain.premiumslots.PremiumSlots;
import net.craftmountain.premiumslots.utilities.Utilities;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class CommandReload implements PluginCommand {

    private String command;

    public CommandReload(String command) {
        this.command = command;
    }

    @Override
    public void onCommand(CommandSender sender, String[] args) {
        if (!Utilities.hasPermission(sender, "ps.admin")) { //Should already have been checked by this point, but just in case
            sender.sendMessage(ChatColor.RED + "Sorry, you don't have access to this command!");
            return;
        }

        PremiumSlots.getInstance().reloadConfig();
        sender.sendMessage(ChatColor.GREEN + "You have successfully reloaded the config!");
    }

    public String getCommand() {
        return command;
    }

}
