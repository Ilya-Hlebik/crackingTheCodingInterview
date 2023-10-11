package Ch_03_Stacks_and_Queues.Q3_01_Three_in_One.run2;


import java.util.Arrays;
import java.util.EmptyStackException;

public class Solution {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>(new Integer[1]);
        stack.push(1, 1);
        stack.push(2, 1);
        stack.push(3, 2);
        System.out.println(stack.pop(1));
        System.out.println(stack.isEmpty(1));
        System.out.println(stack.pop(1));
        System.out.println(stack.isEmpty(1));
        stack.push(4, 1);
        stack.push(5, 2);
        System.out.println(stack.pop(1));
    }
}

class MyStack<T> {
    T[] val;
    int index = 0;

    public MyStack(T[] val) {
        this.val = val;
    }

    private StackNode stackNode1;
    private StackNode stackNode2;
    private StackNode stackNode3;

    public void push(T item, int stackNumber) {
        if (stackNumber > 3 || stackNumber < 1) {
            throw new RuntimeException("Stack not found");
        } else {
            add(stackNumber, item);
        }
    }

    private void add(int stackNumber, T item) {
        if (val.length <= index) {
            val = Arrays.copyOf(val, val.length * 2);
        }
        val[index] = item;
        StackNode newStackNode = new StackNode(index);
        newStackNode.next = getStackNodeByNumber(stackNumber);
        index++;
        if (stackNumber == 1) {
            stackNode1 = newStackNode;
        } else if (stackNumber == 2) {
            stackNode2 = newStackNode;
        } else if (stackNumber == 3) {
            stackNode3 = newStackNode;
        }
    }

    private StackNode getStackNodeByNumber(int stackNumber) {
        if (stackNumber == 1) {
            return stackNode1;
        } else if (stackNumber == 2) {
            return stackNode2;
        } else if (stackNumber == 3) {
            return stackNode3;
        } else {
            throw new RuntimeException("Stack not found");
        }
    }

    public T pop(int stackNumber) {
        if (stackNumber == 1) {
            if (stackNode1 == null) {
                return null;
            }
            int index = stackNode1.index;
            stackNode1 = stackNode1.next;
            return val[index];
        } else if (stackNumber == 2) {
            if (stackNode2 == null) {
                return null;
            }
            int index = stackNode2.index;
            stackNode2 = stackNode2.next;
            return val[index];
        } else if (stackNumber == 3) {
            if (stackNode3 == null) {
                return null;
            }
            int index = stackNode3.index;
            stackNode3 = stackNode3.next;
            return val[index];
        }
        return null;
    }

    public T peek(int stackNumber) {
        StackNode stackNodeByNumber = getStackNodeByNumber(stackNumber);
        if (stackNodeByNumber == null) throw new EmptyStackException();
        return val[stackNodeByNumber.index];
    }

    public boolean isEmpty(int stackNumber) {
        StackNode stackNodeByNumber = getStackNodeByNumber(stackNumber);
        return stackNodeByNumber == null;
    }

    static class StackNode {
        private StackNode next;
        int index;

        public StackNode(int index) {
            this.index = index;
        }
    }

}
