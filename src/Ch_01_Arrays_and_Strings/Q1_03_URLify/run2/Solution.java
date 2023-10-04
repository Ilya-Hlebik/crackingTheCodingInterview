package Ch_01_Arrays_and_Strings.Q1_03_URLify.run2;

public class Solution {
    public static void main(String[] args) {
        String str = "Mr J ohn Smith      ";
        char[] arr = str.toCharArray();
        replaceSpaces(arr, 14);
        System.out.println(new String(arr));
    }

    private static void replaceSpaces(char[] arr, int i) {
        String string = new String(arr).trim().replace(" ", "%20");
        for (int j = 0; j < arr.length; j++) {
            arr[j] = string.charAt(j);
        }
    }

    private static void replaceSpaces2(char[] arr, int i) {
        int maxArrlength = arr.length-1;
        for (int j = i - 1; j >= 0; j--) {
            if (arr[j] == ' ') {
                arr[maxArrlength] = '0';
                arr[maxArrlength-1] = '2';
                arr[maxArrlength-2] = '%';
            } else {
                arr[maxArrlength] = arr[j];
                maxArrlength--;
            }
        }
    }
}
