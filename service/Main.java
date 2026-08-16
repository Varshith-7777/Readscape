package service;
import config.DatabaseHelper;
import model.*;
import dao.BookManager;
import java.util.*;

public class Main 
{
    public static void main(String[] args)
   {
        BookManager manager = new BookManager();
        DatabaseHelper.initializeDatabase();

        Ebook testBook = new Ebook(
            "Frankenstein",
            "Mary Shelley",
            "Gothic Horror",
            0.00,
            1.2,
            280,
            "/books/frankenstein.txt",
            "/images/frankenstein.jpg",
            "A monster created by a young scientist.",
            "/audio/rain_storm.mp3"
        );


        manager.addBook(testBook);

        List <Ebook> book1 = manager.getBooks();

        for(Ebook b : book1)
        {
            System.out.println("ID: " + b.getId() + " | Title: " + b.getTitle() + " | Author: " + b.getAuthor() + " | Category: " + b.getCategory());
        }



        }

 }

