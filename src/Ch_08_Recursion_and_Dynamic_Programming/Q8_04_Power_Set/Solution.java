package Ch_08_Recursion_and_Dynamic_Programming.Q8_04_Power_Set;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list.add(i);
        }
        List<ArrayList<Integer>> subsets = getSubsets(list, 0);
        System.out.println(subsets.toString());
    }

    private static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
        ArrayList<ArrayList<Integer>> allsubsets;
        if (index > set.size() - 1) {
            allsubsets = new ArrayList<>();
            allsubsets.add(new ArrayList<>());
        } else {
            allsubsets = getSubsets(set, index + 1);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<>();
            for (ArrayList<Integer> allsubset : allsubsets) {
                ArrayList<Integer> newsubset = new ArrayList<>();
                newsubset.addAll(allsubset);
                newsubset.add(item);
                moresubsets.add(newsubset);
            }
            allsubsets.addAll(moresubsets);
        }


        return allsubsets;
    }

}
