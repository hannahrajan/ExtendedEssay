package com.hannahrajan.serializationtests.tests.nonserializable;

import com.hannahrajan.serializationtests.classes.TestEnum;
import com.hannahrajan.serializationtests.tests.generaltest.SerializableClassD;

import java.util.ArrayList;
import java.util.HashMap;

public class NonSerializableClassD extends SerializableClassD {

    private static final long serialVersionUID = 7891471058652772247L;

    //testing transient values
    private transient static ArrayList<Double> array = new ArrayList<>();

    //testing transient and static values
    private static HashMap<Double, Double> map = new HashMap<>();

    //testing static values
    private transient double[] doubleArray = null;

    public NonSerializableClassD() {
        super("ND");
    }

    public NonSerializableClassD(TestEnum te) {
        super(te, "ND");
    }

    public NonSerializableClassD(int x) {
        super(x, "ND");
    }

    public NonSerializableClassD(double y) {
        super(y, "ND");
    }
    
    //testing a method with a transient, static value
    public boolean arrayNull(){
        return (array == null);
    }

    //testing a method with a transient value
    public boolean doubleArrayNull(){
        return (doubleArray == null);
    }

    //testing a static method with a static value
    public static boolean mapNull(){
        return (map == null);
    }
}
