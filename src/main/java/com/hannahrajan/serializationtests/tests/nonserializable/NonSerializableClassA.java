package com.hannahrajan.serializationtests.tests.nonserializable;

import com.hannahrajan.serializationtests.classes.TestEnum;
import com.hannahrajan.serializationtests.tests.generaltest.SerializableClassA;

import java.util.ArrayList;

public class NonSerializableClassA extends SerializableClassA {

    private static final long serialVersionUID = 7074524987579295130L;

    //testing transient values
    private transient ArrayList<Object> array = new ArrayList<>();

    //testing transient and static values
    private transient static boolean[] boolArray = null;

    public NonSerializableClassA() {
        super("NA");
    }

    public NonSerializableClassA(TestEnum te) {
        super(te, "NA");
    }

    public NonSerializableClassA(int x) {
        super(x, "NA");
    }

    public NonSerializableClassA(double y) {
        super(y, "NA");
    }

    //testing a method with a transient value
    public static boolean boolArrayNull(){
        return (boolArray == null);
    }

    //testing a method
    public boolean arrayNull(){
        return (array == null);
    }
}
