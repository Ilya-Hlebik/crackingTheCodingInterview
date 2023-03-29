package Ch_04_Trees_and_Graphs.Q4_08_First_Common_Ancestor;

import CtCILibrary.TreeNode;

import java.util.concurrent.atomic.AtomicInteger;

public class Solution {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinimalBST(array);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                try {
                    TreeNode n3 = root.find(i);
                    TreeNode n7 = root.find(j);
                    TreeNode ancestor = commonAncestor(root, n3, n7);
                    System.out.println(i + ", " + j + " ->" + ancestor.data);
                } catch (Exception e) {
                }
            }
        }

    }

    private static TreeNode commonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
        return postOrder(root, node1, node2, new AtomicInteger(0));
    }

    private static TreeNode postOrder(TreeNode root, TreeNode node1, TreeNode node2, AtomicInteger visitedCount) {
        if (root == null) {
            return null;
        }
        TreeNode left = postOrder(root.left, node1, node2, visitedCount);
        if (left != null) {
            return left;
        }
        TreeNode right = postOrder(root.right, node1, node2, visitedCount);
        if (right != null) {
            return right;
        }
        if (root.equals(node1) || root.equals(node2)) {
            visitedCount.incrementAndGet();
        }
        if (visitedCount.get() == 2 && preOrder(root, node1, node2, new AtomicInteger(0))) {
            return root;
        }
        return null;
    }

    private static boolean preOrder(TreeNode root, TreeNode node1, TreeNode node2, AtomicInteger visitedCount) {
        if (root == null) {
            return false;
        }
        boolean left = preOrder(root.left, node1, node2, visitedCount);
        if (left) {
            return true;
        }
        if (root.equals(node1) || root.equals(node2)) {
            int i = visitedCount.incrementAndGet();
            if (i == 2) {
                return true;
            }
        }
        return preOrder(root.right, node1, node2, visitedCount);
    }
}
