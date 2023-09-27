package Ch_16_Moderate.Q16_15_Master_Mind;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Result res = estimate("GGRR", "RGBY");
        System.out.println(res.toString());
    }

    public static Result estimate(String guess, String solution) {
        int hits = 0;
        int pseudoHits = 0;
        List<Integer> skipId = new ArrayList<>();
        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == solution.charAt(i)) {
                hits++;
                skipId.add(i);
            }
        }
        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == solution.charAt(i)) {
                continue;
            }
            for (int j = 0; j < solution.length(); j++) {
                if (!skipId.contains(j)) {
                    if (guess.charAt(i) == solution.charAt(j)) {
                        pseudoHits++;
                        skipId.add(j);
                    }
                }
            }
        }
        return new Result(hits, pseudoHits);
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
