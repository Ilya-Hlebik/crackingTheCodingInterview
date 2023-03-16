package Ch_04_Trees_and_Graphs.Q4_03_List_of_Depths;

import CtCILibrary.AssortedMethods;
import CtCILibrary.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = AssortedMethods.createTreeFromArray(nodes_flattened);
     //   ArrayList<LinkedList<TreeNode>> levelLinkedList2 = createLevelLinkedList2(root);
        HashMap<Integer, LinkedList<TreeNode>> list = createLevelLinkedList(root);
        System.out.println();
        //printResult(list);
    }

    private static HashMap<Integer, LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
        int height = root.height();
        HashMap<Integer, LinkedList<TreeNode>> map = new HashMap<>();
        for (int i = 1; i < height + 1; i++) {
            map.put(i, new LinkedList<>());
        }
        inOrderTraversal(root, map);
        return map;
    }

    private static int getLevel(TreeNode root) {
        return 1+ (root.parent == null?0: getLevel(root));
    }

    private static void inOrderTraversal(TreeNode root, HashMap<Integer, LinkedList<TreeNode>> map) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left, map);
        map.get(map.size() - getLevel(root) + 1).add(root);
        inOrderTraversal(root.right, map);
    }

/*    public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList2(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();

        *//* "Visit" the root *//*
        LinkedList<TreeNode> current = new LinkedList<TreeNode>();
        if (root != null) {
            current.add(root);
        }

        while (current.size() > 0) {
            result.add(current); // Add previous level
            LinkedList<TreeNode> parents = current; // Go to next level
            current = new LinkedList<TreeNode>();
            for (TreeNode parent : parents) {
                *//* Visit the children *//*
                if (parent.left != null) {
                    current.add(parent.left);
                }
                if (parent.right != null) {
                    current.add(parent.right);
                }
            }
        }

        return result;
    }*/
}
