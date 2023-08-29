package Ch_10_Sorting_and_Searching.Q10_07_Missing_Int;

public class Solution {

    public static void findOpenNUmber(int[] arr) {

        long numberOfInts =((long) Integer.MAX_VALUE) + 1;
        byte[] bitfield = new byte [(int) (numberOfInts / 8)];

        for (int i = 0; i < arr.length; i++) {
            int n = arr[i];
            bitfield[n/8] |= 1<<(n%8);
        }
        for (int i = 0; i < bitfield.length; i++) {
            for (int j = 0; j < 8; j++) {
                /* Retrieves the individual bits of each byte. When 0 bit
                 * is found, finds the corresponding value. */
                if ((bitfield[i] & (1 << j)) == 0) {
                    System.out.println (i * 8 + j);
                    return;
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = new int[]{0,1, 3, 5, 4, 7, 8, 2, 4};
        findOpenNUmber(arr);
    }
}
