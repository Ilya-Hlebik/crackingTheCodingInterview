package Ch_16_Moderate.Q16_11_Diving_Board;

import java.util.HashSet;

public class Solution2 {
    public static void main(String[] args) {
        int nSticks = 12;
        int shorter = 2;
        int longer = 3;
        HashSet<Integer> lengthsA = allLengths(nSticks, shorter, longer);

        System.out.println(lengthsA.toString());
    }

    private static HashSet<Integer> allLengths(int nSticks, int shorter, int longer) {
        HashSet<Integer> result = new HashSet<>();
        for (int i = 0; i <= nSticks; i++) {
            int countLonger = nSticks - i;
            int total = countLonger * longer + i * shorter;
            result.add(total);
        }
        return result;
    }
}
