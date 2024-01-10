package Ch_16_Moderate.Q16_24_Pairs_With_Sum.run2;

import Ch_16_Moderate.Q16_24_Pairs_With_Sum.Pair;
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

    public static void print(ArrayList<Pair> pairs) {
        for (Pair p : pairs) {
            System.out.print(p.toString() + ", ");
        }
        System.out.println();
    }

    private static ArrayList<Pair> printPairSums(int[] array, int sum) {
        ArrayList<Pair> pairs = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : array) {
            if (map.getOrDefault(sum - i, 0) > 0) {
                pairs.add(new Pair(i, sum - i));
                map.put(sum - i, map.get(sum - i) - 1);
            } else {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
        }
        return pairs;
    }

}
