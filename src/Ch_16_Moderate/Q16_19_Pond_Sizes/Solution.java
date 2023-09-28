package Ch_16_Moderate.Q16_19_Pond_Sizes;

import java.util.ArrayList;

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
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if (land[i][j] == 0) {
                    result.add(calculateWatter(land, i, j));
                }
            }
        }
        return result;
    }

    private static Integer calculateWatter(int[][] land, int i, int j) {
        if (i < 0 || i > land.length - 1 || j < 0 || j > land[i].length - 1 || land[i][j] != 0) {
            return 0;
        }
        int total = 1;
        land[i][j] = -1;
        for (int r = -1; r <= 1; r++) {
            for (int c = -1; c <= 1; c++) {
                total += calculateWatter(land, i + r, j + c);
            }
        }
        return total;
    }
}
