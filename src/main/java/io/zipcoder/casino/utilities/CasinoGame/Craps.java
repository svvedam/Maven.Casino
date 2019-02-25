package io.zipcoder.casino.utilities.CasinoGame;

import java.util.EnumSet;

public class Craps extends DiceGame implements GamblingGame {
    private java.util.ArrayList<Integer> betList;
    public Console console = new Console(System.in,System.out);
    private Dice crapsDice = new Dice();
    private CrapsPlayer crapsPlayer;
    private boolean isPointOn;
    private Integer point;
    private boolean playing;

//    private java.util.ArrayList<CrapsPlayer> crapsPlayerList;


    public Craps() {
        this(new CrapsPlayer());
    }

    public Craps(CrapsPlayer crapsPlayer) {
        this.crapsPlayer = crapsPlayer;
        isPointOn = false;
    }

    public CrapsBet compareStringToBet(String betType) {
        for (CrapsBet thisBetType : CrapsBet.values()) {
            if (thisBetType.name().equalsIgnoreCase(betType)) {
                return thisBetType;
            }
        }
        console.println("Not a valid bet type");
        return null;
    }


    public void play() {
        playing = true;
        while(playing = true){
            placeBetPhase();
            rollPhase();
            payoutPhase();
            askToPlayAgain();
        }
    }

    public void placeBetPhase() {
        if(askToRollOrBet().equalsIgnoreCase("r")){
            return;
        }
        getBet();
        askForAnotherBet();
    }

    private String askToRollOrBet() {
        return console.getStringInput("Would you like to roll or make a bet?");

    }

    public void getBet() {
        Integer bet = console.getIntegerInput("How much do you want to bet?%n");
        if(bet == 0){
            return;
        }
        String betChoice = console.getStringInput("What type of bet do you want to put your " + bet + " chips on?%n" + "type 'Bet List' for a list of options%n%n");
        if (betChoice.equalsIgnoreCase("Bet list")) {
            printBetList();

        } else {
            try {
                compareStringToBet(betChoice).betOn(bet);
                console.println("You've bet " + bet + " chips on " + betChoice);
            } catch (NullPointerException nfe) {
                placeBetPhase();
            }
        }
    }

    public void rollPhase(){
        console.println("%nThrowing the dice!%n%n");
        crapsDice.rollDice();
        console.println("You rolled a " + crapsDice.getValue(0) + "%n and a " + crapsDice.getValue(1) + "%n for a total of: " + crapsDice.getSum());
    }

    public Integer rollValue(){
        return crapsDice.getSum();
    }

    public void payoutPhase(){
        switch (rollValue()){

            case 2:
                if(!isPointOn) {
                    craps();
                }

                break;
            case 3:
                if (!isPointOn){
                    craps();
                }
                break;
            case 4:
                if (!isPointOn){
                    establishPoint();
                }
                else if(point == 4) {
                    pointHit();
                    clearPoint();
                }
                break;
            case 5:
                if (!isPointOn){
                    establishPoint();
                }
                else if(point == 5) {
                    pointHit();


                    clearPoint();
                }
                break;
            case 6:
                if (!isPointOn){
                    establishPoint();
                }
                else if(point == 6) {
                    pointHit();
                    clearPoint();
                }
                break;
            case 7:
                if (!isPointOn){
                    pass();
            }
                else{
                    sevenOut();
                    clearPoint();
                }
                break;
            case 8:
                if (!isPointOn){
                    establishPoint();
                }
                else if(point == 8) {
                    pointHit();
                    clearPoint();
                }
                break;
            case 9:
                if (!isPointOn){
                    establishPoint();
                }
                else if(point == 9) {
                    pointHit();
                    clearPoint();
                }
                break;
            case 10:
                if (!isPointOn){
                    establishPoint();
                }
                else if(point == 10) {
                    pointHit();
                    clearPoint();
                }
                break;
            case 11:
                if (!isPointOn){
                    pass();
                }
                break;
            case 12:
                if (!isPointOn){
                    craps();
                }
                break;



        }
    }



    private void craps() {
        console.println("Craps! Remove the pass bets, pay the Don'ts!");
        CrapsBet.PASSLINE.clearBet();
        CrapsBet.DONTPASS.getPayout();
    }

    private void pass(){
        console.println("Passline wins!");
        CrapsBet.PASSLINE.getPayout();
        CrapsBet.DONTPASS.clearBet();
    }

    private void sevenOut(){
        console.println("Seven out! Line away!");
        CrapsBet.PASSLINE.clearBet();
        CrapsBet.DONTPASS.getPayout();
    }

    private void pointHit(){
        console.println("Point is hit! Winner! Pay the Passline and remove the Don'ts!");
        CrapsBet.PASSLINE.getPayout();
        CrapsBet.DONTPASS.clearBet();
    }

    public void establishPoint(){
        point = rollValue();
        isPointOn = true;
        console.println("The point is: " + rollValue());
    }

    public void clearPoint(){
        point = 0;
        isPointOn = false;
    }

    public void askToPlayAgain(){
        String response = console.getStringInput("Do you want to keep playing?");
        if(response.equalsIgnoreCase("n") || response.equalsIgnoreCase("no")){
            playing = false;
        }
    }

    public void askForAnotherBet(){
         if(console.getStringInput("Would you like to make a bet?%n Type 'Yes' to do so.").equalsIgnoreCase("yes")){
             placeBetPhase();
         }
    }

    public void printBetList(){
    for (int i = 0; i < EnumSet.allOf(CrapsBet.class).toString().split(", ").length; i++) {
        console.println(EnumSet.allOf(CrapsBet.class).toString().split(", ")[i]);
    }
}

    public Integer getScore() {
        return null;
    }



    public Integer giveWinnings() {
        return null;
    }
}
