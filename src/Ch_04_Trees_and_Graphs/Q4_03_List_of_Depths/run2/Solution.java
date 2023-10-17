package Ch_04_Trees_and_Graphs.Q4_03_List_of_Depths.run2;

import CtCILibrary.AssortedMethods;
import CtCILibrary.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = AssortedMethods.createTreeFromArray(nodes_flattened);
        ArrayList<LinkedList<TreeNode>> list = createLevelLinkedList(root);
    }

    private static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> list = new ArrayList<>();
        createLevelLinkedList(root, 0, list);
        return list;
    }

    private static void createLevelLinkedList(TreeNode root, int level, ArrayList<LinkedList<TreeNode>> list) {
        if (root == null) {
            return;
        }
        if (list.size() == level) {
            list.add(new LinkedList<>());
        }
        list.get(level).add(root);
        createLevelLinkedList(root.left, level + 1, list);
        createLevelLinkedList(root.right, level + 1, list);
    }
}
