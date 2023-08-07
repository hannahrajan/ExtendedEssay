package com.hannahrajan.serializationtests.tests.nonserializable;

import com.hannahrajan.serializationtests.classes.TestEnum;
import com.hannahrajan.serializationtests.tests.generaltest.SerializableClassB;

import java.util.HashMap;

public class NonSerializableClassB extends SerializableClassB {

    private static final long serialVersionUID = 633267807369450655L;

    //testing transient and static values
    private transient static HashMap<Object, Object> map = new HashMap<>();

    //testing transient values
    private transient char[] charArray = null;

    public NonSerializableClassB() {
        super("NB");
    }

    public NonSerializableClassB(TestEnum te) {
        super(te, "NB");
    }

    public NonSerializableClassB(int x) {
        super(x, "NB");
    }

    public NonSerializableClassB(double y) {
        super(y, "NB");
    }

    //testing a method with a transient value
    public boolean charArrayNull(){
        return (this.charArray == null);
    }

    //testing a static method
    public static boolean mapNull(){
        return (map == null);
    }
}
