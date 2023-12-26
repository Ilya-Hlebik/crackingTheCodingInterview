package Ch_16_Moderate.Q16_11_Diving_Board.run2;

import java.util.HashSet;

public class  Solution {
    public static void main(String[] args) {
        int nSticks = 12;
        int shorter = 2;
        int longer = 3;
        HashSet<Integer> lengthsA = allLengths(nSticks, shorter, longer);

        System.out.println(lengthsA.toString());
    }

    private static HashSet<Integer> allLengths(int nSticks, int shorter, int longer) {
        return allLengths(nSticks, 0, shorter, longer);
    }

    private static HashSet<Integer> allLengths(int nSticks, int total, int shorter, int longer) {
        HashSet<Integer> set = new HashSet<>();
        if (nSticks == 0) {
            set.add(total);
            return set;
        }
        set.addAll(allLengths(nSticks - 1, total + shorter, shorter, longer));
        set.addAll(allLengths(nSticks - 1, total + longer, shorter, longer));
        return set;
    }
}
