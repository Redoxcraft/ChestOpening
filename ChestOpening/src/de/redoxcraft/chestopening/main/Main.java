package de.redoxcraft.chestopening.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.redoxcraft.chestopening.commands.GiveLootCommand;
import de.redoxcraft.chestopening.listener.ChestOpeningListener;
import de.redoxcraft.chestopening.listener.LootDropListener;

public class Main extends JavaPlugin {

	public void onEnable() {
		System.out.println(this.getDescription().getName() + " " + this.getDescription().getVersion() + " geladen.");
		
		PluginManager PluginManager = Bukkit.getPluginManager();
		PluginManager.registerEvents(new LootDropListener(), this);
		PluginManager.registerEvents(new ChestOpeningListener(), this);
		
		getCommand("chestopeningloot").setExecutor(new GiveLootCommand());
	}
	
}
