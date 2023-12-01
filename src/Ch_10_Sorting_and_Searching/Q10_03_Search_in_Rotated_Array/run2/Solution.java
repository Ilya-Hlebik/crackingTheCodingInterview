package Ch_10_Sorting_and_Searching.Q10_03_Search_in_Rotated_Array.run2;

public class Solution {
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
        int mid = low + (high - low) / 2;
        if (a[mid] == x) {
            return mid;
        }
        if (a[low] < a[mid]) { // left normal order
            if (a[low] <= x && a[mid] > x) {
                return search(a, x, low, mid - 1);
            } else {
                return search(a, x, mid + 1, high);
            }
        } else if (a[high] > a[mid]) { // right normal order
            if (a[high] >= x && a[mid] < x) {
                return search(a, x, mid + 1, high);
            } else {
                return search(a, x, low, mid - 1);
            }
        } else { //dups
            int location = -1;
            if (a[low] == a[mid]) {
                location = search(a, x, mid + 1, high);
            }
            if (location == -1 && a[high] == a[mid]) {
                location = search(a, x, low, mid - 1);
            }
            return location;
        }
    }
}
