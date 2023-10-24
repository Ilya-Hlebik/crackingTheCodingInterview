package Ch_04_Trees_and_Graphs.Q4_08_First_Common_Ancestor.run2;

import CtCILibrary.TreeNode;

public class Solution {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinimalBST(array);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                try {
                    TreeNode n3 = root.find(i);
                    TreeNode n7 = root.find(j);
                    TreeNode ancestor = commonAncestor(root, n3, n7);
                    System.out.println(i + ", " + j + " ->" + ancestor.data);
                } catch (Exception e) {
                }
            }
        }

    }

    private static TreeNode commonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
        while (node1!=null){
            if (node1.equals(node2)){
                return node1;
            }
            TreeNode temp = node2;
            while (temp.parent!=null){
                temp = temp.parent;
                if (node1.equals(temp)){
                    return temp;
                }
            }
            node1 = node1.parent;
        }

        return null;
    }
}
