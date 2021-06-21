package me.blume.craftingcommands.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.blume.craftingcommands.Main;

public class SwitchCommand implements CommandExecutor{

	@SuppressWarnings("unused")
	private Main plugin;
	public SwitchCommand(Main plugin) {
		this.plugin=plugin;
	}
	int sameWorld=0;
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(label.equals("switch")) {
			if(sender instanceof Player) {
				Player player = (Player) sender;
				if(plugin.allowSwitch.contains(player.getUniqueId())) {
					Player getClosest;
					for(Player p : player.getWorld().getPlayers()) {
						if(p==player) continue;
						sameWorld++;
					}
					if(sameWorld==0) player.sendMessage("No player found in your world");
					else { getClosest = getClosestHunter(player);
					Location loc = new Location(getClosest.getWorld(),getClosest.getLocation().getX(),getClosest.getLocation().getY(),getClosest.getLocation().getZ());
					Location loc1 = new Location(player.getWorld(),player.getLocation().getX(),player.getLocation().getY(),player.getLocation().getZ());
					getClosest.teleport(loc1);
					player.teleport(loc);}
					sameWorld=0;
				}
			}
		}
		return false;
	}
	private Player getClosestHunter(Player runner) {
		Location hunterLocation = runner.getLocation();
		Player closestPlayer = null;
		double closestDistanceSquared = Double.MAX_VALUE;

		for(Player p : Bukkit.getServer().getOnlinePlayers()) {
			if(p == runner) continue;
			double distanceSquared = p.getLocation().distanceSquared(hunterLocation);
			if(distanceSquared <= closestDistanceSquared) {
				closestDistanceSquared = distanceSquared;
				closestPlayer = p;
			}
		}
		return closestPlayer;
	}
}