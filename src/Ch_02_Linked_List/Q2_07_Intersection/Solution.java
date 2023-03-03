package Ch_02_Linked_List.Q2_07_Intersection;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

public class Solution {

    private static LinkedListNode findIntersection(LinkedListNode list1, LinkedListNode list2) {
        if (list1 == null || list2 == null) {
            return null;
        }
        Pointer p1 = length(list1);
        Pointer p2 = length(list2);
        if (p1.tail != p2.tail) {
            return null;
        }
        int diff = Math.abs(p2.length - p1.length);
        if (p1.length > p2.length) {
            list1 = moveList(list1, diff);
        } else {
            list2 = moveList(list2, diff);
        }
        LinkedListNode tempList1 = list1;
        LinkedListNode tempList2 = list2;
        while (tempList1 != tempList2) {
            tempList1 = tempList1.next;
            tempList2 = tempList2.next;
        }
        return tempList1;
    }

    private static LinkedListNode moveList(LinkedListNode list1, int diff) {
        for (int i = 0; i < diff; i++) {
            list1 = list1.next;
        }
        return list1;
    }

    private static Pointer length(LinkedListNode list1) {
        LinkedListNode current = list1;
        int count = 1;
        while (current.next != null) {
            count++;
            current = current.next;
        }
        return new Pointer(current, count);
    }

    public static void main(String[] args) {
        /* Create linked list */
        int[] vals = {-1, -2, 0, 1, 2, 3, 4, 5, 6, 7, 8};
        LinkedListNode list1 = AssortedMethods.createLinkedListFromArray(vals);

        int[] vals2 = {11, 12, 14, 15};
        LinkedListNode list2 = AssortedMethods.createLinkedListFromArray(vals2);

        list2.next.next = list1.next.next.next.next;

        System.out.println(list1.printForward());
        System.out.println(list2.printForward());


        LinkedListNode intersection = findIntersection(list1, list2);

        System.out.println(intersection.printForward());
    }
}

class Pointer {
    LinkedListNode tail = null;
    int length = 0;

    public Pointer(LinkedListNode tail, int length) {
        this.tail = tail;
        this.length = length;
    }
}
