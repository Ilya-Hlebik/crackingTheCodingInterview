package Ch_16_Moderate.Q16_08_English_Int.run2;

public class Solution {
    public static String[] small = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    public static String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public static String[] bigs = {"", "Thousand", "Million", "Billion"};
    public static String hundred = "Hundred";
    public static String negative = "Negative";

    public static void main(String[] args) {
        /* numbers between 1 and 100 */
        for (int i = 100000; i <= 110001; i++) {
            String s = convert(i);
            System.out.println(i + ": " + s);
        }
    }

    private static String convert(int value) {
        int bigIndex = 0;
        String result = "";
        while (value > 0) {
            int tempValue = value % 1000;
            String first =  ((tempValue / 100 > 0 ? small[tempValue / 100] + " " + hundred + " " : "" )+ tens[tempValue % 100 / 10] + " " + small[tempValue % 100 < 20 ? tempValue % 100 : tempValue % 10] + " ") + " " + (bigs[bigIndex] + " ");
          //  String last = tens[tempValue % 100 / 10] + " " + small[tempValue % 100 < 20 ? tempValue % 100 : tempValue % 10] + " ";
            value /= 1000;
            result = ((first + " " + result)).trim();
            bigIndex++;
        }
        return result.trim();
    }
}
