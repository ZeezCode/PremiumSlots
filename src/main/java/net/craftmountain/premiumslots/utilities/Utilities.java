package net.craftmountain.premiumslots.utilities;

import net.craftmountain.premiumslots.PremiumSlots;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Utilities {

    /**
     * <p>Returns whether or not given CommandSender has a specific permission</p>
     *
     * @param sender CommandSender to be verified
     * @param permission Permission to compare against sender
     * @return boolean Whether or not given CommandSender has specific permission
     */
    public static boolean hasPermission(CommandSender sender, String permission) {
        return ((!(sender instanceof Player)) || PremiumSlots.getInstance().getPermission().has((Player) sender, permission));
    }

    /**
     * <p>Returns whether or not given String is a valid integer</p>
     *
     * @param toParse String to be parsed
     * @return boolean Whether or not given String is a valid integer
     */
    public static boolean isValidInt(String toParse) {
        try {
            Integer.parseInt(toParse);
        } catch(Exception e) {
            return false;
        }
        return true;
    }

}
