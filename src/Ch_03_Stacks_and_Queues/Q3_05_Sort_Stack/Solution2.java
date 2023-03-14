package Ch_03_Stacks_and_Queues.Q3_05_Sort_Stack;

import CtCILibrary.AssortedMethods;

import java.util.Stack;

public class Solution2 {
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

    public static void sort(Stack<Integer> s) {
        Stack<Integer> tempStack = new Stack<>();

        while (!s.isEmpty()) {
            if (!tempStack.isEmpty()) {
                Integer pop = s.pop();
                if (tempStack.peek() <= pop) {
                    tempStack.push(pop);
                } else {
                    while (true) {
                        if (tempStack.isEmpty() || tempStack.peek() <= pop) {
                            tempStack.push(pop);
                            break;
                        } else {
                            s.push(tempStack.pop());
                        }
                    }
                }
            } else {
                tempStack.push(s.pop());
            }
        }
        while (!tempStack.isEmpty()) {
            s.push(tempStack.pop());
        }
    }
}
