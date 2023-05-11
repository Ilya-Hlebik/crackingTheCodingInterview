package Ch_07_Object_Oriented_Design.Q7_05_Online_Book_Reader;

public class User {
    private int id;
    private String name;
    private Membership membership;

    public User(int id, String name, Membership membership) {
        this.id = id;
        this.name = name;
        this.membership = membership;
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

    public Membership getMembership() {
        return membership;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }
}
