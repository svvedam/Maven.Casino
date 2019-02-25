package io.zipcoder.casino.utilities.CasinoGame;

public class Card {

    private Suit suit;
    private BlackJackEnum blackJackEnum;
    public CardDefaultEnum cardDefaultEnum;

    public Card (BlackJackEnum blackJackEnum, Suit suit)
    {
        this.blackJackEnum = blackJackEnum;
        this.suit = suit;
    }
    public Card (CardDefaultEnum cardDefultEnum, Suit suit)
    {
        this.cardDefaultEnum = cardDefultEnum;
        this.suit = suit;
    }

    public Suit getSuit()
    {
        return suit;
    }

    public void setSuit(Suit suit)
    {
        this.suit = suit;
    }

    public BlackJackEnum getBlackJackEnum()
    {
        return blackJackEnum;
    }

    public void setBlackJackEnum(BlackJackEnum blackJackEnum)
    {
        this.blackJackEnum = blackJackEnum;
    }

    public CardDefaultEnum getDefaultEnum(){
        return cardDefaultEnum;
    }
    public void setCardDefaultEnum(CardDefaultEnum cardDefaultEnum){
        this.cardDefaultEnum = cardDefaultEnum;
    }

    public String toString(){
        return getDefaultEnum() + " of " + getSuit();
    }


}
