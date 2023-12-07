package Ch_10_Sorting_and_Searching.Q10_10_Rank_from_Stream.run2;

import CtCILibrary.AssortedMethods;

public class Solution {
    static RankNode rankNode;


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

    private static int getRankOfNumber(int i) {
        return rankNode.getRank(i);
    }

    private static void track(int i) {
        if (rankNode == null) {
            rankNode = new RankNode(i);
        } else {
            rankNode.insert(i);
        }
    }

}

class RankNode {

    RankNode left, right;
    private final int data;

    public RankNode(int data) {
        this.data = data;
    }

    public void insert(int i) {
        if (i > data) {
            if (right != null) {
                right.insert(i);
            } else {
                right = new RankNode(i);
            }
        } else {
            if (left != null) {
                left.insert(i);
            } else {
                left = new RankNode(i);
            }
        }
    }

    public int getRank(int i) {
        int rankFromNodes = getRankFromNodes(i);
        return rankFromNodes == 0 ? 0 : rankFromNodes - 1;
    }

    public int getRankFromNodes(int i) {
        int counter = 0;
        counter += left == null ? 0 : left.getRankFromNodes(i);
        if (i >= data) {
            counter++;
        }
        counter += right == null ? 0 : right.getRankFromNodes(i);

        return counter;
    }
}
