package com.hannahrajan.serializationtests.tests.generaltest;

import java.util.ArrayList;
import com.hannahrajan.serializationtests.classes.TestEnum;
import com.hannahrajan.serializationtests.tests.SerializableClasses;

public class SerializableClassA extends SerializableClasses {

    private static final long serialVersionUID = 3716786049981168927L;

    private ArrayList<Object> array = new ArrayList<>();

    private boolean[] boolArray = null;

    public SerializableClassA() {
        this("A");
    }

    public SerializableClassA(String id) {
        super(id);
    }

    //testing enumerators and ArrayList<Object> with Character elements, testing boolean array
    public SerializableClassA(TestEnum te) {
        this(te, "A");
    }

    public SerializableClassA(TestEnum te, String id) {
        this(id);
        boolArray = new boolean[te.id];
        for (int i = 0; i < te.id; i++){
            char value = (char)(65 + i);
            array.add(value);
            boolArray[i] = (int)((Math.random() * 2) + 1) % 2 == 0; //random boolean values
        }
    }

    //testing ArrayList<Object> with Double elements, testing boolean array
    public SerializableClassA(int x) {
        this(x, "A");
    }

    public SerializableClassA(int x, String id) {
        this(id);
        boolArray = new boolean[x];
        for (int i = 0; i < x; i++){
            array.add((double)i);
            boolArray[i] = (int)((Math.random() * 2) + 1) % 2 == 0; //random boolean values
        }
    }

    //testing ArrayList<Object> with Character and Double elements, testing boolean array
    public SerializableClassA(double y) {
        this(y, "A");
    }

    //testing ArrayList<Object> with Character and Double elements, testing boolean array
    public SerializableClassA(double y, String id) {
        this(id);
        boolArray = new boolean[(int)y];
        for (int i = 0; i < y; i++){
            if (i % 2 == 0){ //alternating between Character and Double
                array.add((double)i);
            }else {
                array.add((char)(65 + i));
            }
            boolArray[i] = (int)((Math.random() * 2) + 1) % 2 == 0; //random boolean values
        }
    }

    public ArrayList<Object> getArray() {
        return array;
    }

    public boolean[] getBoolArray() {
        return boolArray;
    }

    public void setArray(ArrayList<Object> array) {
        this.array = array;
    }

    public void setBoolArray(boolean[] boolArray) {
        this.boolArray = boolArray;
    }

    @Override
    public String toString() {
        return "SerializableClassA{" +
                "array=" + array + ", boolArray=" + boolArray +
                "}";
    }
}