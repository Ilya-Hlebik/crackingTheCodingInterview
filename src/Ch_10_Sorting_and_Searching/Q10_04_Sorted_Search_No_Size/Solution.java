package Ch_10_Sorting_and_Searching.Q10_04_Sorted_Search_No_Size;

public class Solution {
    public static int search(Listy list, int value) {
        int index = 1;
        while (list.elementAt(index) != -1 && list.elementAt(index) < value) {
            index *= 2;
        }

        return binarySearch(list, value, 0, index);
    }

    public static int binarySearch(Listy list, int value, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        int midValue = list.elementAt(mid);
        if (midValue == value) {
            return mid;
        } else if (midValue > value || midValue == -1) {
            return binarySearch(list, value, low, mid - 1);
        } else {
            return binarySearch(list, value, mid + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 4, 5, 6, 7, 9, 10, 11, 12, 13, 14, 16, 18};
        Listy list = new Listy(array);
        for (int a : array) {
            System.out.println(search(list, a));
        }
        System.out.println(search(list, 15));
    }
}

class Listy {
    int[] array;

    public Listy(int[] arr) {
        array = arr.clone();
    }

    public int elementAt(int index) {
        if (index >= array.length) {
            return -1;
        }
        return array[index];
    }
}
