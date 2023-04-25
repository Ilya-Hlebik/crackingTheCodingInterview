package Ch_06_Math_and_Logic_Puzzles.Q6_08_Egg_Drop;

public class Solution2 {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            System.out.println(" attempts: " + dropResult(100, i));
        }
    }

    public static int dropResult(int florAmount, int breakLevel) {
        boolean eggOneNotBreak = true;
        int countOfAttempts = 0;
        int j = 14;
        int currentLevel = 0;
        while (true) {
            if (currentLevel > breakLevel) {
                if (!eggOneNotBreak) {
                    throw new RuntimeException();
                }
                eggOneNotBreak = false;
                currentLevel -= j;
                j = j - 1;
            } else if (currentLevel == breakLevel) {
                System.out.print("breakLevel: " + currentLevel);
                break;
            } else if (currentLevel < breakLevel) {
                if (eggOneNotBreak) {
                    currentLevel += j;
                    j = j - 1;
                } else {
                    currentLevel++;
                }
            }
            countOfAttempts++;
        }
        return countOfAttempts;
    }
}
