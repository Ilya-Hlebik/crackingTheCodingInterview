package Ch_04_Trees_and_Graphs.Q4_09_BST_Sequences;

import CtCILibrary.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(100);
        int[] array = {100, 50, 20, 75, 150, 120, 170};
        for (int a : array) {
            node.insertInOrder(a);
        }
        List<List<Integer>> allSeq = allSequences(node);
        for (List<Integer> list : allSeq) {
            System.out.println(list);
        }
        System.out.println(allSeq.size());
    }

    private static List<List<Integer>> allSequences(TreeNode node) {
        int root = node.data;
        ArrayList<Integer> integers = new ArrayList<>();
        preOrder(node, integers);
        integers.remove(0);
        List<List<Integer>> lists = generateCombinations(integers);
        lists.forEach(integers1 -> integers1.add(0,root));
        return lists;
    }

    public static List<List<Integer>> generateCombinations(List<Integer> nums) {
        List<List<Integer>> result = new ArrayList<>();
        generateCombinations(nums, new ArrayList<>(), result);
        return result;
    }

    private static void generateCombinations(List<Integer> nums, List<Integer> temp, List<List<Integer>> result) {
        if (nums.size() == 0 && temp.size() > 0) {
            result.add(new ArrayList<>(temp));
        } else {
            for (int i = 0; i < nums.size(); i++) {
                List<Integer> newNums = new ArrayList<>(nums);
                List<Integer> newTemp = new ArrayList<>(temp);
                newTemp.add(newNums.remove(i));
                generateCombinations(newNums, newTemp, result);
            }
        }
    }

    private static void preOrder(TreeNode node, ArrayList<Integer> integers) {
        if (node == null){
            return;
        }
        integers.add(node.data);
        preOrder(node.left, integers);
        preOrder(node.right, integers);
    }
}
