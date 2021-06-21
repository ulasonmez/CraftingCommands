package me.blume.craftingcommands;

import java.util.HashSet;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import me.blume.craftingcommands.commands.BringCommand;
import me.blume.craftingcommands.commands.CreateCommand;
import me.blume.craftingcommands.commands.FindCommand;
import me.blume.craftingcommands.commands.FlyCommand;
import me.blume.craftingcommands.commands.HuntersDropHead;
import me.blume.craftingcommands.commands.SwitchCommand;
import me.blume.craftingcommands.items.ActivatingCommands;
import me.blume.craftingcommands.items.ItemRecipes;

public class Main extends JavaPlugin{

	public HashSet<UUID> allowFly = new HashSet<UUID>();
	public HashSet<UUID> allowSwitch = new HashSet<UUID>();
	public HashSet<UUID> allowBring = new HashSet<UUID>();
	public HashSet<UUID> allowFind = new HashSet<UUID>();
	public HashSet<UUID> allowDrop= new HashSet<UUID>();
	public HashSet<UUID> dontAllowFly = new HashSet<UUID>();
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new ItemRecipes(this), this);
		getServer().getPluginManager().registerEvents(new ActivatingCommands(this), this);
		getServer().getPluginManager().registerEvents(new HuntersDropHead(this), this);
		getCommand("fly").setExecutor(new FlyCommand(this));
		getCommand("switch").setExecutor(new SwitchCommand(this));
		getCommand("bring").setExecutor(new BringCommand(this));
		getCommand("find").setExecutor(new FindCommand(this));
		getCommand("drop").setExecutor(new CreateCommand(this));
	}
	@Override
	public void onDisable() {
		for(Player p : Bukkit.getServer().getOnlinePlayers()) {
			p.setAllowFlight(false);
		}
	}
}