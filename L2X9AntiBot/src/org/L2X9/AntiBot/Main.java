package org.L2X9.AntiBot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.L2X9.AntiBot.SQLite.CreateDB;
import org.L2X9.AntiBot.WebServer.Server;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	public static Main getPlugin() {
	    return (Main)getPlugin(Main.class);
	}
 FileConfiguration config = getConfig();
	public void onEnable() {
		getLogger().info("L2X9AntiBot Enabled");
		FileManagement.createFiles();
		FileManagement.createDataBase();
		CreateDB.createNewDatabase("verified.db");
		try {
			Server.Start();
		} catch (IOException e) {
			Main.getPlugin().getServer().getPluginManager().disablePlugin(getPlugin());
			e.printStackTrace();
		}
		this.saveDefaultConfig();
		getServer().getPluginManager().registerEvents(new Events(), (Plugin)this);
		getCommand("abreload").setExecutor(new Rconfig());
		getCommand("antibot").setExecutor(new Commands());
		StringBuilder verifiedBuilder = new StringBuilder(); {
   	     try {
   	       BufferedReader in = new BufferedReader(new FileReader("plugins/L2X9AntiBot/verified.txt"));
   	       String str;
   	       while ((str = in.readLine()) != null)
   	         verifiedBuilder.append(str); 
   	       in.close();
   	     } catch (IOException iOException) {}        	
   	 }
		FileManagement.verified.add(verifiedBuilder.toString());
	}
	public void onDisable() {
	   getLogger().info("L2X9AntiBot Disabled");
		
	}
}
