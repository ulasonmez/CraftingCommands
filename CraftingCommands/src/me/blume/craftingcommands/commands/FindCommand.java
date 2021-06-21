package me.blume.craftingcommands.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.blume.craftingcommands.Main;

public class FindCommand implements CommandExecutor{

	@SuppressWarnings("unused")
	private Main plugin;
	public FindCommand(Main plugin) {
		this.plugin=plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(label.equals("find")) {
			if(args.length==1) {
				if(sender instanceof Player) {
					Player player = (Player) sender;
					if(plugin.allowFind.contains(player.getUniqueId())) {
						if(args[0].equals("fortress")) {
							Bukkit.dispatchCommand(player, "locate fortress");
						}
						else if(args[0].equals("bastion")) {
							Bukkit.dispatchCommand(player, "locate bastion_remnant");
						}
						else if(args[0].equals("village")) {
							Bukkit.dispatchCommand(player, "locate village");
						}
						else if(args[0].equals("stronghold")) {
							Bukkit.dispatchCommand(player, "locate stronghold");
						}
						else if(args[0].equals("pyramid")) {
							Bukkit.dispatchCommand(player, "locate desert_pyramid");
						}
						else if(args[0].equals("ruined_portal")) {
							Bukkit.dispatchCommand(player, "locate ruined_portal");
						}
						else if(args[0].equals("shipwreck")) {
							Bukkit.dispatchCommand(player, "locate shipwreck");
						}
					}
				}
			}
		}
		return false;
	}
}
