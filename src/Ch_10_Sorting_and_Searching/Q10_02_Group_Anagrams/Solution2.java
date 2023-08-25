package Ch_10_Sorting_and_Searching.Q10_02_Group_Anagrams;

import CtCILibrary.AssortedMethods;

import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
        String[] array = {"apple", "banana", "carrot", "ele", "duck", "papel", "tarroc", "cudk", "eel", "lee"};
        sort(array);
        System.out.println(AssortedMethods.stringArrayToString(array));
    }

    public static void sort(String[] array) {
        Map<String, List<String>> map = new LinkedHashMap<>();
        for (String s : array) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            map.putIfAbsent(new String(chars), new ArrayList<>());
            map.computeIfPresent(new String(chars), (s1, strings) -> {
                strings.add(s);
                return strings;
            });
        }
        int i = 0;
        for (List<String> entry : map.values()) {
            for (String s : entry) {
                array[i] = s;
                i++;
            }
        }
    }
}
