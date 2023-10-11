package Ch_02_Linked_List.Q2_08_Loop_Detection.run2;

import CtCILibrary.LinkedListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int list_length = 100;
        int k = 10;

        // Create linked list
        LinkedListNode[] nodes = new LinkedListNode[list_length];
        for (int i = 0; i < list_length; i++) {
            nodes[i] = new LinkedListNode(i, null, i > 0 ? nodes[i - 1] : null);
        }

        // Create loop;
        nodes[list_length - 1].next = nodes[list_length - k];

        LinkedListNode loop = findBeginning(nodes[0]);
        if (loop == null) {
            System.out.println("No Cycle.");
        } else {
            System.out.println(loop.data);
        }
    }

    private static LinkedListNode findBeginning(LinkedListNode node) {
        Set<LinkedListNode> nodes = new HashSet<>();
        while (node != null) {
            if (nodes.contains(node)) {
                return node;
            }
            nodes.add(node);
            node = node.next;
        }
        return null;
    }
}
