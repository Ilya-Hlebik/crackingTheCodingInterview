package Ch_02_Linked_List.Q2_07_Intersection.run2;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {
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

    private static LinkedListNode findIntersection(LinkedListNode list1, LinkedListNode list2) {
        Set<LinkedListNode> nodes = new HashSet<>();
        LinkedListNode temp = list1;
        while (temp != null) {
            nodes.add(temp);
            temp = temp.next;
        }
        while (list2 != null) {
            if (nodes.contains(list2)) {
                return list2;
            }
            list2 = list2.next;
        }
        return null;
    }
}
