package Ch_07_Object_Oriented_Design.Q7_11_File_System;

import java.util.ArrayList;
import java.util.List;

public class Directory extends Entry {
    protected List<Entry> contents;

    public Directory(String name, Directory parent) {
        super(name, parent);
        contents = new ArrayList<>();
    }

    public int size() {
        return contents
                .stream()
                .map(Entry::size)
                .mapToInt(value -> value)
                .sum();
    }

    public int numberOfFiles() {
        int count = 0;
        for (Entry content : contents) {
            if (content instanceof Directory) {
                count++;
                count += ((Directory) content).numberOfFiles();
            } else if (content instanceof File) {
                count++;
            }
        }
        return count;
    }

    public boolean deleteEntry(Entry entry) {
        return contents.remove(entry);
    }

    public void addEntry(Entry entry) {
        contents.add(entry);
    }

    public List<Entry> getContents() {
        return contents;
    }
}
