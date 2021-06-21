package me.blume.craftingcommands.items;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class CommandItems {
	public ItemStack flyCommandItem() {
		ItemStack fly = new ItemStack(Material.GOLDEN_CARROT);
		ItemMeta meta = fly.getItemMeta();
		meta.setDisplayName(ChatColor.AQUA+"Fly Command");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("By eating this carrot");
		lore.add("you can use /fly command");
		meta.setLore(lore);
		meta.addEnchant(Enchantment.DURABILITY,100 , true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		fly.setItemMeta(meta);
		return fly;
	}
	public ItemStack switchCommandItem() {
		ItemStack switchItem = new ItemStack(Material.GOLDEN_CARROT);
		ItemMeta meta = switchItem.getItemMeta();
		meta.setDisplayName(ChatColor.AQUA+"Switch Command");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("By eating this carrot");
		lore.add("you can use /switch command");
		lore.add("to switch places with closest player");
		lore.add("in your world");
		meta.setLore(lore);
		meta.addEnchant(Enchantment.DURABILITY,100 , true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		switchItem.setItemMeta(meta);
		return switchItem;
	}
	public ItemStack bringCommandItem() {
		ItemStack bring = new ItemStack(Material.GOLDEN_CARROT);
		ItemMeta meta = bring.getItemMeta();
		meta.setDisplayName(ChatColor.AQUA+"Bring Command");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("By eating this carrot");
		lore.add("you can use /bring command");
		lore.add("to bring a certain player");
		meta.setLore(lore);
		meta.addEnchant(Enchantment.DURABILITY,100 , true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		bring.setItemMeta(meta);
		return bring;
	}
	public ItemStack locateCommandItem() {
		ItemStack locate = new ItemStack(Material.GOLDEN_CARROT);
		ItemMeta meta = locate.getItemMeta();
		meta.setDisplayName(ChatColor.AQUA+"Find Command");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("By eating this carrot");
		lore.add("you can use /find command");
		lore.add("to find structures");
		meta.setLore(lore);
		meta.addEnchant(Enchantment.DURABILITY,100 , true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		locate.setItemMeta(meta);
		return locate;
	}
	public ItemStack summonCommandItem() {
		ItemStack summon = new ItemStack(Material.GOLDEN_CARROT);
		ItemMeta meta = summon.getItemMeta();
		meta.setDisplayName(ChatColor.AQUA+"Drop Command");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("By eating this carrot");
		lore.add("you can use /drop command");
		lore.add("to drop anything");
		meta.setLore(lore);
		meta.addEnchant(Enchantment.DURABILITY,100 , true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		summon.setItemMeta(meta);
		return summon;
	}
}
