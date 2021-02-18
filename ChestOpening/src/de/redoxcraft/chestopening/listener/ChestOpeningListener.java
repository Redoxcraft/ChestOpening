package de.redoxcraft.chestopening.listener;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;

public class ChestOpeningListener implements Listener {

	
	@EventHandler
	public void onPlayerOpenChest(PlayerInteractEvent e) {
		
		Player p = e.getPlayer();
		int main = 0;
		int off = 0;
		
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) { //rightclick
			if(!(p.getInventory().getItemInMainHand().getType() == Material.AIR)) { //mainhand not null
				ItemStack mainitem = p.getInventory().getItemInMainHand();
				main = chestOpeningItem(mainitem);
			}
			if(!(p.getInventory().getItemInOffHand().getType() == Material.AIR)) { //offhand not null
				ItemStack offitem = p.getInventory().getItemInOffHand();
				off = chestOpeningItem(offitem);
			}
			if(main == 0 && off == 0) { //no chestopeningitem in off or main hand
				return;
			}else{//chestopeningitem in off or main hand
				e.setCancelled(true);
				if(main != 0 && off != 0) {//chestopeningitem in main and off hand
					if(main == (-off)) {//right key for chest
						if(main > 0) {
							Loot(main, p);
							return;
						}else {
							Loot(off, p);
							return;
						}
					}else {//wrong key
						p.sendMessage("Dieser Schlüssel gehört nicht zu dieser Truhe!" + ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + " *Der Schlüssel passt einfach nicht in das Schloss*");
						return;
					}
				}else if(main != 0) {//chestopeningitem in main hand
					p.sendMessage("Bitte nimm die Truhe und den passenden Schlüssel in deine beiden Hände!" + ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + " *Meeeiiinnnn Schaaaatzzz*");
					return;
					//später noch eine switch fall um item heraus zu finden und gegenstück zu nennen. Zudem sagen kiste/schlüssel(im switch fall sieht man ob die zahl negativ oder positiv ist) in off/main(eine else klammer drunter ist off) hand
				}else if(off != 0) {//chestopeningitem in off hand
					p.sendMessage("Bitte nimm die Truhe und den passenden Schlüssel in deine beiden Hände!" + ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + " *Meeeiiinnnn Schaaaatzzz*");
					return;
				}else {
					p.sendMessage(ChatColor.DARK_RED + "ChestOpening ERROR, bitte melde diese Nachricht einem Administrator!");
				}
			}
		}return;
			
	}
	
	@EventHandler
	public void onEntityHit(EntityDamageByEntityEvent e) {
		if(e.getDamager() instanceof Player) {
			int main = 0;
			Player p = (Player) e.getDamager();
			if(!(p.getInventory().getItemInMainHand().getType() == Material.AIR)) { //mainhand not null
				ItemStack mainitem = p.getInventory().getItemInMainHand();
				main = chestOpeningItem(mainitem);
			}
			if(main >= 0) {
				return;
			}
			e.setCancelled(true);
			return;	
		}return;
	}
	
	@EventHandler
	public void onBlockBreakEvent(BlockBreakEvent e) {
		if(e.getPlayer() != null) {
			int main = 0;
			int off = 0;
			Player p = e.getPlayer();
			if(!(p.getInventory().getItemInMainHand().getType() == Material.AIR)) { //mainhand not null
				ItemStack mainitem = p.getInventory().getItemInMainHand();
				main = chestOpeningItem(mainitem);
			}
			if(!(p.getInventory().getItemInOffHand().getType() == Material.AIR)) { //offhand not null
				ItemStack offitem = p.getInventory().getItemInOffHand();
				off = chestOpeningItem(offitem);
			}
			if((main >= 0) && (off >= 0)) {
				return;
			}
			e.setCancelled(true);
			return;	
		}return;
	}
	
	/*@EventHandler //not needed yet because of e.cancel in player interact event
	public void onBlockPlace(BlockPlaceEvent e) {
		if(e.getPlayer() != null) {
			Player p = e.getPlayer();
			ItemStack i = p.getInventory().getItemInMainHand();
			if(chestOpeningItem(i) <= 0) {
				return;
			}
			e.setCancelled(true);
			return;	
		}return;
	}*/
		
	
	private int chestOpeningItem(ItemStack item) {
		
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
			
		if(item.getItemMeta().equals(StaubigeTruheMeta)) {
			return 1;
		}else if (item.getItemMeta().equals(RostigerSchlüsselMeta)) {
			return -1;
		}else if (item.getItemMeta().equals(FeurigeTruheMeta)) {
			return 2;
		}else if (item.getItemMeta().equals(DunklerSchlüsselMeta)) {
			return -2;
		}else {
			return 0;
		}
	}

	
	private void Loot(int l, Player p) {
		if(p.getInventory().firstEmpty() == -1) { //inv full
			p.sendMessage("Dein Inventar ist voll!" + ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + " *Du überlegst, von welchen Gegenständen du dich trennen möchtest*");
			return;
		}else { //inv not full
			p.getInventory().getItemInMainHand().setAmount(p.getInventory().getItemInMainHand().getAmount() - 1);
			p.getInventory().getItemInOffHand().setAmount(p.getInventory().getItemInOffHand().getAmount() - 1);
			
			Location arg0 = p.getLocation();
			Sound arg1 = Sound.BLOCK_METAL_PRESSURE_PLATE_CLICK_ON;
			float arg2 = 1;
			float arg3 = 1;
			p.playSound(arg0, arg1, arg2, arg3);
			
			switch(l) {
			case 0: p.sendMessage(ChatColor.DARK_RED + "ChestOpening Loot 0 Error, bitte melde diese Nachricht einem Administrator!"); break;
			case 1: LootStaubigeTruhe(p); break;
			case 2: LootFeurigeTruhe(p); break;
			default: p.sendMessage(ChatColor.DARK_RED + "ChestOpening Loot default Error, bitte melde diese Nachricht einem Administrator!"); break;
			}
			
			return;
		}
		
	}

	private void LootFeurigeTruhe(Player p) {
		
		p.sendMessage(ChatColor.DARK_RED + "Melde die Zahl 1782 sofort einem Administrator!");
		
	}

	private void LootStaubigeTruhe(Player p) {
		int random = (int) (Math.random()*(20));
		if(random == 0) {// 1/20 pickaxe
			LootEnchantedPickaxe(p);
			return;
		}else if(random >= 1 && random <= 4) {// 4/20 channeling
			LootChannelingBook(p);
			return;
		}else if(random >= 5) {// 15/20 ore
			LootOre(p);
			return;
		}
		
	}

	private void LootOre(Player p) {
		ItemStack emerald = new ItemStack(Material.EMERALD);
		ItemStack emeraldore = new ItemStack(Material.EMERALD_ORE);
		ItemStack iron = new ItemStack(Material.IRON_INGOT, 10);
		ItemStack ironore = new ItemStack(Material.IRON_ORE, 10);
		ItemStack diamond = new ItemStack(Material.DIAMOND, 3);
		ItemStack diamondore = new ItemStack(Material.DIAMOND_ORE);
		ItemStack gold = new ItemStack(Material.GOLD_INGOT, 5);
		ItemStack goldore = new ItemStack(Material.GOLD_ORE, 5);
		ItemStack lapisore = new ItemStack(Material.LAPIS_ORE, 5);
		ItemStack redstoneore = new ItemStack(Material.REDSTONE_ORE, 5);
		ItemStack coalore = new ItemStack(Material.COAL_ORE, 10);
		int random = (int) (Math.random()*(11));
		switch(random) {
		case 0: p.getInventory().addItem(emerald); break;
		case 1: p.getInventory().addItem(emeraldore); break;
		case 2: p.getInventory().addItem(iron); break;
		case 3: p.getInventory().addItem(ironore); break;
		case 4: p.getInventory().addItem(diamond); break;
		case 5: p.getInventory().addItem(diamondore); break;
		case 6: p.getInventory().addItem(gold); break;
		case 7: p.getInventory().addItem(goldore); break;
		case 8: p.getInventory().addItem(lapisore); break;
		case 9: p.getInventory().addItem(redstoneore); break;
		case 10: p.getInventory().addItem(coalore); break;
		default: p.sendMessage(ChatColor.DARK_RED + "ChestOpening LootOre ERROR, bitte melde diesen Fehler einem Administrator!");
		}
		return;
	}

	private void LootChannelingBook(Player p) {
		ItemStack channelingbook = new ItemStack(Material.ENCHANTED_BOOK);
		EnchantmentStorageMeta channelingbookMeta = (EnchantmentStorageMeta)channelingbook.getItemMeta();
		channelingbookMeta.addStoredEnchant(Enchantment.CHANNELING, 1, false);
		channelingbook.setItemMeta(channelingbookMeta);
		p.getInventory().addItem(channelingbook);
		return;
	}

	private void LootEnchantedPickaxe(Player p) {
		int random = (int) (Math.random()*(5));
		ItemStack diamondpickaxe = new ItemStack(Material.DIAMOND_PICKAXE);
		ItemMeta diamondpickaxeMeta = diamondpickaxe.getItemMeta();
		switch(random) {
		case 0: diamondpickaxeMeta.addEnchant(Enchantment.DURABILITY, 3, false); break;
		case 1: diamondpickaxeMeta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, false); break;
		case 2: diamondpickaxeMeta.addEnchant(Enchantment.MENDING, 1, false); break;
		case 3: diamondpickaxeMeta.addEnchant(Enchantment.DIG_SPEED, 5, false); break;
		case 4: diamondpickaxeMeta.addEnchant(Enchantment.SILK_TOUCH, 1, false); break;
		default: p.sendMessage(ChatColor.DARK_RED + "ChestOpening LootEnchantedPickaxe ERROR, bitte melde diesen Fehler einem Administrator!"); break;
		}
		diamondpickaxe.setItemMeta(diamondpickaxeMeta);
		p.getInventory().addItem(diamondpickaxe);
		return;
			
	}
	
	
	
}

	

