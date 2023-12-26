package Ch_16_Moderate.Q16_11_Diving_Board.run2;

import java.util.HashSet;

public class Solution2 {
    public static void main(String[] args) {
        int nSticks = 12;
        int shorter = 2;
        int longer = 3;
        HashSet<Integer> lengthsA = allLengths(nSticks, shorter, longer);

        System.out.println(lengthsA.

                toString());
    }

    private static HashSet<Integer> allLengths(int nSticks, int shorter, int longer) {
        HashSet<Integer> lengths = new HashSet<>();
        for (int i = 0; i <= nSticks; i++) {
            int total = (nSticks - i) * longer + (i * shorter);
            lengths.add(total);
        }
        return lengths;
    }
}
