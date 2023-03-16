package Ch_04_Trees_and_Graphs.Q4_02_Minimal_Tree;

public class Solution {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // We needed this code for other files, so check out the code in the library
        MyTreeNode root = MyTreeNode.createMinimalBST(array);
        System.out.println("Root? " + root.data);
        System.out.println("Created BST? " + root.isBST());
        System.out.println("Height: " + root.height());
    }

}

class MyTreeNode {
    int data;
    MyTreeNode left;
    MyTreeNode right;

    public static MyTreeNode createMinimalBST(int[] array) {
        return createMinimalBST(array, 0, array.length - 1);
    }

    private static MyTreeNode createMinimalBST(int[] array, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        MyTreeNode myTreeNode = new MyTreeNode(array[mid]);
        myTreeNode.setLeft(createMinimalBST(array, start, mid - 1));
        myTreeNode.setRight(createMinimalBST(array, mid + 1, end));
        return myTreeNode;
    }

    public void setLeft(MyTreeNode left) {
        this.left = left;
    }

    public void setRight(MyTreeNode right) {
        this.right = right;
    }

    public MyTreeNode(int data) {
        this.data = data;
    }

    public int height() {
        int leftHeight = left != null ? left.height() : 0;
        int rightHeight = right != null ? right.height() : 0;
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public boolean isBST() {
        if (left !=null){
            if (data < left.data || !left.isBST()){
                return false;
            }
        }
        if (right != null){
            if (data >= right.data || !right.isBST()){
                return false;
            }
        }
        return true;
    }
}
