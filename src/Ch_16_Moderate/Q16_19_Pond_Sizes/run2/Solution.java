package Ch_16_Moderate.Q16_19_Pond_Sizes.run2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int[][] land = {{0, 2, 1, 0}, {0, 1, 0, 1}, {1, 1, 0, 1}, {0, 1, 0, 1}};
        ArrayList<Integer> sizes = computePondSizes(land);
        for (int sz : sizes) {
            System.out.println(sz);
        }
    }

    private static ArrayList<Integer> computePondSizes(int[][] land) {
        ArrayList<Integer> result = new ArrayList<>();
        Set<Map.Entry<Integer, Integer>> excluded = new HashSet<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if (land[i][j] == 0) {
                    result.add(computePondSizes(land, i, j, excluded));
                }
            }
        }
        return result;
    }

    private static int computePondSizes(int[][] land, int i, int j, Set<Map.Entry<Integer, Integer>> excluded) {
        int total = 0;
        if (i < 0 || j < 0 || i > land.length - 1 || j > land[i].length - 1 || land[i][j] != 0) {
            return total;
        }
        excluded.add(Map.entry(i, j));
        total++;
        land[i][j] = -1;
        total += computePondSizes(land, i - 1, j, excluded);
        total += computePondSizes(land, i - 1, j + 1, excluded);
        total += computePondSizes(land, i, j + 1, excluded);
        total += computePondSizes(land, i + 1, j + 1, excluded);
        total += computePondSizes(land, i + 1, j, excluded);
        total += computePondSizes(land, i + 1, j - 1, excluded);
        total += computePondSizes(land, i, j - 1, excluded);
        total += computePondSizes(land, i - 1, j - 1, excluded);
        return total;
    }
}
