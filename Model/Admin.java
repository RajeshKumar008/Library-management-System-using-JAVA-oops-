package Model;

public class Admin extends User {

    public Admin(String UserID, String Name){
        super(UserID, Name);
    }

    public void addBook(){
        System.out.println("Admin Can Add Books: ");
    }

    public void removeBook(){
        System.out.println("Admin can Remove Book: ");
    }

    public void updateBooks(){
        System.out.println("Admin can update Books: ");
    }

    
}
