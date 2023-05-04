package Ch_07_Object_Oriented_Design.Q7_03_Jukebox;

/*entity*/
public class User {
    private String name;
    private long ID;

    public User(String name, long ID) {
        this.name = name;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }
}
