package net.craftmountain.premiumslots.commands;

import org.bukkit.command.CommandSender;

public interface PluginCommand {

    void onCommand(CommandSender sender, String[] args);
    String getCommand();

}
