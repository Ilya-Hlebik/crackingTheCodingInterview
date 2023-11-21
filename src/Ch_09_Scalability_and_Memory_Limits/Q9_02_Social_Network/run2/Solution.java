package Ch_09_Scalability_and_Memory_Limits.Q9_02_Social_Network.run2;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int nPeople = 11;
        HashMap<Integer, Person> people = new HashMap<Integer, Person>();
        for (int i = 0; i < nPeople; i++) {
            Person p = new Person(i);
            people.put(i, p);
        }

        int[][] edges = {{1, 4}, {1, 2}, {1, 3}, {3, 2}, {4, 6}, {3, 7}, {6, 9}, {9, 10}, {5, 10}, {2, 5}, {3, 7}};

        for (int[] edge : edges) {
            Person source = people.get(edge[0]);
            source.addFriend(edge[1]);

            Person destination = people.get(edge[1]);
            destination.addFriend(edge[0]);
        }

        int i = 1;
        int j = 10;
        List<Person> path1 = findPathBFS(people, i, j);
        printPeople(path1);
    }

    public static void printPeople(List<Person> path) {
        if (path == null) {
            System.out.println("No path");
        } else {
            for (Person p : path) {
                System.out.println(p.getId());
            }
        }
    }

    private static List<Person> findPathBFS(HashMap<Integer, Person> people, int i, int j) {
        Person person1 = people.get(i);
        Person person2 = people.get(j);
        Queue<Node> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(new Node(person1, null));
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            visited.add(poll.getPerson().getId());
            if (poll.getPerson().getId() == person2.getId()) {
                return poll.collapse();
            }
            poll.getPerson().getFriends()
                    .stream()
                    .filter(integer -> !visited.contains(integer))
                    .forEach(integer -> queue.add(new Node(people.get(integer), poll)));
        }
        return null;
    }
}

class Person {
    private int id;
    private String name;
    List<Integer> friends = new ArrayList();

    public Person(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getFriends() {
        return friends;
    }

    public void setFriends(List<Integer> friends) {
        this.friends = friends;
    }

    public void addFriend(int i) {
        friends.add(i);
    }
}

class Node {
    private Person person;
    private Node previous;

    public Node(Person person, Node previous) {
        this.person = person;
        this.previous = previous;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public LinkedList<Person> collapse() {
        LinkedList<Person> result = new LinkedList<>();
        Node node = this;
        while (node != null) {
            result.addFirst(node.getPerson());
            node = node.getPrevious();
        }
        return result;
    }
}
