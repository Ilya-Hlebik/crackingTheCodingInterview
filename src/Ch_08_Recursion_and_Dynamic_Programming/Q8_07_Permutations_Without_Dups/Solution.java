package Ch_08_Recursion_and_Dynamic_Programming.Q8_07_Permutations_Without_Dups;

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> list = getPerms("abcde", 0);
        System.out.println("There are " + list.size() + " permutations.");
        for (String s : list) {
            System.out.println(s);
        }
    }

    private static ArrayList<String> getPerms(String source, int index) {
        ArrayList<String> allPermutations;
        if (index > source.length() - 1) {
            allPermutations = new ArrayList<>();
            allPermutations.add(source);
        } else {
            allPermutations = getPerms(source, index + 1);
            char item = source.charAt(index);
            StringBuilder temp = new StringBuilder(source);
            temp = temp.replace(index, index + 1, "");
            for (int i = 0; i < temp.length(); i++) {
                StringBuilder innerTem = new StringBuilder(temp);
                innerTem.insert(i, item);
                if (!allPermutations.contains(innerTem.toString())) {
                    allPermutations.add(innerTem.toString());
                }
            }
        }

        return allPermutations;
    }
}
