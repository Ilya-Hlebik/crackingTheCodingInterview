package Ch_01_Arrays_and_Strings.Q1_03_URLify;

public class Solution {
    public static void replaceSpaces(char[] str, int trueLength) {
        int spaceCount = 0;
        for (int i = 0; i < trueLength; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }
        int maxIndex = spaceCount * 2 + trueLength - 1;
        for (int i = trueLength - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[maxIndex] = '0';
                str[maxIndex - 1] = '2';
                str[maxIndex - 2] = '%';
                maxIndex -= 3;
            } else {
                str[maxIndex] = str[i];
                maxIndex--;
            }
        }

    }

    public static void main(String[] args) {
        String str = "Mr John Smith    ";
        char[] arr = str.toCharArray();
        replaceSpaces(arr, 13);
        System.out.println(new String(arr));
    }
}
