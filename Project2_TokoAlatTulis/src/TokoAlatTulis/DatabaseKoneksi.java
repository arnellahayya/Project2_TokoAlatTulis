/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TokoAlatTulis;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DatabaseKoneksi {
    
    static class DatabaseConnection {
        private static Connection connection;
        public static Connection getConnection() throws ClassNotFoundException, SQLException {
            if (connection == null) {
                String url = "jdbc:mysql://localhost:3306/project1_perpustakaan";
                String username = "root";
                String password = "";
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, username, password);
            }
            return connection;
        }
    
        public static void closeConnection() {
            try {
              
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                    System.out.println("Database connection closed.");  
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
    }
}
