package me.blume.craftingcommands.items;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;

import me.blume.craftingcommands.Main;

public class ActivatingCommands implements Listener{
	@SuppressWarnings("unused")
	private Main plugin;
	public ActivatingCommands(Main plugin) {
		this.plugin=plugin;
	}

	CommandItems items = new CommandItems();
	@EventHandler
	public void onEatingFly(PlayerItemConsumeEvent event) {
		if(event.getItem().isSimilar(items.flyCommandItem()) && !plugin.dontAllowFly.contains(event.getPlayer().getUniqueId())) {
			event.getPlayer().sendMessage("You are now able to fly");
			plugin.allowFly.add(event.getPlayer().getUniqueId());
		}
		else if(event.getItem().isSimilar(items.switchCommandItem())) {
			event.getPlayer().sendMessage("You can switch places.");
			plugin.allowSwitch.add(event.getPlayer().getUniqueId());
		}
		else if(event.getItem().isSimilar(items.bringCommandItem())) {
			event.getPlayer().sendMessage("You can bring anyone to you");
			plugin.allowBring.add(event.getPlayer().getUniqueId());
		}
		else if(event.getItem().isSimilar(items.locateCommandItem())) {
			event.getPlayer().sendMessage("You can find structures location.");
			plugin.allowFind.add(event.getPlayer().getUniqueId());
		}
		else if(event.getItem().isSimilar(items.summonCommandItem())) {
			event.getPlayer().sendMessage("You can drop any item.");
			plugin.allowDrop.add(event.getPlayer().getUniqueId());
		}
	}
}
