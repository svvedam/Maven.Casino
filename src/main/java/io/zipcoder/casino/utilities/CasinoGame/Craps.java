package io.zipcoder.casino.utilities.CasinoGame;

import java.util.EnumSet;

public class Craps extends DiceGame implements GamblingGame {
    private java.util.ArrayList<Integer> betList;
    public Console console;
    private Dice crapsDice = new Dice();
    public CrapsPlayer crapsPlayer;
    private Integer point;
    private boolean playing;

//    private java.util.ArrayList<CrapsPlayer> crapsPlayerList;




    public Craps(CrapsPlayer crapsPlayer, Console console) {
        this.crapsPlayer = crapsPlayer;
        this.console = console;
        this.point = 0;

    }

    @Override
    public void play() {

    }

    public boolean askIfUserWantsToMakeABet() {

        String response = console.getStringInput("Would you like to make a bet?%nType 'yes' or 'y' to do so.");
        if (response.equalsIgnoreCase("yes") || response.equalsIgnoreCase("y")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Integer getBet() { // TODO - eliminate recursive nature
        Integer bet = console.getIntegerInput("How much would you like to bet?%n");
        if(bet <= crapsPlayer.getBalance()){
            crapsPlayer.placeBet(bet);
            return bet;
        }
        else{
            console.println("You don't have that much to bet!");
            console.println("You can bet up to: " + crapsPlayer.getBalance());
            return getBet();
        }


    }

    public CrapsBet askThePlayerWhatTypeOfBetTheyWouldLikeToMakeAndThenReturnThatTypeOfBet() {
        String response = console.getStringInput("What type of bet would you like to make?%n");
        for (CrapsBet thisBet : CrapsBet.values()) {
            if (thisBet.name().equalsIgnoreCase(response)) {
                return thisBet;
            } else {
                console.println("Not a valid bet choice%n");
                console.println("Valid bet choices are: %n");
                printBetChoices();
                return askThePlayerWhatTypeOfBetTheyWouldLikeToMakeAndThenReturnThatTypeOfBet();
            }
        }
        return askThePlayerWhatTypeOfBetTheyWouldLikeToMakeAndThenReturnThatTypeOfBet();
    }

    public void printBetChoices() {
        for (CrapsBet thisBet: CrapsBet.values()) {
            console.println(thisBet.name());
            console.println("");
        }
    }

    public void takeThePlayerBetAndPutItOnTheAppropriateBetLocation(){

        Integer betAmount = getBet();
        CrapsBet thisBet = askThePlayerWhatTypeOfBetTheyWouldLikeToMakeAndThenReturnThatTypeOfBet();
        thisBet.placeBet(betAmount);
        console.println("You've bet: $" + betAmount + " on the " + thisBet.name() + "%n");
    }

    public void bettingPhase(){ //TODO - fix recursive calls and add feature to show current bets made
        if(askIfUserWantsToMakeABet()){
            takeThePlayerBetAndPutItOnTheAppropriateBetLocation();
            bettingPhase();
        }
    }

    public void rollDiceAndPrintResult(){
        console.println("%nShootin!!! %n%n%n");
        crapsDice.rollDice();
        console.println("Die 1 landed on: " + crapsDice.getValue(0));
        console.println("Die 2 landed on: " + crapsDice.getValue(1) + "%n");
        console.println("You rolled a: " + crapsDice.getSum());
    }

    public void tellUserToShootUntilTheyDo(){ //TODO - recursive
        String shoot = console.getStringInput("Time to throw the dice!%n%nType 'shoot' shooter!%n");
        if("shoot".equalsIgnoreCase(shoot)){
            rollDiceAndPrintResult();
        }
        else {
            console.println("Cmon... shooter's gotta shoot!");
            tellUserToShootUntilTheyDo();
        }
    }

    public void pointIsOffAfterRollActions(){
        
    }






    public Integer getScore() {
        return null;
    }

    public Integer giveWinnings() {
        return null;
    }
}
