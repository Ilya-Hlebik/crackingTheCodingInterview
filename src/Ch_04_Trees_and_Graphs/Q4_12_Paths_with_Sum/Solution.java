package Ch_04_Trees_and_Graphs.Q4_12_Paths_with_Sum;

import CtCILibrary.AssortedMethods;
import CtCILibrary.TreeNode;

public class Solution {
    public static void main(String[] args) {
        boolean isWorking = true;
        while (isWorking) {
            int min = -20;
            int max = 20;
            int size = 20;
            TreeNode root = AssortedMethods.randomBST(size, min, max);

            for (int targetSum = Math.min(-1, min * size - 10); targetSum <= Math.max(100, max * size + 10); targetSum++) {
                int answerA = countPathsWithSum(root, targetSum);
                int answerB = countPathsWithSum(root, targetSum);
                if (answerA > 0 || answerB > 0) {
                    System.out.println(targetSum + ": " + answerA + ", " + answerB + " | " + (answerA == answerB));
                }
                if (answerA != answerB) {
                    isWorking = false;
                    break;
                }
            }
        }
    }

    private static int countPathsWithSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int pathFromRoot = countPathsWithSumFromNode(root, targetSum, 0);
        int pathFromLeft = countPathsWithSum(root.left, targetSum);
        int pathFromRight = countPathsWithSum(root.right, targetSum);

        return pathFromLeft + pathFromRoot + pathFromRight;
    }

    private static int countPathsWithSumFromNode(TreeNode root, int targetSum, int currentSum) {
        if (root == null) {
            return 0;
        }
        currentSum += root.data;

        int totalPath = 0;
        if (currentSum == targetSum) {
            totalPath++;
        }
        totalPath += countPathsWithSumFromNode(root.left, targetSum, currentSum);
        totalPath += countPathsWithSumFromNode(root.right, targetSum, currentSum);
        return totalPath;
    }
}
