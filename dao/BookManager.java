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
        List<Ebook> bookList = new ArrayList<>();
        String sql = "SELECT * FROM Books";
        try(Connection conn = DatabaseHelper.getConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery())
        {
            while(rs.next())
            {
               Ebook book = new Ebook(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getString("author"),
                rs.getDouble("price"),
                rs.getDouble("file_size"),
                rs.getInt("page_nums"),
                rs.getString("file_path"),
                rs.getString("ambient_track"),
                rs.getString("description"),
                rs.getString("cover_image"),
                rs.getString("category")
            );
            bookList.add(book);

            }
        }
        catch(SQLException e)
        {
            System.err.println("❌ Error fetching books: " + e.getMessage());
        }
        return bookList;
    }

 
}
