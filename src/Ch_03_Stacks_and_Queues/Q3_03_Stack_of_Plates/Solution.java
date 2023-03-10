package Ch_03_Stacks_and_Queues.Q3_03_Stack_of_Plates;

public class Solution {
    public static void main(String[] args) {
        int capacity_per_substack = 5;
        SetOfStacks set = new SetOfStacks(capacity_per_substack);
        for (int i = 0; i < 34; i++) {
            set.push(i);
        }
        System.out.println(set.popAt(2));
        System.out.println();
        for (int i = 0; i < 35; i++) {
            System.out.println("Popped " + set.pop());
        }
    }
}
