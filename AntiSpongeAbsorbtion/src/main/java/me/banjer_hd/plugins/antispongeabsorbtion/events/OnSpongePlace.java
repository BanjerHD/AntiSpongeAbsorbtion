package me.banjer_hd.plugins.antispongeabsorbtion.events;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import me.banjer_hd.plugins.antispongeabsorbtion.Main;

public class OnSpongePlace implements Listener
{

	private Main plugin;
	public OnSpongePlace(Main pl) {
		plugin = pl;
	}


	@EventHandler
	public void onPlace(final BlockPlaceEvent e) {
		if(plugin.getConfig().getList("enabled_worlds").contains("all") || plugin.getConfig().getList("enabled_worlds").contains(e.getBlock().getWorld().getName())) {
			if (e.getBlock().getType() == Material.SPONGE) {
				final List<Block> blockList = surveyArea(e.getBlock().getLocation());
				e.getBlock().getLocation().getBlock().setType(Material.SPONGE);
				Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
					@Override
					public void run()  {
						for(Block b : blockList) {
							e.getBlock().getWorld().getBlockAt(b.getLocation()).setType(Material.WATER);
						}
					}
				}, 5);
				Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()  {
					@Override
					public void run()  {
						e.getBlock().getLocation().getBlock().setType(Material.SPONGE);
					}
				}, 6);
			}
		}
	}

	private List<Block> surveyArea(Location center) { 
		List<Block> blockList = new ArrayList<Block>();
		for (int x = center.getBlockX()-7; x <= center.getBlockX()+7; x++) {
			for (int y = center.getBlockY()-7; y <= center.getBlockY()+7; y++) {
				for (int z = center.getBlockZ()-7; z <= center.getBlockZ()+7; z++) {
					if (center.getWorld().getBlockAt(new Location(center.getWorld(),x,y,z)).getType().equals(Material.WATER)) {
						blockList.add(center.getWorld().getBlockAt(new Location(center.getWorld(),x,y,z)));
					}
				}	
			}	
		}
		return blockList;
	}

}