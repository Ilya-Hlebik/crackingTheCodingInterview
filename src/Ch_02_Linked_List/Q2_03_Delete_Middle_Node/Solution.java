package Ch_02_Linked_List.Q2_03_Delete_Middle_Node;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

public class Solution {

    private static boolean deleteNode(LinkedListNode next) {
        if (next == null || next.next == null) {
            return false; // Failure
        }
        LinkedListNode prev = next.prev;
        prev.next = next.next;
        return true;
    }

    public static void main(String[] args) {
        LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
        System.out.println(head.printForward());
        deleteNode(head.next.next.next.next); // delete node 4
        System.out.println(head.printForward());
    }
}
