package Ch_04_Trees_and_Graphs.Q4_06_Successor;

import CtCILibrary.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    static TreeNode parrent;
    static ArrayList<TreeNode> treeNodeList;

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
        if (parrent == null) {
            parrent = getParrent(node);
        }
        if (treeNodeList == null) {
            treeNodeList = new ArrayList<>();
            inorderSucc(parrent, treeNodeList);
        }
        for (int i = 0; i < treeNodeList.size() - 1; i++) {
            if (treeNodeList.get(i).equals(node)) {
                return treeNodeList.get(i + 1);
            }
        }
        return null;
    }

    private static TreeNode getParrent(TreeNode node) {
        while (node != null && node.parent != null) {
            node = node.parent;
        }
        return node;
    }


    private static void inorderSucc(TreeNode node, List<TreeNode> treeNodeList) {
        if (node == null) {
            return;
        }
        inorderSucc(node.left, treeNodeList);
        treeNodeList.add(node);
        inorderSucc(node.right, treeNodeList);
    }
}
