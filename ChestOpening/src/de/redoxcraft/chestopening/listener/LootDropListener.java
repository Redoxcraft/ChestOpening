package de.redoxcraft.chestopening.listener;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.WitherSkeleton;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class LootDropListener implements Listener {
//only ADD Drops, not replace
	
	@EventHandler
	public void onMobDeath(EntityDeathEvent event) {
		LivingEntity e = event.getEntity();
		
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
		
		int random = (int) (Math.random()*(50));
		if(e instanceof Zombie) {
			
			if(random == 13) {
				e.getLocation().getWorld().dropItem(e.getLocation(), new ItemStack(StaubigeTruhe));
			}
			
		}else if(e instanceof Skeleton) {
			
			if(random == 13) {
				e.getLocation().getWorld().dropItem(e.getLocation(), new ItemStack(RostigerSchl�ssel));
			}
		}else if(e instanceof PigZombie) {
			
			if(random == 13) {
				e.getLocation().getWorld().dropItem(e.getLocation(), new ItemStack(FeurigeTruhe));
			}
			
		}else if(e instanceof WitherSkeleton) {
			
			if(random == 13) {
				e.getLocation().getWorld().dropItem(e.getLocation(), new ItemStack(DunklerSchl�ssel));
			}
			
		}
	}
	
}
