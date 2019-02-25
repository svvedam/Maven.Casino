package io.zipcoder.casino.utilities.CasinoGame;

public enum CrapsRolls {

    TWO(2,false,false),
    THREE(3, false,false),
    FOUR(4, true,false),
    FIVE(5,true,false),
    SIX(6,true,false),
    SEVEN(7,false,true),
    EIGHT(8,true,false),
    NINE(9,true,false),
    TEN(10,true,false),
    ELEVEN(11,false,true),
    TWELVE(12,false,false);

    public Integer value;
    public boolean possiblePoint;
    public boolean pointOffPass;
    CrapsRolls(Integer value, boolean possiblePoint, boolean pointOffPass){
        this.value = value;
        this.possiblePoint = possiblePoint;
        this.pointOffPass = pointOffPass;
    }
}
