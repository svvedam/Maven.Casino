/*package io.zipcoder.casino.utilities.CasinoGame;

import java.util.function.Supplier;

public enum GameEnum {
    BLACKJACK(BlackJack::new),
    CRAPS(Craps::new),
    GOFISH(GoFish::new);

    private final Supplier<Game> supplier;

    GameEnum(Supplier<Game> supplier) {
        this.supplier = supplier;
    }

    public Game create() {
        return supplier.get();
    }

    public static GameEnum getValueOf(String userInput) {
        userInput = userInput.toUpperCase();
        try {
            return valueOf(userInput);
        } catch (IllegalArgumentException iae) {
            return valueOf(userInput.replaceAll(" ", "_"));
        }
    }
}
*/