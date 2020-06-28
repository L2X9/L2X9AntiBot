package org.L2X9.AntiBot;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

@SuppressWarnings("deprecation")
public class Events implements Listener {
	@EventHandler
	public void onChat(PlayerChatEvent event) {
		Player player = event.getPlayer();
		if (!FileManagement.verified.toString().contains(player.getUniqueId().toString())) {
			event.setCancelled(true);
			player.kickPlayer(ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Kick-Message")));
  }		
 }
	@EventHandler
	public void onCmd(PlayerCommandPreprocessEvent event) {
		Player player = event.getPlayer();
		if (!FileManagement.verified.toString().contains(player.getUniqueId().toString())) {
			event.setCancelled(true);
			player.kickPlayer(ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Kick-Message")));
		
  }
 }
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		if (!FileManagement.verified.toString().contains(player.getUniqueId().toString())) {
		 if (Main.getPlugin().getConfig().getString("Spam-the-player-to-whitelist").equalsIgnoreCase("false")) {
			 List<String> strings = Main.getPlugin().getConfig().getStringList("Not-Verified-Message");
	          ArrayList finalStrings = new ArrayList();
	          (new Thread(() -> {
	              Iterator var3 = strings.iterator();

	              String sss;
	              while (var3.hasNext()) {
	                  sss = (String) var3.next();
	                  finalStrings.add(sss.replace("&", "§").replace("{playername}", player.getDisplayName()));
	              }

	              var3 = finalStrings.iterator();

	              while (var3.hasNext()) {
	                  sss = (String) var3.next();
	                  player.sendMessage(sss);
	              }

	          })).start();			 
		 }
			Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), new Runnable() {
				 int time = Main.getPlugin().getConfig().getInt("Verify-Timeout");
					public void run() {
			            if (time == 0)
			            	player.kickPlayer(ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Kick-Message")));
			            this.time--;
			            if (!FileManagement.verified.contains(player.getUniqueId().toString())) {
			            player.sendActionBar(ChatColor.translateAlternateColorCodes('&', "&6&lPlease verify at AntiBot.l2x9.org to play&r&b&l L2X9&r&c&l " + String.valueOf(time) + ""));
			            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100.0F, 1.0F);
			             if (Main.getPlugin().getConfig().getString("Spam-the-player-to-whitelist").equalsIgnoreCase("true")) {
			    			 List<String> strings = Main.getPlugin().getConfig().getStringList("Not-Verified-Message");
			   	          ArrayList finalStrings = new ArrayList();
			   	          (new Thread(() -> {
			   	              Iterator var3 = strings.iterator();

			   	              String sss;
			   	              while (var3.hasNext()) {
			   	                  sss = (String) var3.next();
			   	                  finalStrings.add(sss.replace("&", "§").replace("{playername}", player.getDisplayName()));
			   	              }

			   	              var3 = finalStrings.iterator();

			   	              while (var3.hasNext()) {
			   	                  sss = (String) var3.next();
			   	   	                  player.sendMessage(sss);
		}
	   })).start();
      }			
	 }				
	}			
   }, 0, 20);	
  }
 }
	@EventHandler
	public void onMove(PlayerMoveEvent event) {
		Player player = event.getPlayer();
		Location to = event.getFrom();
		to.setPitch(event.getTo().getPitch());
		to.setYaw(event.getTo().getYaw());
		if (!FileManagement.verified.toString().contains(player.getUniqueId().toString())) {
			event.setTo(to);
			
		
  }	
 }
	@EventHandler
	public void onBreak(BlockBreakEvent event) {
		Player player = event.getPlayer();
		if (!FileManagement.verified.toString().contains(player.getUniqueId().toString())) {
			event.setCancelled(true);
  }	
 }
}