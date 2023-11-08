package Ch_06_Math_and_Logic_Puzzles.Q6_08_Egg_Drop.run2;

public class Solution {
    public static int countDrops = 0;
    public static int breakingPoint = 89;


    private static int findBreakingPoint(int countOfFloors) {
        int countOfSteps = 14;
        int currentFloor = 0;
        int previousFloor = 0;
        while (breakingPoint > currentFloor) {
            countDrops++;
            previousFloor = currentFloor;
            currentFloor += countOfSteps;
            countOfSteps--;
        }
        if (breakingPoint < currentFloor) {
            currentFloor = previousFloor;
        }
        while (currentFloor != breakingPoint) {
            countDrops++;
            currentFloor++;
        }
        return currentFloor;
    }

    public static void main(String[] args) {
        int max = 0;
        for (int i = 1; i <= 100; i++) {
            countDrops = 0;
            breakingPoint = i;
            countDrops = 0;
            int bp = findBreakingPoint(100);

            if (bp == breakingPoint) {
                System.out.println("SUCCESS: " + i + " -> " + bp + " -> " + countDrops);
            } else {
                System.out.println("ERROR: " + i + " -> " + bp + " vs " + breakingPoint);
                break;
            }
            max = countDrops > max ? countDrops : max;
        }
        System.out.println(max);
    }
}
