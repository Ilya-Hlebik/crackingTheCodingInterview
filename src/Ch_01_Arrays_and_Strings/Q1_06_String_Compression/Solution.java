package Ch_01_Arrays_and_Strings.Q1_06_String_Compression;

public class Solution {
    public static String compressBad(String str) {
        char[] resultArray = new char[str.length()];
        char[] current = str.toCharArray();
        int count = 0;
        int resultIndex = 0;
        for (int i = 0; i < current.length; i++) {
            count++;
            if (i + 1 == current.length || current[i] != current[i + 1]) {
                resultArray[resultIndex] = current[i];
                resultArray[resultIndex + 1] = Character.forDigit(count, 10);
                count = 0;
                resultIndex += 2;
            }
        }
        String result = new String(resultArray).trim();
        return result.length() < str.length() ? result : str;
    }

    /*    public static void main(String[] args) {
            String str = "aa";
            System.out.println(str);
            System.out.println(compressBad(str));
        }*/
    public static void main(String[] args) {
        String str = "aaaaabbbbaaaabbddd";
        System.out.println(str);
        System.out.println(compressBad(str));
    }
}
