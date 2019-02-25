package io.zipcoder.casino.utilities.CasinoGame;

import java.util.ArrayList;
import java.util.Stack;

public class War extends CardGame implements Game {
    public java.util.ArrayList<WarPlayer> warPlayerList;

    public War(PlayerList playerList) {
    }


    public static Hand getPlayer1Hand() {
        Deck warPlayerDeck = new Deck();
        Hand player1Hand = new Hand();

        warPlayerDeck.buildRegularDeck();
        for (int i = 0; i < 26; i++) {
            Card card = warPlayerDeck.regularDeck.pop();
            player1Hand.addCard(card);
        }
        return player1Hand;
    }

    public static Hand getPlayer2Hand() {
        Deck warPlayerDeck = new Deck();
        Hand player2Hand = new Hand();

        warPlayerDeck.buildRegularDeck();
        for (int i = 26; i < 52; i++) {
                Card card = warPlayerDeck.regularDeck.pop();
                player2Hand.addCard(card);
            }
        return player2Hand;
    }

    public void play() {
        Hand player1Hand = new Hand();
        Hand player2Hand = new Hand();

        Hand player1DiscardPile = new Hand();
        Hand player2DiscardPile = new Hand();

        player1Hand.equals(getPlayer1Hand());
        player2Hand.equals(getPlayer2Hand());

        if (player1Hand.getSize() != 0 && player2Hand.getSize() != 0) {
            for (int i = 0; i < 26; i++) {
                Card cardForTurn1 = player1Hand.hand.get(0);
                player1Hand.hand.remove(0);
                System.out.println(cardForTurn1);

                Card cardForTurn2 = player2Hand.hand.get(0);
                player2Hand.hand.remove(0);
                System.out.println(cardForTurn2);
                if (cardForTurn1.cardDefaultEnum.compareTo(cardForTurn2.cardDefaultEnum) > 0) {
                    player1DiscardPile.hand.add(cardForTurn1);
                    player1DiscardPile.hand.add(cardForTurn2);
                    System.out.println("Player 1 wins this round");
                } else if (cardForTurn1.cardDefaultEnum.compareTo(cardForTurn2.cardDefaultEnum) < 0) {
                    player2DiscardPile.hand.add(cardForTurn1);
                    player2DiscardPile.hand.add(cardForTurn2);
                    System.out.println("Player 2 wins this round");
                } else {
                    System.out.println("War!");

                }
            }
        }
    }





    public Integer getScore() {
        return null;
    }

    public Integer giveScore() {
        return null;
    }
}
