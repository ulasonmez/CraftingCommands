package me.blume.craftingcommands.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import me.blume.craftingcommands.Main;
import me.blume.craftingcommands.items.CommandItems;

public class FlyCommand implements CommandExecutor{
	@SuppressWarnings("unused")
	private Main plugin;
	public FlyCommand(Main plugin) {
		this.plugin=plugin;
	}
	Bukkit task;
	CommandItems items = new CommandItems(); 
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			if(label.equals("fly")) {
				Player player = (Player) sender;
				if(plugin.allowFly.contains(player.getUniqueId()) && !plugin.dontAllowFly.contains(player.getUniqueId())) {
					player.setAllowFlight(true);
					Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
						@Override
						public void run() {
							player.setAllowFlight(false);
							player.setFlying(false);
							plugin.allowFly.remove(player.getUniqueId());
							plugin.dontAllowFly.add(player.getUniqueId());
						}
					},20L*20);
				}
			}
		}
		return false;
	}

}