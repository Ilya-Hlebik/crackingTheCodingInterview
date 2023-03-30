package Ch_04_Trees_and_Graphs.Q4_08_First_Common_Ancestor;

import CtCILibrary.TreeNode;

public class Solution2 {
    public static TreeNode commonAncestor(TreeNode p, TreeNode q) {
        if (p == q) return p;

        TreeNode ancestor = p;
        while (ancestor != null) {
            if (isOnPath(ancestor, q)) {
                return ancestor;
            }
            ancestor = ancestor.parent;
        }
        return null;
    }

    public static boolean isOnPath(TreeNode ancestor, TreeNode node) {
        while (node != ancestor && node != null) {
            node = node.parent;
        }
        return node == ancestor;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinimalBST(array);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                try {
                    TreeNode n3 = root.find(i);
                    TreeNode n7 = root.find(j);
                    TreeNode ancestor = commonAncestor( n3, n7);
                    System.out.println(i + ", " + j + " ->" + ancestor.data);
                } catch (Exception e) {
                }
            }
        }

    }
}
