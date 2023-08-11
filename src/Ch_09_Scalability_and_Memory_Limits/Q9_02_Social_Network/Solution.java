package Ch_09_Scalability_and_Memory_Limits.Q9_02_Social_Network;

import java.util.*;

public class Solution {

    public static LinkedList<Person> findPathBFS(HashMap<Integer, Person> people, int source, int destination) {
        Queue<Node> toVisit = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        toVisit.add(new Node(people.get(source), null));

        while (!toVisit.isEmpty()) {
            Node node = toVisit.poll();
            Person person = node.getPerson();
            visited.add(person.getId());
            if (person.getId() == destination) {
                return node.collapse(false);
            }
            List<Integer> friends = person.getFriends();
            friends.forEach(friendId -> {
                if (!visited.contains(friendId)) {
                    toVisit.add(new Node(people.get(friendId), node));
                }
            });
        }
        return null;
    }

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
        LinkedList<Person> path1 = findPathBFS(people, i, j);
        printPeople(path1);
    }

    public static void printPeople(LinkedList<Person> path) {
        if (path == null) {
            System.out.println("No path");
        } else {
            for (Person p : path) {
                System.out.println(p.getId());
            }
        }
    }
}

class Node {
    private Node previous;
    private Person person;

    public Node(Person person, Node previous) {
        this.person = person;
        this.previous = previous;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public LinkedList<Person> collapse(boolean startsWithRoot) {
        LinkedList<Person> result = new LinkedList<>();
        Node node = this;
        while (node != null) {
            if (startsWithRoot) {
                result.add(node.getPerson());
            } else {
                result.addFirst(node.getPerson());
            }
            node = node.getPrevious();
        }
        return result;
    }
}

class Person {
    private Integer id;
    private String name;
    private List<Integer> friends = new ArrayList<>();

    public Person(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addFriend(int id) {
        friends.add(id);
    }

    public List<Integer> getFriends() {
        return friends;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
