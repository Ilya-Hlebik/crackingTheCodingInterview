package Ch_07_Object_Oriented_Design.Q7_07_Chat_Server;

import java.util.List;

public class PrivateChat extends Conversation {
    public PrivateChat(User user1, User user2) {
        super(List.of(user1, user2));
    }
    public User getOtherParticipant(User primary){

        return null;
    }
}
