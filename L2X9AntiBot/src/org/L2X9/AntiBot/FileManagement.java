package org.L2X9.AntiBot;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileManagement {
	public static File passed;
	public static File failed;
	public static File index;
	public static File verifiedFile;
	public static File dataBase;
	public static File dir;
	public static ArrayList<String> verified = new ArrayList<>();	  
	public static void createFiles() {
	 dir = new File("plugins/L2X9AntiBot"); { 
		if (!dir.exists()) {
			 dir.mkdir();
	File wsDir = new File("plugins/L2X9AntiBot/HTMLfiles"); {
		if (!wsDir.exists()) {
			 wsDir.mkdir();
 }	
}
	    passed = new File(wsDir, "passed.html");
		if (!passed.exists()) {
			try {
				passed.createNewFile();
				FileWriter passedWriter = new FileWriter("plugins/L2X9AntiBot/HTMLfiles/passed.html");
				passedWriter.write("<html>\r\n" + 
						"  <head>\r\n" + 
						"    <title>L2X9 AntiBot</title>\r\n" + 
						"  </head>\r\n" + 
						"  <body>\r\n" + 
						"    <form action=\"/submit\">\r\n" + 
						"      <div  align=\"center\"><label for=\"username\">\r\n" + 
						"	  <br><br>\r\n" + 
						"	  <img src=\"https://cdn.discordapp.com/attachments/645796541080010752/714567758125465740/server-icon.png\"  width=\"64\" height=\"64\">\r\n" + 
						"	  <b><h1>L2X9 AntiBot</h1></b></label>\r\n" + 
						"<label for=\"username\"><b><h2>Valid you may relog now</h2></b></label>\r\n" + 
						"<br><br>      <div id=\"html_element\"></div>\r\n" + 
						"      </div>  </body>\r\n" + 
						"	        <style>\r\n" + 
						"body {\r\n" + 
						"    color: black;\r\n" + 
						"    background-image:url('https://cdn.discordapp.com/attachments/645796541080010752/714566844299870280/2020-05-25_12.52.04.png');\r\n" + 
						"    background-repeat: no-repeat;\r\n" + 
						"    background-size: 100% 100%;\r\n" + 
						"}\r\n" + 
						"h1 {\r\n" + 
						"  color: white;\r\n" + 
						"}\r\n" + 
						"h2 {\r\n" + 
						"  color: white;\r\n" + 
						"}\r\n" + 
						"h3 {\r\n" + 
						"  color: white;\r\n" + 
						"}\r\n" + 
						"h4 {\r\n" + 
						"  color: white;\r\n" + 
						"}\r\n" + 
						"h5 {\r\n" + 
						"  color: white;\r\n" + 
						"}\r\n" + 
						"h6 {\r\n" + 
						"  color: white;\r\n" + 
						"}\r\n" + 
						"html {\r\n" + 
						"    height: 100%\r\n" + 
						"}\r\n" + 
						".class { \r\n" + 
						"	font-family: Verdana,Geneva,sans-serif; \r\n" + 
						"}\r\n" + 
						"            body, html\r\n" + 
						"            {\r\n" + 
						"                margin: 0; padding: 0; height: 100%; overflow: hidden;\r\n" + 
						"            }\r\n" + 
						"\r\n" + 
						"            #content\r\n" + 
						"            {\r\n" + 
						"                position:absolute; left: 0; right: 0; bottom: 0; top: 0px; \r\n" + 
						"            }\r\n" + 
						"</style>\r\n" + 
						"</html>");
				passedWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	    failed = new File(wsDir, "failed.html");
	    if (!failed.exists()) {
	    	try {
				failed.createNewFile();
				FileWriter failedWriter = new FileWriter("plugins/L2X9AntiBot/HTMLfiles/failed.html");
				failedWriter.write("<html>\r\n" + 
						"  <head>\r\n" + 
						"    <title>L2X9 AntiBot</title>\r\n" + 
						"  </head>\r\n" + 
						"  <body>\r\n" + 
						"    <form action=\"/submit\">\r\n" + 
						"      <div  align=\"center\"><label for=\"username\">\r\n" + 
						"	  <br><br>\r\n" + 
						"	  <img src=\"https://cdn.discordapp.com/attachments/645796541080010752/714567758125465740/server-icon.png\"  width=\"64\" height=\"64\">\r\n" + 
						"	  <b><h1>L2X9 AntiBot</h1></b></label>\r\n" + 
						"<label for=\"username\"><b><h2>Invalid please retry</h2></b></label>\r\n" + 
						"<br><br>      <div id=\"html_element\"></div>\r\n" + 
						"      </div>  </body>\r\n" + 
						"	        <style>\r\n" + 
						"body {\r\n" + 
						"    color: black;\r\n" + 
						"    background-image:url('https://cdn.discordapp.com/attachments/645796541080010752/714566844299870280/2020-05-25_12.52.04.png');\r\n" + 
						"    background-repeat: no-repeat;\r\n" + 
						"    background-size: 100% 100%;\r\n" + 
						"}\r\n" + 
						"h1 {\r\n" + 
						"  color: white;\r\n" + 
						"}\r\n" + 
						"h2 {\r\n" + 
						"  color: white;\r\n" + 
						"}\r\n" + 
						"h3 {\r\n" + 
						"  color: white;\r\n" + 
						"}\r\n" + 
						"h4 {\r\n" + 
						"  color: white;\r\n" + 
						"}\r\n" + 
						"h5 {\r\n" + 
						"  color: white;\r\n" + 
						"}\r\n" + 
						"h6 {\r\n" + 
						"  color: white;\r\n" + 
						"}\r\n" + 
						"html {\r\n" + 
						"    height: 100%\r\n" + 
						"}\r\n" + 
						".class { \r\n" + 
						"	font-family: Verdana,Geneva,sans-serif; \r\n" + 
						"}\r\n" + 
						"            body, html\r\n" + 
						"            {\r\n" + 
						"                margin: 0; padding: 0; height: 100%; overflow: hidden;\r\n" + 
						"            }\r\n" + 
						"\r\n" + 
						"            #content\r\n" + 
						"            {\r\n" + 
						"                position:absolute; left: 0; right: 0; bottom: 0; top: 0px; \r\n" + 
						"            }\r\n" + 
						"</style>\r\n" + 
						"</html>");
				failedWriter.close();
				
			} catch (IOException e) {
			  e.printStackTrace();
			}
	    }
	    index = new File(wsDir, "index.html");
	    if (!index.exists()) {
	    	try {
				index.createNewFile();
				FileWriter indexWriter = new FileWriter("plugins/L2X9AntiBot/HTMLfiles/index.html");
				indexWriter.write("<html>\r\n" + 
						"  <head>\r\n" + 
						"    <title>L2X9 AntiBot</title>\r\n" + 
						"    <script type=\"text/javascript\">\r\n" + 
						"      var onloadCallback = function() {\r\n" + 
						"        grecaptcha.render('html_element', {\r\n" + 
						"          'sitekey' : '6LeOOPwUAAAAAOk2RGF8mZHAoQ7rQA3HgxNnyQgT'});\r\n" + 
						"      };\r\n" + 
						"    </script>\r\n" + 
						"  </head>\r\n" + 
						"  <body>\r\n" + 
						"    <form action=\"/submit\">\r\n" + 
						"      <div  align=\"center\"><label for=\"username\">\r\n" + 
						"	  <br><br>\r\n" + 
						"	  <br>\r\n" + 
						"	  <br>\r\n" + 
						"	  <img src=\"https://cdn.discordapp.com/attachments/645796541080010752/714567758125465740/server-icon.png\"  width=\"64\" height=\"64\">\r\n" + 
						"	  <b><h1>L2X9 AntiBot</h1></b></label>\r\n" + 
						"<label for=\"username\"><b><h3>Please enter your username with proper caps and lower case</h3></b></label>\r\n" + 
						" <label for=\"username\"><b><h3>Username</h3></b></label>\r\n" + 
						"      <input type=\"text\" placeholder=\"Enter Username\" name=\"username\" required>\r\n" + 
						"<br><br>      <div id=\"html_element\"></div>\r\n" + 
						"      <br>\r\n" + 
						"      <input type=\"submit\" value=\"Submit\">\r\n" + 
						"    </form>\r\n" + 
						"    <script src=\"https://www.google.com/recaptcha/api.js?onload=onloadCallback&render=explicit\"\r\n" + 
						"        async defer>\r\n" + 
						"    </script>\r\n" + 
						"    <br><br><br><br><br>\r\n" + 
						"    <a href=\"https://minecraftservers.org/server/586264\" target=\"_blank\"><img src=\"https://status.minecraftservers.org/ice/586264.png\" alt=\"L2X9 Minecraft server\" width=\"540\" height=\"90\" /></a>\r\n" + 
						"      </div>  </body>\r\n" + 
						"	        <style>\r\n" + 
						"body {\r\n" + 
						"    color: black;\r\n" + 
						"    background-image:url('https://cdn.discordapp.com/attachments/645796541080010752/714566844299870280/2020-05-25_12.52.04.png');\r\n" + 
						"    background-repeat: no-repeat;\r\n" + 
						"    background-size: 100% 100%;\r\n" + 
						"}\r\n" + 
						"h1 {\r\n" + 
						"  color: white;\r\n" + 
						"}\r\n" + 
						"h2 {\r\n" + 
						"  color: white;\r\n" + 
						"}\r\n" + 
						"h3 {\r\n" + 
						"  color: white;\r\n" + 
						"}\r\n" + 
						"h4 {\r\n" + 
						"  color: white;\r\n" + 
						"}\r\n" + 
						"h5 {\r\n" + 
						"  color: white;\r\n" + 
						"}\r\n" + 
						"h6 {\r\n" + 
						"  color: white;\r\n" + 
						"}\r\n" + 
						"html {\r\n" + 
						"    height: 100%\r\n" + 
						"}\r\n" + 
						".class { \r\n" + 
						"	font-family: Verdana,Geneva,sans-serif; \r\n" + 
						"}\r\n" + 
						"            body, html\r\n" + 
						"            {\r\n" + 
						"                margin: 0; padding: 0; height: 100%; overflow: hidden;\r\n" + 
						"            }\r\n" + 
						"\r\n" + 
						"            #content\r\n" + 
						"            {\r\n" + 
						"                position:absolute; left: 0; right: 0; bottom: 0; top: 0px; \r\n" + 
						"            }\r\n" + 
						"</style>\r\n" + 
						"</html>");
				indexWriter.close();
				
			} catch (IOException e) {
			  e.printStackTrace();
		 }
	    }
		verifiedFile = new File(dir, "verified.txt");
		if (!verifiedFile.exists()) {
			try {
				verifiedFile.createNewFile();
			} catch (IOException e) {
			  e.printStackTrace();
	 }
	}		
   }
  }				 
 }
	public static void createDataBase() {
		dataBase = new File(dir, "verified.db");
		if (!dataBase.exists()) {
			try {
				dataBase.createNewFile();
			} catch (IOException e) {
			}
		}
		
	}
}