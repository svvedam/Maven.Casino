package io.zipcoder.casino.utilities.CasinoGame;

import java.util.ArrayList;

public class GoFish extends CardGame implements Game {

    public ArrayList<GoFishPlayer> goFishPlayerList;
    public Deck myDeck;
    public Hand goFishHandPlayer1;
    public Hand goFishHandPlayer2;
    public GoFishPlayer gfPlayer1;
    public GoFishPlayer gfPlayer2;
    public Console console;
    public int playerTurn;

    public GoFish() {
        //create a deck
        myDeck = new Deck();

        //create a hand
        goFishHandPlayer1 = new Hand();
        goFishHandPlayer2 = new Hand();
        gfPlayer1 = new GoFishPlayer();
        gfPlayer2 = new GoFishPlayer();
        playerTurn = 1;
        console = new Console(System.in, System.out);
    }

    public void play() {
        //Write the logic to play the game
        //Populate GoFish hand to the user
        console.println("***** Go Fish game *****");
        populateGoFishHand();
        //Populate Players and List
        populatePlayersAndList(this.goFishHandPlayer1, this.goFishHandPlayer2);
        //find duplicate card and get rid of them from the hand and increment score
        findDuplicateCardsForEachPlayer(gfPlayer1);
        findDuplicateCardsForEachPlayer(gfPlayer2);
        int sizeOfDeck = myDeck.regularDeck.size();

        while(sizeOfDeck!=0){
            if (playerTurn ==1)
             playTurn(gfPlayer1, gfPlayer2);
            else
             playTurn(gfPlayer2, gfPlayer1);
            String userResponse = console.getStringInput("Do you want to continue Y/N ");
            if(userResponse.equalsIgnoreCase("n"))
                break;
         }
    }

    public void playTurn(GoFishPlayer currentPlayer, GoFishPlayer otherPlayer) {
        console.println("Entered playTurn method : ");
        ArrayList<Card> cardArrayList = otherPlayer.getPlayerHand().hand;

        int i1 = 0;
        printCardsToConsole(currentPlayer);
        printCardsToConsole(otherPlayer);
        Integer cardInput = console.getIntegerInput("Enter current player card to fish : ");
        //Get the index of inserted number in currentPlayer list
        int inputIndexValue = getIndexOfMatchedCard(currentPlayer, cardInput);
        compareHandsOfPlayers(currentPlayer, otherPlayer, inputIndexValue, cardInput);


    }
    //loop through otherPlayer cards and compare the input with the cards
    //If match found then currentPlayer score++ remove the card from currentPlayer and player2 hand.

