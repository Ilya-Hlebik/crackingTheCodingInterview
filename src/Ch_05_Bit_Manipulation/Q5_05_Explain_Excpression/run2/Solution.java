package Ch_05_Bit_Manipulation.Q5_05_Explain_Excpression.run2;

import CtCILibrary.AssortedMethods;

public class Solution {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(AssortedMethods.toFullBinaryString( i) + " : " +AssortedMethods.toFullBinaryString((i & (i-1))));
        }
    }
}
