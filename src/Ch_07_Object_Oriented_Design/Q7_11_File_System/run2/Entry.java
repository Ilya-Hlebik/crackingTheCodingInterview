package Ch_07_Object_Oriented_Design.Q7_11_File_System.run2;

public abstract class Entry {
    public String name;
    public Directory parent;

    public Entry(String name, Directory parent) {
        this.name = name;
        this.parent = parent;
    }


    public String getFullPath() {
        if (parent == null) {
            return name;
        }
        String fullPath = parent.getFullPath();
        fullPath = fullPath + "/" + name;
        return fullPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Directory getParent() {
        return parent;
    }

    public void setParent(Directory parent) {
        this.parent = parent;
    }
    public boolean delete() {
        if (parent == null) {
            return false;
        }
        return parent.deleteEntry(this);
    }

    public abstract int size();
}
