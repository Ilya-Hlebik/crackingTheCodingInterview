package Ch_15_Threads_and_Locks.Q15_07_FizzBuzz;

public class Solution {
    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        int maxNumber = 100;
        MyRunnableDivisionBy3 myRunnable1 = new MyRunnableDivisionBy3(fizzBuzz, maxNumber);
        MyRunnableDivisionBy5 myRunnable2 = new MyRunnableDivisionBy5(fizzBuzz, maxNumber);
        MyRunnableDivisionBy3And5 myRunnable3 = new MyRunnableDivisionBy3And5(fizzBuzz, maxNumber);
        MyRunnableDivisionNumbers myRunnable4 = new MyRunnableDivisionNumbers(fizzBuzz, maxNumber);

        Thread thread1 = new Thread(myRunnable1);
        Thread thread2 = new Thread(myRunnable2);
        Thread thread3 = new Thread(myRunnable3);
        Thread thread4 = new Thread(myRunnable4);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}

class FizzBuzz {

    public boolean checkDivisionBy3(int number) {
        return number % 3 == 0;
    }

    public boolean checkDivisionBy5(int number) {
        return number % 5 == 0;
    }
}

class MyRunnableDivisionBy3 implements Runnable {
    private final FizzBuzz fizzBuzz;
    private final int number;

    public MyRunnableDivisionBy3(FizzBuzz fizzBuzz, int number) {
        this.fizzBuzz = fizzBuzz;
        this.number = number;
    }

    @Override
    public void run() {
        int current = 1;
        while (current <= number) {
            if (fizzBuzz.checkDivisionBy3(current) && !fizzBuzz.checkDivisionBy5(current)) {
                System.out.println(current + " Fizz");
            }
            current++;
        }
    }
}

class MyRunnableDivisionBy5 implements Runnable {
    private final FizzBuzz fizzBuzz;
    private final int number;

    public MyRunnableDivisionBy5(FizzBuzz fizzBuzz, int number) {
        this.fizzBuzz = fizzBuzz;
        this.number = number;
    }

    @Override
    public void run() {
        int current = 1;
        while (current <= number) {
            if (fizzBuzz.checkDivisionBy5(current) && !fizzBuzz.checkDivisionBy3(current)) {
                System.out.println(current + " Buzz");
            }
            current++;
        }
    }
}

class MyRunnableDivisionBy3And5 implements Runnable {
    private final FizzBuzz fizzBuzz;
    private final int number;

    public MyRunnableDivisionBy3And5(FizzBuzz fizzBuzz, int number) {
        this.fizzBuzz = fizzBuzz;
        this.number = number;
    }

    @Override
    public void run() {
        int current = 1;
        while (current <= number) {
            if (fizzBuzz.checkDivisionBy3(current) && fizzBuzz.checkDivisionBy5(current)) {
                System.out.println(current + " FizzBuzz");
            }
            current++;
        }
    }
}

class MyRunnableDivisionNumbers implements Runnable {
    private final FizzBuzz fizzBuzz;
    private final int number;

    public MyRunnableDivisionNumbers(FizzBuzz fizzBuzz, int number) {
        this.fizzBuzz = fizzBuzz;
        this.number = number;
    }

    @Override
    public void run() {
        int current = 1;
        while (current <= number) {
            if (!fizzBuzz.checkDivisionBy3(current) && !fizzBuzz.checkDivisionBy5(current)) {
                System.out.println(current);
            }
            current++;
        }
    }
}
