package net.craftmountain.premiumslots.commands;

import net.craftmountain.premiumslots.PremiumSlots;
import net.craftmountain.premiumslots.utilities.Utilities;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginDescriptionFile;

public class CommandVersion implements PluginCommand {

    private String command;

    public CommandVersion(String command) {
        this.command = command;
    }

    @Override
    public void onCommand(CommandSender sender, String[] args) {
        if (!Utilities.hasPermission(sender, "ps.admin")) { //Should already have been checked by this point, but just in case
            sender.sendMessage(ChatColor.RED + "Sorry, you don't have access to this command!");
            return;
        }

        PluginDescriptionFile pdfFile = PremiumSlots.getInstance().getDescription();
        sender.sendMessage(ChatColor.GREEN + pdfFile.getName() + " is running version " + pdfFile.getVersion() + ".");
    }

    @Override
    public String getCommand() {
        return command;
    }

}
