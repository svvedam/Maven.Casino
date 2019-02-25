//package io.zipcoder.casino.utilities.CasinoGame;
//
//
//
//import java.util.ArrayList;
//
//public class BlackJack extends CardGame implements GamblingGame {
//
//    Console console = new Console(System.in, System.out);
//    BlackJackPlayer bjplayer;
//    BlackJackPlayer player;
//
//    Hand playerhd;
//    Hand dealerhd;
//    //Hand playerhd = new Hand(new ArrayList<Card>());
//    //Hand dealerhd = new Hand(new ArrayList<Card>());
//    Player dealer;
//    Card card;
//    int totalPlays = 0;
//    int totalWins = 0;
//    int playerBet;
//
//    public java.util.ArrayList<Integer> betList;
//    Deck mydeck ;
//
//
//    // public java.util.ArrayList<BlackJackPlayer> blackJackPlayerList;
//
//    public BlackJack(BlackJackPlayer blackJackPlayer) {
//
//    }
//
//    public BlackJack() {
//        bjplayer = new BlackJackPlayer();
//        player =  new BlackJackPlayer();
//        mydeck = new Deck();
//        playerhd = new Hand();
//        dealerhd = new Hand();
//        //card = new Card();
//
//
//
//    }
//
//
//    public void play() {
//
//        console.println("Welcome to Black Jack!");
//        bjplayer = new BlackJackPlayer();
//
//        //while-loop for playing the game
//        while (bjplayer.getBalance() > 0) //keep playing as long as the player has money left
//        {
//
//            //Ask player to place bet
//            console.println("You have played " + totalPlays + " times, and won " + totalWins + " times");
//            console.println("You have $" + bjplayer.balance + ", place bet plase.");
//            playerBet = getBet();
//
//            if (playerBet > bjplayer.getBalance()) {
//                console.println("You don't have enough money for that.");
//            }
//
//
//            boolean endRound = false; //variable to keep track of wether current round is going
//
//
//            console.println("Dealing the cards... %n");
//
//            mydeck.buildBlackJackDeck();
//
//
//            //Deal two cards to each player one by one
//            for (int i = 0; i < 2; i++) {
//
//
//                Card card = mydeck.blackJackDeck.pop();
//                playerhd.addCard(card);
//                dealerhd.addCard(card);
//
//
//            }
//
//
//            while (true) //while-loop to keep drawing cards
//            {
//
//                console.println("\nYour hand value is currently: "
//                        + playerhd.getBlackJackValue());
//
//                //shows the dealers hand, show the first card and hides the others
//                console.println("Dealer hand: " + dealerhd.getBlackJackValue()
//                        + "[Hidden]");
//
//                //Ask if player wants to hit or stand
//                int response = console.getIntegerInput("Do you want to (1)hit or (2)stand?");
//
//
//                //If player hits, draw more cards
//                if (response == 1) {
//
//
//                    Card card = mydeck.blackJackDeck.pop();
//                    playerhd.addCard(card);
//
//                    console.println("You drew a: "
//                            + card);
//
//                    //If hand value is over 21, bust
//                    if (playerhd.getBlackJackValue() > 21) {
//                        console.println("Bust. Your current value is: "
//                                + playerhd.getBlackJackValue());
//                        bjplayer.balance -= playerBet; //Withdraw player bet from player bank
//                        endRound = true;
//                        break;
//                    }
//                }
//                if (response == 2) //If player stands, end the loop
//                {
//                    // break;
//                    // }
//
//                    //Show dealers full hand
//                    console.println("Dealers hand: " + dealerhd.toString());
//                    //Check weather dealers value is higher than players and if game is still going
//                    if ((dealerhd.getBlackJackValue() > playerhd.getBlackJackValue())
//                            && endRound == false) {
//                        console.println("Dealer wins!");
//                        bjplayer.balance -= playerBet;
//                        endRound = true;
//                    }
//                    //dealer-AI, if hand value is 16 or lower, hit.
//                    while ((dealerhd.getBlackJackValue() < 17) && endRound == false) {
//                        mydeck.blackJackDeck.pop();
//                        console.println("Dealer drew: " + dealerhd.toString());
//
//                    }
//
//
//                    //Show the value of dealers hand
//                    console.println("Dealer's hands current value is: " + dealerhd.getSize());
//                    //If dealer is bust, you win
//                    if ((dealerhd.getBlackJackValue() > 21) && endRound == false) {
//                       console.println("Dealer is bust, you win!");
//                        bjplayer.balance += playerBet;
//                        endRound = true;
//                        totalWins++;
//                    }
//                    //check if it's a draw
//                    if ((playerhd.getBlackJackValue() == dealerhd.getBlackJackValue()) && endRound == false) {
//                        console.println("It's a draw!");
//                        endRound = true;
//                        totalPlays++;
//                    }
//
//                    //Check if player won
//                    if ((playerhd.getBlackJackValue() > dealerhd.getBlackJackValue()) && endRound == false) {
//                        System.out.println("Player win!");
//                        bjplayer.balance += playerBet;
//                        endRound = true;
//                        totalWins++;
//                    } else if (endRound == false) {
//                        console.println("You lose the round.");
//                        bjplayer.balance -= playerBet;
//                        endRound = true;
//                    }
//
//                    System.out.println("End of round.");
//                    totalPlays++;
//                }
//
//                System.out.println("You're out of money, too bad!");
//
//
//
//            }
//
//
//            }
//
//
//        }
//
//
//        public Integer giveWinnings () {
//
//            Integer winning = 0;
//
//            if (bjplayer.balance > player.balance) {
//
//                winning = 2 * getBet();
//
//
//            }
//
//
//            return winning;
//
//        }
//
//
//        public Integer getBet() {
//
//
//            Integer bet = console.getIntegerInput("How much you want to Bet ?");
//
//
//            return bet;
//
//
//        }
//
//        public Integer getScore () {
//
//
//            return null;
//        }
//
//
//
//    }
//
//
