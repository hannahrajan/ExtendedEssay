package com.hannahrajan.serializationtests.tests.generaltest;

import com.hannahrajan.serializationtests.classes.TestEnum;
import com.hannahrajan.serializationtests.tests.SerializableClasses;

import java.util.HashMap;

public class SerializableClassE extends SerializableClasses {

    private static final long serialVersionUID = 26224331394950866L;

    HashMap<Character, Double> map = new HashMap<>();
    String[] stringArray = null;

    public SerializableClassE() {
        super("E");
    }

    //testing enumerators and HashMap<Character, Double>, testing String array
    public SerializableClassE(String id) {
        super(id);
    }

    //testing ArrayList<Double>, testing double array
    public SerializableClassE(int x, String id) {
        this(id);
        stringArray = new String[x];
        for (int i = 0; i < x; i++){
            char value = (char)(65 + i);
            map.put(value, (double)i);
            stringArray[i] = String.valueOf(value);
        }
    }

    public SerializableClassE(TestEnum te) { this(te.id, "E"); }

    public SerializableClassE(TestEnum te, String id) {
        this(te.id, id);
    }

    public SerializableClassE(double y) {
        this((int)y, "E");
    }

    public SerializableClassE(double y, String id) {
        this((int)y, id);
    }

    @Override
    public String toString() {
        return "SerializableClassE{" +
                "map=" + map + ", stringArray=" + stringArray +
                "}";
    }
}