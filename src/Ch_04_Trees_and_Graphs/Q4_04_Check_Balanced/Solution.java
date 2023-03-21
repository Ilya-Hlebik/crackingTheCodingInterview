package Ch_04_Trees_and_Graphs.Q4_04_Check_Balanced;

import CtCILibrary.AssortedMethods;
import CtCILibrary.TreeNode;

public class Solution {
    public static void main(String[] args) {
        // Create balanced tree
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinimalBST(array);
        System.out.println("Root? " + root.data);
        System.out.println("Is balanced? " + isBalanced(root));

        // Could be balanced, actually, but it's very unlikely...
        TreeNode unbalanced = new TreeNode(10);
        for (int i = 0; i < 10; i++) {
            unbalanced.insertInOrder(AssortedMethods.randomIntInRange(0, 100));
        }
        System.out.println("Root? " + unbalanced.data);
        System.out.println("Is balanced? " + isBalanced(unbalanced));
    }

    private static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int heightDiff = getHeight(root.left) - getHeight(root.right);
        if (Math.abs(heightDiff) > 1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public static int getHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

   /* private static int getHeight(TreeNode node) {
        int leftHeight = node != null && node.left != null ? getHeight(node.left) : 0;
        int rightHeight = node != null && node.right != null ? getHeight(node.right) : 0;
        return 1 + Math.max(leftHeight, rightHeight);
    }*/
}
