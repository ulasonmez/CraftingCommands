package me.blume.craftingcommands.commands;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import me.blume.craftingcommands.Main;

public class HuntersDropHead implements Listener{

	@SuppressWarnings("unused")
	private Main plugin;
	public HuntersDropHead(Main plugin) {
		this.plugin=plugin;
	}
	@EventHandler
	public void onDeath(PlayerDeathEvent event) {
		Player player = event.getEntity();
		player.getWorld().dropItemNaturally(player.getLocation(), new ItemStack(Material.PLAYER_HEAD));
	}
}
