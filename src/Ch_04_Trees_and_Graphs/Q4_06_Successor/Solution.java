package Ch_04_Trees_and_Graphs.Q4_06_Successor;

import CtCILibrary.TreeNode;

public class Solution {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinimalBST(array);
        for (int i = 0; i < array.length; i++) {
            TreeNode node = root.find(array[i]);
            TreeNode next = inorderSucc(node);
            if (next != null) {
                System.out.println(node.data + "->" + next.data);
            } else {
                System.out.println(node.data + "->" + null);
            }
        }
    }

    private static TreeNode inorderSucc(TreeNode node) {
        return inorderSucc(node, node);

    }


    private static TreeNode inorderSucc(TreeNode node, TreeNode search) {
        if (node == null) {
            return null;
        }
        inorderSucc(node.left, search);
        if (node.parent != null && node.parent.equals(search)) {
            return node;
        }
        else if (node.equals(search) && node.left == null && node.right == null && node.parent.data > node.data){
            return node.parent;
        }
        return inorderSucc(node.right, search);
    }
}
