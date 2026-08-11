import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookManager manager = new BookManager();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to the Book Manager!");

  
        while (running) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Add a Book");
            System.out.println("2. Display All Books");
            System.out.println("3. Search for a Book");
            System.out.println("4. Delete a Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) 
            {
                case 1:
                    manager.addBook();
                    break;
                case 2:
                    manager.display();
                    break;
                case 3:
                
                    manager.searchBook(); 
                    System.out.println(".......");
                    break;
                case 4:
                    manager.deleteBook();
                    break;
                case 5:
                    System.out.println("Saving data...");
                    running = false; 
                    break;
                default:
                    
                    System.out.println("Invalid choice! Please select a number from 1 to 5.");
            }
        }
        
        sc.close(); 
    }
}
