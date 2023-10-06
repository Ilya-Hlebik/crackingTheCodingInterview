package Ch_02_Linked_List.Q2_01_Remove_Dups.run2;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        LinkedListNode first = AssortedMethods.randomLinkedList(1000, 1, 3);
        LinkedListNode head = first;
        LinkedListNode second = first;
        for (int i = 1; i < 8; i++) {
            second = new LinkedListNode(i % 2, null, null);
            first.setNext(second);
            second.setPrevious(first);
            first = second;
        }
        System.out.println(head.printForward());
        deleteDups2(head);
        System.out.println(head.printForward());
    }

    private static void deleteDups(LinkedListNode head) {
        if (head == null) {
            return;
        }
        List<Integer> linkedListNodeList = new ArrayList<>();
        LinkedListNode temp = head;
        while (temp != null) {
            if (linkedListNodeList.contains(temp.data)) {
                temp.prev.next = temp.next;
                if (temp.next != null) {
                    temp.next.prev = temp.prev;
                }
            } else {
                linkedListNodeList.add(temp.data);
            }
            temp = temp.next;
        }
    }

    private static void deleteDups2(LinkedListNode head) {
        if (head == null) {
            return;
        }
        LinkedListNode temp = head;
        while (temp != null) {
            LinkedListNode current = temp.next;
            while (current != null) {
                if (temp.data == current.data) {
                    current.prev.next = current.next;
                    if (current.next != null) {
                        current.next.prev = current.prev;
                    }
                }
                current = current.next;
            }
            temp = temp.next;
        }
    }
}
