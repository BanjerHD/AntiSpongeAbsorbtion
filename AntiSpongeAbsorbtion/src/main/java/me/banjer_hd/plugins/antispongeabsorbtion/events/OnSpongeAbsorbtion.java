package me.banjer_hd.plugins.antispongeabsorbtion.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SpongeAbsorbEvent;

import me.banjer_hd.plugins.antispongeabsorbtion.Main;

public class OnSpongeAbsorbtion implements Listener {

	private Main plugin;
	public OnSpongeAbsorbtion(Main pl) {
		plugin = pl;
	}

	@EventHandler
	public void onEvent(SpongeAbsorbEvent e) {
		if(plugin.getConfig().getList("enabled_worlds").contains("all") || plugin.getConfig().getList("enabled_worlds").contains(e.getBlock().getWorld().getName())) {
			e.setCancelled(true);
		}
	}

}