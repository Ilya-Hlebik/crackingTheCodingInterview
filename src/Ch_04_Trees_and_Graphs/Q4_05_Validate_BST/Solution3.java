package Ch_04_Trees_and_Graphs.Q4_05_Validate_BST;

import CtCILibrary.TreeNode;

public class Solution3 {
    public static boolean checkBST(TreeNode n, Integer min, Integer max) {
        if (n == null) {
            return true;
        }
        if ((min != null && n.data <= min) || (max != null && n.data > max)) {
            return false;
        }
        if (!checkBST(n.left, min, n.data) || !checkBST(n.right, n.data, max)) {
            return false;
        }
        return true;
    }

    public static boolean checkBST(TreeNode n) {
        return checkBST(n, null, null);
    }

    public static void main(String[] args) {
        /* Simple test -- create one */
        int[] array = {Integer.MIN_VALUE, 3, 5, 6, 10, 13, 15, Integer.MAX_VALUE};
        TreeNode node = TreeNode.createMinimalBST(array);
        //node.left.data = 6; // "ruin" the BST property by changing one of the elements
        node.print();
        boolean isBst = checkBST(node);
        System.out.println(isBst);

        /* More elaborate test -- creates 100 trees (some BST, some not) and compares the outputs of various methods. */
		/*for (int i = 0; i < 100; i++) {
			TreeNode head = createTestTree();

			// Compare results
			boolean isBst1 = checkBST(head);
			boolean isBst2 = checkBSTAlternate(head);

			if (isBst1 != isBst2) {
				System.out.println("*********************** ERROR *******************");
				head.print();
				break;
			} else {
				System.out.println(isBst1 + " | " + isBst2);
				head.print();
			}
		}*/
    }
}
