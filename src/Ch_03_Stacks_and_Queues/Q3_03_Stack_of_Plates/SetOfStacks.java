package Ch_03_Stacks_and_Queues.Q3_03_Stack_of_Plates;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class SetOfStacks<T> {
    List<MyStack<T>> myStackList = new ArrayList<>();
    private final int capacityPerSubstack;

    public SetOfStacks(int capacityPerSubstack) {
        this.capacityPerSubstack = capacityPerSubstack;
        MyStack<T> stack = new MyStack<>();
        myStackList.add(stack);
    }

    public void push(T i) {
        MyStack<T> lastStack = myStackList.get(myStackList.size() - 1);
        if (lastStack.size == capacityPerSubstack) {
            MyStack<T> stack = new MyStack<>();
            stack.push(i);
            myStackList.add(stack);
        } else {
            lastStack.push(i);
        }
    }

    public T pop() {
        if (myStackList.size() - 1 < 0){
            return null;
        }
        MyStack<T> lastStack = myStackList.get(myStackList.size() - 1);
        if (lastStack.isEmpty()) {
            myStackList.remove(myStackList.size() - 1);
        }
        if (myStackList.isEmpty()) {
            return null;
        }
        lastStack = myStackList.get(myStackList.size() - 1);
        return lastStack.pop();
    }

    public T popAt(int stackIndex) {
        if (stackIndex <= myStackList.size() - 1 && stackIndex > -1) {
            MyStack<T> tMyStack = myStackList.get(stackIndex);
            T pop = tMyStack.pop();
            if (myStackList.size() != 1) {
                rearrangeStacks(stackIndex);
            }
            return pop;
        } else return null;
    }

    private void rearrangeStacks(int stackIndex) {
        for (int i = stackIndex; i < myStackList.size() - 1; i++) {
            MyStack<T> tMyStack = myStackList.get(i);
            MyStack<T> tMyStack2 = myStackList.get(i + 1);
            tMyStack.push(tMyStack2.popFirst());
        }
    }
}

class MyStack<T> {
    public int size;

    private static class StackNode<T> {
        private final T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }
    }

    private StackNode<T> top;

    public T popFirst() {
        StackNode<T> temp = top;
        List<StackNode<T>> stackNodes = new ArrayList<>();

        while (temp.next != null) {
            stackNodes.add(0, temp);
            temp = temp.next;
        }
        StackNode<T> newTop = null;
        size = 0;
        top = null;
        for (int i = 0; i < stackNodes.size(); i++) {
            push(stackNodes.get(i).data);
        }
        return temp.data;
    }

    public T pop() {
        if (top == null) throw new EmptyStackException();
        T item = top.getData();
        top = top.next;
        --size;
        return item;
    }

    public void push(T item) {
        StackNode<T> t = new StackNode<T>(item);
        t.next = top;
        top = t;
        ++size;
    }

    public T peek() {
        if (top == null) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
