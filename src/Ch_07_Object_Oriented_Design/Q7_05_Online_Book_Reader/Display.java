package Ch_07_Object_Oriented_Design.Q7_05_Online_Book_Reader;

public class Display {
    private int pageNumber = 0;
    private Book activeBook;
    private User activeUser;

    public void displayBook(Book book) {
        pageNumber = 0;
        activeBook = book;

        refreshTitle();
        refreshDetails();
        refreshPage();
    }

    private void refreshDetails() {
    }

    private void refreshPage() {

    }

    private void refreshTitle() {

    }

    public void displayUser(User user) {
        activeUser = user;
        refreshUsername();
    }

    private void refreshUsername() {
    }

    public void turnPageForward() {
        pageNumber++;
        refreshPage();
    }

    public void turnPageBackward() {
        pageNumber--;
        refreshPage();
    }
}
