package Ch_15_Threads_and_Locks.Q15_07_FizzBuzz;

import java.util.function.Function;
import java.util.function.Predicate;

public class Solution {
    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        int maxNumber = 100;
        DivisionNumbers myRunnable1 = new DivisionNumbers(maxNumber, current -> fizzBuzz.checkDivisionBy3(current) && !fizzBuzz.checkDivisionBy5(current), current -> current + " Fizz");
        DivisionNumbers myRunnable2 = new DivisionNumbers(maxNumber, current -> fizzBuzz.checkDivisionBy5(current) && !fizzBuzz.checkDivisionBy3(current), current -> current + " Buzz");
        DivisionNumbers myRunnable3 = new DivisionNumbers(maxNumber, current -> fizzBuzz.checkDivisionBy3(current) && fizzBuzz.checkDivisionBy5(current), current -> current + " FizzBuzz");
        DivisionNumbers myRunnable4 = new DivisionNumbers(maxNumber, current -> !fizzBuzz.checkDivisionBy3(current) && !fizzBuzz.checkDivisionBy5(current), String::valueOf);

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

class DivisionNumbers implements Runnable {
    private final int number;
    private final Predicate<Integer> function;
    private final Function<String, String> functionPrint;
    private static int current = 1;

    protected DivisionNumbers(int number, Predicate<Integer> predicate, Function<String, String> functionPrint) {
        this.number = number;
        this.function = predicate;
        this.functionPrint = functionPrint;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (DivisionNumbers.class) {
                if (current > number) {
                    return;
                }
                if (function.test(current)) {
                    System.out.println(functionPrint.apply(String.valueOf(current)));
                    current++;
                }

            }
        }
    }
}
