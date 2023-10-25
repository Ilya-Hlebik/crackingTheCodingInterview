package Ch_08_Recursion_and_Dynamic_Programming.Q8_01_Triple_Step.run2;


public class Solution {
    public static void main(String[] args) {

        for (int i = 1; i < 30; i++) {
            int c1 = countWays(i);
            System.out.println(i + ": " + c1);
        }
    }

    private static int countWays(int numberOfStairs) {
        return countWays(numberOfStairs, 0, 0);
    }

    private static int countWays(int numberOfStairs, int currentNumber, int countOfSteps) {
        if (currentNumber > numberOfStairs) {
            return 0;
        }
        currentNumber += countOfSteps;
        int totalNumber = 0;
        if (currentNumber == numberOfStairs) {
            totalNumber++;
        }
        totalNumber += countWays(numberOfStairs, currentNumber, 1);
        totalNumber += countWays(numberOfStairs, currentNumber, 2);
        totalNumber += countWays(numberOfStairs, currentNumber, 3);
        return totalNumber;
    }
}
