package Ch_07_Object_Oriented_Design.Q7_11_File_System.run2;

import java.util.ArrayList;
import java.util.List;

public class Directory extends Entry {
    protected List<Entry> contents = new ArrayList<>();

    public Directory(String name, Directory parent) {
        super(name, parent);
    }

    @Override
    public int size() {
        int size = 0;
        for (Entry content : contents) {
            size += content.size();
        }
        return size;
    }

    public boolean deleteEntry(Entry entry) {
        return contents.remove(entry);
    }

    public void addEntry(Entry entry) {
        entry.setParent(this);
        contents.add(entry);
    }

    public int numberOfFiles() {
        int count = 0;
        for (Entry entry : contents) {
            if (entry instanceof Directory) {
                count++;
                count += ((Directory) entry).numberOfFiles();
            } else {
                count++;
            }
        }
        return count;
    }
}
