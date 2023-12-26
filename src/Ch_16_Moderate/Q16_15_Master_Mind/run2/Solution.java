package Ch_16_Moderate.Q16_15_Master_Mind.run2;

import Ch_16_Moderate.Q16_15_Master_Mind.Result;

public class Solution {
    public static void main(String[] args) {
        Result res = estimate("GGRR", "RGBY");
        System.out.println(res.toString());
    }

    public static Result estimate(String guess, String solution) {
        Result result = new Result();
        String guessForPseudo = "";
        String solutionForPseudo = "";
        for (int i = 0; i < solution.length(); i++) {
            if (guess.charAt(i) == solution.charAt(i)) {
                result.hits++;
            } else {
                guessForPseudo += guess.charAt(i);
                solutionForPseudo += solution.charAt(i);
            }
        }
        for (int i = 0; i < solutionForPseudo.length(); i++) {
            if (solutionForPseudo.contains(String.valueOf(guessForPseudo.charAt(i)))) {
                result.pseudoHits++;
                solutionForPseudo = solutionForPseudo.replaceFirst(String.valueOf(guessForPseudo.charAt(i)), "_");
            }
        }
        return result;
    }
}
