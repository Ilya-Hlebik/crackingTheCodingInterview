package Ch_04_Trees_and_Graphs.Q4_05_Validate_BST;

import CtCILibrary.TreeNode;

public class Solution2 {
    public static void main(String[] args) {
        int[] array = {Integer.MAX_VALUE, Integer.MAX_VALUE - 2, Integer.MAX_VALUE - 1, Integer.MAX_VALUE};
        TreeNode node = TreeNode.createMinimalBST(array);
        //node.left.data = 5;
        //node.left.right.data = 3;
        System.out.println(checkBST(node, new WrapInt()));

        test();
    }

    private static boolean checkBST(TreeNode node, WrapInt wrapInt) {
        if (node == null) {
            return true;
        }
        if (!checkBST(node.left, wrapInt)) {
            return false;
        }
        if (wrapInt.value != null && node.data <= wrapInt.value) {
            return false;
        }
        wrapInt.value = node.data;
        if (!checkBST(node.right, wrapInt)) {
            return false;
        }
        return true;
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
        condition = checkBST(node, new WrapInt());
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
        condition = checkBST(node, new WrapInt());
        System.out.println("should be false: " + condition);
    }
}

class WrapInt {
    Integer value;
}
