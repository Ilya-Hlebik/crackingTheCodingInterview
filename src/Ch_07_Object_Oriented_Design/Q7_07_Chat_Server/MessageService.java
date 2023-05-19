package Ch_07_Object_Oriented_Design.Q7_07_Chat_Server;

import java.util.List;

public class MessageService {

    public Message sendDirectMessageToUser(User from, User to, String message) {
        /*check conversations with this user*/
        /*create if not exists, or add new*/
        List<Conversation> conversationList = from.getConversationList();
        Message messageObject = new Message(message, from);
        conversationList.stream()
                .filter(conversation -> conversation.getParticipants().contains(to))
                .filter(conversation -> conversation instanceof PrivateChat)
                .findFirst()
                .ifPresentOrElse(conversation -> conversation.addMessage(messageObject), () -> {
                    Conversation conversation = new PrivateChat(from, to);
                    conversation.addMessage(messageObject);
                });
        return messageObject;
    }

    public Message sendMessageToGroupChat(User from, long conversationId, String message) {
        /*check conversations with this group*/
        /*create if not exists, or add new*/
        Message messageObject = new Message(message, from);
        from.getConversationList()
                .stream()
                .filter(conversation -> conversation.getId() == conversationId)
                .findFirst().ifPresent(conversation -> conversation.addMessage(messageObject));

        return messageObject;
    }
}
