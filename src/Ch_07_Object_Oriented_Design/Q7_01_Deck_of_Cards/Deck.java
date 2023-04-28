package Ch_07_Object_Oriented_Design.Q7_01_Deck_of_Cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Deck<T, D extends Card<T>> {
    private final List<D> cards = new ArrayList<>();

    public Deck() {
        for (CardType cardType : CardType.getAll()) {
            for (CardSuite cardSuite : CardSuite.getAll()) {
                cards.add(createCard(cardType, cardSuite));
            }
        }
        shuffle();
    }

    public abstract D createCard(CardType cardType, CardSuite cardSuite);

    public List<D> getCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public D getNext() {
        D card = cards.get(cards.size() - 1);
        cards.remove(card);
        return card;
    }
}
