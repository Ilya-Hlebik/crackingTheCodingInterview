package Ch_16_Moderate.Q16_11_Diving_Board;

import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        int nSticks = 12;
        int shorter = 2;
        int longer = 3;
        HashSet<Integer> lengthsA = allLengths(nSticks, shorter, longer);

        System.out.println(lengthsA.toString());
    }

    private static HashSet<Integer> allLengths(int nSticks, int shorter, int longer) {
        HashSet<Integer> result = new HashSet<>();
        getAllLengths(nSticks, 0, shorter, longer, result);
        return result;
    }

    private static void getAllLengths(int nSticks, int total, int shorter, int longer, HashSet<Integer> result) {
        if (nSticks == 0) {
            result.add(total);
            return;
        }
        getAllLengths(nSticks - 1, total + shorter, shorter, longer, result);
        getAllLengths(nSticks - 1, total + longer, shorter, longer, result);

    }
}
