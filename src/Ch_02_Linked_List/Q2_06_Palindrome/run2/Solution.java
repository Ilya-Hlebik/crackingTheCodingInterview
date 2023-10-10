package Ch_02_Linked_List.Q2_06_Palindrome.run2;

import CtCILibrary.LinkedListNode;

public class Solution {
    public static void main(String[] args) {
        int length = 10;
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
     nodes[length - 2].data = 9; // Uncomment to ruin palindrome

        LinkedListNode head = nodes[0];
        System.out.println(head.printForward());
        System.out.println(isPalindrome2(head));
    }

    private static boolean isPalindrome(LinkedListNode head) {
        StringBuilder builder = new StringBuilder();
        while (head != null) {
            builder.append(head.data);
            head = head.next;
        }
        return builder.toString().equals(builder.reverse().toString());
    }

    private static boolean isPalindrome2(LinkedListNode head) {
        LinkedListNode cloned = reverseAndClone(head);

        return  compare(head, cloned);
    }

    private static boolean compare(LinkedListNode head, LinkedListNode cloned) {
        while (head !=null){
            if (head.data != cloned.data){
                return false;
            }
            head = head.next;
            cloned = cloned.next;
        }
        return true;
    }

    private static LinkedListNode reverseAndClone(LinkedListNode node) {
        LinkedListNode head = null ;
        while (node != null) {
            LinkedListNode newNode = new LinkedListNode(node.data);
            newNode.next = head;
            head = newNode;
            node = node.next;
        }
        return head;
    }
}
