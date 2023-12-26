package Ch_16_Moderate.Q16_15_Master_Mind;

public class Result {
    public int hits;
    public int pseudoHits;

    public Result(int h, int p) {
        hits = h;
        pseudoHits = p;
    }

    public Result() {
    }

    @Override
    public String toString() {
        return "Result [hits=" + hits + ", pseudoHits=" + pseudoHits + "]";
    }
}
