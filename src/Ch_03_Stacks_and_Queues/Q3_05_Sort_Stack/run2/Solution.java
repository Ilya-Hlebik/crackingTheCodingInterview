package Ch_03_Stacks_and_Queues.Q3_05_Sort_Stack.run2;

import CtCILibrary.AssortedMethods;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < 10; i++) {
            int r = AssortedMethods.randomIntInRange(0, 1000);
            s.push(r);
        }

        sort(s);

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    private static void sort(Stack<Integer> stackToSort) {
        Stack<Integer> secondStack = new Stack<>();
        while (!stackToSort.isEmpty()) {
            secondStack.push(stackToSort.pop());
        }
        while (!secondStack.isEmpty()) {
            Integer pop = secondStack.pop();
            if (!stackToSort.isEmpty() && pop <= stackToSort.peek()) {
                stackToSort.push(pop);
            }
            else if (stackToSort.isEmpty()){
                stackToSort.push(pop);
            }
            else {
                while (!stackToSort.isEmpty() && pop > stackToSort.peek()){
                    secondStack.push(stackToSort.pop());
                }
                stackToSort.push(pop);
            }
        }
    }
}
