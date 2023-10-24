package run2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solution {
    public static void main(String[] args) {
        int[] counts = new int[10];
        for (int i = 0; i < 1000000; i++) {
            Tree2 tree = new Tree2();
            int[] array = {1, 0, 6, 2, 3, 9, 4, 5, 8, 7};
            for (int x : array) {
                tree.insertInOrder(x);
            }
            int d = tree.getRandomNode().data;
            counts[d]++;
        }

        for (int i = 0; i < counts.length; i++) {
            System.out.println(i + ": " + counts[i]);
        }
    }
}

class Tree2 {
    TreeNode2 root = null;
    List<TreeNode2> values = new ArrayList<>();

    public void insertInOrder(int x) {
        if (root == null) {
            TreeNode2 root = new TreeNode2(x);
            this.root = root;
            values.add(root);
        } else {
            root.insertInOrder(x, values);
        }
    }

    public TreeNode2 getRandomNode() {
        return values.get(new Random().nextInt(values.size()));
    }
}

class TreeNode2 {
    public TreeNode2 right;
    public TreeNode2 left;
    int data;


    public TreeNode2(int data) {
        this.data = data;
    }

    public TreeNode2 find(int d) {
        if (d == data) {
            return this;
        }
        if (d <= data) {
            return left != null ? left.find(d) : null;
        } else {
            return right != null ? right.find(d) : null;
        }
    }


    public void insertInOrder(int x, List<TreeNode2> list) {
        if (this.data >= x) {
            if (left == null) {
                left = new TreeNode2(x);
                list.add(left);
            } else {
                left.insertInOrder(x, list);
            }

        } else {
            if (right == null) {
                right = new TreeNode2(x);
                list.add(right);
            } else {
                right.insertInOrder(x, list);
            }
        }
    }


}
