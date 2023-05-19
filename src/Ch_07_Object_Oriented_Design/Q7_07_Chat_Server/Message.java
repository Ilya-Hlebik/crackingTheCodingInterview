package Ch_07_Object_Oriented_Design.Q7_07_Chat_Server;

import java.util.Date;

public class Message {
    private long id;
    private final String content;
    private final Date date = new Date();
    private User originator;

    public Message(String content, User originator) {
        this.content = content;
        this.originator = originator;
    }

    public String getContent() {
        return content;
    }

    public Date getDate() {
        return date;
    }

    public long getId() {
        return id;
    }

    public User getOriginator() {
        return originator;
    }
}
