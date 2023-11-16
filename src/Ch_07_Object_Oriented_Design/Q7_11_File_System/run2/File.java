package Ch_07_Object_Oriented_Design.Q7_11_File_System.run2;

public class File extends Entry {
    private int size;

    public File(String name, Directory parent, int size) {
        super(name, parent);
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public int size() {
        return size;
    }
}
