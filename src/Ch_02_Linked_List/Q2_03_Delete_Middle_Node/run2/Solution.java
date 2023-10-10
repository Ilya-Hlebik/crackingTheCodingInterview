package Ch_02_Linked_List.Q2_03_Delete_Middle_Node.run2;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

public class Solution {
    public static void main(String[] args) {
        LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
        System.out.println(head.printForward());
        deleteNode(head.next.next.next.next); // delete node 4
        System.out.println(head.printForward());
    }

    private static void deleteNode(LinkedListNode next) {
        if(next == null){
            return;
        }
        if (next.prev!= null){
            next.prev.next = next.next;
        }
        if (next.next != null){
            next.next.prev = next.prev;
        }
    }
}
