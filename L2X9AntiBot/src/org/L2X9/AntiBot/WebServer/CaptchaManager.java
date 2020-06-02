package org.L2X9.AntiBot.WebServer;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;

import org.L2X9.AntiBot.Main;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class CaptchaManager {
	@SuppressWarnings("resource")
	public static boolean isCaptchaValid(String secretKey, String response) {
	    @SuppressWarnings("unused")
		String sitekey = Main.getPlugin().getConfig().getString("Site-Key");
	    try {
	      String url = "https://www.google.com/recaptcha/api/siteverify?secret=" + secretKey + "&response=" + response;
	      InputStream res = (new URL(url)).openStream();
	      BufferedReader rd = new BufferedReader(new InputStreamReader(res, Charset.forName("UTF-8")));
	      Server.jsonText = "";
	      rd.lines().forEach(s -> Server.jsonText += s);
	      System.out.print(Server.jsonText);
	      res.close();
	      JsonElement json = (new JsonParser()).parse(Server.jsonText);
	      System.out.print(json);
	      return json.getAsJsonObject().get("success").getAsBoolean();
	    } catch (Exception e) {
	      e.printStackTrace();
	      return false;
  } 
 }
}
