package Ch_06_Math_and_Logic_Puzzles.Q6_07_The_Apocalypse;

import java.util.Random;

public class Solution {
    public static int[] runOneFamily() {
        Random random = new Random();
        int boys = 0;
        int girls = 0;
        while (girls == 0) { // until we have a girl
            if (random.nextBoolean()) { // girl
                girls += 1;
            } else { // boy
                boys += 1;
            }
        }
        int[] genders = {girls, boys};
        return genders;
    }

    public static double runNFamilies(int n) {
        int boys = 0;
        int girls = 0;
        for (int i = 0; i < n; i++) {
            int[] genders = runOneFamily();
            girls += genders[0];
            boys += genders[1];
        }
        return girls / (double) (boys);
    }

    public static void main(String[] args) {
        double ratio = runNFamilies(100000000);
        System.out.println(ratio);

    }
}
