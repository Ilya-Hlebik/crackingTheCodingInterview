package Ch_03_Stacks_and_Queues.Q3_06_Animal_Shelter;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        AnimalQueue animals = new AnimalQueue();
        animals.enqueue(new Cat("Callie"));
        animals.enqueue(new Cat("Kiki"));
        animals.enqueue(new Dog("Fido"));
        animals.enqueue(new Dog("Dora"));
        animals.enqueue(new Cat("Kari"));
        animals.enqueue(new Dog("Dexter"));
        animals.enqueue(new Dog("Dobo"));
        animals.enqueue(new Cat("Copa"));
        System.out.println();
        System.out.println(animals.dequeueAny().name());
        System.out.println(animals.dequeueAny().name());
        System.out.println(animals.dequeueAny().name());
        System.out.println();
        animals.enqueue(new Dog("Dapa"));
        animals.enqueue(new Cat("Kilo"));

        while (animals.size() != 0) {
            System.out.println(animals.dequeueAny().name());
        }
    }


}

class AnimalQueue {
    Queue<Animal> queue = new LinkedList<>();

    public void enqueue(Animal animal) {
        queue.add(animal);
    }

    public Animal dequeueAny() {
        return queue.poll();
    }

    public Cat dequeueCat() {
        Animal poll = queue.poll();
        if (poll instanceof Cat) {
            return (Cat) poll;
        }
        Queue<Animal> tempQueue = new LinkedList<>();
        tempQueue.add(poll);
        while (!(queue.peek() instanceof Cat)) {
            tempQueue.add(queue.poll());
        }
        Cat toReturn = (Cat) tempQueue.poll();
        while (queue.isEmpty()) {
            tempQueue.add(queue.poll());
        }
        queue = tempQueue;
        return toReturn;
    }

    public Dog dequeueDog() {
        return queue.poll();
    }


    public int size() {
        return queue.size();
    }
}

class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
}

class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }
}
