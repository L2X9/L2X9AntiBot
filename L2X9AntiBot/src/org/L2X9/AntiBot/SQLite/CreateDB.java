package org.L2X9.AntiBot.SQLite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;  
   
public class CreateDB {  
  
    public static void createNewDatabase(String fileName) {  
   
        String url = "jdbc:sqlite:C:/sqlite/" + fileName;  
   
        try {  
            Connection conn = DriverManager.getConnection(url);  
            if (conn != null) {  
            }  
   
        } catch (SQLException e) {  
        }  
 }  
}  