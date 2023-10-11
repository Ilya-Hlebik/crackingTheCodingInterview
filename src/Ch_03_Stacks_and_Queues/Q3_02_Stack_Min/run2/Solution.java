package Ch_03_Stacks_and_Queues.Q3_02_Stack_Min.run2;


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
    private StackNode stackNode;

    public void push(int data) {
        StackNode stackNode = new StackNode(data);
        if (this.stackNode != null) {
            int min = this.stackNode.min;
            stackNode.min = Math.min(data, min);
        } else {
            stackNode.min = data;
        }
        stackNode.next = this.stackNode;
        this.stackNode = stackNode;
    }

    public int min() {
        if (stackNode == null) {
            throw new RuntimeException();
        }
        return stackNode.min;
    }

    public int pop() {
        if (stackNode == null) {
            throw new RuntimeException();
        }
        int data = stackNode.data;
        stackNode = stackNode.next;
        return data;
    }
}

class StackNode {
    public int data;
    public int min;
    public StackNode next;

    public StackNode(int data) {
        this.data = data;
    }
}
