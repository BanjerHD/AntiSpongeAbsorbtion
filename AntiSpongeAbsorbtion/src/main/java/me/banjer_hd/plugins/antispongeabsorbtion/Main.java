package me.banjer_hd.plugins.antispongeabsorbtion;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.banjer_hd.plugins.antispongeabsorbtion.events.OnSpongeAbsorbtion;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new OnSpongeAbsorbtion(), this);
	}
	
}
