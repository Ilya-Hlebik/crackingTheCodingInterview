package Ch_10_Sorting_and_Searching.Q10_05_Sparse_Search.run2;

public class Solution {
    public static void main(String[] args) {
        String[] stringList = {"apple", "", "", "banana", "", "", "", "carrot", "duck", "", "", "eel", "", "flower"};
        System.out.println(search(stringList, "banana"));
    }

    private static int search(String[] stringList, String word) {
        return search(stringList, word, 0, stringList.length - 1);
    }

    private static int search(String[] stringList, String word, int min, int max) {
        if (min > max) {
            return -1;
        }
        int mid = min + (max - min) / 2;
        int tempMid = mid;
        while (stringList[tempMid].equals("") && tempMid <= max) {
            tempMid++;
        }
        if (stringList[tempMid].equals("")) {
            tempMid = mid;
            while (stringList[tempMid].equals("") && tempMid >= min) {
                tempMid--;
            }
        }
        if (stringList[tempMid].equals("")) {
            return -1;
        }
        mid = tempMid;
        if (stringList[mid].equals(word)) {
            return mid;
        }
        if (stringList[mid].compareTo(word) > 0) {
            return search(stringList, word, min, mid - 1);
        }
        return search(stringList, word, mid + 1, max);
    }
}
