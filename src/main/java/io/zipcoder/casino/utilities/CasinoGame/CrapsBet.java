package io.zipcoder.casino.utilities.CasinoGame;

public enum CrapsBet {
    PASSLINE(1,1,new int[]{0}),
    DONTPASS(1,1,new int[]{0}),
//    COME(1,1),
//    DONTCOME(1,1),
//    ODDS4OR10(2,1),
//    ODDS5OR9(3,2),
//    ODDS6OR8(6,5),
//    PLACE4(9,5),
//    PLACE5(7,5),
//    PLACE6(6,5),
//    PLACE8(7,6),
//    PLACE9(7,5),
//    PLACE10(9,5),
//    BIG6(1,1),
//    BIG8(1,1),
//    FIELD(2,1),
//    HARD4(7,1),
//    HARD6(9,1),
//    HARD8(9,1),
    HARD10(7,1,new int[]{10}),
    ANY7(4,1,new int[]{7}),
    ANY11(15,1,new int[]{11}),
    ANYCRAPS(7,1,new int[]{2,3,12}),
    ACEDEUCE(15,1,new int[]{3}),
    ACES(30,1,new int[]{2}),
    BOXCAR(30,1,new int[]{12});

public Integer[] betOdds = new Integer[2];
public Integer currentBet;
public int[] oneTimeWins;
Console console = new Console(System.in,System.out);
    CrapsBet(int multiplier,int divisor,int[] oneTimeWins) {
        this.betOdds[0] = multiplier;
        this.betOdds[1] = divisor;
        this.currentBet = 0;
        this.oneTimeWins = oneTimeWins;

    }

    public Integer getPayout() {

        Integer payout = ((betOdds[0] * currentBet) / betOdds[1]);
        if(payout != 0) {
            console.println("You've won: " + payout + " chips on your " + this.name() + " bet!");
        }
        return payout;
    }

    public void placeBet(Integer bet){
         this.currentBet = bet;
        }
    public Integer getBet(){
        return currentBet;
    }

    public void clearBet(){
        this.currentBet = 0;
    }

    public Integer checkOneTimeWins(Integer roll){
        for (int winCheck : oneTimeWins) {
            if(winCheck == roll){
                Integer winnings = getPayout();
                this.clearBet();
                return winnings;
            }
        }
        return 0;
    }

    public Integer checkHardwaysWins(Integer roll) {
        if (roll != 2 && roll != 12) {
            for (int winCheck : oneTimeWins) {
                if (winCheck == roll) {
                    Integer winnings = getPayout();
                    this.clearBet();
                    return winnings;
                }
            }
        }
        return 0;
    }

}

