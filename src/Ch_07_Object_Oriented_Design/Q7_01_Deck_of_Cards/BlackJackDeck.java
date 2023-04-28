package Ch_07_Object_Oriented_Design.Q7_01_Deck_of_Cards;

public class BlackJackDeck extends Deck<Integer, BlackJackCard> {

    @Override
    public BlackJackCard createCard(CardType cardType, CardSuite cardSuite) {
        int cardValue;
        switch (cardType) {
            case Two: {
                cardValue = 2;
            }
            break;
            case Three: {
                cardValue = 3;
            }
            break;
            case Four: {
                cardValue = 4;
            }
            break;
            case Five: {
                cardValue = 5;
            }
            break;
            case Six: {
                cardValue = 6;
            }
            break;
            case Seven: {
                cardValue = 7;
            }
            break;
            case Eight: {
                cardValue = 8;
            }
            break;
            case Nine: {
                cardValue = 9;
            }
            break;
            case Ten:
            case Jack:
            case Quin:
            case King:{
                cardValue = 10;
            }
            break;
            case Ace: {
                cardValue = 11;
            }
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + cardType);
        }
        return new BlackJackCard(cardType, cardSuite, cardValue);
    }
}
