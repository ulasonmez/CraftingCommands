package me.blume.craftingcommands.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.blume.craftingcommands.Main;

public class BringCommand implements CommandExecutor {

	@SuppressWarnings("unused")
	private Main plugin;
	public BringCommand(Main plugin) {
		this.plugin=plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(label.equals("bring")) {
			if(args.length==1) {
				if(sender instanceof Player) {
					Player player = (Player) sender;
					if(plugin.allowBring.contains(player.getUniqueId())) {
						Player bringPlayer = Bukkit.getServer().getPlayer(args[0]);
						if(bringPlayer!=null) {
							bringPlayer.teleport(player.getLocation());
						}
					}
				}
			}
		}
		return false;
	}
}