package net.craftmountain.premiumslots.listeners;

import net.craftmountain.premiumslots.PremiumSlots;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class ConnectionListener implements Listener {

    /**
     * <p>Called when a player successfully logs into the server</p>
     *
     * @param e PlayerLoginEvent
     */
    @EventHandler
    public void onPlayerJoin(PlayerLoginEvent e) {
        PremiumSlots plugin = PremiumSlots.getInstance();
        int prem_slots = plugin.getConfig().getInt("premium_slots");

        if (plugin.getServer().getOnlinePlayers().size() >= plugin.getServer().getMaxPlayers() - prem_slots) { //if current player count is or is higher than amount needed to toggle premium slot mode
            if (!PremiumSlots.getInstance().getPermission().has(e.getPlayer(), "ps.bypass")) //if player doesn't have bypass permission
                e.disallow(PlayerLoginEvent.Result.KICK_OTHER, plugin.getConfig().getString("denied_access_message").replaceAll("%NEWLINE%", "\n").replaceAll("%NAME%", e.getPlayer().getName()));
        }
    }

}
