package io.zipcoder.casino.utilities.CasinoGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dice {
    public java.util.Random random;
    private Random diceVal;
    private List<Integer> diceValueList = new ArrayList<>();

    public Dice(Integer numberOfDice, Integer diceSize) {
        this.diceVal = new Random();
        for(int i = 0; i < numberOfDice; i++){
            diceValueList.add(diceSize);
        }
    }

    public Dice(Integer numberOfDice, Integer diceSize, Long seed) {
        this(numberOfDice,diceSize);
        this.diceVal = new Random(seed);

    }



    public Dice() {
        this(2,6);
    }

    public Integer getValue(Integer diceNumber) {

        return diceValueList.get(diceNumber);
    }

    public void setValue(Integer diceNumber, Integer value){
        diceValueList.set(diceNumber,value);
    }

    public void rollDice() {
        for (int i = 0; i < diceValueList.size(); i++){
            diceValueList.set(i,diceVal.nextInt(5)+1);
        }
    }

    public Integer getSum() {
        Integer diceSum = 0;
        for(Integer thisValue : diceValueList){
            diceSum += thisValue;
        }
        return diceSum;
    }
}


