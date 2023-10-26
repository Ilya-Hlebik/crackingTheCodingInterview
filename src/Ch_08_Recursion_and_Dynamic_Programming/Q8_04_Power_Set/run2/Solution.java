package Ch_08_Recursion_and_Dynamic_Programming.Q8_04_Power_Set.run2;

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

    private static List<ArrayList<Integer>> getSubsets(ArrayList<Integer> list, int index) {

        List<ArrayList<Integer>> result;
        if (list.size() == index) {
            result = new ArrayList<>();
            result.add(new ArrayList<>());
        } else {
            result = getSubsets(list, index + 1);
            int item = list.get(index);
            List<ArrayList<Integer>> moreSubsets = new ArrayList<>();
            for (ArrayList<Integer> integers : result) {
                ArrayList<Integer> newSubSet = new ArrayList<>();
                newSubSet.addAll(integers);
                newSubSet.add(item);
                moreSubsets.add(newSubSet);
            }
            result.addAll(moreSubsets);
        }

        return result;
    }

}
