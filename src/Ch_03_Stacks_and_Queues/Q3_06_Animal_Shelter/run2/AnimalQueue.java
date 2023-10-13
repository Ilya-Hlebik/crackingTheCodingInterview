package Ch_03_Stacks_and_Queues.Q3_06_Animal_Shelter.run2;

import java.util.LinkedList;
import java.util.Queue;

public class AnimalQueue {
    private final Queue<Dog> dogs = new LinkedList<>();
    private final Queue<Cat> cats = new LinkedList<>();

    public <T extends Animal> void enqueue(T animal) {
        if (animal instanceof Dog) {
            dogs.add((Dog) animal);
        } else {
            cats.add((Cat) animal);
        }
    }

    public Animal dequeueAny() {
        if (dogs.isEmpty()) {
            return cats.poll();
        } else if (cats.isEmpty()) {
            return dogs.poll();
        }
        if (dogs.peek().getMillisOfArrival() < cats.peek().getMillisOfArrival()) {
            return dogs.poll();
        }
        return cats.poll();
    }

    public int size() {
        return dogs.size() + cats.size();
    }

    public Animal dequeueDog() {
        return dogs.poll();
    }

    public Animal dequeueCat() {
        return cats.poll();
    }
}
