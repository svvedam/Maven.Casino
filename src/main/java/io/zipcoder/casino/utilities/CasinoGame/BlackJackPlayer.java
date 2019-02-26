
package io.zipcoder.casino.utilities.CasinoGame;
//import java.io.Console;
import java.io.InputStream;
import java.io.PrintStream;
public class BlackJackPlayer extends Player implements GamblingPlayer {

    Console console = new Console(System.in,System.out);
    String bjname;
    Integer bjbalance;



  public String name ;
  public Integer balance;
  public Integer remainingBalance;




   public BlackJackPlayer(String name, Integer balance){

        name = this.name;

        balance = this.balance;
    }
    public BlackJackPlayer(String name){

        name = this.name;


    }
    public BlackJackPlayer(Integer balance) {

        balance = this.balance;
    }






    public BlackJackPlayer(){


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getRemainingBalance() {
        return remainingBalance;
    }

    public void setRemainingBalance(Integer remainingBalance) {
        this.remainingBalance = remainingBalance;
    }

    public void placeBet(Integer betValue) {

        remainingBalance = balance- betValue;

    }

    

    public void receiveWinnings(Integer winnings) {

        Integer integerInput = console.getIntegerInput("");


    }



}





