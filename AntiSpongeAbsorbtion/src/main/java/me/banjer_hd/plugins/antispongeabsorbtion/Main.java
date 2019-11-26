package me.banjer_hd.plugins.antispongeabsorbtion;

import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.banjer_hd.plugins.antispongeabsorbtion.events.OnSpongeAbsorbtion;

public class Main extends JavaPlugin {
		
	@Override
	public void onEnable() {
		getConfig().options().copyDefaults(true);
		saveConfig();
		
		int version = Integer.parseInt(Bukkit.getBukkitVersion().replaceAll("^\\d+[.]", "").replaceAll("-R.+", ""));
		if(version >= 13) {
			Bukkit.getPluginManager().registerEvents(new OnSpongeAbsorbtion(this), this);
		}else {
			Bukkit.getLogger().log(Level.SEVERE, "This plugin only works in 1.13 or above!");
		}
			
	}
	
	
}
