package Ch_02_Linked_List.Q2_05_Sum_Lists;

import CtCILibrary.LinkedListNode;


public class Solution2 {
    private static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2) {
        int len1 = length(l1);
        int len2 = length(l2);
        System.out.println(len1);
        System.out.println(len2);
        return null;

    }

    private static int length(LinkedListNode node) {
        if (node == null){
            return 0;
        }
        return length(node.next) +1;
    }

    public static int linkedListToInt(LinkedListNode node) {
        int value = 0;
        while (node != null) {
            value = value * 10 + node.data;
            node = node.next;
        }
        return value;
    }

    public static void main(String[] args) {
        LinkedListNode lA1 = new LinkedListNode(3, null, null);
        LinkedListNode lA2 = new LinkedListNode(1, null, lA1);

        LinkedListNode lB1 = new LinkedListNode(5, null, null);
        LinkedListNode lB2 = new LinkedListNode(9, null, lB1);
        LinkedListNode lB3 = new LinkedListNode(1, null, lB2);

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
}
