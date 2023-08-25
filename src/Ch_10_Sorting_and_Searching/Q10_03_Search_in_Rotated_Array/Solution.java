package Ch_10_Sorting_and_Searching.Q10_03_Search_in_Rotated_Array;


public class Solution {
    public static void main(String[] args) {
        int[] a = {2, 3, 1, 2, 2, 2, 2, 2, 2, 2};

        System.out.println(search(a, 2));
        System.out.println(search(a, 3));
        System.out.println(search(a, 4));
        System.out.println(search(a, 1));
        System.out.println(search(a, 8));
    }

    private static int search(int[] a, int x) {
        return search(a, x, 0, a.length - 1);
    }

    private static int search(int[] a, int x, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (a[mid] == x) {
            return mid;
        } else {
            int searchRight = search(a, x, mid + 1, high);
            if (searchRight != -1) {
                return searchRight;
            }
            return search(a, x, low, mid - 1);
        }
    }
}
