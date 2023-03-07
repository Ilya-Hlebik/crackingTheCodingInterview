package Ch_03_Stacks_and_Queues.Q3_01_Three_in_One;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Solution {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>(new Integer[1]);
        stack.push(1,1);
        stack.push(2,1);
        stack.push(3,2);
        System.out.println(stack.pop(1));
        System.out.println(stack.isEmpty(1));
        System.out.println(stack.pop(1));
        System.out.println(stack.isEmpty(1));

    }
}

class MyStack<T> {
    public T[] val;
    public int index = 0;

    private class StackNode {
        private StackNode next;
        private final int elemIndex;

        public StackNode(T data) {
            if (index > val.length - 1) {
                val = Arrays.copyOf(val, val.length * 2);
            }
            val[index] = data;
            elemIndex = index;
            index++;
        }

        public int getData() {
            return elemIndex;
        }
    }

    public MyStack(T[] val) {
        this.val = val;
    }

    private StackNode top1;

    private StackNode top2;

    private StackNode top3;

    public T pop(int stackNumber) {
        if (stackNumber == 1){
            if (top1 == null) throw new EmptyStackException();
            T item = val[top1.elemIndex];
            top1 = top1.next;
            return item;
        }
        else if (stackNumber == 2){
            if (top2 == null) throw new EmptyStackException();
            T item = val[top2.elemIndex];
            top2 = top2.next;
            return item;
        }
        else if (stackNumber == 3){
            if (top3 == null) throw new EmptyStackException();
            T item = val[top3.elemIndex];
            top3 = top3.next;
            return item;
        }
        else {
            throw new RuntimeException("unsupported");
        }
    }

    public void push(T item, int stackNumber) {
        StackNode t = new StackNode(item);
        t.next = getStuckByNumber(stackNumber);
        switch (stackNumber) {
            case 1: {
                top1 = t;
            }
            break;
            case 2: {
                top2 = t;
            }
            break;
            case 3: {
                top3 = t;
            }
            break;
            default: {
                throw new RuntimeException("unsupported");
            }
        }
    }

    private StackNode getStuckByNumber(int stackNumber) {
        switch (stackNumber) {
            case 1: {
                return top1;
            }
            case 2: {
                return top2;
            }
            case 3: {
                return top3;
            }
            default: {
                throw new RuntimeException("unsupported");
            }
        }
    }

    public T peek(int stackNumber) {
        StackNode stuckByNumber = getStuckByNumber(stackNumber);
        if (stuckByNumber == null) throw new EmptyStackException();
        return val[stuckByNumber.elemIndex];
    }

    public boolean isEmpty(int stackNumber) {
        StackNode stuckByNumber = getStuckByNumber(stackNumber);
        return stuckByNumber == null;
    }
}
