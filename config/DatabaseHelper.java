package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHelper {
    private static final String SERVER_URL = "jdbc:mysql://localhost:3306/";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/readscape_db";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "root123";

    // Used by BookManager to connect directly to readscape_db
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }

    public static void initializeDatabase() {
        // Step 1: Connect to MySQL server to ensure DB exists
        try (Connection conn = DriverManager.getConnection(SERVER_URL, DB_USER, DB_PASS);
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS readscape_db");
        } catch (SQLException e) {
            System.err.println("Database Creation Failed: " + e.getMessage());
            return;
        }

        // Step 2: Connect to readscape_db to create tables
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {

            String createBooksTable = "CREATE TABLE IF NOT EXISTS Books (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "title VARCHAR(255) NOT NULL, " +
                    "author VARCHAR(255) NOT NULL, " +
                    "category VARCHAR(100), " +
                    "price DOUBLE NOT NULL, " +
                    "file_size DOUBLE, " +
                    "page_nums INT, " +
                    "file_path VARCHAR(500), " +
                    "cover_image VARCHAR(500), " +
                    "description TEXT, " +
                    "ambient_track VARCHAR(255)" +
                    ");";
            stmt.executeUpdate(createBooksTable);

            String createAudioTable = "CREATE TABLE IF NOT EXISTS Audio (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "track VARCHAR(255) NOT NULL, " +
                    "artist VARCHAR(255) NOT NULL, " +
                    "audio_url VARCHAR(500) NOT NULL" +
                    ");";
            stmt.executeUpdate(createAudioTable);

            System.out.println("✅ Database & Tables initialized successfully!");
        } catch (SQLException e) {
            System.err.println("Table Initialization Failed: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        initializeDatabase();
    }
}