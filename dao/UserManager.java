package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import config.DatabaseHelper;
import model.User;

public class UserManager
{
    public boolean register(User user)
    {
        String sql = "INSERT INTO USER(username,password,role);" + "VALUES(?,?,?)";

        try(Connection conn = DatabaseHelper.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql))
        {

            stmt.setString(1,user.getUser());
            stmt.setString(2,user.getPassword());
            stmt.setString(3,user.getRole());

            int rowsInserted = stmt.executeUpdate();
            if(rowsInserted>0)
            {
                return true;
            }


        }
        catch(SQLException e)
        {
            System.out.println("Failed to Regsiter" + e.getMessage());
            return false;
        }
        return false;
    }






}
