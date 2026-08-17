package ui;

import dao.BookManager;
import model.Ebook;
import java.util.List;
import java.util.Scanner;

public class BookConsoleUI {
    private final BookManager bookManager = new BookManager();
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        boolean running = true;

        while (running) {
            System.out.println("\n=================================");
            System.out.println("   📚 READSCAPE CONSOLE MENU   ");
            System.out.println("=================================");
            System.out.println("1. View All Books");
            System.out.println("2. Search Book by Title");
            System.out.println("3. Add New Book");
            System.out.println("4. Update Book Details");
            System.out.println("5. Delete Book by ID");
            System.out.println("6. Exit");
            System.out.print("Select an option (1-6): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    viewAllBooks();
                    break;
                case 2:
                    searchBooks();
                    break;
                case 3:
                    addNewBook();
                    break;
                case 4:
                    updateBookDetails();
                    break;
                case 5:
                    deleteBook();
                    break;
                case 6:
                    System.out.println("Exiting Readscape... Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
        scanner.close();
    }

    private void viewAllBooks() {
        System.out.println("\n--- ALL EBOOKS ---");
        List<Ebook> books = bookManager.getBooks();
        if (books.isEmpty()) {
            System.out.println("No books found in database.");
        } else {
            for (Ebook book : books) {
                printBook(book);
            }
        }
    }

    private void searchBooks() {
        System.out.print("\nEnter title keyword to search: ");
        String keyword = scanner.nextLine();
        List<Ebook> results = bookManager.searchByTitle(keyword);

        if (results.isEmpty()) {
            System.out.println("No books matching '" + keyword + "' found.");
        } else {
            System.out.println("\nFound " + results.size() + " matching book(s):");
            for (Ebook book : results) {
                printBook(book);
            }
        }
    }

    private void addNewBook() {
        System.out.println("\n--- ADD NEW EBOOK ---");
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Author: ");
        String author = scanner.nextLine();
        
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); 

        System.out.print("File Size (MB): ");
        double fileSize = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Page Numbers: ");
        int pageNums = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("File Path: ");
        String filePath = scanner.nextLine();
        System.out.print("Cover Image URL/Path: ");
        String coverImage = scanner.nextLine();
        System.out.print("Description: ");
        String description = scanner.nextLine();
        System.out.print("Ambient Track Name: ");
        String ambientTrack = scanner.nextLine();
        System.out.print("Category: ");
        String category = scanner.nextLine();

        Ebook newBook = new Ebook(0, title, author, price, fileSize, pageNums, filePath, coverImage, description, ambientTrack, category);
        bookManager.addBook(newBook);
    }

    private void updateBookDetails() {
        System.out.print("\nEnter the ID of the book to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        System.out.println("Enter NEW details for Book ID " + id + ":");
        System.out.print("New Title: ");
        String title = scanner.nextLine();
        System.out.print("New Author: ");
        String author = scanner.nextLine();
        
        System.out.print("New Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); 

        System.out.print("New File Size (MB): ");
        double fileSize = scanner.nextDouble();
        scanner.nextLine(); 

        System.out.print("New Page Numbers: ");
        int pageNums = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("New File Path: ");
        String filePath = scanner.nextLine();
        System.out.print("New Cover Image: ");
        String coverImage = scanner.nextLine();
        System.out.print("New Description: ");
        String description = scanner.nextLine();
        System.out.print("New Ambient Track: ");
        String ambientTrack = scanner.nextLine();
        System.out.print("New Category: ");
        String category = scanner.nextLine();

        Ebook updatedBook = new Ebook(id, title, author, price, fileSize, pageNums, filePath, coverImage, description, ambientTrack, category);
        bookManager.updateBook(updatedBook);
    }

    private void deleteBook() {
        System.out.print("\nEnter the ID of the book to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        
        bookManager.deleteBook(id);
    }

    private void printBook(Ebook b) {
        System.out.println("ID: " + b.getId() + " | Title: " + b.getTitle() + " | Author: " + b.getAuthor() +
                           " | Category: " + b.getCategory() + " | Price: $" + b.getPrice() + " | Track: " + b.getAmbient_track());
    }
}