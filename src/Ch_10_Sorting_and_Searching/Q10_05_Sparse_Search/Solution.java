package Ch_10_Sorting_and_Searching.Q10_05_Sparse_Search;


public class Solution {

    public static void main(String[] args) {
        String[] stringList = {"apple", "", "", "banana", "", "", "", "carrot", "duck", "", "", "eel", "", "flower"};
        System.out.println(search(stringList, "banana"));
    }

    private static int search(String[] array, String value) {
        return binarySearch(array, value, 0, array.length - 1);
    }

    public static int binarySearch(String[] array, String value, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        String midValue = array[mid];
        if (midValue.equals("")) {
            int leftMid = mid;
            int rightMid = mid;
            while (leftMid > low && rightMid < high) {
                if (!array[--leftMid].equals("")) {
                    mid = leftMid;
                    break;
                } else if (!array[++rightMid].equals("")) {
                    mid = rightMid;
                    break;
                }
            }
            if (array[mid].equals("")) {
                return -1;
            }
            midValue = array[mid];
        }
        int comparison = midValue.compareTo(value);
        if (comparison == 0) {
            return mid;
        } else if (comparison > 0) {
            return binarySearch(array, value, low, mid - 1);
        } else {
            return binarySearch(array, value, mid + 1, high);
        }
    }
}
