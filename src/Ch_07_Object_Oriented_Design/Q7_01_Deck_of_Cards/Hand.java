package Ch_07_Object_Oriented_Design.Q7_01_Deck_of_Cards;

import java.util.ArrayList;
import java.util.List;

public class Hand <T extends Card<D>, D> {
    private final List<T> cards = new ArrayList<>();
    private D currentSum;

    public D getCurrentSum() {
        return currentSum;
    }

    public List<T> getCards() {
        return cards;
    }

    public void setCurrentSum(D currentSum) {
        this.currentSum = currentSum;
    }
}
