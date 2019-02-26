package io.zipcoder.casino.utilities.CasinoGame;
import org.junit.Assert;
import org.junit.Test;

import org.junit.Assert;
import org.junit.Test;

public class BlackJackPlayerTest {

    @Test


    public void blackJackPlayernameBalanceTest() {

        BlackJackPlayer  bj = new BlackJackPlayer();
        //Given
        Integer expectedBalance = 50;
        String expectedName = "Myname";
        bj.setName(expectedName);
        bj.setBalance(expectedBalance);
        String actualName =bj.getName();
        Integer actualBalance =bj.getBalance();

        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedBalance, actualBalance);
    }
}

