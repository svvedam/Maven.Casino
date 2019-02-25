package io.zipcoder.casino.utilities.CasinoGame;

import java.io.InputStream;

public class CrapsPlayer implements GamblingPlayer {

    String name;
    Integer balance;
    Console console = new Console(System.in,System.out);

    public CrapsPlayer(){
        this.name = "";
        this.balance = 10000;
    }
    public CrapsPlayer(Player player) {
        this.name = player.getName();
        this.balance = player.getBalance();
    }

    public Integer placeBet() {
        Integer bet = console.getIntegerInput("What would you like to bet?");
        balance -= bet;
        return bet;
    }

    public void receiveWinnings(Integer winnings) {
        balance += winnings;
    }
}
