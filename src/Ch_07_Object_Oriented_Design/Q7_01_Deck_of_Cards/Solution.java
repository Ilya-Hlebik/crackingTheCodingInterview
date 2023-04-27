package Ch_07_Object_Oriented_Design.Q7_01_Deck_of_Cards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
}

class Deck {
    private final List<Card> cards = new ArrayList<>();

    public Deck() {
        for (CardType cardType : CardType.getAll()) {
            for (CardSuite cardSuite : CardSuite.getAll()) {
                cards.add(new Card(cardType, cardSuite));
            }
        }
        shuffle();
    }

    public List<Card> getCards() {
        return cards;
    }

    public List<Card> shuffle() {
        Collections.shuffle(cards);
        return cards;
    }
    public List<Card> getNext() {
        Card card = cards.get(cards.size() - 1);
        cards.remove(card);
        return cards;
    }
}

class Card {
    private final CardType cardType;
    private final CardSuite cardSuite;

    public Card(CardType cardType, CardSuite cardSuite) {
        this.cardType = cardType;
        this.cardSuite = cardSuite;
    }

    public CardType getCardType() {
        return cardType;
    }

    public CardSuite getCardSuite() {
        return cardSuite;
    }
}

enum CardType {
    Two, Three, Four;

    public static List<CardType> getAll() {
        return Arrays.stream(CardType.values()).collect(Collectors.toList());
    }
}

enum CardSuite {
    Clubs, Diamonds, Hearts, Spades;

    public static List<CardSuite> getAll() {
        return Arrays.stream(CardSuite.values()).collect(Collectors.toList());
    }
}
