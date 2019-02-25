package io.zipcoder.casino.utilities.CasinoGame;
import java.lang.*;

public class BlackJackPlayer implements GamblingPlayer {


  public String name ;
  public Integer balance;
  public Integer remainingBalance;

    Console console = new Console(System.in, System.out);


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

    public Integer recieveWinnings() {

        Integer integerInput = console.getIntegerInput("");

        return integerInput;
    }
}
