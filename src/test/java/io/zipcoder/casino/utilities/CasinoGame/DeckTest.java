package io.zipcoder.casino.utilities.CasinoGame;

import org.junit.Assert;
import org.junit.Test;


import static org.junit.Assert.*;

public class DeckTest {

    @Test
    public void buildBlackJackAndRegularDeckTest() {
        //Given
        Deck myDeck;

        //When
        myDeck = new Deck();

        int actualBlackJackDeckSize = myDeck.blackJackDeck.size();
        int actualRegularDeckSize = myDeck.regularDeck.size();

        //Then
        Assert.assertEquals(52, actualBlackJackDeckSize);
        Assert.assertEquals(52, actualRegularDeckSize);
    }
}
