package net.craftmountain.premiumslots;

import net.craftmountain.premiumslots.listeners.ConnectionListener;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class PremiumSlots extends JavaPlugin {

    public Permission permission = null;
    private static PremiumSlots plugin;

    @Override
    public void onEnable() {
        plugin = this;
        setupPermissions();
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new ConnectionListener(), this);

        PluginDescriptionFile pdfFile = getDescription();
        getLogger().info(pdfFile.getName() + " has been enabled running version " + pdfFile.getVersion() + ".");
    }

    @Override
    public void onDisable() {
        PluginDescriptionFile pdfFile = getDescription();
        getLogger().info(pdfFile.getName() + " has been disabled.");
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
