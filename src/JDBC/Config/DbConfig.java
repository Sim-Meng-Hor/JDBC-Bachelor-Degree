package JDBC.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConfig {

        // Create Singleton Object
        private static Connection conn;

        // Invoke singleton object
        public static Connection getInstance(){
            return conn;
        }

        // Initialize singleton object (only 1 time)
        public static void init () {
            if (conn == null) {
                try {
                    // Step 1 : Load Driver
                    Class.forName("org.postgresql.Driver");

                    // Step 2: Establish Connection
                    String url = "jdbc:postgresql://localhost:5432/postgres";
                    String user = "postgres";
                    String password = "12345";
                    conn = DriverManager.getConnection(url, user, password);
                } catch (ClassNotFoundException e) {
                    System.out.println("Class Not Found :" + e.getMessage());
                } catch (SQLException e) {
                    System.out.println("SQL Error : " + e.getMessage());
                }
            } else {
                System.out.println("Already Connect");
            }
        }
}

