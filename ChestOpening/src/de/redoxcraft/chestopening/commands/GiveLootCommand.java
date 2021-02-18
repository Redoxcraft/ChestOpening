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
				StaubigeTruheMeta.setDisplayName("�9Staubige Truhe");
				ArrayList<String> StaubigeTruheLore = new ArrayList<String>();
				StaubigeTruheLore.add("�7Zum �ffnen rechtsklicken");
				StaubigeTruheLore.add("�d�oTrotz ihres alters");
				StaubigeTruheLore.add("�d�onoch recht stabil");
				StaubigeTruheMeta.setLore(StaubigeTruheLore);
				StaubigeTruhe.setItemMeta(StaubigeTruheMeta);
				
				ItemStack RostigerSchl�ssel = new ItemStack(Material.IRON_HOE, 1);
				ItemMeta RostigerSchl�sselMeta = RostigerSchl�ssel.getItemMeta();
				RostigerSchl�sselMeta.setDisplayName("�9Rostiger Schl�ssel");
				ArrayList<String> RostigerSchl�sselLore = new ArrayList<String>();
				RostigerSchl�sselLore.add("�7Zum Benutzen rechtsklicken");
				RostigerSchl�sselLore.add("�d�oZu welcher Truhe");
				RostigerSchl�sselLore.add("�d�oer wohl geh�rt...");
				RostigerSchl�sselMeta.setLore(RostigerSchl�sselLore);
				RostigerSchl�ssel.setItemMeta(RostigerSchl�sselMeta);
				
				ItemStack FeurigeTruhe = new ItemStack(Material.CHEST, 1);
				ItemMeta FeurigeTruheMeta = FeurigeTruhe.getItemMeta();
				FeurigeTruheMeta.setDisplayName("�5Feurige Truhe");
				ArrayList<String> FeurigeTruheLore = new ArrayList<String>();
				FeurigeTruheLore.add("�7Zum �ffnen rechtsklicken");
				FeurigeTruheLore.add("�d�oMan muss aufpassen,");
				FeurigeTruheLore.add("�d�odass man sich nicht");
				FeurigeTruheLore.add("�d�overbrennt!");
				FeurigeTruheMeta.setLore(FeurigeTruheLore);
				FeurigeTruhe.setItemMeta(FeurigeTruheMeta);
				
				ItemStack DunklerSchl�ssel = new ItemStack(Material.NETHERITE_HOE, 1);
				ItemMeta DunklerSchl�sselMeta = DunklerSchl�ssel.getItemMeta();
				DunklerSchl�sselMeta.setDisplayName("�5Dunkler Schl�ssel");
				ArrayList<String> DunklerSchl�sselLore = new ArrayList<String>();
				DunklerSchl�sselLore.add("�7Zum Benutzen rechtsklicken");
				DunklerSchl�sselLore.add("�d�oEine gruselige Aura");
				DunklerSchl�sselLore.add("�d�oumgibt den Schl�ssel");
				DunklerSchl�sselMeta.setLore(DunklerSchl�sselLore);
				DunklerSchl�ssel.setItemMeta(DunklerSchl�sselMeta);
				
				p.getInventory().addItem(StaubigeTruhe);
				p.getInventory().addItem(RostigerSchl�ssel);
				p.getInventory().addItem(FeurigeTruhe);
				p.getInventory().addItem(DunklerSchl�ssel);
				return true;
			}return false;
		}return false;
	}	
	
}
