package io.zipcoder.casino.utilities.CasinoGame;

public class GoFishPlayer {
    public String name;
    public Hand playerHand;
    public Integer score;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void addCard(Card card) {
        playerHand.addCard(card);
    }

    public Hand getPlayerHand() {
        return playerHand;
    }

    public void setPlayerHand(Hand playerHand) {
        this.playerHand = playerHand;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
