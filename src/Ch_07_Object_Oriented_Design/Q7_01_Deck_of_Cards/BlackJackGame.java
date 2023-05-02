package Ch_07_Object_Oriented_Design.Q7_01_Deck_of_Cards;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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

    public void playerTurn() {
        BlackJackCard firstCard = blackJackDeck.getNext();
        int sum = calculateSum(firstCard, playerHand);
        if (sum > 21) {
            setGameStatus(GameStatus.DEALER_WON);
        }
    }

    public void dealerTurn() {
        int sum;
        if (dealerHand.getHiddenCard() != null) {
            BlackJackCard hiddenCard = dealerHand.getHiddenCard();
            sum = calculateSum(hiddenCard, dealerHand);
            dealerHand.setHiddenCard(null);
        } else {
            BlackJackCard firstCard = blackJackDeck.getNext();
            sum = calculateSum(firstCard, dealerHand);
        }
        if (sum >= 17 && playerHand.getCurrentSum() > dealerHand.getCurrentSum()) {
            setGameStatus(GameStatus.PLAYER_WON);
        } else if (sum == 21 && dealerHand.getCards().size() == 2) {
            setGameStatus(GameStatus.DEALER_BJ);
        } else if (sum >= 17 && sum <= 21 && playerHand.getCurrentSum() < dealerHand.getCurrentSum()) {
            setGameStatus(GameStatus.DEALER_WON);
        } else if (sum >= 17 && sum <= 21 && playerHand.getCurrentSum().equals(dealerHand.getCurrentSum())) {
            setGameStatus(GameStatus.DRAW);
        } else if (sum > 21) {
            setGameStatus(GameStatus.PLAYER_WON);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("------------START---------");

        BlackJackGame blackJackGame = new BlackJackGame(new BlackJackDeck());
        blackJackGame.initialize();
        BlackJackHand dealerHand = blackJackGame.getDealerHand();
        BlackJackHand playerHand = blackJackGame.getPlayerHand();
        System.out.println("Dealer Cards: " + dealerHand.getCards() + " Dealer sum: " + dealerHand.getCurrentSum());
        System.out.println("Player Cards: " + playerHand.getCards() + " Player sum: " + playerHand.getCurrentSum());
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        if (playerHand.getCards().size() == 2 && playerHand.getCurrentSum() == 21) {
            blackJackGame.setGameStatus(GameStatus.PLAYER_BJ);
        }
        while (blackJackGame.getGameStatus() == GameStatus.CONTINUE || blackJackGame.getGameStatus() == GameStatus.PLAYER_STOP) {
            if (blackJackGame.getGameStatus() != GameStatus.PLAYER_STOP) {
                System.out.println("Do you need more?(y/n)");
                String readLine = reader.readLine();
                if ("y".equals(readLine)) {
                    blackJackGame.playerTurn();
                } else if ("n".equals(readLine)) {
                    blackJackGame.setGameStatus(GameStatus.PLAYER_STOP);
                } else {
                    System.out.println("Wrong input, try again");
                }
                System.out.println("Player Cards: " + playerHand.getCards() + " Player sum: " + playerHand.getCurrentSum());
            } else {
                blackJackGame.dealerTurn();
            }
            System.out.println("Dealer Cards: " + dealerHand.getCards() + " Dealer sum: " + dealerHand.getCurrentSum());
        }
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!! " + blackJackGame.getGameStatus() + " !!!!!!!!!!!!!!!!!!!!");
    }

    private void initialize() {
        List<BlackJackCard> playerHandBlackJackCards = playerHand.getCards();
        playerHandBlackJackCards.add(blackJackDeck.getNext());
        playerHandBlackJackCards.add(blackJackDeck.getNext());
        List<BlackJackCard> dealerHandBlackJackCards = dealerHand.getCards();
        dealerHandBlackJackCards.add(blackJackDeck.getNext());
        dealerHand.setHiddenCard(blackJackDeck.getNext());
        calculateCurrentSum(dealerHand);
        calculateCurrentSum(playerHand);
    }

    private <T extends BlackJackHand> int calculateCurrentSum(T hand) {
        List<BlackJackCard> blackJackCards = hand.getCards();
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
        return totalSum;
    }

    private Integer calculateSum(BlackJackCard next, BlackJackHand hand) {
        hand.getCards().add(next);
        return calculateCurrentSum(hand);
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

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }
}
