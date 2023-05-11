package Ch_07_Object_Oriented_Design.Q7_05_Online_Book_Reader;

public class OnlineReadingSystem {
    private Library library;
    private UserManager userManager;
    private Display display;

    private Book activeBook;
    private User activeUser;

    public OnlineReadingSystem() {
        library = new Library();
        userManager = new UserManager();
        display = new Display();
    }
    public void setActiveBook(Book book){
        display.displayBook(book);
        activeBook = book;
    }
    public void setActiveUser(User user){
        display.displayUser(user);
        activeUser = user;
    }
}
