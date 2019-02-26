
package io.zipcoder.casino.utilities.CasinoGame;

import org.junit.Assert;
import org.junit.Test;



import java.util.ArrayList;

public class BlackJackTest {

    @Test
    public void play() {



    }

    @Test
    public void giveWinningsTest() {
        BlackJackPlayer bjp1 = new BlackJackPlayer ();
        BlackJackPlayer bjp2 = new BlackJackPlayer ();
        BlackJack bj = new BlackJack();

        Integer expectedWinning = 100;

          bjp1.setBalance(50);
          bjp2.setBalance(20);
          if (bjp1.balance>bjp2.balance)

       Assert.assertEquals(expectedWinning,bj.giveWinnings());






    }



}

