package Service;

import java.util.*;

import Exceptions.BookNotFoundException;
import Exceptions.OutOfStockException;
import Model.BookMain;
import Model.User;


public class Library {
    private List<BookMain> books;

    public Library(){
        books = new ArrayList<>();
    }
    
    public void addBook(BookMain book){
        books.add(book);
        System.out.println("Book Added Successfully.");

    }

    public void removeBook(int bookId){
        BookMain book = findBookById(bookId);
        
        if(book != null){
            books.remove(book);
            System.out.println("Book Removed Successfully.");
        }
        else{
            System.out.println("Book Not Found !");
        }
    }

    public BookMain SearchBookById(String Title){
        for(BookMain book: books){
            if(book.GetTitle().equalsIgnoreCase(Title)){
                return book;
            }
        }
        return null;
    }

    public void borrowBook(User user, int bookId) throws BookNotFoundException, OutOfStockException{
        
        BookMain book = findBookById(bookId);

        if(book == null){
            throw new BookNotFoundException("Book With ID: " +bookId+ "not Found !");
        }

        if (book.GetAvailableCount() <= 0) {
            throw new OutOfStockException("Book is Out of Stock !");
        }
        book.SetAvailableCount(book.GetAvailableCount() - 1);
        System.out.println(user.getName() + "Borrowed the book Successfully");
    }

    public void rerurnBook(User user, int bookId) throws BookNotFoundException{
        BookMain book = findBookById(bookId);

        if(book == null){
           throw new BookNotFoundException("Invalid book ID !");
        }

        book.SetAvailableCount(book.GetAvailableCount() + 1);
        System.out.println(user.getName()+ "returned the Book Successfully !");
    }

    public void DisplayAllBook(){
        System.out.println("\n ------------- Library Books --------------");
        if (books.isEmpty()) {
            System.out.println("No Book Available !");
        }
        else{
            for(BookMain book : books){
                System.out.println(book.GetBookDetails());
            }
        }
        System.out.println("-------------------------------------");
    }

    private BookMain findBookById(int id){
        for(BookMain book : books){
            if(book.GetId() == id){
                return book;
            }
        }
        return null;
    }

    public BookMain GetBookDetails(String searchTitle)throws BookNotFoundException {
        // TODO Auto-generated method stub
        for (BookMain book : books) {
        if (book.GetTitle().equalsIgnoreCase(searchTitle)) {
            return book;
        }
    }
    throw new BookNotFoundException("Book with title '" + searchTitle + "' not found");
    }
    
}
