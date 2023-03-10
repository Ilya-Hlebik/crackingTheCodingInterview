package Ch_02_Linked_List.Q2_06_Palindrome;

import CtCILibrary.LinkedListNode;

import java.util.Stack;

public class Solution {
    private static boolean isPalindrome(LinkedListNode head) {
        Stack<Integer> stack = new Stack<>();
        LinkedListNode temp = head;
        while (temp!=null){
            stack.push(temp.data);
            temp = temp.next;
        }
        for (int i = 0; i < stack.size(); i++) {
            if (stack.pop() != head.data){
                return false;
            }
            head = head.next;
        }
        return true;
    }

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
        // nodes[length - 2].data = 9; // Uncomment to ruin palindrome

        LinkedListNode head = nodes[0];
        System.out.println(head.printForward());
        System.out.println(isPalindrome(head));
    }
}
