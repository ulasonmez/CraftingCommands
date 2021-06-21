package me.blume.craftingcommands.items;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;

import me.blume.craftingcommands.Main;

public class ItemRecipes implements Listener {
	CommandItems items = new CommandItems();
	@SuppressWarnings("unused")
	private Main plugin;
	public ItemRecipes(Main plugin) {
		this.plugin=plugin;
	}
	@SuppressWarnings("serial")
	@EventHandler
	public void craftFlycommand(PrepareItemCraftEvent event) {
		CraftingInventory inv = event.getInventory();
		if(inv.getMatrix().length<9) return;
		checkCraft(items.flyCommandItem(),inv,new HashMap<Integer,ItemStack>(){{
			put(1,new ItemStack(Material.PLAYER_HEAD));
			put(3,new ItemStack(Material.PLAYER_HEAD));
			put(4,new ItemStack(Material.FEATHER));
			put(5,new ItemStack(Material.PLAYER_HEAD));
			put(7,new ItemStack(Material.PLAYER_HEAD));
			/*
			 * 012
			 * 345
			 * 678
			 */
		}});
	}
	@SuppressWarnings("serial")
	@EventHandler
	public void craftSwitchCommand(PrepareItemCraftEvent event) {
		CraftingInventory inv = event.getInventory();
		if(inv.getMatrix().length<9) return;
		checkCraft(items.switchCommandItem(),inv,new HashMap<Integer,ItemStack>(){{
			put(4,new ItemStack(Material.CLOCK));
			put(5,new ItemStack(Material.PLAYER_HEAD));
			/*
			 * 012
			 * 345
			 * 678
			 */
		}});
	}
	@SuppressWarnings("serial")
	@EventHandler
	public void craftBringCommand(PrepareItemCraftEvent event) {
		CraftingInventory inv = event.getInventory();
		if(inv.getMatrix().length<9) return;
		checkCraft(items.bringCommandItem(),inv,new HashMap<Integer,ItemStack>(){{
			put(4,new ItemStack(Material.LEAD));
			put(5,new ItemStack(Material.PLAYER_HEAD));
			/*
			 * 012
			 * 345
			 * 678
			 */
		}});
	}
	@SuppressWarnings("serial")
	@EventHandler
	public void craftFindCommand(PrepareItemCraftEvent event) {
		CraftingInventory inv = event.getInventory();
		if(inv.getMatrix().length<9) return;
		checkCraft(items.locateCommandItem(),inv,new HashMap<Integer,ItemStack>(){{
			for(int i =0;i<9;i++) {
				if(i!=4) {
					put(i,new ItemStack(Material.REDSTONE));
				}
				else {
					put(i,new ItemStack(Material.IRON_BLOCK));
				}
			}
			/*
			 * 012
			 * 345
			 * 678
			 */
		}});
	}
	@SuppressWarnings("serial")
	@EventHandler
	public void craftDropCommand(PrepareItemCraftEvent event) {
		CraftingInventory inv = event.getInventory();
		if(inv.getMatrix().length<9) return;
		checkCraft(items.summonCommandItem(),inv,new HashMap<Integer,ItemStack>(){{
			
					put(0,new ItemStack(Material.DIAMOND));
					put(1,new ItemStack(Material.LAPIS_LAZULI));
					put(3,new ItemStack(Material.LAPIS_LAZULI));
					put(5,new ItemStack(Material.LAPIS_LAZULI));
					put(7,new ItemStack(Material.LAPIS_LAZULI));
					put(4,new ItemStack(Material.IRON_INGOT));
					put(2,new ItemStack(Material.DIAMOND));
					put(6,new ItemStack(Material.DIAMOND));
					put(8,new ItemStack(Material.DIAMOND));
			/*
			 * 012
			 * 345
			 * 678
			 */
		}});
	}
	public void checkCraft(ItemStack result,CraftingInventory inv,HashMap<Integer, ItemStack> ingredients) {
		ItemStack[] matrix = inv.getMatrix();
		for(int i =0;i<9;i++) {
			if(ingredients.containsKey(i)) {
				if(matrix[i]==null || !matrix[i].equals(ingredients.get(i))) {
					return;
				}
			}
			else {
				if(matrix[i]!=null) {
					return;
				}
			}
		}
		inv.setResult(result);
	}
	
}
