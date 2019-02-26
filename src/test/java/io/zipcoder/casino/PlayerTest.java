package io.zipcoder.casino;

import io.zipcoder.casino.utilities.CasinoGame.Player;
import org.junit.Assert;
import org.junit.Test;

public class PlayerTest {

 @Test

 public void playerTest()
    {
     //Given

  String expectedName = "abcd";
  Integer expectedBalance =1000;

  Player player = new Player(expectedName,expectedBalance);

  //When

   String actualName = player.getName();
   Integer actualBalance = player.getBalance();

   //Then
        Assert.assertEquals(expectedName,actualName);
        Assert.assertEquals(expectedBalance,actualBalance);


    }

}

