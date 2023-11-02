package Ch_05_Bit_Manipulation.Q5_02_Binary_to_String.run2;

public class Solution {
    public static void main(String[] args) {
        String bs = printBinary(.125);
        System.out.println(bs);

        for (int i = 0; i < 1000; i++) {
            double num = i / 1000.0;
            String binary = printBinary(num);
            String binary2 = Ch_05_Bit_Manipulation.Q5_02_Binary_to_String.Solution.printBinary2(num);
            if (!binary.equals("ERROR") || !binary2.equals("ERROR")) {
                System.out.println(num + " : " + binary + " " + binary2);
            }
        }
    }

    private static String printBinary(double num) {
        if (num <= 0 || num > 1) {
            return "ERROR";
        }
        StringBuilder binary = new StringBuilder();
        binary.append(".");
        while (num > 0) {
            if (binary.length() >= 32) {
                return "ERROR";
            }
            double temp = num * 2;
            if (temp >= 1) {
                binary.append("1");
                num = temp - 1;
            } else {
                binary.append("0");
                num = temp;
            }
        }
        return binary.toString();
    }

}
