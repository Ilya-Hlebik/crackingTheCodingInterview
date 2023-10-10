package Ch_02_Linked_List.Q2_05_Sum_Lists.run2;

import CtCILibrary.LinkedListNode;

import java.util.Optional;

public class Solution {
    public static void main(String[] args) {
        LinkedListNode lA1 = new LinkedListNode(9, null, null);
        LinkedListNode lA2 = new LinkedListNode(8, null, lA1);
        LinkedListNode lA3 = new LinkedListNode(8, null, lA2);
        LinkedListNode lA4 = new LinkedListNode(9, null, lA3);

        LinkedListNode lB1 = new LinkedListNode(0, null, null);
        LinkedListNode lB2 = new LinkedListNode(0, null, lB1);
        LinkedListNode lB3 = new LinkedListNode(2, null, lB2);

        LinkedListNode list3 = addLists(lA1, lB1);

        System.out.println("  " + lA1.printForward());
        System.out.println("+ " + lB1.printForward());
        System.out.println("= " + list3.printForward());

        int l1 = linkedListToInt(lA1);
        int l2 = linkedListToInt(lB1);
        int l3 = linkedListToInt(list3);

        System.out.print(l1 + " + " + l2 + " = " + l3 + "\n");
        System.out.print(l1 + " + " + l2 + " = " + (l1 + l2));
    }

    private static LinkedListNode addLists(LinkedListNode list1, LinkedListNode list2) {
        return addLists(list1, list2, 0);
    }

    private static LinkedListNode addLists(LinkedListNode list1, LinkedListNode list2, int carry) {
        if (list1 == null && list2 == null && carry == 0) {
            return null;
        }
        LinkedListNode linkedListNode = new LinkedListNode();
        int data = Optional.ofNullable(list1).map(l -> l.data).orElse(0) + Optional.ofNullable(list2).map(l -> l.data).orElse(0) + carry;
        int nodeValue;
        if (data > 9) {
            nodeValue = data % 10;
        } else {
            nodeValue = data;
        }
        linkedListNode.data = nodeValue;
        if (list1 != null) {
            list1 = list1.next;
        }
        if (list2 != null) {
            list2 = list2.next;
        }
        LinkedListNode more = addLists(list1, list2, data < 10 ? 0 : data / 10);
        linkedListNode.setNext(more);
        return linkedListNode;
    }

    public static int linkedListToInt(LinkedListNode node) {
        int value = 0;
        if (node.next != null) {
            value = 10 * linkedListToInt(node.next);
        }
        return value + node.data;
    }
}
