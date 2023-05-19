package Ch_07_Object_Oriented_Design.Q7_07_Chat_Server;

import java.util.ArrayList;
import java.util.List;

public class Conversation {
    private long id;
    private final List<Message> messageList = new ArrayList<>();
    private final List<User> participants;

    public Conversation(List<User> participants) {
        this.participants = participants;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void addMessage(Message message) {
        messageList.add(message);
    }

    public long getId() {
        return id;
    }
}
