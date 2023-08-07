package com.hannahrajan.serializationtests.tests.nonserializable;

import com.hannahrajan.serializationtests.classes.TestEnum;
import com.hannahrajan.serializationtests.tests.generaltest.SerializableClassE;

import java.util.ArrayList;
import java.util.HashMap;

public class NonSerializableClassE extends SerializableClassE {

    private static final long serialVersionUID = 1807182730730132283L;

    //testing transient values
    private transient static ArrayList<Double> array = new ArrayList<>();

    //testing transient and static values
    private static HashMap<Double, Double> map = new HashMap<>();

    //testing static values
    private transient double[] doubleArray = null;

    public NonSerializableClassE() {
        super("NE");
    }

    public NonSerializableClassE(TestEnum te) {
        super(te, "NE");
    }

    public NonSerializableClassE(int x) {
        super(x, "NE");
    }

    public NonSerializableClassE(double y) {
        super(y, "NE");
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
