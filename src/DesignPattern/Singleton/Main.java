package DesignPattern.Singleton;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        try {
            // Get the only available instance
            ConfigManager db = (ConfigManager) ConfigManager.getInstance();
            Connection conn = ConfigManager.getInstance();

            if (conn != null) {
                System.out.println("Successfully connected to the database!");
                // Perform SQL operations here...
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
