package Ch_03_Stacks_and_Queues.Q3_03_Stack_of_Plates.run2;


import java.util.ArrayList;
import java.util.List;

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

class SetOfStacks {
    int capacity_per_substack;
    List<StackNode> stackNodes = new ArrayList<>();

    public SetOfStacks(int capacity_per_substack) {
        this.capacity_per_substack = capacity_per_substack;
    }

    public void push(int item) {
        boolean isInserted = false;
        for (StackNode stackNode : stackNodes) {
            if (stackNode != null && stackNode.currentCapacityLeft > 0) {
                stackNode.setNext(item);
                isInserted = true;
            }
        }
        if (!isInserted) {
            StackNode stackNode = new StackNode(capacity_per_substack);
            stackNode.setNext(item);
            stackNodes.add(stackNode);
        }
    }

    public Integer popAt(int i) {
        if (i < 0 || stackNodes.size() - 1 < i || stackNodes.get(i).isEmpty()) {
            throw new RuntimeException();
        }
        return pop(stackNodes.get(i));
    }

    public Integer pop() {
        if (stackNodes.isEmpty() || stackNodes.stream().allMatch(StackNode::isEmpty)) {
            throw new RuntimeException();
        }
        StackNode stackNode = stackNodes.get(stackNodes.size() - 1);
        return pop(stackNode);
    }

    private Integer pop(StackNode stackNode) {
        Integer pop = stackNode.pop();
        if (stackNode.isEmpty()){
            stackNodes.remove(stackNode);
        }
        return pop;
    }
}

class StackNode {
    List<Integer> list = new ArrayList<>();
    int currentCapacityLeft;

    public StackNode(int capacity_per_substack) {
        this.currentCapacityLeft = capacity_per_substack;
    }

    public void setNext(Integer st) {
        if (list.isEmpty()) {
            list.add(st);
        } else {
            list.add(0, st);
        }
        currentCapacityLeft--;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public Integer pop() {
        Integer integer = list.get(0);
        currentCapacityLeft++;
        list.remove(0);
        return integer;
    }
}
