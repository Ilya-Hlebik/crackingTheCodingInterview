package Ch_07_Object_Oriented_Design.Q7_05_Online_Book_Reader;

import java.util.HashMap;

public class Library {
    private final HashMap<Integer, Book> books = new HashMap<>();

    public Book addBook(int id, String name, String author, String content) {
        return books.putIfAbsent(id, new Book(id, name, author, content));
    }

    public boolean removeBook(Book book) {
        return remove(book.getId());
    }

    private boolean remove(int id) {
        if (!books.containsKey(id)) {
            return false;
        }
        books.remove(id);
        return true;
    }

    public Book find(int id) {
        return books.get(id);
    }
}
