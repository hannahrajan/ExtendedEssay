package com.hannahrajan.serializationtests.tests.generaltest;

import com.hannahrajan.serializationtests.classes.TestEnum;
import com.hannahrajan.serializationtests.tests.SerializableClasses;

import java.util.ArrayList;
import java.util.HashMap;

public class SerializableClassC extends SerializableClasses {

    private static final long serialVersionUID = 465835412844238536L;

    private ArrayList<Character> array = new ArrayList<>();
    private HashMap<Character, Character> map = new HashMap<>();
    private int[] intArray = null;

    public SerializableClassC() {
        super("C");
    }

    public SerializableClassC(String id) {
        super(id);
    }

    public SerializableClassC(TestEnum te) {
        this(te, "C");
    }

    //testing enumerators, ArrayList<Character>, and HashMap<Character, Character>, testing int array
    public SerializableClassC(TestEnum te, String id) {
        this(id);
        intArray = new int[te.id];
        for (int i = 0; i < te.id; i++){
            char value = (char)(65 + i);
            array.add(value);
            map.put(value, value);
            intArray[i] = i;
        }
    }

    public SerializableClassC(int x) {
        this(x, "C");
    }

    //testing ArrayList<Character>, testing int array
    public SerializableClassC(int x, String id) {
        this(id);
        intArray = new int[x];
        for (int i = 0; i < x; i++){
            char value = (char)(65 + i);
            array.add(value);
            intArray[i] = i;
        }
    }

    public SerializableClassC(double y) {
        this(y, "C");
    }

    //testing HashMap<Character, Character>, testing int array
    public SerializableClassC(double y, String id) {
        this(id);
        intArray = new int[(int)y];
        for (int i = 0; i < y; i++){
            char value = (char)(65 + i);
            map.put(value, value);
            intArray[i] = i;
        }
    }

    @Override
    public String toString() {
        return "SerializableClassC{" +
                "array=" + array + ", map=" + map + ", intArray=" + intArray +
                "}";
    }
}