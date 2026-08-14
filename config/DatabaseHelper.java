package config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHelper
{
    private static final String DB_url = "jdbc:mysql://localhost:3306/";
    private static final String DB_User = "root";
    private static final String DB_Pass = "root123";

    public static Connection getConnection() throws SQLException
    {
       return DriverManager.getConnection(DB_url, DB_User, DB_Pass);
    }

    public static void intializeDatabase()
    {

        try(Connection conn = getConnection();
        Statement stmt = conn.createStatement())
        {
            String createDB = "CREATE DATABASE IF NOT EXISTS readscape_db";
            stmt.executeUpdate(createDB);

            stmt.executeUpdate("USE readscape_db");

            String createTable = "CREATE TABLE IF NOT EXISTS Books ("+"id INT AUTO_INCREMENT PRIMARY KEY,"+"title VARCHAR(255) NOT NULL,"+"author VARCHAR(255) NOT NULL,"+"price DOUBLE NOT NULL,"+"file_size DOUBLE,"+"page_nums INT,"+"file_path VARCHAR(500), "+"ambeint_track VARCHAR(255)"+");";   
            stmt.executeUpdate(createTable);

            String audioTable = "CREATE TABLE IF NOT EXISTS Audio ("+"id INT AUTO_INCREMENT PRIMARY KEY,"+"track VARCHAR(255) NOT NULL,"+"artist VARCHAR(255) NOT NULL,"+"audio_url VARCHAR(500) NOT NULL" +");";
            stmt.executeUpdate(audioTable);
            System.out.println("DataBase is Ready!!"); 
       } catch(SQLException e)
       {
        System.out.println("Database Initialztion Failed :" +e.getMessage());
       }
    }

    public static void main(String[] args) {
    intializeDatabase();
}

}
