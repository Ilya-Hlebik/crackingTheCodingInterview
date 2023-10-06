package Ch_02_Linked_List.Q2_02_Return_Kth_To_Last.run2;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

public class Solution {
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6};
        LinkedListNode head = AssortedMethods.createLinkedListFromArray(array);
        for (int i = 0; i <= array.length + 1; i++) {
            printKthToLast2(head, i);
        }
    }

    public static int printKthToLast(LinkedListNode head, int k) {
        return printKthToLast(head, k, new Index()).data;
    }

    public static LinkedListNode printKthToLast(LinkedListNode head, int k, Index index) {
        if (head == null) {
            return null;
        }
        LinkedListNode linkedListNode = printKthToLast(head.next, k, index);
        index.value = index.value + 1;
        if (k == index.value) {
            return head;
        }
        return linkedListNode;
    }

    public static void printKthToLast2(LinkedListNode head, int k) {
        LinkedListNode p1 = head;
        LinkedListNode p2 = head;
        for (int i = 0; i < k && p2 != null; i++) {
            p2 = p2.next;
            if (p2 == null){
                System.out.println("null");
                return;
            }
        }
        while (p2 != null ) {
            p1 = p1.next;
            p2 = p2.next;
        }
        System.out.println(p1 == null ? "null" : p1.data);
    }

    public static class Index {
        public int value = -1;
    }

}
