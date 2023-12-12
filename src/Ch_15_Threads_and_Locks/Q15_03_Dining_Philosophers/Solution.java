package Ch_15_Threads_and_Locks.Q15_03_Dining_Philosophers;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Solution {
    public static void main(String[] args) {
        Chopstick one = new Chopstick();
        Chopstick two = new Chopstick();
        Chopstick tree = new Chopstick();
        Chopstick four = new Chopstick();
        Chopstick five = new Chopstick();
        Philosopher philosopher1 = new Philosopher(two, one);
        Philosopher philosopher2 = new Philosopher(tree, two);
        Philosopher philosopher3 = new Philosopher(four, tree);
        Philosopher philosopher4 = new Philosopher(five, four);
        Philosopher philosopher5 = new Philosopher(one, five);
        philosopher1.start();
        philosopher2.start();
        philosopher3.start();
        philosopher4.start();
        philosopher5.start();
    }
}

class Chopstick {
    private Lock lock = new ReentrantLock();

    public boolean pickup() {
        return lock.tryLock();
    }

    public void putDown() {
        lock.unlock();
    }
}

class Philosopher extends Thread {
    private int bites = 10;
    private Chopstick left, right;

    public Philosopher(Chopstick left, Chopstick right) {
        this.left = left;
        this.right = right;
    }

    public void eat() {
        if (pickUp()) {
            chew();
            putDown();
        }
    }

    private void putDown() {
        right.putDown();
        left.putDown();
    }

    private void chew() {
    }

    private boolean pickUp() {
        if (!left.pickup()) {
            return false;
        }
        if (!right.pickup()) {
            left.putDown();
            return false;
        }
        return true;
    }

    @Override
    public void run() {
        for (int i = 0; i < bites; i++) {
            eat();
        }
    }
}
