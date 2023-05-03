package Ch_07_Object_Oriented_Design.Q7_02_Call_Center;

public class Call {
    private Rank rank;
    private Employee handler;
    public Call( ) {
        rank = Rank.Respondent;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Employee getHandler() {
        return handler;
    }

    public void setHandler(Employee handler) {
        this.handler = handler;
    }
}
