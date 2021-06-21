package me.blume.craftingcommands.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.blume.craftingcommands.Main;

public class CreateCommand implements CommandExecutor {

	@SuppressWarnings("unused")
	private Main plugin;
	public CreateCommand(Main plugin) {
		this.plugin=plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(label.equals("drop")) {
			if(args.length==1) {
				if(sender instanceof Player) {
					Player player = (Player) sender;
					if(plugin.allowDrop.contains(player.getUniqueId())) {
						Material m = Material.getMaterial(args[0].toUpperCase());
						if(m!=null) 
							player.getWorld().dropItemNaturally(player.getLocation(), new ItemStack(m));
					}
				}
			}
		}	
		return false;
	}
}
