package io.zipcoder.casino.utilities.CasinoGame;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CrapsTest {

    Integer expectedBet;
    Integer actualBet;
    Integer expectedBalance;

    Integer actualBalance;
    Console console = new Console(System.in,System.out);
    CrapsPlayer crapsPlayer = new CrapsPlayer("test",500);
    Craps craps = new Craps(crapsPlayer,console);

    @Before
    public void setup(){
        for(CrapsBet thisBet : CrapsBet.values()){
            thisBet.placeBet(0);
        }
    }

   @Test
    public void removeBalance(){
      expectedBet = 50;
      crapsPlayer.placeBet(expectedBet);
      expectedBalance = 450;
      actualBalance = crapsPlayer.balance;
       Assert.assertEquals(expectedBalance,actualBalance);
   }

   @Test
    public void printBetChoicesTest(){
       craps.printBetChoices();
   }


   @Test
    public void correctBetPlacedTest(){
       CrapsBet givenBet = CrapsBet.PASSLINE;
       String givenString = "passline";
       CrapsBet returnBet = null;
       for (CrapsBet thisBet : CrapsBet.values()) {
           if (thisBet.name().equalsIgnoreCase(givenString)) {
                returnBet = thisBet;
           }
       }
       Assert.assertEquals(givenBet,returnBet);
   }

    @Test
    public void incorrectStringBetPlacedTest(){
        CrapsBet givenBet = CrapsBet.PASSLINE;
        String givenString = "iuhfiuhiu";
        CrapsBet returnBet = null;
        for (CrapsBet thisBet : CrapsBet.values()) {
            if (thisBet.name().equalsIgnoreCase(givenString)) {
                returnBet = thisBet;
            }
        }
        Assert.assertNull(returnBet);
    }

    @Test
    public void passWinTest(){
       expectedBet = 50;
       expectedBalance = 550;
       CrapsBet.PASSLINE.placeBet(expectedBet);
       craps.passWin();
       Assert.assertEquals(expectedBalance,crapsPlayer.getBalance());

    }

    @Test
    public void passWinFailTest(){
        expectedBet = 50;
        expectedBalance = 500;
        Integer expectedClear = 0;
        CrapsBet.DONTPASS.placeBet(expectedBet);
        craps.passWin();
        Assert.assertEquals(expectedBalance,crapsPlayer.getBalance());
        Assert.assertEquals(expectedClear,CrapsBet.DONTPASS.currentBet);
    }

    @Test
    public void crapsWinTest(){
        expectedBet = 50;
        expectedBalance = 550;
        CrapsBet.DONTPASS.placeBet(expectedBet);
        craps.craps();
        Assert.assertEquals(expectedBalance,crapsPlayer.getBalance());

    }

    @Test
    public void crapsFailTest(){
        expectedBet = 50;
        expectedBalance = 500;
        Integer expectedClear = 0;
        CrapsBet.PASSLINE.placeBet(expectedBet);
        craps.craps();
        Assert.assertEquals(expectedBalance,crapsPlayer.getBalance());
        Assert.assertEquals(expectedClear,CrapsBet.PASSLINE.currentBet);
    }

    @Test
    public void establishPointTest(){
      Integer expectedPoint = 8;
       craps.establishPoint(expectedPoint);
      Assert.assertEquals(expectedPoint,craps.point);
    }

    @Test
    public void sevenOutTest(){
        expectedBet = 50;
        expectedBalance = 500;
        CrapsBet.PASSLINE.placeBet(expectedBet);
       Integer startingPoint = 8;
       Integer expectedPoint = 0;
       craps.establishPoint(startingPoint);
       craps.sevenOutPointAway();
       Assert.assertEquals(expectedPoint,craps.point);
       Assert.assertEquals(expectedPoint,CrapsBet.PASSLINE.currentBet);
    }

    //Payout Phase Tests

    @Test
    public void PayoutTest1(){
        expectedBet = 50;
        expectedBalance = 550;
        Integer startingPoint = 0;
        Integer expectedPoint = 8;
        craps.setDiceSum(4,4);
        craps.point = startingPoint;
        CrapsBet.PASSLINE.placeBet(expectedBet);
        craps.payoutPhase();
        Assert.assertEquals(expectedPoint,craps.point);
    }

    @Test
    public void PayoutTest2(){
        expectedBet = 50;
        expectedBalance = 550;
        Integer startingPoint = 0;
        Integer expectedRoll = 7;
        craps.setDiceSum(3,4);
        craps.point = startingPoint;
        CrapsBet.PASSLINE.placeBet(expectedBet);
        craps.payoutPhase();
        Assert.assertEquals(expectedBalance,crapsPlayer.getBalance());
    }

    @Test
    public void PayoutTest3(){
        expectedBet = 50;
        expectedBalance = 550;
        Integer startingPoint = 0;
        Integer expectedRoll = 11;
        craps.setDiceSum(6,5);
        craps.point = startingPoint;
        CrapsBet.PASSLINE.placeBet(expectedBet);
        craps.payoutPhase();
        Assert.assertEquals(expectedBalance,crapsPlayer.getBalance());
    }

    @Test
    public void PayoutTest4(){
        expectedBet = 50;
        expectedBalance = 550;
        Integer startingPoint = 0;
        Integer expectedRoll = 2;
        craps.setDiceSum(1,1);
        craps.point = startingPoint;
        CrapsBet.DONTPASS.placeBet(expectedBet);
        craps.payoutPhase();
        Assert.assertEquals(expectedBalance,crapsPlayer.getBalance());
    }

    @Test
    public void PayoutTest5(){
        expectedBet = 50;
        expectedBalance = 550;
        Integer startingPoint = 0;
        Integer expectedRoll = 3;
        craps.setDiceSum(2,1);
        craps.point = startingPoint;
        CrapsBet.DONTPASS.placeBet(expectedBet);
        craps.payoutPhase();
        Assert.assertEquals(expectedBalance,crapsPlayer.getBalance());
    }

    @Test
    public void PayoutTest6(){
        expectedBet = 50;
        expectedBalance = 550;
        Integer startingPoint = 0;
        Integer expectedRoll = 12;
        craps.setDiceSum(6,6);
        craps.point = startingPoint;
        CrapsBet.DONTPASS.placeBet(expectedBet);
        craps.payoutPhase();
        Assert.assertEquals(expectedBalance,crapsPlayer.getBalance());
    }

    @Test
    public void PayoutTest7(){
        expectedBet = 50;
        expectedBalance = 550;
        Integer startingPoint = 6;
        Integer expectedRoll = 6;
        craps.setDiceSum(3,3);
        craps.point = startingPoint;
        CrapsBet.PASSLINE.placeBet(expectedBet);
        craps.payoutPhase();
        Assert.assertEquals(expectedBalance,crapsPlayer.getBalance());
    }

    @Test
    public void PayoutTest8(){
        expectedBet = 50;
        expectedBalance = 550;
        Integer startingPoint = 6;
        Integer expectedRoll = 7;
        craps.setDiceSum(3,4);
        craps.point = startingPoint;
        CrapsBet.DONTPASS.placeBet(expectedBet);
        craps.payoutPhase();
        Assert.assertEquals(expectedBalance,crapsPlayer.getBalance());
    }

    @Test
    public void PayoutTest9(){
        expectedBet = 50;
        expectedBalance = 500;
        Integer startingPoint = 6;
        Integer expectedRoll = 12;
        craps.setDiceSum(6,6);
        craps.point = startingPoint;
        CrapsBet.PASSLINE.placeBet(expectedBet);
        craps.payoutPhase();
        Assert.assertEquals(expectedBalance,crapsPlayer.getBalance());
    }
    //Onetime bets check
    @Test
    public void PayoutTest10(){
        expectedBet = 50;
        expectedBalance = 2000;
        Integer startingPoint = 6;
        Integer expectedRoll = 2;
        craps.setDiceSum(1,1);
        craps.point = startingPoint;
        CrapsBet.ACES.placeBet(expectedBet);
        craps.payoutPhase();
        Assert.assertEquals(expectedBalance,crapsPlayer.getBalance());
    }

    @Test
    public void PayoutTest11(){
        expectedBet = 50;
        expectedBalance = 2000;
        Integer startingPoint = 0;
        Integer expectedRoll = 12;
        craps.setDiceSum(6,6);
        craps.point = startingPoint;
        CrapsBet.BOXCAR.placeBet(expectedBet);
        craps.payoutPhase();
        Assert.assertEquals(expectedBalance,crapsPlayer.getBalance());
    }

    @Test
    public void PayoutTest12(){
        expectedBet = 50;
        expectedBalance = 500 + (15 * expectedBet);
        Integer startingPoint = 0;
        Integer expectedRoll = 3;
        craps.setDiceSum(1,2);
        craps.point = startingPoint;
        CrapsBet.ACEDEUCE.placeBet(expectedBet);
        craps.payoutPhase();
        Assert.assertEquals(expectedBalance,crapsPlayer.getBalance());
    }

    @Test
    public void PayoutTest13(){
        expectedBet = 50;
        expectedBalance = 500 + (7 * expectedBet);
        Integer startingPoint = 0;
        Integer expectedRoll = 3;
        craps.setDiceSum(1,2);
        craps.point = startingPoint;
        CrapsBet.ANYCRAPS.placeBet(expectedBet);
        craps.payoutPhase();
        Assert.assertEquals(expectedBalance,crapsPlayer.getBalance());
    }

    @Test
    public void PayoutTest14(){
        expectedBet = 50;
        expectedBalance = 500 + (7 * expectedBet);
        Integer startingPoint = 0;
        Integer expectedRoll = 2;
        craps.setDiceSum(1,1);
        craps.point = startingPoint;
        CrapsBet.ANYCRAPS.placeBet(expectedBet);
        craps.payoutPhase();
        Assert.assertEquals(expectedBalance,crapsPlayer.getBalance());
    }

    @Test
    public void PayoutTest15(){
        expectedBet = 50;
        expectedBalance = 500 + (7 * expectedBet);
        Integer startingPoint = 8;
        Integer expectedRoll = 12;
        craps.setDiceSum(6,6);
        craps.point = startingPoint;
        CrapsBet.ANYCRAPS.placeBet(expectedBet);
        craps.payoutPhase();
        Assert.assertEquals(expectedBalance,crapsPlayer.getBalance());
    }

    @Test
    public void PayoutTest16(){
        expectedBet = 50;
        expectedBalance = 500 + (15 * expectedBet);
        Integer startingPoint = 6;
        Integer expectedRoll = 11;
        craps.setDiceSum(5,6);
        craps.point = startingPoint;
        CrapsBet.ANY11.placeBet(expectedBet);
        craps.payoutPhase();
        Assert.assertEquals(expectedBalance,crapsPlayer.getBalance());
    }

    @Test
    public void PayoutTest17(){
        expectedBet = 50;
        expectedBalance = 500 + (4 * expectedBet);
        Integer startingPoint = 4;
        Integer expectedRoll = 7;
        craps.setDiceSum(3,4);
        craps.point = startingPoint;
        CrapsBet.ANY7.placeBet(expectedBet);
        craps.payoutPhase();
        Assert.assertEquals(expectedBalance,crapsPlayer.getBalance());
    }
    //Hardways tests
    @Test
    public void PayoutTest18(){
        expectedBet = 50;
        expectedBalance = 500 + (7 * expectedBet);
        Integer startingPoint = 0;
        Integer expectedRoll = 10;
        craps.setDiceSum(5,5);
        craps.point = startingPoint;
        CrapsBet.HARD10.placeBet(expectedBet);
        craps.payoutPhase();
        Assert.assertEquals(expectedBalance,crapsPlayer.getBalance());
    }

    @Test
    public void PayoutTest19(){
        expectedBet = 50;
        expectedBalance = 500 + (7 * expectedBet);
        Integer startingPoint = 0;
        Integer expectedRoll = 10;
        craps.setDiceSum(4,6);
        craps.point = startingPoint;
        CrapsBet.HARD10.placeBet(expectedBet);
        craps.payoutPhase();
        Assert.assertNotEquals(expectedBalance,crapsPlayer.getBalance());
        Assert.assertEquals(startingPoint,CrapsBet.HARD10.currentBet);
    }










}
