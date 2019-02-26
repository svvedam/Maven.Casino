package io.zipcoder.casino.utilities.CasinoGame;

import org.junit.Assert;
import org.junit.Test;

public class WarTest {

    @Test
    public void getPlayer1HandTest(){
        // given
        Integer expected = 26;
        // when
        Integer actual = War.getPlayer1Hand().getSize();
        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPlayer2HandTest(){
        // given
        Integer expected = 26;
        // when
        Integer actual = War.getPlayer2Hand().getSize();
        // then
        Assert.assertEquals(expected, actual);
    }
}
