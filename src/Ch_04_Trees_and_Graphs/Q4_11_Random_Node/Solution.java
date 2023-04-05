package Ch_04_Trees_and_Graphs.Q4_11_Random_Node;


import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {

    public static void main(String[] args) {
        int[] counts = new int[10];
        for (int i = 0; i < 1000000; i++) {
            Tree tree = new Tree();
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

class Tree {
    TreeNode root = null;
    int size = 0;

    public void insertInOrder(int x) {
        if (root == null) {
            root = new TreeNode(x);
        } else {
            root.insertInOrder(x);
        }
        size++;
    }


    public TreeNode getRandomNode() {
        AtomicInteger random = new AtomicInteger(new Random().nextInt(size));
        return inOrderWithStop(root, random, new AtomicInteger(0));
    }

    private TreeNode inOrderWithStop(TreeNode root, AtomicInteger random, AtomicInteger current) {
        if (root == null) {
            return null;
        }
        TreeNode treeNode = inOrderWithStop(root.left, random, current);
        if (treeNode != null) {
            return treeNode;
        }
        if (random.get() == current.get()) {
            return root;
        } else {
            current.incrementAndGet();
        }
        return inOrderWithStop(root.right, random, current);
    }
}

class TreeNode {
    public TreeNode right;
    public TreeNode left;
    int data;


    public TreeNode(int data) {
        this.data = data;
    }

    public TreeNode find(int d) {
        if (d == data) {
            return this;
        }
        if (d <= data) {
            return left != null ? left.find(d) : null;
        } else {
            return right != null ? right.find(d) : null;
        }
    }


    public void insertInOrder(int x) {
        if (this.data >= x) {
            if (left == null) {
                left = new TreeNode(x);
            } else {
                left.insertInOrder(x);
            }

        } else {
            if (right == null) {
                right = new TreeNode(x);
            } else {
                right.insertInOrder(x);
            }
        }
    }
}
