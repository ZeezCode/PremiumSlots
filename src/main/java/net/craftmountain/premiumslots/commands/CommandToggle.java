package net.craftmountain.premiumslots.commands;

import net.craftmountain.premiumslots.PremiumSlots;
import net.craftmountain.premiumslots.utilities.Utilities;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class CommandToggle implements PluginCommand {

    private String command;

    public CommandToggle(String command) {
        this.command = command;
    }

    public void onCommand(CommandSender sender, String[] args) {
        if (!Utilities.hasPermission(sender, "ps.admin")) { //Should already have been checked by this point, but just in case
            sender.sendMessage(ChatColor.RED + "Sorry, you don't have access to this command!");
            return;
        }

        PremiumSlots plugin = PremiumSlots.getInstance();
        boolean enabled = !plugin.getConfig().getBoolean("enabled");
        plugin.getConfig().set("enabled", enabled);
        plugin.saveConfig();

        sender.sendMessage(ChatColor.GREEN + "You have " + (enabled ? "enabled" : "disabled") + " the enforcement of Premium Slots!");
    }

    public String getCommand() {
        return command;
    }

}
