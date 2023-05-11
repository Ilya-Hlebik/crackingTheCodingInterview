package Ch_07_Object_Oriented_Design.Q7_05_Online_Book_Reader;

import java.util.HashMap;

public class UserManager {
    private HashMap<Integer, User> users = new HashMap<>();

    public User addUser(int id, String name, Membership membership) {
        return users.putIfAbsent(id, new User(id, name, membership));
    }

    public boolean removeUser(User user) {
        return remove(user.getId());
    }

    private boolean remove(int id) {
        if (!users.containsKey(id)) {
            return false;
        }
        users.remove(id);
        return true;
    }

    public User find(int id) {
        return users.get(id);
    }
}
