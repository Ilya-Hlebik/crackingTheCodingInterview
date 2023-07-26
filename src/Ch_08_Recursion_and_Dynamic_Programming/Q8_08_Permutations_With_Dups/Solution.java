package Ch_08_Recursion_and_Dynamic_Programming.Q8_08_Permutations_With_Dups;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> list = getPerms("aabbccc").stream().distinct().collect(Collectors.toCollection(ArrayList::new));
        System.out.println("There are " + list.size() + " permutations.");
        for (String s : list) {
            System.out.println(s);
        }
    }

    private static ArrayList<String> getPerms(String source) {
        if (source == null) {
            return null;
        }
        ArrayList<String> allPermutations = new ArrayList<>();
        if (source.length() == 0) {
            allPermutations.add("");
            return allPermutations;
        }
        char first = source.charAt(0);
        ArrayList<String> words = getPerms(source.substring(1));
        for (String word : words) {
            for (int i = 0; i <= word.length(); i++) {
                String s = new StringBuilder(word).insert(i, first).toString();
                allPermutations.add(s);
            }
        }
        return allPermutations;
    }
}
