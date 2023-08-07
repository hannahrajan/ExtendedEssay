package com.hannahrajan.serializationtests.tests.generaltest;

import com.hannahrajan.serializationtests.classes.TestEnum;
import com.hannahrajan.serializationtests.tests.SerializableClasses;

import java.util.HashMap;

public class SerializableClassB extends SerializableClasses {

    private static final long serialVersionUID = 1858986424131374351L;

    private HashMap<Object, Object> map = new HashMap<>();
    private char[] charArray = null;

    public SerializableClassB() {
        super("B");
    }

    public SerializableClassB(String id) {
        super(id);
    }

    public SerializableClassB(TestEnum te) {
        this(te, "B");
    }

    //testing HashMap<Object, Object> with Character, Character elements, testing char array
    public SerializableClassB(TestEnum te, String id) {
        this(id);
        charArray = new char[te.id];
        for (int i = 0; i < te.id; i++){
            char value = (char)(65 + i);
            map.put(value, value);
            charArray[i] = value;
        }
    }

    public SerializableClassB(int x) {
        this(x, "B");
    }

    //testing HashMap<Object, Object> with Double, Double elements, testing char array
    public SerializableClassB(int x, String id) {
        this(id);
        charArray = new char[x];
        for (int i = 0; i < x; i++){
            map.put((double)i, (double)i);
            charArray[i] = (char)(65 + i);
        }
    }

    public SerializableClassB(double y) {
        this(y, "B");
    }

    //testing HashMap<Object, Object> with Double, Character and Character, Double elements, testing char array
    public SerializableClassB(double y, String id) {
        this(id);
        charArray = new char[(int)y];
        for (int i = 0; i < y; i++){
            char value = (char)(65 + i);
            if (i % 2 == 0){ //alternating between Double, Character and Character, Double
                map.put(value, (double)i);
            }else {
                map.put((double)i, value);
            }
            charArray[i] = value;
        }
    }

    @Override
    public String toString() {
        return "SerializableClassB{" +
                "map=" + map + ", charArray=" + charArray +
                '}';
    }
}