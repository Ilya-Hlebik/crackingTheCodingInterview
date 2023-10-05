package Ch_01_Arrays_and_Strings.Q1_06_String_Compression.run2;

public class Solution {

    public static void main(String[] args) {
        String str = "aaaaabbbbaaaabbddd";
        System.out.println(str);
        System.out.println(compress(str));
    }

    private static String compress(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        StringBuilder result = new StringBuilder();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            count++;
            if (i == str.length() - 1 || str.charAt(i) != str.charAt(i+1)){
                result.append(str.charAt(i)).append(count);
                count = 0;
            }

        }
        return result.length() > str.length() ? str : result.toString();
    }
}
