package Ch_07_Object_Oriented_Design.Q7_01_Deck_of_Cards;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum CardSuite {
    Clubs, Diamonds, Hearts, Spades;

    public static List<CardSuite> getAll() {
        return Arrays.stream(CardSuite.values()).collect(Collectors.toList());
    }
}

