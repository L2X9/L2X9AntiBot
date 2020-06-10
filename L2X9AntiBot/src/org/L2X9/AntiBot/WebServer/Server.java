package org.L2X9.AntiBot.WebServer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

import org.L2X9.AntiBot.FileManagement;
import org.L2X9.AntiBot.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class Server {
  static String jsonText;
  
  public static void Start() throws IOException {
    int port = Main.getPlugin().getConfig().getInt("port");
    HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
    server.createContext("/", new MyHandler());
    server.createContext("/submit", new MyHandler2());
    server.setExecutor(null);
    server.start();
    System.out.println(ChatColor.translateAlternateColorCodes('&', "&3[L2X9AntiBot]&r&4 WebServer&r&a Started&r"));
  }
  
  static class MyHandler implements HttpHandler {
    public void handle(HttpExchange t) throws IOException {
    	 StringBuilder indexBuilder = new StringBuilder(); {
   	      try {
   	        BufferedReader in = new BufferedReader(new FileReader("plugins/L2X9AntiBot/HTMLfiles/index.html"));
   	        String str;
   	        while ((str = in.readLine()) != null)
   	          indexBuilder.append(str); 
   	          in.close();
   	} catch (IOException iOException) {}
   	}
      String response = indexBuilder.toString();
      t.sendResponseHeaders(200, response.length());
      OutputStream os = t.getResponseBody();
      os.write(response.getBytes());
      os.close();
      }
    }
  
  public static Map<String, String> xd(String a) {
    HashMap<String, String> map = new HashMap<>();
    for (String s : a.split("&"))
      map.put(s.split("=")[0], s.split("=")[1]); 
    return map;
  }
  
  static class MyHandler2 implements HttpHandler {
    @SuppressWarnings("deprecation")
	public void handle(HttpExchange t) throws IOException {
      String privatekey = Main.getPlugin().getConfig().getString("Private-Key");
      boolean captchaValid = false;
      String response = null;
      Map<String, String> map = Server.xd(t.getRequestURI().getRawQuery());
      try {
        if (CaptchaManager.isCaptchaValid("" + privatekey + "", map.get("g-recaptcha-response")))
          captchaValid = true; 
        if (captchaValid) {
        	 StringBuilder passedBuilder = new StringBuilder(); {
       	      try {
       	        BufferedReader in = new BufferedReader(new FileReader("plugins/L2X9AntiBot/HTMLfiles/passed.html"));
       	        String str;
       	        while ((str = in.readLine()) != null)
       	          passedBuilder.append(str); 
       	          in.close();
       	} catch (IOException iOException) {}
       	}       	
          response = passedBuilder.toString();
        } else {
        	StringBuilder failedBuilder = new StringBuilder(); {
      	      try {
      	        BufferedReader in = new BufferedReader(new FileReader("plugins/L2X9AntiBot/HTMLfiles/failed.html"));
      	        String str;
      	        while ((str = in.readLine()) != null)
      	          failedBuilder.append(str); 
      	          in.close();
      	} catch (IOException iOException) {
      		
      	}
      	}
          response = failedBuilder.toString();
        } 
        if (captchaValid) {
          String name = map.get("username");
          String uuid = Bukkit.getOfflinePlayer(name).getUniqueId().toString();
          FileManagement.verified.add(uuid);
          SaveArrayToFile.save();
          System.out.println(ChatColor.translateAlternateColorCodes('&', "&a" + name + " Has been Whitelisted&r"));
        } 
      } catch (Exception e) {
        e.printStackTrace();
      } 
      t.sendResponseHeaders(200, response.length());
      OutputStream os = t.getResponseBody();
      os.write(response.toString().getBytes());
      os.close();
  }
 }
 
}
  
