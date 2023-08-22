package Ch_10._Sorting_and_Searching.Binary_search;

public class Solution {
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1, 2, 3, 4, 5, 6, 7}, 5));
        System.out.println(binarySearchRecursive(new int[]{1, 2, 3, 4, 5, 6, 7}, 5,0, 6));
    }

    public static int binarySearch(int arr[], int x) {
        int low = 0;
        int high = arr.length - 1;
        while (high >= low) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > x) {
                high = mid -1;
            } else if (arr[mid] < x) {
                    low = mid +1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int binarySearchRecursive(int arr[], int x, int low, int high) {
        if (low > high){
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (arr[mid] > x) {
            return binarySearchRecursive(arr, x, low, mid -1);
        } else if (arr[mid] < x) {
            return binarySearchRecursive(arr, x, mid +1, high);
        } else {
            return mid;
        }
    }
}
