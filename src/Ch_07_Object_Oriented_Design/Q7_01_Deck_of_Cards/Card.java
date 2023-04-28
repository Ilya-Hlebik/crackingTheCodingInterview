package Ch_07_Object_Oriented_Design.Q7_01_Deck_of_Cards;

public abstract class Card<T> {
    private final CardType cardType;
    private final CardSuite cardSuite;
    private final T cardValue;

    public Card(CardType cardType, CardSuite cardSuite, T cardValue) {
        this.cardType = cardType;
        this.cardSuite = cardSuite;
        this.cardValue = cardValue;
    }

    public CardType getCardType() {
        return cardType;
    }

    public CardSuite getCardSuite() {
        return cardSuite;
    }

    public T getCardValue() {
        return cardValue;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardType=" + cardType +
                ", cardSuite=" + cardSuite +
                ", cardValue=" + cardValue +
                '}';
    }
}
