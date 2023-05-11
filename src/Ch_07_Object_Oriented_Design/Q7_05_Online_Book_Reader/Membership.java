package Ch_07_Object_Oriented_Design.Q7_05_Online_Book_Reader;

public enum Membership {
    Essential(0), Premium(1);
    int priority;

    Membership(int priority) {
        this.priority = priority;
    }
}
