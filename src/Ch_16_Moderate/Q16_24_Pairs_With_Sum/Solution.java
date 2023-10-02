package Ch_16_Moderate.Q16_24_Pairs_With_Sum;

import CtCILibrary.AssortedMethods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int[] array = {7, 9, 3, 6, 5, 7, 7, -1, 13, 14, -2, 12, 0};
        int sum = 14;

        ArrayList<Pair> pairsA = printPairSums(array, sum);

        System.out.println(AssortedMethods.arrayToString(array));
        System.out.println("sum: " + sum);
        print(pairsA);
        System.out.println();
        System.out.println();
        System.out.println();
    }

    private static ArrayList<Pair> printPairSums(int[] array, int sum) {
        ArrayList<Pair> pairs = new ArrayList<>();
        Map<Integer, Integer> numberMap = new HashMap<>();
        for (int value : array) {
            int searchValue = sum - value;
            if (numberMap.getOrDefault(searchValue, 0) > 0) {
                pairs.add(new Pair(value, searchValue));
                numberMap.put(searchValue, numberMap.getOrDefault(searchValue, 0) - 1);
            } else {
                numberMap.put(value, numberMap.getOrDefault(value, 0) + 1);
            }
        }
        return pairs;
    }

    public static void print(ArrayList<Pair> pairs) {
        for (Pair p : pairs) {
            System.out.print(p.toString() + ", ");
        }
        System.out.println();
    }
}

class Pair {
    public int first;
    public int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}
