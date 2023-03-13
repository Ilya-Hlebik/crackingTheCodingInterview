package Ch_03_Stacks_and_Queues.Q3_05_Sort_Stack;
import CtCILibrary.AssortedMethods;

import java.util.Stack;

public class Solution {
    public static void main(String [] args) {
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < 10; i++) {
            int r = AssortedMethods.randomIntInRange(0,  1000);
            s.push(r);
        }

        sort(s);

        while(!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    private static void sort(Stack<Integer> s) {

    }
}
