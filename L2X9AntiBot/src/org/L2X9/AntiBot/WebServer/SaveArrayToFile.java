package org.L2X9.AntiBot.WebServer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.L2X9.AntiBot.FileManagement;

public class SaveArrayToFile {
	@SuppressWarnings("resource")
	public static void save() {
	      try {
	          BufferedWriter br = new BufferedWriter(new FileWriter("plugins/L2X9AntiBot/verified.txt"));
	          FileManagement.verified.forEach(s -> {
	              try {
	                  br.append(s);
	                  br.newLine();
	                  br.flush();
	              } catch (IOException e) {
	                  e.printStackTrace();
	              }
	          });
	      } catch (Exception e) {
	          e.printStackTrace();
	      }
	  }
	}

