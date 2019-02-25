package io.zipcoder.casino.utilities.CasinoGame;

import io.zipcoder.casino.utilities.CasinoGame.Card;
import io.zipcoder.casino.utilities.CasinoGame.Hand;
import org.junit.Assert;
import org.junit.Test;
import java.lang.String;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class HandTest {

   @Test

   public void getBlackJackValueTest() {

        Card cd1 = new Card(BlackJackEnum.KING,Suit.SPADE);

        Card cd2 = new Card(BlackJackEnum.EIGHT,Suit.SPADE);
        Card cd3 = new Card(BlackJackEnum.QUEEN,Suit.SPADE);

        java.util.ArrayList<Card> mylist = new ArrayList<Card>();
        Hand myhand = new Hand();
        myhand.addCard(cd1);
       myhand.addCard(cd2);
       myhand.addCard(cd3);

        int expectedvalue = 28;
        int actualvalue = myhand.getBlackJackValue();

       Assert.assertEquals(expectedvalue, actualvalue);
   }

   @Test
    public void getgeneralValueTest() {

       Card cd1 = new Card(CardDefaultEnum.ACE.KING,Suit.SPADE);

        Card cd2 = new Card(CardDefaultEnum.JACK,Suit.SPADE);
        Card cd3 = new Card(CardDefaultEnum.QUEEN,Suit.SPADE);

        java.util.ArrayList<Card> mylist = new ArrayList<Card>();
        Hand myhand = new Hand();

       myhand.addCard(cd1);
       myhand.addCard(cd2);
       myhand.addCard(cd3);

        int expectedvalue = 36;
        int actualvalue = myhand.getGeneralValue();

        Assert.assertEquals(expectedvalue, actualvalue);


    }



    @Test
    public void getBlackJackValuewithAceTest() {

        Card cd1 = new Card(BlackJackEnum.ACE,Suit.SPADE);

        Card cd2 = new Card(BlackJackEnum.JACK,Suit.SPADE);
        Card cd3 = new Card(BlackJackEnum.QUEEN,Suit.SPADE);


        java.util.ArrayList<Card> mylist = new ArrayList<Card>();
        Hand myhand = new Hand();

        myhand.addCard(cd1);
        myhand.addCard(cd2);
        myhand.addCard(cd3);
       int expectedvalue = 21;
        int actualvalue = myhand.getBlackJackValue();

        Assert.assertEquals(expectedvalue, actualvalue);


   }






    @Test
    public void getSizeTest() {



        Card cd1 = new Card(CardDefaultEnum.QUEEN,Suit.SPADE);

        Card cd2 = new Card(CardDefaultEnum.QUEEN,Suit.SPADE);
        Card cd3 = new Card(CardDefaultEnum.QUEEN,Suit.SPADE);



        java.util.ArrayList<Card> mylist = new ArrayList<Card>();
        Hand myhand = new Hand();

        myhand.addCard(cd1);
        myhand.addCard(cd2);
        myhand.addCard(cd3);

        int expectedsize = 3;
        int actualvaluesize = myhand.getSize();

        Assert.assertEquals(expectedsize, actualvaluesize);


    }

    @Test
    public void clearHandTest() {



        Card cd1 = new Card(CardDefaultEnum.QUEEN,Suit.SPADE);

        Card cd2 = new Card(CardDefaultEnum.QUEEN,Suit.SPADE);
        Card cd3 = new Card(CardDefaultEnum.QUEEN,Suit.SPADE);


        java.util.ArrayList<Card> myList = new ArrayList<Card>();
        Hand myhand = new Hand();

        myhand.addCard(cd1);
        myhand.addCard(cd2);
        myhand.addCard(cd3);


        int expectedsize = 3;
        int actualvaluesize = myhand.getSize();
        Assert.assertEquals(expectedsize, actualvaluesize);

        myhand.clearHand();
        int expectedsizeclear = 0;
        int actualvaluesizeclear = myhand.getSize();
        Assert.assertEquals(expectedsizeclear, actualvaluesizeclear);



    }
    @Test

    public void addCardTest() {



        Card cd1 = new Card(CardDefaultEnum.QUEEN,Suit.SPADE);

        Card cd2 = new Card(CardDefaultEnum.QUEEN,Suit.SPADE);
        Card cd3 = new Card(CardDefaultEnum.QUEEN,Suit.SPADE);


        java.util.ArrayList<Card> myList = new ArrayList<Card>();




        Hand myhand = new Hand();
        myhand.addCard(cd1);

        int expectedsize = 1;
        int actualvaluesize = myhand.getSize();
        Assert.assertEquals(expectedsize, actualvaluesize);




    }







}