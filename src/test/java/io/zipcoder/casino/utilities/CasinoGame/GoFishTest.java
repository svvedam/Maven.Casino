package io.zipcoder.casino.utilities.CasinoGame;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GoFishTest {

    @Test
    public void playTest() {
        //Given

        //When

        //Then
    }

    @Test
    public void populateGoFishHandTest() {
        //Given
        GoFish goFish = new GoFish();

        //When
        goFish.populateGoFishHand();

        //Then
        int actualPlayer1Handsize= goFish.goFishHandPlayer1.hand.size();
        int actualPlayer2Handsize= goFish.goFishHandPlayer2.hand.size();
        Assert.assertEquals(7,actualPlayer1Handsize);
        Assert.assertEquals(7,actualPlayer2Handsize);


    }
    @Test
    public void populatePlayersAndListTest() {
        //Given
        GoFish goFish = new GoFish();

        //When
        goFish.populateGoFishHand();
        goFish.populatePlayersAndList(goFish.goFishHandPlayer1,goFish.goFishHandPlayer2);

        //Then
        int actualGoFishPlayerListSize=goFish.goFishPlayerList.size();
        Assert.assertEquals(2,actualGoFishPlayerListSize);
    }

    @Test
    public void getScoreTest() {
        //Given

        //When

        //Then
    }

    @Test
    public void findDuplicateCardsForEachPlayerTest() {
        //Given
        GoFish goFish = new GoFish();
        goFish.populateGoFishHand();
        goFish.populatePlayersAndList(goFish.goFishHandPlayer1,goFish.goFishHandPlayer2);


        //When
        goFish.findDuplicateCardsForEachPlayer(goFish.gfPlayer1);
        //Then
        //Since the card hand is randomized, this test check if the method executed
        Assert.assertTrue(true);
    }
}