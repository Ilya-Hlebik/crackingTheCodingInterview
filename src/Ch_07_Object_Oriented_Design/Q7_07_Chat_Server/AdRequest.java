package Ch_07_Object_Oriented_Design.Q7_07_Chat_Server;

public class AdRequest {
    private User fromUser;
    private User toUser;
    private RequestStatus status;

    public AdRequest(User fromUser, User toUser, RequestStatus status) {
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.status = status;
    }

    public User getFromUser() {
        return fromUser;
    }

    public void setFromUser(User fromUser) {
        this.fromUser = fromUser;
    }

    public User getToUser() {
        return toUser;
    }

    public void setToUser(User toUser) {
        this.toUser = toUser;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }
}
