package Model;

public class BookMain {
    private int Id;
    private String Title;
    private String Author;
    private int AvailableCount;

    public BookMain(int Id, String Title, String Author,int AvailableCount){
        this.Id = Id;
        this.Title = Title;
        this.Author = Author;
        this.AvailableCount = AvailableCount;

    }
    
    public int GetId(){
        return Id;
    }
    public String GetTitle(){
        return Title;
    }
    public String GetAuthor(){
        return Author;
    }
    public int GetAvailableCount(){
        return AvailableCount;
    }

    public void SetId(int Id){
        this.Id = Id;
    }
    public void SetTitle(String Title){
        this.Title = Title;
    }
    public void SetAuthor(String Author){
        this.Author = Author;
    }
    public void SetAvailableCount(int AvailableCount){
        this.AvailableCount = AvailableCount;
    }

    public String GetBookDetails(){
        return "ID: " +Id + " | Title: " +Title + " | Author: " +Author + " | AvailableCount: " +AvailableCount;
    }

}
    

