package Ch_10_Sorting_and_Searching.Q10_06_Sort_Big_File.run2;

public class Solution {
    public static void main(String[] args) {
        /*
        External sort
        * Divide file by x chunks, where x - number of ram available
        * Sort each chunk and save in file system.
        * Merge the chunks, by taking them one by one
        * For chunks merge we can read 1 word from top of each.
        Then compare them between each other
        Move into result file a word that should go first withing input, but remember file name for this word.
        Add to the input a word from a file, that you just use.
        Repeat process
        * */
    }
}
