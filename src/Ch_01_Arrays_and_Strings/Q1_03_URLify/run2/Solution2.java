package Ch_01_Arrays_and_Strings.Q1_03_URLify.run2;

public class Solution2 {
    public static void main(String[] args) {
        /*%20*/
        String str = "Mr John Smith    ";
        char[] arr = str.toCharArray();
        replaceSpaces(arr, 13);
        System.out.println(new String(arr));
    }

    private static void replaceSpaces(char[] arr, int start) {
        for (int i = start - 1, j = arr.length - 1; i >= 0; i--, j--) {
            if (arr[i] == ' ') {
                arr[j--] = '0';
                arr[j--] = '2';
                arr[j] = '%';
            } else {
                arr[j] = arr[i];
            }
        }
        System.out.println();
    }
}
