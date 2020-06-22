package org.L2X9.AntiBot.SQLite;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  
   
public class ConnectToDB {    
    public static void connect() {  
        Connection conn = null;  
        try {   
            String url = "jdbc:sqlite:C:/sqlite/verified.db";   
            conn = DriverManager.getConnection(url);  
              
            System.out.println("Connection to SQLite has been established.");  
              
        } catch (SQLException e) {  
        } finally {  
            try {  
                if (conn != null) {  
                    conn.close();  
                }  
            } catch (SQLException ex) {  
            }  
        }  
    }  
} 