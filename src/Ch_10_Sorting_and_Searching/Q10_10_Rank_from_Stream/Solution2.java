package Ch_10_Sorting_and_Searching.Q10_10_Rank_from_Stream;

import CtCILibrary.AssortedMethods;

public class Solution2 {
    private static RankNode2 root = null;

    public static void track(int number) {
        if (root == null) {
            root = new RankNode2(number);
        } else {
            root.insert(number);
        }
    }

    public static int getRankOfNumber(int number) {
        return root.getRank(number);
    }

    public static void main(String[] args) {
        int size = 100;
        int[] list = AssortedMethods.randomArray(size, -100, 100);
        for (int i = 0; i < list.length; i++) {
            track(list[i]);
        }

        int[] tracker = new int[size];
        for (int i = 0; i < list.length; i++) {
            int v = list[i];
            int rank1 = getRankOfNumber(list[i]);
            tracker[rank1] = v;
        }

        for (int i = 0; i < tracker.length - 1; i++) {
            if (tracker[i] != 0 && tracker[i + 1] != 0) {
                if (tracker[i] > tracker[i + 1]) {
                    System.out.println("ERROR at " + i);
                }
            }
        }

        System.out.println("Array: " + AssortedMethods.arrayToString(list));
        System.out.println("Ranks: " + AssortedMethods.arrayToString(tracker));
    }
}

class RankNode2 {
    private int leftSize;
    private final int number;
    private RankNode2 left;
    private RankNode2 right;

    public RankNode2(int number) {
        this.number = number;
    }

    public int getRank(int number) {
        if (this.number == number) {
            return leftSize;
        } else if (number < this.number) {
            if (left == null) {
                return -1;
            } else {
                return left.getRank(number);
            }
        } else {
            int rightRank = right == null ? -1 : right.getRank(number);
            if (rightRank == -1) {
                return -1;
            } else {
                return leftSize + 1 + rightRank;
            }
        }
    }

    public void insert(int number) {
        if (number <= this.number) {
            if (left != null) {
                left.insert(number);
            } else {
                left = new RankNode2(number);
            }
            leftSize++;
        } else {
            if (right != null) {
                right.insert(number);
            } else {
                right = new RankNode2(number);
            }
        }
    }
}
