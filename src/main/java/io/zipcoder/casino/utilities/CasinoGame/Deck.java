package io.zipcoder.casino.utilities.CasinoGame;

import java.util.*;

public class Deck {

    public Stack<Card> blackJackDeck;
    public Stack<Card> regularDeck;

    public Deck () {
        buildBlackJackDeck();
        buildRegularDeck();
    }

    public void buildBlackJackDeck() {
        blackJackDeck = new Stack<Card>();
        for (int i = 0; i < 13; i++) {
                BlackJackEnum value = BlackJackEnum.values()[i];

                for (int j = 0; j < 4; j++) {
                    Card card = new Card(value, Suit.values()[j]);
                    this.blackJackDeck.push(card);
                }
            }
            Collections.shuffle(blackJackDeck);
    }
    public void buildRegularDeck() {
        regularDeck = new Stack<Card>();
        for (int i = 0; i < 13; i++) {
            CardDefaultEnum value = CardDefaultEnum.values()[i];

            for (int j = 0; j < 4; j++) {
                Card card = new Card(value, Suit.values()[j]);
                regularDeck.push(card);
            }
        }
        Collections.shuffle(regularDeck);
    }
}