package Ch_02_Linked_List.Q2_04_Partition.run2;

import CtCILibrary.LinkedListNode;

public class Solution {
    public static void main(String[] args) {
        int length = 20;
        LinkedListNode[] nodes = new LinkedListNode[length];
        for (int i = 0; i < length; i++) {
            nodes[i] = new LinkedListNode(i >= length / 2 ? length - i - 1 : i, null, null);
        }

        for (int i = 0; i < length; i++) {
            if (i < length - 1) {
                nodes[i].setNext(nodes[i + 1]);
            }
            if (i > 0) {
                nodes[i].setPrevious(nodes[i - 1]);
            }
        }

        LinkedListNode head = nodes[0];
        System.out.println(head.printForward());

        LinkedListNode h = partition(head, 8);
        System.out.println(h.printForward());
    }

    private static LinkedListNode partition(LinkedListNode node, int x) {
        LinkedListNode temp = node;
        LinkedListNode rigthPartition = null;
        while (temp != null) {
            if (temp.data >= x) {
                if (temp.prev != null) {
                    temp.prev.next = temp.next;
                }
                if (temp.next != null) {
                    temp.next.prev = temp.prev;
                }
                if (rigthPartition == null) {
                    rigthPartition = temp;
                    rigthPartition.prev = null;
                } else {
                    rigthPartition.next = temp;
                    temp.prev = rigthPartition;
                    rigthPartition = rigthPartition.next;
                }
            }
            if (temp.next == null && rigthPartition != null) {
                rigthPartition.next = null;
                while (rigthPartition.prev != null) {
                    rigthPartition = rigthPartition.prev;
                }
                temp.next = rigthPartition;
                break;
            }
            temp = temp.next;
        }
        return node;
    }

}
