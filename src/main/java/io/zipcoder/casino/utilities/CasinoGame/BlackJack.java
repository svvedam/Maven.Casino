
package io.zipcoder.casino.utilities.CasinoGame;


import java.util.ArrayList;

public class BlackJack extends CardGame implements GamblingGame {

    Console console = new Console(System.in, System.out);
    int[] surrogates = {0xD83D, 0xDC7D};
    String alienEmojiString = new String(surrogates, 0, surrogates.length);
    //System.out.println(alienEmojiString);


    BlackJackPlayer bjplayer;
    BlackJackPlayer dplayer;

    Hand playerhd;
    Hand dealerhd;
    //Hand playerhdlist = new Hand(new ArrayList<Card>()); // For future use in case of Multiple Player

    Player dealer;
    Card card;
    int totalPlays = 0;
    int totalWins = 0;
    int playerBet;
    int playervalue = 0;
    int dealervalue = 0;


    // public java.util.ArrayList<Integer> betList;   // For future use in Case of multiple Player
    Deck mydeck;


    // public java.util.ArrayList<BlackJackPlayer> blackJackPlayerList;

    public BlackJack(BlackJackPlayer blackJackPlayer) {

    }

    public BlackJack() {
        bjplayer = new BlackJackPlayer();
        dplayer = new BlackJackPlayer();
        mydeck = new Deck();
        playerhd = new Hand();
        dealerhd = new Hand();
        //card = new Card();


    }


    public void play() {


        console.println("WELCOME TO BLACK JACK GAME " + alienEmojiString + "!!!!!!!! Player");
        System.out.println("\uD83C\uDCC1" + " " + "\uD83C\uDCC1" + " " + "\uD83C\uDCC1");



            bjplayer = new BlackJackPlayer();

            //while-loop for playing the game

            while (bjplayer.getBalance() > 0) //keep playing as long as the player has money left
            {


                //Ask player to place bet
                console.println("You have completed " + totalPlays + " rounds, and won " + totalWins + " times");


                int playerWish = console.getIntegerInput("Do you want to (1)Play or (2)exit from game?");
                if (playerWish == 2) {
                    console.println("Thanks for Playing Black Jack with us!!!! Please visit again");
                    System.exit(0);
                }

                if (playerWish == 1) {


                    console.println("You have $" + bjplayer.balance + ", place bet please.");
                    playerBet = getBet();
                    playerhd.clearHand();
                    dealerhd.clearHand();


                    if (playerBet > bjplayer.getBalance()) {
                        console.println("You don't have enough money for that.");
                        break;
                    }


                    boolean endRound = false; //variable to keep track of weather current round is going


                    console.println(" Dealer Dealing the cards... %n");


                    //Deal two cards to each player one by one
                    for (int i = 0; i < 2; i++) {
                        mydeck.buildBlackJackDeck();

                        Card card = mydeck.blackJackDeck.pop();

                        playerhd.addCard(card);
                        playervalue = playerhd.getBlackJackValue();


                    }
                    for (int i = 0; i < 2; i++) {

                        mydeck.buildBlackJackDeck();
                        Card card = mydeck.blackJackDeck.pop();
                        dealerhd.addCard(card);
                        dealervalue = dealerhd.getBlackJackValue();


                    }


                    while (true) //while-loop to keep drawing cards
                    {

                        console.println("\nPlayer hand value is currently: "
                                + playerhd.value);


                        //shows the dealers hand, show the first card and hides the others
                        console.println("Dealer hand: " + dealerhd.getfirstcard()
                                + "[Hidden]");


                        //Ask if player wants to hit or stand
                        int response = console.getIntegerInput("Do you want to (1)hit or (2)stand ?");


                        //If player hits, draw more cards
                        if (response == 1) {


                            Card drawcard = mydeck.blackJackDeck.pop();
                            playerhd.addCard(drawcard);
                            mydeck.buildBlackJackDeck();

                            console.println("You drew a: "
                                    + drawcard.getBlackJackEnum());


                            //If hand value is over 21, bust
                            if (playerhd.getBlackJackValue() > 21) {
                                console.println("You are Busted. Your current value is: "
                                        + playerhd.value);
                                bjplayer.balance -= playerBet; //Withdraw player bet from player bank
                                playerhd.clearHand();
                                mydeck.buildBlackJackDeck();
                                endRound = true;
                                break;
                            }


                            //Show dealers full hand

                            //Check weather dealers value is higher than players and if game is still going
                            if ((dealerhd.getBlackJackValue() > playerhd.getBlackJackValue()
                                    && endRound == false)) {


                                console.println("Dealers hand Value: " + dealerhd.value);
                                console.println("Dealer wins!");
                                bjplayer.balance -= playerBet;
                                mydeck.buildBlackJackDeck();
                                endRound = true;
                                break;
                            }

                        }
                        if (response == 2) //If player stands, end the loop
                        {
                            //break;
                            // }
                            //dealer-AI, if hand value is 16 or lower, hit.
                            while (dealerhd.value < 17) {
                                console.println("Dealer hand value is " + dealerhd.value);

                                Card dealerdrawcard = mydeck.blackJackDeck.pop();
                                console.println("Dealer drew: " + dealerdrawcard.getBlackJackEnum());
                                dealerhd.addCard(dealerdrawcard);
                                int afterdrawdealervalue = dealerhd.getBlackJackValue();
                                console.println("Dealer hand value after draw is " + afterdrawdealervalue);
                                mydeck.buildBlackJackDeck();


                            }


                            //Show the value of dealers hand
                            console.println("Dealer's hands current value is: " + dealerhd.value);
                            //If dealer is bust, you win
                            if ((dealerhd.getBlackJackValue() > 21) && endRound == false) {
                                console.println("Dealer is bust, you win!");
                                bjplayer.balance += playerBet;
                                dealerhd.clearHand();
                                endRound = true;
                                totalWins++;
                                break;
                            }
                            //check if it's a draw
                            if ((playerhd.getBlackJackValue() == dealerhd.getBlackJackValue()) && endRound == false) {
                                console.println("It's a draw!");
                                endRound = true;
                                totalPlays++;
                                break;
                            }

                            //Check if player won
                            if ((playerhd.getBlackJackValue() > dealerhd.getBlackJackValue()) && endRound == false) {
                                console.println("Player win!");
                                bjplayer.balance += playerBet;
                                console.println("You Win" + giveWinnings());

                                totalWins++;
                                console.println("No of rounds you won" + totalWins);
                                endRound = true;
                                break;
                            } else if (endRound == false) {
                                console.println("You lose the round.");
                                bjplayer.balance -= playerBet;
                                console.println("Your balance is : " + bjplayer.balance);
                                endRound = true;
                                break;
                            }
                        }


                        console.println("End of round.");
                        totalPlays++;
                    }
                }

            }
                console.println("You're out of money, too bad!");



        }



    public Integer giveWinnings() {

        Integer winning = 0;

        if (bjplayer.balance > dplayer.balance) {


            winning = 2 * getBet();


        }


        return winning;

    }


    public Integer getBet() {


        Integer bet = console.getIntegerInput("How much you want to Bet ?");


        return bet;


    }

    public Integer getScore() {


        return null;
    }



}



