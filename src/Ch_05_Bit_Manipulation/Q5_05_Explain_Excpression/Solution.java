package Ch_05_Bit_Manipulation.Q5_05_Explain_Excpression;

public class Solution {
    public static void main(String[] args) {
        //1000000
        //0111111
        //0000000

        //((n & (n-1)) ==0)
        //n power of 2
        //count of bites was increased
        //n zero
        System.out.println((0 & (-1)) == 0);
    }
}
