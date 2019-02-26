package io.zipcoder.casino.utilities.CasinoGame;

public enum CrapsBet {
    PASSLINE(1,1,new int[]{0},false),
    DONTPASS(1,1,new int[]{0},false),
//    COME(1,1),
//    DONTCOME(1,1),
    ODDS4OR10(3,1,new int[]{0},false),
    ODDS5OR9(5,2,new int[]{0},false),
    ODDS6OR8(11,5,new int[]{0},false),
//    PLACE4(9,5),
//    PLACE5(7,5),
//    PLACE6(6,5),
//    PLACE8(7,6),
//    PLACE9(7,5),
//    PLACE10(9,5),
//    BIG6(1,1),
//    BIG8(1,1),
//    FIELD(2,1),
//    HARD4(7,1,new int[]{4},true),
//    HARD6(9,1, new int[]{6},true),
//    HARD8(9,1,new int[]{8},true),
//    HARD10(7,1,new int[]{10},true),
    ANY7(4,1,new int[]{7},false),
    ANY11(15,1,new int[]{11},false),
    ANYCRAPS(7,1,new int[]{2,3,12},false),
    ACEDEUCE(15,1,new int[]{3},false),
    ACES(30,1,new int[]{2},false),
    BOXCAR(30,1,new int[]{12},false);

public Integer[] betOdds = new Integer[2];
public Integer currentBet;
public int[] oneTimeWins;
public boolean isHardway;
Console console = new Console(System.in,System.out);
    CrapsBet(int multiplier,int divisor,int[] oneTimeWins,boolean isHardway) {
        this.betOdds[0] = multiplier;
        this.betOdds[1] = divisor;
        this.currentBet = 0;
        this.oneTimeWins = oneTimeWins;
        this.isHardway = isHardway;

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
                this.currentBet=0;
                return winnings;
            }
        }

        return 0;
    }



}

