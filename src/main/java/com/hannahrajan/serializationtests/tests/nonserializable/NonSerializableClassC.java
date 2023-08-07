package com.hannahrajan.serializationtests.tests.nonserializable;

import com.hannahrajan.serializationtests.classes.TestEnum;
import com.hannahrajan.serializationtests.tests.generaltest.SerializableClassC;

import java.util.ArrayList;
import java.util.HashMap;

public class NonSerializableClassC extends SerializableClassC {

    private static final long serialVersionUID = 7799999644082894816L;

    //testing transient values
    private transient ArrayList<Character> array = new ArrayList<>();

    //testing transient and static values
    private transient static HashMap<Character, Character> map = new HashMap<>();

    //testing static values
    private static int[] intArray = null;

    public NonSerializableClassC() {
        super("NC");
    }

    public NonSerializableClassC(TestEnum te) {
        super(te, "NC");
    }

    public NonSerializableClassC(int x) {
        super(x, "NC");
    }

    public NonSerializableClassC(double y) {
        super(y, "NC");
    }

    //testing a method with a transient value
    public boolean arrayNull(){
        return (array == null);
    }

    //testing a static method
    public static boolean intArrayNull(){
        return (intArray == null);
    }

    //testing a static method with a transient, static value
    public static boolean mapNull(){
        return (map == null);
    }
}
