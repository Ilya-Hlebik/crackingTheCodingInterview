package Ch_07_Object_Oriented_Design.Q7_01_Deck_of_Cards;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BlackJackGame {
    private final BlackJackDeck blackJackDeck;
    private final BlackJackHand playerHand = new BlackJackHand();
    private final DealerBlackJackHand dealerHand = new DealerBlackJackHand();
    private GameStatus gameStatus = GameStatus.CONTINUE;

    public BlackJackGame(BlackJackDeck blackJackDeck) {
        this.blackJackDeck = blackJackDeck;
    }

    public GameStatus playerTurn(boolean firstTurn) {
        Integer sum;
        if (firstTurn) {
            List<BlackJackCard> blackJackCards = playerHand.getBlackJackCards();
            BlackJackCard firstCard = blackJackDeck.getNext();
            BlackJackCard secondCard = blackJackDeck.getNext();
            blackJackCards.add(firstCard);
            sum = calculateSum(firstCard, dealerHand);
            blackJackCards.add(secondCard);
        } else {
            BlackJackCard firstCard = blackJackDeck.getNext();
            sum = calculateSum(firstCard, dealerHand);
        }
        if (sum > 21) {
            return GameStatus.DEALER_WON;
        } else if (playerHand.getBlackJackCards().size() == 2 && sum == 21) {
            return GameStatus.PLAYER_BJ;
        }
        return GameStatus.CONTINUE;
    }

    public GameStatus dealerTurn(boolean firstTurn) {
        Integer sum;
        if (firstTurn) {
            List<BlackJackCard> blackJackCards = dealerHand.getBlackJackCards();
            BlackJackCard firstCard = blackJackDeck.getNext();
            BlackJackCard secondCard = blackJackDeck.getNext();
            blackJackCards.add(firstCard);
            sum = calculateSum(firstCard, dealerHand);
            blackJackCards.add(secondCard);
        } else {
            BlackJackCard firstCard = blackJackDeck.getNext();
            sum = calculateSum(firstCard, dealerHand);
        }
        if (sum >= 17 && playerHand.getCurrentSum() > dealerHand.getCurrentSum()) {
            return GameStatus.PLAYER_WON;
        } else if (sum == 21 && dealerHand.getBlackJackCards().size() == 2) {
            return GameStatus.DEALER_BJ;
        } else if (sum >= 17 && playerHand.getCurrentSum() < dealerHand.getCurrentSum()) {
            return GameStatus.DEALER_WON;
        } else if (sum > 21) {
            return GameStatus.PLAYER_WON;
        }
        return GameStatus.CONTINUE;
    }

    public static void main(String[] args) {
        System.out.println("------------START---------");

        BlackJackGame blackJackGame = new BlackJackGame(new BlackJackDeck());
        blackJackGame.initialize();
        BlackJackHand dealerHand = blackJackGame.getDealerHand();
        BlackJackHand playerHand = blackJackGame.getPlayerHand();
        System.out.println("Dealer Cards: " + dealerHand.getBlackJackCards() + " Dealer sum: " + dealerHand.getCurrentSum());
        System.out.println("Player Cards: " + playerHand.getBlackJackCards() + " Player sum: " + playerHand.getCurrentSum());

        while (blackJackGame.gameStatus == GameStatus.CONTINUE){


            System.out.println(blackJackGame.gameStatus);
        }

/*        blackJackGame.dealerTurn(true);

        blackJackGame.playerTurn();*/

    }

    private void initialize() {
        List<BlackJackCard> playerHandBlackJackCards = playerHand.getBlackJackCards();
        playerHandBlackJackCards.add(blackJackDeck.getNext());
        playerHandBlackJackCards.add(blackJackDeck.getNext());
        List<BlackJackCard> dealerHandBlackJackCards = dealerHand.getBlackJackCards();
        dealerHandBlackJackCards.add(blackJackDeck.getNext());
        dealerHand.setHiddenCard(blackJackDeck.getNext());
        calculateCurrentSum(dealerHand);
        calculateCurrentSum(playerHand);
    }

    private <T extends BlackJackHand> void calculateCurrentSum(T hand) {
        List<BlackJackCard> blackJackCards = hand.getBlackJackCards();
        int totalSum = blackJackCards.stream()
                .mapToInt(Card::getCardValue)
                .sum();
        Set<BlackJackCard> aces = blackJackCards
                .stream()
                .filter(blackJackCard -> blackJackCard.getCardType().equals(CardType.Ace))
                .collect(Collectors.toSet());
        while (totalSum > 21 && !aces.isEmpty()) {
            aces.remove(aces.iterator().next());
            totalSum -= 10;
        }
        hand.setCurrentSum(totalSum);
    }

    private Integer calculateSum(BlackJackCard next, BlackJackHand hand) {

        Integer sum = 0;
        /*       for (BlackJackCard blackJackCard : blackJackCards) {
         *//*Logic for ace*//*
            sum += blackJackCard.getCardValue();
        }*/
        return sum;
    }

    public BlackJackDeck getBlackJackDeck() {
        return blackJackDeck;
    }

    public BlackJackHand getPlayerHand() {
        return playerHand;
    }

    public BlackJackHand getDealerHand() {
        return dealerHand;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }
}
