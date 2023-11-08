package Ch_06_Math_and_Logic_Puzzles.Q6_07_The_Apocalypse.run2;

import java.util.Random;

public class Solution {
    public static void main(String[] args) {
        simulation();
    }

    private static void simulation() {
        int countOfBoys = 0;
        int countOfGirls = 0;
        int countOfFamilies = 100000000;
        Random random = new Random();
        for (int i = 0; i <= countOfFamilies; i++) {
            while (random.nextBoolean()){
                countOfBoys++;
            }
            countOfGirls++;
        }
        System.out.println((double) countOfBoys/countOfGirls);
    }
}
