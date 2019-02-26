package io.zipcoder.casino.utilities.CasinoGame;

public class Craps extends DiceGame implements GamblingGame {
    private java.util.ArrayList<Integer> betList;
    public Console console;
    private Dice crapsDice = new Dice();
    public CrapsPlayer crapsPlayer;
    public Integer point;
    private boolean playing;
    boolean comeOut = false;

    public Craps(CrapsPlayer crapsPlayer, Console console) {
        this.crapsPlayer = crapsPlayer;
        this.console = console;
        this.point = 0;

    }

    public Craps(){
        this(new CrapsPlayer(),new Console(System.in,System.out));
    }

    @Override
    public void play() {
        console.println("Welcome to craps!%n%n");
        console.println("Your starting balance is: $" + crapsPlayer.getBalance());
        playing = true;
        while(playing){
            bettingPhase();
            rollPhase();
            payoutPhase();
            askIfUserWantsToStopPlaying();
        }
        console.println("Cya! Your ending balance is: $" + crapsPlayer.getBalance());
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
    //Betting phase methods
    public CrapsBet askThePlayerWhatTypeOfBetTheyWouldLikeToMakeAndThenReturnThatTypeOfBet() {//TODO - recursive
        String response = console.getStringInput("What type of bet would you like to make?%n");
        for (CrapsBet thisBet : CrapsBet.values()) {
            if (thisBet.name().equalsIgnoreCase(response)) {
                return thisBet;
            }
        }
            console.println("Not a valid bet choice%n");
            console.println("Valid bet choices are: %n");
            printBetChoices();
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
        if(point == 0) {
            if (askIfUserWantsToMakeABet()) {
                takeThePlayerBetAndPutItOnTheAppropriateBetLocation();
                bettingPhase();
            }
        }else if(comeOut){
            askForOddsBetAndAssignBetToAppropriateBet();
            comeOut = false;
        }
    }
    public void askForOddsBetAndAssignBetToAppropriateBet(){
        String response = console.getStringInput("would you like to place an odds bet?");
        if("yes".equalsIgnoreCase(response) || "y".equalsIgnoreCase(response)){
            if(point == 6 || point == 8){
                CrapsBet.ODDS6OR8.placeBet(CrapsBet.PASSLINE.currentBet);
                crapsPlayer.placeBet(CrapsBet.PASSLINE.currentBet);
            }
        }
    }
    //Roll phase methods
    public void rollDiceAndPrintResult(){
        console.println("%nShootin!!! %n%n");
        crapsDice.rollDice();
        console.println("Die 1 landed on: " + crapsDice.getValue(0));
        console.println("Die 2 landed on: " + crapsDice.getValue(1) + "%n");
        console.println("You rolled a: " + crapsDice.getSum() +"%n");
    }
    public void setDiceSum(Integer num1, Integer num2){
        crapsDice.setValue(0,num1);
        crapsDice.setValue(1,num2);
    }
    public void rollPhase(){ //TODO - recursive
        String shoot = console.getStringInput("Time to throw the dice!%n%nType 'shoot' shooter!%n");
        if("shoot".equalsIgnoreCase(shoot)|| "r".equalsIgnoreCase(shoot)){
            rollDiceAndPrintResult();
        }
        else {
            console.println("Cmon... shooter's gotta shoot!");
            rollPhase();
        }
    }
    //Craps winning conditions
    public void passWin(){
        console.println("Winner! Pay the Pass and take the Dont's");
        crapsPlayer.receiveWinnings(CrapsBet.PASSLINE.getPayout());
        crapsPlayer.receiveWinnings(CrapsBet.ODDS6OR8.getPayout());
        CrapsBet.ODDS6OR8.clearBet();
        CrapsBet.DONTPASS.clearBet();
    }
    public void craps(){
        console.println("Craps! Take the Pass and pay the Dont's");
        CrapsBet.PASSLINE.clearBet();
        crapsPlayer.receiveWinnings(CrapsBet.DONTPASS.getPayout());
    }
    public void establishPoint(Integer rollValue){
        point = rollValue;
        console.println(point +"! The point is " + point + "!");
        comeOut =true;
    }
    public void sevenOutPointAway(){
        console.println("7 out! Point away!");
        CrapsBet.PASSLINE.clearBet();
        crapsPlayer.receiveWinnings(CrapsBet.DONTPASS.getPayout());
        point = 0;
    }
    public void pointAway(){
        console.println("Point away!");
        point = 0;
    }
    //Pay bets according to conditionals
    public void anytimeRollActions(){
        for(CrapsBet betChecker : CrapsBet.values()) {
            crapsPlayer.receiveWinnings(betChecker.checkOneTimeWins(crapsDice.getSum()));
            }
        }
    public void clearOneTimeBets(){
        CrapsBet.ANY7.clearBet();
        CrapsBet.ANY11.clearBet();
        CrapsBet.ACEDEUCE.clearBet();
        CrapsBet.ANYCRAPS.clearBet();
        CrapsBet.ACES.clearBet();
        CrapsBet.BOXCAR.clearBet();
    }
    public void pointIsOffAfterRollActions(){
        for(CrapsRolls roll : CrapsRolls.values()){
            if(roll.value == crapsDice.getSum()){
                if(roll.possiblePoint){
                    establishPoint(roll.value);
                }
                else{
                    if(roll.pointOffPass){
                        passWin();
                    }
                    else{
                        craps();
                    }
                }
            }
        }
    }
    public void pointIsOnAfterRollActions(){
        for(CrapsRolls roll : CrapsRolls.values()){
            if(roll.value == crapsDice.getSum()){
                if(roll.value == point){
                    passWin();
                    pointAway();
                }
                else if(roll.value == 7){
                    sevenOutPointAway();
                }
                else{
                    //Place bet payout conditionals go here
                }
            }
        }
    }
    public void payoutPhase(){

        anytimeRollActions();
        if(point == 0){
            pointIsOffAfterRollActions();
        }
        else{
            pointIsOnAfterRollActions();
        }
        clearOneTimeBets();
    }
    //Ask if user wants to stop playing
    public void askIfUserWantsToStopPlaying(){
        if (point == 0) {
            console.println("Your current balance is: $" + crapsPlayer.getBalance());
            String response = console.getStringInput("Do you want to keep playing?%n%nType 'Quit' to stop");
            if ("quit".equalsIgnoreCase(response)) {
                playing = false;
            }
        }
    }



    public Integer getScore() {
        return null;
    }

    public Integer giveWinnings() {
        return null;
    }
}
