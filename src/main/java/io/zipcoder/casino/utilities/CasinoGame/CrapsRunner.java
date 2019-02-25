package io.zipcoder.casino.utilities.CasinoGame;

public class CrapsRunner {

    public static void main(String[] args) {
        Craps craps = new Craps(new CrapsPlayer(),new Console(System.in,System.out));
        craps.bettingPhase();

    }
}
