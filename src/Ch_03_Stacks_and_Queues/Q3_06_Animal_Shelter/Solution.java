package Ch_03_Stacks_and_Queues.Q3_06_Animal_Shelter;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

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
    Queue<Cat> cats = new LinkedList<>();
    Queue<Dog> dogs = new LinkedList<>();
    int count;

    public void enqueue(Animal animal) {
        count++;
        animal.setCount(count);
        if (animal instanceof Cat) {
            cats.add((Cat) animal);
        } else {
            dogs.add((Dog) animal);
        }
    }

    public Animal dequeueAny() {
        if (cats.isEmpty()) {
            return dequeueDog();
        } else if (dogs.isEmpty()) {
            return dequeueCat();
        }
        Cat cat = cats.peek();
        Dog dog = dogs.peek();
        if (cat.count > dog.count) {
            return dequeueCat();
        } else if (cat.count < dog.count) {
            return dequeueDog();
        }
        int i = new Random().nextInt(2);
        return i == 0 ? dequeueDog() : dequeueCat();
    }

    public Cat dequeueCat() {
        if (cats.isEmpty()) {
            throw new RuntimeException("No Cats was present");
        }
        return cats.poll();
    }

    public Dog dequeueDog() {
        if (dogs.isEmpty()) {
            throw new RuntimeException("No Dogs was present");
        }
        return dogs.poll();
    }


    public int size() {
        return cats.size() + dogs.size();
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
    public int count;
    private String name;

    public void setCount(int count) {
        this.count = count;
    }

    public Animal(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }
}
