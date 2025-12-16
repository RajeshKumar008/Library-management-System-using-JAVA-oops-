package Model;

public class User {
    private String UserID;
    private String Name;

    public User(String UserID, String Name){
        this.UserID = UserID;
        this.Name = Name;
    }

    public String getUserId(){
        return UserID;
    }
    public String getName(){
        return Name;
    }

    public void SetUserId(String UserID){
        this.UserID = UserID;
    }
    public void SetName(String Name){
        this.Name = Name;
    }

    public String PrintUserDetails(String UserID, String Name){
        return "UserID: " +UserID + " | Name: " +Name;
    }
    
}
