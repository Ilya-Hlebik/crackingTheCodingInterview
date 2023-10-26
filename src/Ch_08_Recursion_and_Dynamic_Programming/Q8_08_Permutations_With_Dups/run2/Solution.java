package Ch_08_Recursion_and_Dynamic_Programming.Q8_08_Permutations_With_Dups.run2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> list = getPerms("aabbccc").stream().distinct().collect(Collectors.toCollection(ArrayList::new));
        System.out.println("There are " + list.size() + " permutations.");
        for (String s : list) {
            System.out.println(s);
        }
    }

    private static ArrayList<String> getPerms(String aabbccc) {

        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(aabbccc.split("")));
        return getPerms(arrayList, 0);
    }

    private static ArrayList<String> getPerms(ArrayList<String> strings, int index) {
        if (strings == null) {
            return null;
        }
        ArrayList<String> result = new ArrayList<>();
        if (index == strings.size()) {
            result.add("");
            return result;
        }
        String first = strings.get(index);
        ArrayList<String> words = getPerms(strings, index + 1);
        for (String word : words) {
            for (int i = 0; i <= word.length(); i++) {
                String newStr = new StringBuilder(word).insert(i, first).toString();
                result.add(newStr);
            }
        }
        return result;
    }
}
