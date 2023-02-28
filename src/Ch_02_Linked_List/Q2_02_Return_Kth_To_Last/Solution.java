package Ch_02_Linked_List.Q2_02_Return_Kth_To_Last;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

public class Solution {
    public static int printKthToLast(LinkedListNode head, int k) {
        int size = 0;
        LinkedListNode copy = head;
        while (copy != null){
            size ++;
            copy = copy.next;
        }
        for (int i=0; i< size -k -1; i++){
            head = head.next;
        }
        return head.data;
    }
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6};
        LinkedListNode head = AssortedMethods.createLinkedListFromArray(array);
        for (int i = 0; i <= array.length + 1; i++) {
            System.out.println(printKthToLast(head, i));
        }
    }
}
