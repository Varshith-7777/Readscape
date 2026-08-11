import java.util.*;

public class BookManager 
{

    //This is a class which does Book operations like adding book,updating,removing,deleting
    ArrayList<Book> books = new ArrayList<>();
    Scanner sc= new Scanner(System.in);
    void addBook()
    {
    
        System.out.println("Enter Title of book :");
        String title = sc.nextLine();
        System.out.println("Enter Author of book :");
        String author = sc.nextLine();
        System.out.println("Enter Price of book :");
        float price = sc.nextFloat();
        System.out.println("Enter FileSize of book :");
        int fileSize = sc.nextInt();
        System.out.println("Enter PageNo's of book :");
        int pageNum = sc.nextInt();
        sc.nextLine();
        books.add(new Ebook(title,author,price,fileSize,pageNum));
        System.out.println("Book added successfully!");

    }

    void searchBook()
    {
        System.out.println("Enter The Title of book You Want To Search :");
        String searchTitle = sc.nextLine();
         if (books.isEmpty()) 
        {
            System.out.println("No books found.");
            return;
        }
        for(Book i : books)
        {
            if(i.getTitle().contains(searchTitle))
            {
                i.display();
            }
        }
    }
    void updateBook()
    {
        System.out.println("Enter The Title of book You Want To Update :");
        String hj = sc.nextLine();
        





    }

    void deleteBook()
    {
        System.out.println("Enter The Title of book You Want To Delete :");
        String deleteTitle = sc.nextLine();
         if (books.isEmpty())
        {
            System.out.println("No books found.");
            return;
        }
        boolean removed = books.removeIf(target->target.getTitle().equalsIgnoreCase(deleteTitle));
        if(removed)
        {
            System.out.println("Book Deleted");
        }
        else{
            System.out.println("Failed to delete");
        }
    }




     public void display()
    {
        if (books.isEmpty()) {
            System.out.println("No books found.");
            return;
        }
        for(Book i : books)
        {
            i.display();
        }

    }


    
    
}
