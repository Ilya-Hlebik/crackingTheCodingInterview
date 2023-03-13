package interviewprep.Q10_MergeTwoSortedLists;

public class Solution {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = null;
        ListNode temp = null;

        while (list1 != null && list2 != null) {
            int l1Val = list1.val;
            int l2Val = list2.val;
            if (l1Val >= l2Val) {
                if (temp == null) {
                    result = new ListNode(l2Val);
                    temp = result;
                } else {
                    ListNode nextNode = new ListNode(l2Val);
                    temp.next = nextNode;
                    temp = temp.next;
                }
                list2 = list2.next;
            } else {
                if (temp == null) {
                    result = new ListNode(l1Val);
                    temp = result;
                } else {
                    ListNode nextNode = new ListNode(l1Val);
                    temp.next = nextNode;
                    temp = temp.next;
                }
                list1 = list1.next;
            }
        }
        ListNode temp2 = list1 != null ? list1 : list2;
        while (temp2 != null) {
            if (temp == null) {
                result = new ListNode(temp2.val);
                temp = result;
                temp2 = temp2.next;
                continue;
            }
            temp.next = new ListNode(temp2.val);
            temp = temp.next;
            temp2 = temp2.next;
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
/*        ListNode list1 = null;
        ListNode list2 = new ListNode(0);*/
        mergeTwoLists(list1, list2);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
