package Ch_05_Bit_Manipulation.Q5_02_Binary_to_String;

public class Solution {
    public static void main(String[] args) {
        String bs = printBinary(.125);
        System.out.println(bs);

        for (int i = 0; i < 1000; i++) {
            double num = i / 1000.0;
            String binary = printBinary(num);
            String binary2 = printBinary2(num);
            if (!binary.equals("ERROR") || !binary2.equals("ERROR")) {
                System.out.println(num + " : " + binary + " " + binary2);
            }
        }
    }

    private static String printBinary2(double num) {
        if (num >= 1 || num <= 0) {
            return "ERROR";
        }

        StringBuilder binary = new StringBuilder();
        binary.append(".");
        while (num > 0) {
            /* Setting a limit on length: 32 characters */
            if (binary.length() > 32) {
                return "ERROR";
            }
            double r = num * 2;
            if (r >= 1) {
                binary.append(1);
                num = r - 1;
            } else {
                binary.append(0);
                num = r;
            }
        }
        return binary.toString();
    }

    private static String printBinary(double num) {
        StringBuilder res = new StringBuilder(".");
        while (num != 0) {
            if (res.length() > 32) {
                return "ERROR";
            }
            num *= 2;
            if (num >= 1) {
                res.append(1);
                num -= 1;
            } else {
                res.append(0);
            }
        }
        return res.length() > 1 ? res.toString() : "ERROR";
    }
}
