package Ch_07_Object_Oriented_Design.Q7_07_Chat_Server;

import java.util.ArrayList;
import java.util.List;

public class User {
    private long id;
    private String name;
    private String login;
    private UserStatus userStatus;
    private List<Conversation> conversationList = new ArrayList<>();
    private List<User> friends;

    public User(long id, String name, String login) {
        this.id = id;
        this.name = name;
        this.login = login;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void updateUserStatus(UserStatus userStatus){
        this.userStatus = userStatus;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public List<Conversation> getConversationList() {
        return conversationList;
    }
    public void addConversation(Conversation conversation){

    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }
}
