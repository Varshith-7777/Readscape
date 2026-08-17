package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import config.DatabaseHelper;
import model.Ebook;
import java.util.*;

public class BookManager {

    public void addBook(Ebook book) {
        String sql = "INSERT INTO Books (title, author, price, file_size, page_nums, file_path, ambient_track, description, cover_image, category) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setString(1, book.getTitle());
            pstm.setString(2, book.getAuthor());
            pstm.setDouble(3, book.getPrice());
            pstm.setDouble(4, book.getFilesize());
            pstm.setInt(5, book.getPageNums());
            pstm.setString(6, book.getFilePath());
            pstm.setString(7, book.getAmbient_track());
            pstm.setString(8, book.getDescription());
            pstm.setString(9, book.getCoverImage());
            pstm.setString(10, book.getCategory());

            int rowsInserted = pstm.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println(" Ebook '" + book.getTitle() + "' saved to MySQL successfully!");
            }
        } catch (SQLException e) {
            System.err.println(" Database Error inserting book: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Ebook> getBooks()
    {
       List<Ebook> books = new ArrayList<>();
       String sql = "SELECT * FROM Books";

       try(Connection conn = DatabaseHelper.getConnection();
           PreparedStatement stmt = conn.prepareStatement(sql);
           ResultSet rs = stmt.executeQuery())
           {

              while(rs.next())
            {

                Ebook book = new Ebook
                (
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("author"),
                    rs.getDouble("price"),
                    rs.getDouble("file_size"),
                    rs.getInt("page_nums"),
                    rs.getString("file_path"),
                    rs.getString("cover_image"),
                    rs.getString("description"),
                    rs.getString("ambient_track"),
                    rs.getString("category")
                );
                books.add(book);
             }
           }
           catch(SQLException e)
           {
            System.err.println("Database Error in rettriveing books:" + e.getMessage());
            e.printStackTrace();
           }
           return books;

    }


    public boolean deleteBook(int id)
    {
        String sql = "DELETE FROM Books WHERE id =?";

        try(Connection conn = DatabaseHelper.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql))
          {

            pstmt.setInt(1,id);

            int rowAffected = pstmt.executeUpdate();
            if(rowAffected>0)
            {
                System.out.println("Book with ID :"+id+"Has Been deleted Succesfully");
                return rowAffected>0;
            }
          }
          catch(SQLException e)
          {
            System.err.println("Failed to Delete Book From DataBase" + e.getMessage());
            return false;
          }
          
        return true;
 
    }


    public List<Ebook> searchByTitle(String Word)
    {
        String sql = "SELECT * FROM Books WHERE title LIKE ?";
        List<Ebook> books = new ArrayList<>();


        try(Connection conn = DatabaseHelper.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql)) 
        {
            pstmt.setString(1,"%"+Word+"%");
             ResultSet rs = pstmt.executeQuery();
             while(rs.next())
             {
                Ebook book = new Ebook (
                rs.getInt("id"),
                rs.getString("title"),
                rs.getString("author"),
                rs.getDouble("price"),
                rs.getDouble("file_size"),
                rs.getInt("page_nums"),
                rs.getString("file_path"),
                rs.getString("cover_image"),
                rs.getString("description"),
                rs.getString("ambient_track"),
                rs.getString("category"));

                books.add(book);
             }
          
        }
        catch(SQLException e)
        {
            System.err.println("Unable to Search" + e.getMessage());
        }
      return books;
    }



    public boolean updateBook(Ebook book)
    {
        String sql = "UPDATE SET Books title = ?, author = ?, price =?, file_size = ?,page_nums = ?, file_path = ?,cover_image=?, description =?, ambient_track =?, category =? WHERE id = ?";
        try(Connection conn = DatabaseHelper.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql))
            {
                pstmt.setString(1,book.getTitle());
                pstmt.setString(2, book.getAuthor());
                pstmt.setDouble(3, book.getPrice());
                pstmt.setDouble(4, book.getFilesize());
                pstmt.setInt(5, book.getPageNums());
                pstmt.setString(6, book.getFilePath());
                pstmt.setString(7, book.getCoverImage());
                pstmt.setString(8, book.getDescription());
                pstmt.setString(9, book.getAmbient_track());
                pstmt.setString(10, book.getCategory());

                pstmt.setInt(11, book.getId());

                int rowAffected = pstmt.executeUpdate();
                if(rowAffected>0)
                {
                    System.out.println("Book Updated Succesfully");
                    return true;
                }
            }
            catch(SQLException e)
            {
                System.err.println("Failed to Update Details"+e.getMessage());
                return false;
            }
        return false;
    }
}