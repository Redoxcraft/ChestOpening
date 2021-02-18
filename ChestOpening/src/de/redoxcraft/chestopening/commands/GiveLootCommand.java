package de.redoxcraft.chestopening.commands;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GiveLootCommand implements CommandExecutor{

	@Override
	public boolean onCommand (CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.isOp() == true) {
				
				ItemStack StaubigeTruhe = new ItemStack(Material.CHEST, 1);
				ItemMeta StaubigeTruheMeta = StaubigeTruhe.getItemMeta();
				StaubigeTruheMeta.setDisplayName("§9Staubige Truhe");
				ArrayList<String> StaubigeTruheLore = new ArrayList<String>();
				StaubigeTruheLore.add("§7Zum Öffnen rechtsklicken");
				StaubigeTruheLore.add("§d§oTrotz ihres alters");
				StaubigeTruheLore.add("§d§onoch recht stabil");
				StaubigeTruheMeta.setLore(StaubigeTruheLore);
				StaubigeTruhe.setItemMeta(StaubigeTruheMeta);
				
				ItemStack RostigerSchlüssel = new ItemStack(Material.IRON_HOE, 1);
				ItemMeta RostigerSchlüsselMeta = RostigerSchlüssel.getItemMeta();
				RostigerSchlüsselMeta.setDisplayName("§9Rostiger Schlüssel");
				ArrayList<String> RostigerSchlüsselLore = new ArrayList<String>();
				RostigerSchlüsselLore.add("§7Zum Benutzen rechtsklicken");
				RostigerSchlüsselLore.add("§d§oZu welcher Truhe");
				RostigerSchlüsselLore.add("§d§oer wohl gehört...");
				RostigerSchlüsselMeta.setLore(RostigerSchlüsselLore);
				RostigerSchlüssel.setItemMeta(RostigerSchlüsselMeta);
				
				ItemStack FeurigeTruhe = new ItemStack(Material.CHEST, 1);
				ItemMeta FeurigeTruheMeta = FeurigeTruhe.getItemMeta();
				FeurigeTruheMeta.setDisplayName("§5Feurige Truhe");
				ArrayList<String> FeurigeTruheLore = new ArrayList<String>();
				FeurigeTruheLore.add("§7Zum Öffnen rechtsklicken");
				FeurigeTruheLore.add("§d§oMan muss aufpassen,");
				FeurigeTruheLore.add("§d§odass man sich nicht");
				FeurigeTruheLore.add("§d§overbrennt!");
				FeurigeTruheMeta.setLore(FeurigeTruheLore);
				FeurigeTruhe.setItemMeta(FeurigeTruheMeta);
				
				ItemStack DunklerSchlüssel = new ItemStack(Material.NETHERITE_HOE, 1);
				ItemMeta DunklerSchlüsselMeta = DunklerSchlüssel.getItemMeta();
				DunklerSchlüsselMeta.setDisplayName("§5Dunkler Schlüssel");
				ArrayList<String> DunklerSchlüsselLore = new ArrayList<String>();
				DunklerSchlüsselLore.add("§7Zum Benutzen rechtsklicken");
				DunklerSchlüsselLore.add("§d§oEine gruselige Aura");
				DunklerSchlüsselLore.add("§d§oumgibt den Schlüssel");
				DunklerSchlüsselMeta.setLore(DunklerSchlüsselLore);
				DunklerSchlüssel.setItemMeta(DunklerSchlüsselMeta);
				
				p.getInventory().addItem(StaubigeTruhe);
				p.getInventory().addItem(RostigerSchlüssel);
				p.getInventory().addItem(FeurigeTruhe);
				p.getInventory().addItem(DunklerSchlüssel);
				return true;
			}return false;
		}return false;
	}	
	
}
