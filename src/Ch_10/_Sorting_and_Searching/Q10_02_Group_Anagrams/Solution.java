package Ch_10._Sorting_and_Searching.Q10_02_Group_Anagrams;

import CtCILibrary.AssortedMethods;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
        String[] array = {"apple", "banana", "carrot", "ele", "duck", "papel", "tarroc", "cudk", "eel", "lee"};
        System.out.println(AssortedMethods.stringArrayToString(array));
        Arrays.sort(array, new AnagramComparator());
        System.out.println(AssortedMethods.stringArrayToString(array));
    }
}

class AnagramComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return sort(o1).compareTo(sort(o2));
    }

    private String sort(String o1) {
        char[] o1Char = o1.toCharArray();
        Arrays.sort(o1Char);
        return new String(o1Char);
    }
}
