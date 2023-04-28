package Ch_07_Object_Oriented_Design.Q7_01_Deck_of_Cards;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum CardType {
    Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Quin, Jack, King, Ace;

    public static List<CardType> getAll() {
        return Arrays.stream(CardType.values()).collect(Collectors.toList());
    }
}
