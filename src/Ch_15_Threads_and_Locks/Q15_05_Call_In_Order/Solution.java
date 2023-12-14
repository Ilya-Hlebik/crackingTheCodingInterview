package Ch_15_Threads_and_Locks.Q15_05_Call_In_Order;

import java.util.concurrent.Semaphore;

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();
        MyThread thread1 = new MyThread(foo, "first");
        MyThread thread2 = new MyThread(foo, "second");
        MyThread thread3 = new MyThread(foo, "third");
        MyThread thread5 = new MyThread(foo, "first");
        MyThread thread6 = new MyThread(foo, "second");
        MyThread thread7 = new MyThread(foo, "third");
            thread3.start();
            thread2.start();
            thread1.start();
            Thread.sleep(5000);
        thread5.start();
        thread6.start();
        thread7.start();
    }
}

class Foo {
    Semaphore semaphore1, semaphore2;

    public Foo() throws InterruptedException {
        semaphore1 = new Semaphore(1);
        semaphore2 = new Semaphore(1);
        semaphore1.acquire();
        semaphore2.acquire();
    }

    public void first() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("First called");
        semaphore1.release();
    }

    public void second() throws InterruptedException {
        semaphore1.acquire();
        Thread.sleep(1000);
        System.out.println("Second called");
        semaphore2.release();
    }

    public void third() throws InterruptedException {
        semaphore2.acquire();
        Thread.sleep(1000);
        System.out.println("Third called");
    }
}

class MyThread extends Thread {
    private final Foo foo;
    private final String method;

    @Override
    public void run() {
        try {
            if ("first".equals(method)) {
                foo.first();
            }
            if ("second".equals(method)) {
                foo.second();
            }
            if ("third".equals(method)) {
                foo.third();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public MyThread(Foo foo, String method) {
        this.foo = foo;
        this.method = method;
    }
}
