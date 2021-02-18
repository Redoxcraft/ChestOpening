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
		
		int random = (int) (Math.random()*(50));
		if(e instanceof Zombie) {
			
			if(random == 13) {
				e.getLocation().getWorld().dropItem(e.getLocation(), new ItemStack(StaubigeTruhe));
			}
			
		}else if(e instanceof Skeleton) {
			
			if(random == 13) {
				e.getLocation().getWorld().dropItem(e.getLocation(), new ItemStack(RostigerSchlüssel));
			}
		}else if(e instanceof PigZombie) {
			
			if(random == 13) {
				e.getLocation().getWorld().dropItem(e.getLocation(), new ItemStack(FeurigeTruhe));
			}
			
		}else if(e instanceof WitherSkeleton) {
			
			if(random == 13) {
				e.getLocation().getWorld().dropItem(e.getLocation(), new ItemStack(DunklerSchlüssel));
			}
			
		}
	}
	
}
