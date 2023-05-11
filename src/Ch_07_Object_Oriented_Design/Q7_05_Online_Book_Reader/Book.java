package Ch_07_Object_Oriented_Design.Q7_05_Online_Book_Reader;

public class Book {
    private int id;
    private String name;
    private String author;
    private String content;

    public Book(int id, String name, String author, String content) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
