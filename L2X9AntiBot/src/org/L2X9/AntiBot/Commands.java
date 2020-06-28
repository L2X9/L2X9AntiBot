package org.L2X9.AntiBot;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Commands implements CommandExecutor {
	  @SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	      if (cmd.getLabel() == "antibot" && args.length == 0) {
	    	  sender.sendMessage(ChatColor.GOLD + "/antibot verify/unverify username");
	          if (sender.hasPermission("whitelist.admin")) {
	              if (args.length > 0) {
	                  if (args[0].equals("verify") && args.length > 1) {
	                      String uuid;
	                      uuid = Bukkit.getOfflinePlayer(args[1]).getName();
	                      FileManagement.verified.add(String.valueOf(uuid));
	                      sender.sendMessage(ChatColor.GREEN + "The player " + args[1] + " has been added to the whitelist");
	 }else {
		 if (args[0].equalsIgnoreCase("unverify")) {
			 String uuid;
             uuid = Bukkit.getOfflinePlayer(args[1]).getName();
             FileManagement.verified.remove(String.valueOf(uuid));
             sender.sendMessage(ChatColor.RED + "The player " + args[1] + " has been removed from the whitelist");
			 
		 }
	 }
	}
   }
  }	return true;
 }
}
