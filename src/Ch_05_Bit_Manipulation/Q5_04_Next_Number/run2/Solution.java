
package Ch_05_Bit_Manipulation.Q5_04_Next_Number.run2;

public class Solution {
    public static void main(String[] args) {
        System.out.println(getNext(118));
        System.out.println(getPrevious(118));
    }

    private static int getPrevious(int i) {
        int countOf1s = getCountOf1s(i);
        while (countOf1s != getCountOf1s(--i)) ;
        return i;
    }

    private static int getNext(int i) {
        int countOf1s = getCountOf1s(i);
        while (countOf1s != getCountOf1s(++i)) ;
        return i;
    }

    private static int getCountOf1s(int i) {
        int count = 0;
        while (i != 0) {
            if ((i & 1) == 1) {
                count++;
            }
            i >>>= 1;
        }
        return count;
    }
}
