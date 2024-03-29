package Ch_10_Sorting_and_Searching.Merge_sort;

import java.util.Arrays;

public class Solution {

    public void mergeSort(int array[]) {
        int helper[] = new int[array.length];
        mergeSort(array, helper, 0, array.length - 1);
    }

    private void mergeSort(int[] array, int[] helper, int low, int high) {
        if (high > low) {
            int middle = low + (high - low) / 2;
            mergeSort(array, helper, low, middle);
            mergeSort(array, helper, middle + 1, high);
            merge(array, helper, low, middle, high);
        }
    }

    private void merge(int[] array, int[] helper, int low, int middle, int high) {
        for (int i = low; i <= high; i++) {
            helper[i] = array[i];
        }
        int helperLeft = low;
        int helperRight = middle + 1;
        int current = low;
        while (helperLeft <= middle && helperRight <= high) {
            if (helper[helperLeft] <= helper[helperRight]) {
                array[current] = helper[helperLeft];
                helperLeft++;
            } else {
                array[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }
        int remaining = middle - helperLeft;
        for (int i = 0; i <= remaining; i++) {
            array[current + i] = helper[helperLeft + i];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {4, 3, 6, 7, 8, 2, 3, 5, 8, 9, 1, 2};
        solution.mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
