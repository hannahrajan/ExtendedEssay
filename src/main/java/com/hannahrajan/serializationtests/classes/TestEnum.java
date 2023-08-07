package com.hannahrajan.serializationtests.classes;

//A simple enumeration class with eleven enumerators.
public enum TestEnum {

    //enumerators
    ZERO(0), ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), 
    SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10);

    //assigning their integer values
    public final int id;
    private TestEnum(int id) {
        this.id = id;
    }

}


