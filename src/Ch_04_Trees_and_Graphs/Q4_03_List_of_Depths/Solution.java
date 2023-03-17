package Ch_04_Trees_and_Graphs.Q4_03_List_of_Depths;

import CtCILibrary.AssortedMethods;
import CtCILibrary.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/*BDS*/
public class Solution {
    public static void main(String[] args) {
        int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = AssortedMethods.createTreeFromArray(nodes_flattened);
        ArrayList<LinkedList<TreeNode>> list = createLevelLinkedList(root);
    }

    private static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<>();
        preOrderTraversal(root, lists, 0);
        return lists;
    }

    private static void preOrderTraversal(TreeNode root, ArrayList<LinkedList<TreeNode>> linkedLists, int level) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> nodes;
        if (linkedLists.size() == level) {
            nodes = new LinkedList<>();
            linkedLists.add(nodes);
        } else {
            nodes = linkedLists.get(level);
        }
        nodes.add(root);
        preOrderTraversal(root.left, linkedLists, level + 1);
        preOrderTraversal(root.right, linkedLists, level + 1);
    }


}
