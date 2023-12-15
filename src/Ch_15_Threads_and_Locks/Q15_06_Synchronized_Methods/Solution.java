package Ch_15_Threads_and_Locks.Q15_06_Synchronized_Methods;

public class Solution {
    public static void main(String[] args) {
        Foo foo = new Foo();
        MyThread myThread1 = new MyThread(foo, "FOO");
        MyThread myThread2 = new MyThread(foo, "bar");
        myThread1.start();
        myThread2.start();
    }
}

class Foo {
    public synchronized void foo() throws InterruptedException {
        System.out.println("Foo begin");
        Thread.sleep(500);
        System.out.println("Foo end");
    }

    public void bar() throws InterruptedException {
        System.out.println("Bar begin");
        Thread.sleep(500);
        System.out.println("Bar end");
    }
}

class MyThread extends Thread {
    private final Foo foo;
    private final String method;

    public MyThread(Foo foo, String method) {
        this.foo = foo;
        this.method = method;
    }

    @Override
    public void run() {
        try {
            if ("FOO".equals(method)) {
                foo.foo();
            } else {
                foo.bar();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
