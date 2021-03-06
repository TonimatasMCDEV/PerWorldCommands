package net.tonimatasmc.perworldcommands.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UpdateChecker {
    public static String latestversion;

    public static void check() {
        try {
            HttpURLConnection con = (HttpURLConnection) (new URL("https://api.spigotmc.org/legacy/update.php?resource=97003")).openConnection();

            int timed_out = 1250;

            con.setConnectTimeout(timed_out);
            con.setReadTimeout(timed_out);

            latestversion = (new BufferedReader(new InputStreamReader(con.getInputStream()))).readLine();

            if (latestversion.length() <= 7 && !PluginDescription.version.equals(latestversion)) {
                Bukkit.getConsoleSender().sendMessage(PluginDescription.prefix + ChatColor.RED + " There is a new version available. " + ChatColor.YELLOW + "(" + ChatColor.GRAY + latestversion + ChatColor.YELLOW + ")");
                Bukkit.getConsoleSender().sendMessage(PluginDescription.prefix + ChatColor.RED + " You can download it at: " + ChatColor.WHITE + "https://www.spigotmc.org/resources/perworldcommands.97003/");
            }
        } catch (Exception var3) {
            Bukkit.getConsoleSender().sendMessage(PluginDescription.prefix + ChatColor.RED + " Error while checking update.");
        }
    }
}
