package io.zipcoder.casino.utilities.CasinoGame;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class War extends CardGame implements Game {
    public java.util.ArrayList<WarPlayer> warPlayerList;
    Console console = new Console(System.in,System.out);
    public War(PlayerList playerList) {
    }

    Stack<Card> player1Hand = new Stack<>();
    Stack<Card> player2Hand = new Stack<>();

    Stack<Card> player1DiscardPile = new Stack<>();
    Stack<Card> player2DiscardPile = new Stack<>();

    Card p1WarCard;
    Card p2WarCard;

    public War() {

    }

    public static Stack<Card> getPlayer1Hand() {
        Deck warPlayerDeck = new Deck();
        Stack<Card> player1Hand = new Stack<>();

        warPlayerDeck.buildRegularDeck();
        for (int i = 0; i < 26; i++) {
            Card card = warPlayerDeck.regularDeck.pop();
            player1Hand.push(card);
        }
        return player1Hand;
    }

    public static Stack<Card> getPlayer2Hand() {
        Deck warPlayerDeck = new Deck();
        Stack<Card> player2Hand = new Stack<>();

        for (int i = 26; i < 52; i++) {
                Card card = warPlayerDeck.regularDeck.pop();
                player2Hand.push(card);
            }
        return player2Hand;
    }

    public void play() {
        Stack<Card> player1Hand = getPlayer1Hand();
        Stack<Card> player2Hand = getPlayer2Hand();

        while (!player1Hand.isEmpty() && !player2Hand.isEmpty()) {
            Card cardForTurn1 = player1Hand.pop();
            System.out.println("Player1 played: " + cardForTurn1.toString());
            Card cardForTurn2 = player2Hand.pop();
            System.out.println("Player2 played: " + cardForTurn2.toString());
            if (player1Hand.isEmpty() && player1DiscardPile.isEmpty()) {
                System.out.println("Player 2 wins, Game Over");
                break;
            } else if (player2Hand.isEmpty() && player2DiscardPile.isEmpty()) {
                System.out.println("Player 1 wins, Game Over");
                break;
            } else if (player1Hand.isEmpty()) {
                Collections.shuffle(player1DiscardPile);
                player1Hand = player1DiscardPile;
            } else if (player2Hand.isEmpty()) {
                Collections.shuffle(player2DiscardPile);
                player2Hand = player2DiscardPile;

            } else if (cardForTurn1.cardDefaultEnum.compareTo(cardForTurn2.cardDefaultEnum) > 0) {
                player1DiscardPile.push(cardForTurn1);
                player1DiscardPile.push(cardForTurn2);
                System.out.println("Player 1 wins this round");
                System.out.println();
            } else if (cardForTurn1.cardDefaultEnum.compareTo(cardForTurn2.cardDefaultEnum) < 0) {
                player2DiscardPile.push(cardForTurn1);
                player2DiscardPile.push(cardForTurn2);
                System.out.println("Player 2 wins this round");
                System.out.println();
            } else {
                War();
            }
        }
    }

    public void War() {
        while (player1Hand.size() > 4 && player2Hand.size() > 4) {
            System.out.println("War!");
            System.out.println();

            Card p1WarCard1 = player1Hand.pop();
            Card p1WarCard2 = player1Hand.pop();
            Card p1WarCard3 = player1Hand.pop();
            Card p1WarCard4 = player1Hand.pop();
            Integer p1Choice = console.getIntegerInput("Choose which card to flip: 1, 2, 3, or 4", 1, 2, 3, 4);
            System.out.println(p1Choice.toString());
            if (p1Choice == 1) {
                p1WarCard = p1WarCard1;
            } else if (p1Choice == 2) {
                p1WarCard = p1WarCard2;
            } else if (p1Choice == 3) {
                p1WarCard = p1WarCard3;
            } else if (p1Choice == 4) {
                p1WarCard = p1WarCard4;
            } else {
                p1WarCard = p1WarCard4;
            }

            Card p2WarCard1 = player2Hand.pop();
            Card p2WarCard2 = player2Hand.pop();
            Card p2WarCard3 = player2Hand.pop();
            Card p2WarCard4 = player2Hand.pop();
            Integer p2Choice = console.getIntegerInput("Choose which card to flip: 1, 2, 3, or 4", 1, 2, 3, 4);
            System.out.println(p2Choice.toString());
            if (p2Choice == 1) {
                p2WarCard = p2WarCard1;
            } else if (p2Choice == 2) {
                p2WarCard = p2WarCard2;
            } else if (p2Choice == 3) {
                p2WarCard = p2WarCard3;
            } else if (p2Choice == 4) {
                p2WarCard = p2WarCard4;
            } else {
                p2WarCard = p2WarCard4;
            }
            if (p1WarCard.cardDefaultEnum.compareTo(p2WarCard.cardDefaultEnum) > 0) {
                System.out.println("Player 1 wins the war");
                player1DiscardPile.push(p1WarCard1);
                player1DiscardPile.push(p1WarCard2);
                player1DiscardPile.push(p1WarCard3);
                player1DiscardPile.push(p1WarCard4);
                player1DiscardPile.push(p2WarCard1);
                player1DiscardPile.push(p2WarCard2);
                player1DiscardPile.push(p2WarCard3);
                player1DiscardPile.push(p2WarCard4);
            } else if (p1WarCard.cardDefaultEnum.compareTo(p2WarCard.cardDefaultEnum) < 0) {
                System.out.println("Player 2 wins the war");
                player2DiscardPile.push(p1WarCard1);
                player2DiscardPile.push(p1WarCard2);
                player2DiscardPile.push(p1WarCard3);
                player2DiscardPile.push(p1WarCard4);
                player2DiscardPile.push(p2WarCard1);
                player2DiscardPile.push(p2WarCard2);
                player2DiscardPile.push(p2WarCard3);
                player2DiscardPile.push(p2WarCard4);
            } else if (p1WarCard.cardDefaultEnum.equals(p2WarCard.cardDefaultEnum)){
                War();
            } else {
                if (player1Hand.size() < 4){
                    System.out.println("Player 2 wins, Game Over");
                    break;
                } else if (player2Hand.size() < 4){
                    System.out.println("Player 1 wins, Game Over");
                    break;
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
