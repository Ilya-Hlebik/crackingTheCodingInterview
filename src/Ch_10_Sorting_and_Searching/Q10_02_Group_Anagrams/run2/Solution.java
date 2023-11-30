package Ch_10_Sorting_and_Searching.Q10_02_Group_Anagrams.run2;

import CtCILibrary.AssortedMethods;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String[] array = {"apple", "banana", "carrot", "ele", "duck", "papel", "tarroc", "cudk", "eel", "lee"};
        sort(array);
        System.out.println(AssortedMethods.stringArrayToString(array));
    }

    private static void sort(String[] array) {
        Arrays.sort(array, (o1, o2) -> {
            char[] chars = o1.toCharArray();
            char[] chars1 = o2.toCharArray();
            Arrays.sort(chars);
            Arrays.sort(chars1);
            return new String(chars).compareTo(new String(chars1));
        });
    }

}
