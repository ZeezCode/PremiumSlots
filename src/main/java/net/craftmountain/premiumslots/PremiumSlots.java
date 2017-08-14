package net.craftmountain.premiumslots;

import net.craftmountain.premiumslots.commands.*;
import net.craftmountain.premiumslots.listeners.ConnectionListener;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class PremiumSlots extends JavaPlugin {

    private ArrayList<PluginCommand> executors;
    private Permission permission = null;
    private static PremiumSlots plugin;

    @Override
    public void onEnable() {
        plugin = this;
        setupPermissions();
        saveDefaultConfig();
        getCommand("premiumslots").setExecutor(new CommandPremiumSlots());
        getServer().getPluginManager().registerEvents(new ConnectionListener(), this);

        executors = new ArrayList<>();
        executors.add(new CommandSlots("slots"));
        executors.add(new CommandMessage("msg"));
        executors.add(new CommandToggle("toggle"));
        executors.add(new CommandReload("reload"));
        executors.add(new CommandVersion("version"));

        PluginDescriptionFile pdfFile = getDescription();
        getLogger().info(pdfFile.getName() + " has been enabled running version " + pdfFile.getVersion() + ".");
    }

    @Override
    public void onDisable() {
        PluginDescriptionFile pdfFile = getDescription();
        getLogger().info(pdfFile.getName() + " has been disabled.");
    }

    public PluginCommand getExecutor(String name) {
        return executors.stream().filter(cmd -> cmd.getCommand().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    public Permission getPermission() {
        return permission;
    }

    public static PremiumSlots getInstance() {
        return plugin;
    }

    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> permissionProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);
        if (permissionProvider != null) {
            permission = permissionProvider.getProvider();
        }
        return (permission != null);
    }

}
