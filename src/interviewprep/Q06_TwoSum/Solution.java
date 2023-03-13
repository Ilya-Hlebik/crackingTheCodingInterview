package interviewprep.Q06_TwoSum;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[0];
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            Integer integer = map.get(target - current);
            if (integer != null) {
                result = new int[]{i, integer};
                break;
            } else {
                map.put(current, i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        twoSum(new int[]{2,7,11,15}, 9);
    }
}
