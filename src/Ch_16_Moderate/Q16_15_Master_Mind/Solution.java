package Ch_16_Moderate.Q16_15_Master_Mind;

public class Solution {
    public static void main(String[] args) {
        Result res = estimate("GGRR", "RGBY");
        System.out.println(res.toString());
    }

    public static Result estimate(String guess, String solution) {
        int hits = 0;
        int pseudoHits = 0;
        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == solution.charAt(i)) {
                hits++;
            }


        }
        return null;
    }
}
class Result {
    public int hits;
    public int pseudoHits;

    public Result(int h, int p) {
        hits = h;
        pseudoHits = p;
    }

    @Override
    public String toString() {
        return "Result [hits=" + hits + ", pseudoHits=" + pseudoHits + "]";
    }
}
