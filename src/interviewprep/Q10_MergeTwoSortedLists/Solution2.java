package interviewprep.Q10_MergeTwoSortedLists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution2 {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        List<Integer> list = new ArrayList<>();
        ListNode result = null;
        ListNode temp = null;
        while (list1 !=null){
            list.add(list1.val);
            list1 = list1.next;
        }
        while (list2 !=null){
            list.add(list2.val);
            list2 = list2.next;
        }
        Collections.sort(list);
        for (Integer integer : list) {
         if (result == null){
             result = new ListNode(integer);
             temp = result;
             continue;
         }
         temp.next= new ListNode(integer);
         temp = temp.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        list2.next.next.next = new ListNode(5);
        mergeTwoLists(list1, list2);
    }
}
