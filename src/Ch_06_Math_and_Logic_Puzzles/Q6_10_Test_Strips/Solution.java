package Ch_06_Math_and_Logic_Puzzles.Q6_10_Test_Strips;

public class Solution {
    static int currentPoisoned = 1;
    int total = 10000;

    public static void main(String[] args) {
        for (int i = 1; i < 10000; i++) {
            currentPoisoned = i;
        }
    }

    int amountOfDays() {
        int countOfTests = 10;
        int each = total / countOfTests;
        while (total !=0){

        }
    }

    boolean isPoisoned(int fromRange, int toRange) {
        return fromRange >= currentPoisoned && toRange <= currentPoisoned;
    }
}
