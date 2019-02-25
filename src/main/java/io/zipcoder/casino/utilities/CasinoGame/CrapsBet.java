package io.zipcoder.casino.utilities.CasinoGame;

public enum CrapsBet {
    PASSLINE(1,1),
    DONTPASS(1,1),
    COME(1,1),
    DONTCOME(1,1),
    ODDS4OR10(2,1),
    ODDS5OR9(3,2),
    ODDS6OR8(6,5),
    PLACE4(9,5),
    PLACE5(7,5),
    PLACE6(6,5),
    PLACE8(7,6),
    PLACE9(7,5),
    PLACE10(9,5),
    BIG6(1,1),
    BIG8(1,1),
    FIELD(2,1),
    HARD4(7,1),
    HARD6(9,1),
    HARD8(9,1),
    HARD10(7,1),
    ANY7(4,1),
    ANY11(15,1),
    ANYCRAPS(7,1),
    ACEDEUCE(15,1),
    ACES(30,1),
    BOXCAR(30,1);

public Integer[] betOdds = new Integer[2];
public Integer currentBet;
Console console = new Console(System.in,System.out);
    CrapsBet(int multiplier,int divisor) {
        this.betOdds[0] = multiplier;
        this.betOdds[1] = divisor;
        this.currentBet = 0;

    }

    public Integer getPayout() {
        Integer payout = ((betOdds[0] * currentBet) / betOdds[1]) + currentBet;
        console.println("You've won: " + payout + "!");
        this.currentBet = 0;
        return payout;
    }

    public void betOn(Integer bet){
         this.currentBet = bet;
        }
    public Integer getBet(){
        return currentBet;
    }

    public void clearBet(){
        this.currentBet = 0;
    }

}

