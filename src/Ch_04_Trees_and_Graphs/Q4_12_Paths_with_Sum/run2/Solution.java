package Ch_04_Trees_and_Graphs.Q4_12_Paths_with_Sum.run2;

import CtCILibrary.TreeNode;

public class Solution {
    public static void main(String[] args) {
		/*
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(-8);
		root.left.right = new TreeNode(8);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(6);
		System.out.println(countPathsWithSum(root, 0));*/

		/*TreeNode root = new TreeNode(-7);
		root.left = new TreeNode(-7);
		root.left.right = new TreeNode(1);
		root.left.right.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(20);
		root.right.right.left = new TreeNode(0);
		root.right.right.left.left = new TreeNode(-3);
		root.right.right.left.left.right = new TreeNode(2);
		root.right.right.left.left.right.left = new TreeNode(1);
		System.out.println(countPathsWithSum(root, -14));*/

        TreeNode root = new TreeNode(-7);
        root.left = new TreeNode(-7);
        root.left.right = new TreeNode(1);
        root.left.right.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(20);
        root.right.right.left = new TreeNode(0);
        root.right.right.left.left = new TreeNode(-3);
        root.right.right.left.left.right = new TreeNode(2);
        root.right.right.left.left.right.left = new TreeNode(1);
        System.out.println(countPathsWithSum(root, 0));
    }

    private static int countPathsWithSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int countFromRoot = countPathsWithSumFromNode(root, 0, sum);
        int countFromLeft = countPathsWithSum(root.left, sum);
        int countFromRight = countPathsWithSum(root.right, sum);

        return countFromRoot + countFromLeft + countFromRight;
    }

    private static int countPathsWithSumFromNode(TreeNode root, int currentSum, int sum) {
        if (root == null) {
            return 0;
        }
        currentSum += root.data;
        int totalPaths = 0;
        if (currentSum == sum) {
            totalPaths++;
        }
        totalPaths += countPathsWithSumFromNode(root.left, currentSum, sum);
        totalPaths += countPathsWithSumFromNode(root.right, currentSum, sum);

        return totalPaths;
    }
}
