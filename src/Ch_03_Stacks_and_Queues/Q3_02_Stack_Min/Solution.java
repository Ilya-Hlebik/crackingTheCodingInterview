package Ch_03_Stacks_and_Queues.Q3_02_Stack_Min;

import java.util.EmptyStackException;

public class Solution {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(-1);
        myStack.push(3);
        myStack.push(-1);
        myStack.push(0);
        System.out.println(myStack.min());
        myStack.pop();
        System.out.println(myStack.min());
        myStack.pop();
        System.out.println(myStack.min());
        myStack.pop();
        System.out.println(myStack.min());
        myStack.pop();
        System.out.println(myStack.min());

    }
}

class MyStack {

    private static class StackNode {
        private int data;
        private int min =Integer.MAX_VALUE;
        private StackNode next;

        public StackNode(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }
    }

    private StackNode top;

    public int pop() {
        if (top == null) throw new EmptyStackException();
        int item = top.getData();
        top = top.next;
        return item;
    }

    public void push(int item) {
        int min = Math.min(item, min());
        StackNode t = new StackNode(item);
        t.min = min;
        t.next = top;
        top = t;

    }
    public int min(){
        if (top == null) {
            return Integer.MAX_VALUE;
        }
        return top.min;
    }

    public int peek() {
        if (top == null) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