    public void compareHandsOfPlayers(GoFishPlayer currentPlayer, GoFishPlayer otherPlayer,
                                      int index, int input){
        boolean flag = false;
        for(int i = 0; i<otherPlayer.getPlayerHand().getSize(); i++)
        {
            ArrayList<Card> otherPlayerArrayList = otherPlayer.getPlayerHand().hand;

            CardDefaultEnum enumi = otherPlayerArrayList.get(i).getDefaultEnum();
            int cardValueenumi = (int) enumi.getCardDefaultEnum();
            if (input == cardValueenumi) {
                console.println("Card input matches a card in other players hand ");

                //Removed value from other player
                otherPlayer.getPlayerHand().hand.remove(i);
                //Removed value from current player
                currentPlayer.getPlayerHand().hand.remove(index);

                currentPlayer.score++;
                console.println("After removing matching card in current and other player");
                printCardsToConsole(currentPlayer);
                console.println("The below list is for other player");
                printCardsToConsole(otherPlayer);
                flag = true;
                playerTurn=1;
                break;
            }

        }
        if(flag==false){
            playerTurn=1;
            popCardFromDeck(currentPlayer, otherPlayer);
        }
}

public void popCardFromDeck(GoFishPlayer currentPlayer, GoFishPlayer otherPlayer){

    //If the values are not matching pop a card from the deck
    console.println("Card popped ");
    Card card = myDeck.regularDeck.pop();

    CardDefaultEnum defaultEnum = card.getDefaultEnum();
    int cardDeckEnum = (int)defaultEnum.getCardDefaultEnum();
    console.println("Popped card : "+ cardDeckEnum);

    //Check the popped card from the deck with current players hand
   // ArrayList<Card> currentArrayList2 = currentPlayer.getPlayerHand().hand;
    if(currentPlayer.getPlayerHand().hand.contains(card)){
        currentPlayer.getPlayerHand().hand.remove(card);
        currentPlayer.score++;
        printCardsToConsole(currentPlayer);
        printCardsToConsole(otherPlayer);
        playerTurn=1;
    }
    else
    {
        currentPlayer.getPlayerHand().addCard(card);
        printCardsToConsole(currentPlayer);
        printCardsToConsole(otherPlayer);
        playerTurn=2;
    }
}
    //Gets the index of the matched input
    public int getIndexOfMatchedCard(GoFishPlayer currentPlayer, int input){
        int index=0;
        ArrayList<Card> currentPlayerList = currentPlayer.getPlayerHand().hand;

        for(int i =0 ; i< currentPlayer.getPlayerHand().getSize();i++){
            CardDefaultEnum enum1 = currentPlayerList.get(i).getDefaultEnum();
            int cardValueenum = (int) enum1.getCardDefaultEnum();
            if(input==cardValueenum){
                index=i;
            }
        }
        return index;
    }
//populates players hand
    public void populateGoFishHand() {
        //pop 7 cards and add to player 1 hand
        for (int i = 0; i < 7; i++) {
            Card card = myDeck.regularDeck.pop();
            goFishHandPlayer1.addCard(card);
        }
        //pop 7 cards and add to player 2 hand
        for (int i = 0; i < 7; i++) {
            Card card = myDeck.regularDeck.pop();
            goFishHandPlayer2.addCard(card);
        }
    }

//populates players and list
    public void populatePlayersAndList(Hand player1, Hand player2) {
        //populate player1
        gfPlayer1.setName("GoFishPlayer1");
        gfPlayer1.setPlayerHand(player1);
        gfPlayer1.setScore(0);

        //populate player2
        gfPlayer2.setName("GoFishPlayer2");
        gfPlayer2.setPlayerHand(player2);
        gfPlayer2.setScore(0);
        //initialize and populate list
        goFishPlayerList = new ArrayList<GoFishPlayer>();
        goFishPlayerList.add(gfPlayer1);
        goFishPlayerList.add(gfPlayer2);
    }

    public void findDuplicateCardsForEachPlayer(GoFishPlayer player) {
        //Finds duplicate scores and increments the score if duplicates are found
        ArrayList<Card> cardArrayList = player.getPlayerHand().hand;

        for (int i = 0; i < cardArrayList.size(); i++) {
            for (int j = i + 1; j < cardArrayList.size(); j++) {
                CardDefaultEnum enumi = cardArrayList.get(i).getDefaultEnum();
                CardDefaultEnum enumj = cardArrayList.get(j).getDefaultEnum();

                if (enumi == enumj) {
                    player.getPlayerHand().hand.remove(j);
                    player.getPlayerHand().hand.remove(i);
                    player.score++;
                }
            }
        }
    }
    public void printCardsToConsole(GoFishPlayer player) {
        //Print the cards
        ArrayList<Card> cardArrayList = player.getPlayerHand().hand;
        console.println("Player name: "+player.getName());
        for (int i = 0; i < cardArrayList.size(); i++) {
            CardDefaultEnum enumi = cardArrayList.get(i).getDefaultEnum();
            int cardValueenumi = (int) enumi.getCardDefaultEnum();

            console.println("Player cards : " + cardValueenumi);
        }
        console.println("Score: "+ player.score);
        console.println("------------------");
    }

    public Integer getScore() {
        // Return the winning score
        Integer player1Score = gfPlayer1.score;
        Integer player2Score = gfPlayer2.score;

        if(player1Score>player2Score)
            return player1Score;
            else
            return player2Score;
    }

    public static void main(String[] args) {
        GoFish goFish = new GoFish();
        goFish.play();
       /* Console console1 = new Console(System.in, System.out);
        GoFish goFish = new GoFish();
        goFish.populateGoFishHand();
        goFish.populatePlayersAndList(goFish.goFishHandPlayer1,goFish.goFishHandPlayer2);
        goFish.findDuplicateCardsForEachPlayer(goFish.gfPlayer1);

        goFish.printCardsToConsole(goFish.gfPlayer1);

        console1.println("second player");
        goFish.findDuplicateCardsForEachPlayer(goFish.gfPlayer2);
        goFish.printCardsToConsole(goFish.gfPlayer2);*/
    }


}
