package me.banjer_hd.plugins.antispongeabsorbtion;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.banjer_hd.plugins.antispongeabsorbtion.events.OnSpongeAbsorbtion;

public class Main extends JavaPlugin {
	
	private static Main instance;
	
	@Override
	public void onEnable() {
		instance = this;
		
		getConfig().options().copyDefaults(true);
		saveConfig();
		
		Bukkit.getPluginManager().registerEvents(new OnSpongeAbsorbtion(), this);
	}
	
	@Override
	public void onDisable() {
		instance = null;
	}
	
	
	
	public static Main getInstance() {
		return instance;
	}
	
}
