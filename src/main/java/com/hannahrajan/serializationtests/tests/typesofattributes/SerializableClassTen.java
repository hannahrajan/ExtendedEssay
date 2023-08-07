package com.hannahrajan.serializationtests.tests.typesofattributes;

import com.hannahrajan.serializationtests.tests.SerializableClasses;
import com.hannahrajan.serializationtests.tests.typesofattributes.classes.*;

public class SerializableClassTen extends SerializableClasses {
    ONE one = new ONE();
    TWO two = new TWO();
    THREE three = new THREE();
    FOUR four = new FOUR();
    FIVE five = new FIVE();
    SIX six = new SIX();
    SEVEN seven = new SEVEN();
    EIGHT eight = new EIGHT();
    NINE nine = new NINE();
    TEN ten = new TEN();

    public SerializableClassTen(){
        this.programID = "TEN";
    }
}
