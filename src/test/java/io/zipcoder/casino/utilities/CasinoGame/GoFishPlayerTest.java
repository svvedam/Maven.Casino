package io.zipcoder.casino.utilities.CasinoGame;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GoFishPlayerTest {

    @Test
    public void getNameTest() {
        //Given
        GoFishPlayer goFishPlayer = new GoFishPlayer();
        goFishPlayer.setName("Player1");

        //When
        String actualResult = goFishPlayer.getName();

        //Then
        Assert.assertEquals("Player1",actualResult);
    }
    @Test
    public void setNameTest() {
        //Given
        GoFishPlayer goFishPlayer = new GoFishPlayer();

        //When
        goFishPlayer.setName("Player1");
        String actualResult = goFishPlayer.getName();

        //Then
        Assert.assertEquals("Player1",actualResult);
    }

    @Test
    public void addCardTest() {
        //Given
        GoFishPlayer goFishPlayer = new GoFishPlayer();
        Deck testDeck = new Deck();
        Card card = testDeck.regularDeck.pop();
        goFishPlayer.playerHand= new Hand();

        //When
        goFishPlayer.playerHand.addCard(card);

        //Then
        int actualSize = goFishPlayer.playerHand.getSize();
        Assert.assertEquals(1,actualSize);
    }

    @Test
    public void getPlayerHandTest() {
        //Given
        GoFishPlayer goFishPlayer = new GoFishPlayer();
        Deck testDeck = new Deck();
        Card card = testDeck.regularDeck.pop();
        goFishPlayer.playerHand= new Hand();
        goFishPlayer.playerHand.addCard(card);
        Hand expectedResult = goFishPlayer.playerHand;

        //When
        Hand actualResult = goFishPlayer.getPlayerHand();

        //Then
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getScoreTest() {
        //Given
        GoFishPlayer goFishPlayer = new GoFishPlayer();
        goFishPlayer.setScore(20);

        //When
        int actualResult = goFishPlayer.getScore();

        //Then
        Assert.assertEquals(20,actualResult);
    }
}