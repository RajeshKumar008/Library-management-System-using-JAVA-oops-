import Exceptions.*;
import Model.*;
import Service.*;

import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Library lib = new Library();

        System.out.println("Enter UserID: ");
        String UserID = sc.nextLine();

        System.out.println("Enter the User Name: ");
        String Name = sc.nextLine();

        User Us = new User(UserID, Name);

        while (true) {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Display All Books");
            System.out.println("4. Search Book by Title");
            System.out.println("5. Borrow Book");
            System.out.println("6. Return Book");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Book ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Title: ");
                        String title = sc.nextLine();

                        System.out.print("Enter Author: ");
                        String author = sc.nextLine();

                        System.out.print("Enter Available Count: ");
                        int count = sc.nextInt();

                        lib.addBook(new BookMain(id, title, author, count));
                        break;

                    case 2:
                        System.out.println("Enter the BookID to Remove: ");
                        int Removed = sc.nextInt();
                        lib.removeBook(Removed);
                        break;
                    
                    case 3:
                        lib.DisplayAllBook();
                        break;
                    
                    case 4:
                         System.out.print("Enter Book Title: ");
                        String searchTitle = sc.nextLine();

                        BookMain book = lib.GetBookDetails(searchTitle);
                        if (book != null) {
                            System.out.println(book.GetBookDetails());
                        } else {
                            System.out.println("Book not found!");
                        }
                        break;

                    case 5:
                        System.out.println("Enter the ID for Borrow Book: ");
                        lib.borrowBook(Us, sc.nextInt());
                        break;

                    case 6:
                        System.out.println("Enter Book ID to Return: ");
                        lib.rerurnBook(Us, sc.nextInt());
                        break;

                    case 0:
                        System.out.println("Good Bye " +Us.getName());
                        sc.close();
                        return;

                
                    default:
                        System.out.println("Invalid Choice !");
                }
            } catch (BookNotFoundException | OutOfStockException e) {
                // TODO: handle exception
                System.out.println("Error: " +e.getMessage());
            }

        }
    }
    
}
