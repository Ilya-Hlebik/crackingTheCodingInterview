package Ch_16_Moderate.Q16_16_Sub_Sort;

public class Solution {
    public static void main(String[] args) {
        int[] array = {1, 2, 4, 7, 10, 11, 8, 12, 5, 6, 16, 18, 19};

        Range r = findUnsortedSequence(array);
        System.out.println(r.toString());
        System.out.println(array[r.start] + ", " + array[r.end]);
    }

    private static Range findUnsortedSequence(int[] array) {
        int min = Integer.MAX_VALUE;
        int startMiddle = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            if (min < array[i]) {
                startMiddle = i;
            }
            min = Math.min(array[i], min);
        }
        int endMiddle = 0;
        for (int i = array.length-1; i>0; i--){
            if (array[i] < array[i-1]){
                endMiddle = i+1;
                break;
            }
        }
        return new Range(startMiddle, endMiddle);
    }
}
