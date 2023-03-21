package Ch_04_Trees_and_Graphs.Q4_05_Validate_BST;

import CtCILibrary.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static Integer lastPrinted = null;
    public static void main(String[] args) {
        int[] array = {Integer.MAX_VALUE, Integer.MAX_VALUE - 2, Integer.MAX_VALUE - 1, Integer.MAX_VALUE};
        TreeNode node = TreeNode.createMinimalBST(array);
        //node.left.data = 5;
        //node.left.right.data = 3;
        System.out.println(checkBST(node));

        test();
    }

    protected static void test() {
        TreeNode node;
        boolean condition;
        System.out.println("test cases for equals condition.");

		/* Expect true: for left child: node.data <= last_printed.
   2
  / \
 /   \
 2   3
      \
      4
		*/
        int[] array2 = {1, 2, 3, 4};
        node = TreeNode.createMinimalBST(array2);
        node.left.data = 2;
        node.print();
        lastPrinted = null;
        condition = checkBST(node);
        System.out.println("should be true: " + condition);

		/* Expect false: for right child: node.data <= last_printed.
   2
  / \
 /   \
 1   2
      \
      4
		 */
        int[] array3 = {1, 2, 3, 4};
        node = TreeNode.createMinimalBST(array3);
        node.right.data = 2;
        node.print();
        lastPrinted = null;
        condition = checkBST(node);
        System.out.println("should be false: " + condition);
    }

    private static boolean checkBST(TreeNode node) {
        ArrayList<TreeNode> list = new ArrayList<>();
        checkBst(node, list);
        boolean dupsPossible = true;
        for (int i = 0; i < list.size()-1; i++) {
            if (node.equals(list.get(i))){
                dupsPossible = false;
            }
            if (dupsPossible && !(list.get(i).data <= list.get(i + 1).data) || !dupsPossible && !(list.get(i).data < list.get(i + 1).data)) {
                return false;
            }
        }
        return true;
    }

    private static void checkBst(TreeNode node, List<TreeNode> list) {
        if (node == null){
            return;
        }
        checkBst(node.left, list);
        list.add(node);
        checkBst(node.right, list);
    }
}
