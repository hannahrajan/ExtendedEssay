package com.hannahrajan.serializationtests.tests.generaltest;

import com.hannahrajan.serializationtests.classes.TestEnum;
import com.hannahrajan.serializationtests.tests.SerializableClasses;

import java.util.ArrayList;
import java.util.HashMap;

public class SerializableClassD extends SerializableClasses {

    private static final long serialVersionUID = 7020559476485673421L;

    private ArrayList<Double> array = new ArrayList<>();
    private HashMap<Double, Double> map = new HashMap<>();
    private double[] doubleArray = null;

    public SerializableClassD() {
        super("D");
    }

    public SerializableClassD(String id) {
        super(id);
    }

    public SerializableClassD(TestEnum te) {
        this(te, "C");
    }

    //testing enumerators, ArrayList<Double>, and HashMap<Double, Double>, testing double array
    public SerializableClassD(TestEnum te, String id) {
        this(id);
        doubleArray = new double[te.id];
        for (int i = 0; i < te.id; i++){
            array.add((double)i);
            map.put((double)i, (double)i);
            doubleArray[i] = i;
        }
    }

    public SerializableClassD(int x) {
        this(x, "D");
    }

    //testing ArrayList<Double>, testing double array
    public SerializableClassD(int x, String id) {
        this(id);
        doubleArray = new double[x];
        for (int i = 0; i < x; i++){
            array.add((double)i);
            doubleArray[i] = i;
        }
    }

    public SerializableClassD(double y) {
        this(y, "D");
    }

    //testing HashMap<Double, Double>, testing double array
    public SerializableClassD(double y, String id) {
        this(id);
        doubleArray = new double[(int)y];
        for (int i = 0; i < y; i++){
            map.put((double)i, (double)i);
            doubleArray[i] = i;
        }
    }

    @Override
    public String toString() {
        return "SerializableClassD{" +
                "array=" + array + ", map=" + map + ", doubleArray=" + doubleArray +
                "}";
    }
}