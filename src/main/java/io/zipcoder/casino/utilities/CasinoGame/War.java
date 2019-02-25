package io.zipcoder.casino.utilities.CasinoGame;

import java.util.ArrayList;
import java.util.Stack;

public class War extends CardGame implements Game {
    public java.util.ArrayList<WarPlayer> warPlayerList;
    Console console = new Console(System.in,System.out);
    public War(PlayerList playerList) {
    }

    Hand player1Hand = new Hand();
    Hand player2Hand = new Hand();

    Hand player1DiscardPile = new Hand();
    Hand player2DiscardPile = new Hand();

    Card p1WarCard;
    Card p2WarCard;

    public War() {

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
                    War();
                }
            }

        } else {
            if (player2Hand.getSize() == 0) {
                System.out.println("Player 1 wins, Game Over");
            } else {
                System.out.println("Player 2 wins, Game Over");
            }
        }
    }

    public void War(){
        System.out.println("War!");
        Card p1WarCard1 = player1Hand.hand.get(0);
        Card p1WarCard2 = player1Hand.hand.get(1);
        Card p1WarCard3 = player1Hand.hand.get(2);
        Card p1WarCard4 = player1Hand.hand.get(3);
        player1Hand.hand.remove(0);
        player1Hand.hand.remove(1);
        player1Hand.hand.remove(2);
        player1Hand.hand.remove(3);
        Integer p1Choice = console.getIntegerInput("Choose which card to flip: 1, 2, 3, or 4", 1, 2, 3, 4);
        System.out.println(p1Choice);
        if (p1Choice == 1){
            p1WarCard = p1WarCard1;
        } else if (p1Choice == 2){
            p1WarCard = p1WarCard2;
        } else if (p1Choice == 3){
            p1WarCard = p1WarCard3;
        } else if (p1Choice == 4){
            p1WarCard = p1WarCard4;
        } else {
            p1WarCard = p1WarCard4;
        }

        Card p2WarCard1 = player2Hand.hand.get(0);
        Card p2WarCard2 = player2Hand.hand.get(1);
        Card p2WarCard3 = player2Hand.hand.get(2);
        Card p2WarCard4 = player2Hand.hand.get(3);
        player2Hand.hand.remove(0);
        player2Hand.hand.remove(1);
        player2Hand.hand.remove(2);
        player2Hand.hand.remove(3);
        Integer p2Choice = console.getIntegerInput("Choose which card to flip: 1, 2, 3, or 4", 1, 2, 3, 4);
        System.out.println(p2Choice);
        if (p2Choice == 1){
            p2WarCard = p2WarCard1;
        } else if (p2Choice == 2){
            p2WarCard = p2WarCard2;
        } else if (p2Choice == 3){
            p2WarCard = p2WarCard3;
        } else if (p2Choice == 4){
            p2WarCard = p2WarCard4;
        } else {
            p2WarCard = p2WarCard4;
        }
        if (p1WarCard.cardDefaultEnum.compareTo(p2WarCard.cardDefaultEnum) > 0){
            System.out.println("Player 1 wins the war");
            player1DiscardPile.hand.add(p1WarCard1);
            player1DiscardPile.hand.add(p1WarCard2);
            player1DiscardPile.hand.add(p1WarCard3);
            player1DiscardPile.hand.add(p1WarCard4);
            player1DiscardPile.hand.add(p2WarCard1);
            player1DiscardPile.hand.add(p2WarCard2);
            player1DiscardPile.hand.add(p2WarCard3);
            player1DiscardPile.hand.add(p2WarCard4);
        } else if (p1WarCard.cardDefaultEnum.compareTo(p2WarCard.cardDefaultEnum) < 0){
            System.out.println("Player 2 wins the war");
            player2DiscardPile.hand.add(p1WarCard1);
            player2DiscardPile.hand.add(p1WarCard2);
            player2DiscardPile.hand.add(p1WarCard3);
            player2DiscardPile.hand.add(p1WarCard4);
            player2DiscardPile.hand.add(p2WarCard1);
            player2DiscardPile.hand.add(p2WarCard2);
            player2DiscardPile.hand.add(p2WarCard3);
            player2DiscardPile.hand.add(p2WarCard4);
        } else {
            War();
        }
    }
    public Integer getScore() {
        return null;
    }

    public Integer giveScore() {
        return null;
    }
}
