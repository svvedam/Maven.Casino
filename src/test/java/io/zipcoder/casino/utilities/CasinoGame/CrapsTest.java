package io.zipcoder.casino.utilities.CasinoGame;

import org.junit.Assert;
import org.junit.Test;

public class CrapsTest {

    Integer expectedBet;
    Integer actualBet;
    Integer expectedBalance;
    Integer actualBalance;
    Console console = new Console(System.in,System.out);
    CrapsPlayer crapsPlayer = new CrapsPlayer("test",500);
    Craps craps = new Craps(crapsPlayer,console);

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
    public void takePlayerBetTest(){


   }





}
