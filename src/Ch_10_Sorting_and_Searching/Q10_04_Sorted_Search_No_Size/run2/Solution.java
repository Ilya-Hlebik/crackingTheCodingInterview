package Ch_10_Sorting_and_Searching.Q10_04_Sorted_Search_No_Size.run2;

import Ch_10_Sorting_and_Searching.Q10_04_Sorted_Search_No_Size.Listy;

public class Solution {
    public static void main(String[] args) {
        int[] array = {1, 2, 4, 5, 6, 7, 9, 10, 11, 12, 13, 14, 16, 18};
        Listy list = new Listy(array);
        for (int a : array) {
            System.out.println(search(list, a));
        }
        System.out.println(search(list, 15));
    }

    private static int search(Listy list, int a) {
        int lastIndex = 1;
        while (list.elementAt(lastIndex) < a && list.elementAt(lastIndex) != -1) {
            lastIndex *= 2;
        }
        return search(list, a, lastIndex / 2, lastIndex);
    }

    private static int search(Listy list, int a, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (list.elementAt(mid) == a) {
            return mid;
        }
        if (list.elementAt(mid) == -1 || list.elementAt(mid) > a) {
            return search(list, a, low, mid - 1);
        }
        return search(list, a, mid + 1, high);
    }
}
