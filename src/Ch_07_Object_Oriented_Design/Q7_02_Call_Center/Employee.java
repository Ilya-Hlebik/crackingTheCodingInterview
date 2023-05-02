package Ch_07_Object_Oriented_Design.Q7_02_Call_Center;

public class Employee {
    private boolean isAvailable;
    private Call call;

    public Call getCall() {
        return call;
    }

    public void setCall(Call call) {
        this.call = call;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
