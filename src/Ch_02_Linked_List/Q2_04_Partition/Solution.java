package Ch_02_Linked_List.Q2_04_Partition;

import CtCILibrary.LinkedListNode;

public class Solution {

    public static LinkedListNode partition(LinkedListNode node, int x) {

        LinkedListNode before = null;
        LinkedListNode afterOrEqual = null;
        while (node != null) {
            LinkedListNode next = node.next;
            node.next = null;
            if (node.data < x) {
                if (before == null) {
                    before = node;
                } else {
                    LinkedListNode temp = before;
                    while (true) {
                        if (temp.next == null) {
                            temp.next = node;
                            break;
                        } else {
                            temp = temp.next;
                        }
                    }
                }
            } else {
                if (afterOrEqual == null) {
                    afterOrEqual = node;
                } else {
                    LinkedListNode temp = afterOrEqual;
                    while (true) {
                        if (temp.next == null) {
                            temp.next = node;
                            break;
                        } else {
                            temp = temp.next;
                        }
                    }
                }
            }
            node = next;
        }
        LinkedListNode temp = before;
        while (temp != null) {
            if (temp.next == null) {
                temp.next = afterOrEqual;
                break;
            }
            temp = temp.next;
        }
        return before;
    }

    public static void main(String[] args) {
        /* Create linked list */
        int[] vals = {33, 9, 2, 3, 10, 10389, 838, 874578, 5};
        LinkedListNode head = new LinkedListNode(vals[0], null, null);
        LinkedListNode current = head;
        for (int i = 1; i < vals.length; i++) {
            current = new LinkedListNode(vals[i], null, current);
        }
        System.out.println(head.printForward());

        /* Partition */
        LinkedListNode h = partition(head, 3);

        /* Print Result */
        System.out.println(h.printForward());
    }
}
