package Ch_10_Sorting_and_Searching.Binary_search.run2;

public class Solution {
    public static void main(String[] args) {
        System.out.println(binarySearchRecursive(new int[]{1, 2, 3, 4, 5, 6, 7}, 5, 0, 6));
    }

    private static int binarySearchRecursive(int[] ints, int number, int min, int max) {
        if (min > max) {
            return -1;
        }
        int middle = min + (max - min) / 2;
        int middleValue = ints[middle];
        if (middleValue == number) {
            return max;
        }
        if (middleValue > number) {
            return binarySearchRecursive(ints, number, min, middle - 1);
        }
        return binarySearchRecursive(ints, number, middle + 1, max);
    }


}
