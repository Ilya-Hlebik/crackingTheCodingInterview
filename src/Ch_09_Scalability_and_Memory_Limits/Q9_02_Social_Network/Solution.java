package Ch_09_Scalability_and_Memory_Limits.Q9_02_Social_Network;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    private static LinkedList<Person> getShortestPath(Person sourcePerson, Person destination){
        List<List<Node>> sourceSubFriends = new ArrayList<>();
        List<List<Node>> destinationSubFriends = new ArrayList<>();
        LinkedList<Person> result = new LinkedList<>();
        result.add(sourcePerson);
        Person sourceCopy = sourcePerson;
        Person destinationCopy = destination;
        Node sourceNode = new Node(sourcePerson);
        Node destinationNode = new Node(destination);

        while (true){
            sourceNode.setNext();
            List<Node> sourceNodeNext = sourceNode.getNext();

            List<Node> destinationNodeNext = destinationNode.getNext();
            sourceSubFriends.add(sourceNodeNext);
            destinationSubFriends.add(destinationNodeNext);

            if (sourceSubFriends
                    .stream().flatMap(Collection::stream)
                    .anyMatch(node -> destinationSubFriends.stream().flatMap(Collection::stream).anyMatch(node::equals))) {
                sourceSubFriends
                        .stream().flatMap(Collection::stream)
                        .anyMatch(node -> destinationSubFriends.stream().flatMap(Collection::stream).anyMatch(node::equals))
            }
            for (Node node : sourceNodeNext) {
                node.getPerson().equals()
            }
            if (friends.stream().anyMatch(friends1::contains)){
                Person person = friends.stream().filter(friends1::contains)
                        .findAny().get();
                result.add(person);
                result.add(destination);
                break;
            }
            sourcePerson.setFriends(friends);
            destination.setFriends(friends1);
            sourceCopy =
        }
        return result;
    }
    public static void main(String[] args) {
        Person source = new Person("source");
        Person notCommonFriend = new Person("test");
        Person com = new Person("com");
        notCommonFriend.setFriends(List.of(com));
        source.setFriends(List.of(notCommonFriend, new Person("test2")));

        Person destination = new Person("destination");
        destination.setFriends(List.of(com, new Person("test3"), new Person("test4")));
        LinkedList<Person> shortestPath = getShortestPath(source, destination);
        System.out.println(shortestPath);
    }
}

class Node{
    private List<Node> next;
    private Node previous;
    private Person person;

    public Node(Person person) {
        this.person = person;
    }

    public List<Node> getNext() {
        return next;
    }

    public void setNext(List<Node> next) {
        this.next = next;
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
}

class Person {
    private String name;
    private List<Person> friends;


    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getFriends() {
        return friends;
    }

    public void setFriends(List<Person> friends) {
        this.friends = friends;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
