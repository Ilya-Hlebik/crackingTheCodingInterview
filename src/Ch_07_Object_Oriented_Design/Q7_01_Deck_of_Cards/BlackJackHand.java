package Ch_07_Object_Oriented_Design.Q7_01_Deck_of_Cards;

import java.util.ArrayList;
import java.util.List;

public class BlackJackHand {
    private final List<BlackJackCard> blackJackCards = new ArrayList<>();
    private Integer currentSum;

    public Integer getCurrentSum() {
        return currentSum;
    }

    public List<BlackJackCard> getBlackJackCards() {
        return blackJackCards;
    }

    public void setCurrentSum(Integer currentSum) {
        this.currentSum = currentSum;
    }
}
