package Ch_01_Arrays_and_Strings.Q1_03_URLify;

public class Solution2 {
    public static void replaceSpaces(char[] str, int trueLength) {
        String s = new String(str).trim().replaceAll(" ", "%20");
        for (int i = 0; i < str.length; i++) {
            str[i] = s.charAt(i);
        }
    }

    public static void main(String[] args) {
        String str = "Mr John Smith    ";
        char[] arr = str.toCharArray();
        replaceSpaces(arr, 13);
        System.out.println(new String(arr));
    }
}
