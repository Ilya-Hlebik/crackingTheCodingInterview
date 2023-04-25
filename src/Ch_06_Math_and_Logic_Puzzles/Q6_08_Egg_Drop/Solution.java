package Ch_06_Math_and_Logic_Puzzles.Q6_08_Egg_Drop;

public class Solution {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(" attempts: " +dropResult(100, i));
        }
    }

    public static int dropResult(int florAmount, int breakLevel) {
        boolean eggOneNotBreak = true;
        int countOfAttempts = 0;
        for (int i = 0, j = 10; i < florAmount; i++) {
            countOfAttempts++;
            if (j > breakLevel) {
                if (!eggOneNotBreak) {
                    throw new RuntimeException();
                }
                eggOneNotBreak = false;
                j -= 10;
            } else if (j == breakLevel) {
                System.out.print("breakLevel: " + j);
                break;
            } else if (j < breakLevel) {
                if (eggOneNotBreak){
                    j += 10;
                }
                else {
                    j++;
                }
            }
        }
        return countOfAttempts;
    }
}
