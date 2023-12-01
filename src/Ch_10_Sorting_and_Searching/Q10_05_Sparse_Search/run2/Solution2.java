package Ch_10_Sorting_and_Searching.Q10_05_Sparse_Search.run2;

public class Solution2 {
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
        int tempMidLeft = mid;
        int tempMidRigth = mid;
        while (stringList[mid].equals("") && (tempMidLeft > min || tempMidRigth < max)) {
            if (tempMidLeft >= min && !stringList[--tempMidLeft].equals("")) {
                mid = tempMidLeft;
                break;
            } else if (tempMidRigth <= max && !stringList[++tempMidRigth].equals("")) {
                mid = tempMidRigth;
                break;
            }
        }
        if (stringList[mid].equals("")) {
            return -1;
        }
        if (stringList[mid].equals(word)) {
            return mid;
        }
        if (stringList[mid].compareTo(word) > 0) {
            return search(stringList, word, min, mid - 1);
        }
        return search(stringList, word, mid + 1, max);
    }
}
