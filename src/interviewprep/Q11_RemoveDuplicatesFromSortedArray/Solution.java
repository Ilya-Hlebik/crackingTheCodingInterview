package interviewprep.Q11_RemoveDuplicatesFromSortedArray;

import java.util.Arrays;

public class Solution {
    public static int removeDuplicates(int[] nums) {
        int k = nums.length;
        for (int i =0; i<nums.length-1; i++){
            if (nums[i] == 101){
                return k;
            }
            if (nums[i] == nums[i+1]){
                k--;
                for (int j = i; j < nums.length-1; j++) {
                    nums[j] = nums[j+1];
                    if (j+1<nums.length){
                        nums[j+1] = 101;
                    }
                }
                i--;
            }
        }
        return k;
    }
    public static int removeDuplicates2(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i == 0 || n > nums[i-1])
                nums[i++] = n;
        return i;
    }
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates2(nums));
        System.out.println(Arrays.toString(nums));

    }
}
