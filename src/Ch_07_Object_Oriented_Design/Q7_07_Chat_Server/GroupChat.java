package Ch_07_Object_Oriented_Design.Q7_07_Chat_Server;

import java.util.List;

public class GroupChat extends Conversation {
    public GroupChat(List<User> participants) {
        super(participants);
    }

    public void addParticipant(User user) {
        getParticipants().add(user);
    }
    public void removeUser(User user) {
        getParticipants().remove(user);
    }
}
