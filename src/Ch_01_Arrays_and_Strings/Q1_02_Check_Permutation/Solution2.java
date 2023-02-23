package Ch_01_Arrays_and_Strings.Q1_02_Check_Permutation;

public class Solution2 {

    public static boolean permutation(String s, String t) {
        if (t.length() != s.length()){
            return false;
        }
        //for ASCII
        int char_arr[]= new int[128];
        for (int i = 0; i < s.toCharArray().length; i++) {
            char_arr[s.charAt(i)]++;
        }
        for (int i = 0; i < t.toCharArray().length; i++) {
            char_arr[t.charAt(i)]--;
            if (char_arr[t.charAt(i)] < 0){
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean anagram = permutation(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + anagram);
        }
    }
}
