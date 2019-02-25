package io.zipcoder.casino.utilities.CasinoGame;

import org.junit.Assert;
import org.junit.Test;

public class CrapsBetEnumTest {




    Integer expectedBet;
    Integer actualBet;
    CrapsBet testBet;
    Integer expectedPayout;
    Integer actualPayout;
    Craps craps = new Craps();

    @Test
    public void storeBetTest(){
        expectedBet = 50;
        CrapsBet.DONTPASS.betOn(expectedBet);
        actualBet = CrapsBet.DONTPASS.getBet();
        Assert.assertEquals(expectedBet,actualBet);

    }

    @Test
    public void clearBetTest(){
        expectedBet = 50;
        CrapsBet.ACES.betOn(expectedBet);
        CrapsBet.ACES.clearBet();
        Integer didBetClear = CrapsBet.PASSLINE.currentBet;
        Integer finalbet = 0;
        Assert.assertEquals(finalbet,didBetClear);
    }

    @Test
    public void getPayoutTest1(){
        expectedBet = 50;
        expectedPayout = 100;
        CrapsBet.PASSLINE.betOn(expectedBet);
        actualPayout = CrapsBet.PASSLINE.getPayout();
        Assert.assertEquals(expectedPayout,actualPayout);
        Integer didBetClear = CrapsBet.PASSLINE.currentBet;
        Integer finalbet = 0;
        Assert.assertEquals(finalbet,didBetClear);
    }

    @Test
    public void getPayoutTest2(){
        expectedBet = 50;
        expectedPayout = 110;
        CrapsBet.PLACE6.betOn(expectedBet);
        actualPayout = CrapsBet.PLACE6.getPayout();
        Assert.assertEquals(expectedPayout,actualPayout);
    }

    @Test
    public void compareStringTest(){
        testBet = CrapsBet.PASSLINE;
        String betString = "Passline";
        CrapsBet actualBet = craps.compareStringToBet(betString);
        Assert.assertEquals(testBet,actualBet);

    }
















//    @Test
//    public void constructorTest1(){
//         expectedBet = 0;
//         actualBet = testBetTree.betMap.get(CrapsBets.PASSLINE.name());
//
//        Assert.assertEquals(expectedBet,actualBet);
//    }
//
//    @Test
//    public void constructorTest2(){
//         expectedBet = 0;
//         actualBet = testBetTree.betMap.get(CrapsBets.BOXCAR.name());
//
//        Assert.assertEquals(expectedBet,actualBet);
//    }
//
//    @Test
//    public void addBetTest(){
//         expectedBet = 50;
//         testBet = CrapsBets.PASSLINE;
//         testBetTree.betMap.put(testBet.name(),expectedBet);
//         actualBet = testBetTree.betMap.get(testBet);
//         Assert.assertEquals(expectedBet,actualBet);
//
//    }
//
//    @Test
//    public void getPayoutTest(){
//        expectedBet = 50;
//        expectedPayout = 100;
//        testBet = CrapsBets.PASSLINE;
//        testBetTree.betMap.put(testBet.name(),expectedBet);
//        actualPayout = testBet.getPayout(testBetTree.betMap.get(testBet));
//        Assert.assertEquals(expectedPayout,actualPayout);
//    }


}
