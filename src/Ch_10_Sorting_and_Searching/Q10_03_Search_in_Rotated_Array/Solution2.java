package Ch_10_Sorting_and_Searching.Q10_03_Search_in_Rotated_Array;


public class Solution2 {
    public static void main(String[] args) {
        int[] a = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7};

        System.out.println(search(a, 5));
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
        int middle = low + (high - low) / 2;
        if (x == a[middle]) {
            return middle;
        }
        if (a[low] < a[middle]) {
            if (a[low] <= x && x < a[middle]) {
                return search(a, x, low, middle - 1);
            } else {
                return search(a, x, middle + 1, high);
            }
        } else if (a[high] > a[middle]) {
            if (a[high] >= x && x > a[middle]) {
                return search(a, x, middle + 1, high);
            } else {
                return search(a, x, low, middle - 1);
            }
        } else {
            int location = -1;
            if (a[low] == a[middle]) {
                location = search(a, x, middle + 1, high);
            }
            if (location == -1 && a[middle] == a[high]) {
                location = search(a, x, low, middle - 1);
            }
            return location;
        }
    }
}
