package Ch_04_Trees_and_Graphs.Q4_06_Successor.run2;

import CtCILibrary.TreeNode;

import java.util.ArrayList;
import java.util.List;

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
        TreeNode parent = getParent(node);
        List<TreeNode> integers = new ArrayList<>();
        inOrderTraversa(parent, integers);
        for (int i = 0; i < integers.size() - 1; i++) {
            if (node.equals(integers.get(i))) {
                return integers.get(i + 1);
            }
        }
        return null;
    }

    private static void inOrderTraversa(TreeNode parent, List<TreeNode> integers) {
        if (parent == null) {
            return;
        }
        inOrderTraversa(parent.left, integers);
        integers.add(parent);
        inOrderTraversa(parent.right, integers);
    }

    private static TreeNode getParent(TreeNode node) {
        while (node != null && node.parent != null) {
            node = node.parent;
        }
        return node;
    }
}
