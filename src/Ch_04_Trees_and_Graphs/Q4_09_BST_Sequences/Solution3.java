package Ch_04_Trees_and_Graphs.Q4_09_BST_Sequences;

import CtCILibrary.TreeNode;

import java.util.LinkedList;

public class Solution3 {

    public static LinkedList<LinkedList<Integer>> weaveLists(LinkedList<Integer> front, LinkedList<Integer> left, LinkedList<Integer> right) {
        /* One list is empty. Add the remainder to [a cloned] prefix and
         * store result. */
        LinkedList<LinkedList<Integer>> allSeq = new LinkedList<>();
        if (left.size() == 0 || right.size() == 0) {
            LinkedList<Integer> clone = (LinkedList<Integer>) front.clone();
            clone.addAll(left);
            clone.addAll(right);
            allSeq.add(clone);
            return allSeq;
        }

        front.addLast(left.removeFirst());
        allSeq.addAll(weaveLists(front, left, right));
        left.add(0, front.removeLast());

        front.addLast(right.removeFirst());
        allSeq.addAll(weaveLists(front, left, right));
        right.add(0, front.removeLast());

        return allSeq;
    }

    public static LinkedList<LinkedList<Integer>> allSequences(TreeNode node) {
        LinkedList<LinkedList<Integer>> result = new LinkedList<>();

        if (node == null) {
            result.add(new LinkedList<>());
            return result;
        }

        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(node.data);

        /* Recurse on left and right subtrees. */
        LinkedList<LinkedList<Integer>> leftSeq = allSequences(node.left);
        LinkedList<LinkedList<Integer>> rightSeq = allSequences(node.right);

        /* Weave together each list from the left and right sides. */
        for (LinkedList<Integer> left : leftSeq) {
            for (LinkedList<Integer> right : rightSeq) {
                result.addAll(weaveLists(prefix, left, right));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(100);
        int[] array = {100, 50, 20, 75, 150, 120, 170};
        for (int a : array) {
            node.insertInOrder(a);
        }
        LinkedList<LinkedList<Integer>> allSeq = allSequences(node);
        for (LinkedList<Integer> list : allSeq) {
            System.out.println(list);
        }
        System.out.println(allSeq.size());
    }

}
