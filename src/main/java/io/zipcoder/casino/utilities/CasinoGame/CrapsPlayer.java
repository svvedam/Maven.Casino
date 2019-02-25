package io.zipcoder.casino.utilities.CasinoGame;

import java.io.InputStream;

public class CrapsPlayer extends Player implements GamblingPlayer  {

    String name;
    Integer balance;


    public CrapsPlayer(){
        this.name = "";
        this.balance = 10000;
    }
    public CrapsPlayer(String name, Integer balance) {
        this.name = name;
        this.balance = balance;
    }


    public Integer getBalance(){
        return balance;
    }
    public void placeBet(Integer bet) {

        balance -= bet;

    }

    public void receiveWinnings(Integer winnings) {
        balance += winnings;
    }
}
