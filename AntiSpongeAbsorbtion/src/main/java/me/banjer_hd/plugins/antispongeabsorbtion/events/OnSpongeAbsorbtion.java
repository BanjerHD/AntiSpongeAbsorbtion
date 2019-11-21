package me.banjer_hd.plugins.antispongeabsorbtion.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SpongeAbsorbEvent;

public class OnSpongeAbsorbtion implements Listener {
	
	@EventHandler
	public void onEvent(SpongeAbsorbEvent e) {
		e.setCancelled(true);
	}
	
}