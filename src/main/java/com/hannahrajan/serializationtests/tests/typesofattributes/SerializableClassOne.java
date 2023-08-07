package com.hannahrajan.serializationtests.tests.typesofattributes;

import com.hannahrajan.serializationtests.tests.SerializableClasses;
import com.hannahrajan.serializationtests.tests.typesofattributes.classes.ONE;

public class SerializableClassOne extends SerializableClasses {
    private ONE one = new ONE();

    public SerializableClassOne(){
        this.programID = "ONE";
    }
}
