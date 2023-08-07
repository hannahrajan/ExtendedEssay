package com.hannahrajan.serializationtests.tests.typesofattributes;

import com.hannahrajan.serializationtests.tests.SerializableClasses;
import com.hannahrajan.serializationtests.tests.typesofattributes.classes.*;

public class SerializableClassFive extends SerializableClasses {
    ONE one = new ONE();
    TWO two = new TWO();
    THREE three = new THREE();
    FOUR four = new FOUR();
    FIVE five = new FIVE();

    public SerializableClassFive(){
        this.programID = "FIVE";
    }
}
