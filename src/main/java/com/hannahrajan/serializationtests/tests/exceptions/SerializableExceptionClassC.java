package com.hannahrajan.serializationtests.tests.exceptions;

import com.hannahrajan.serializationtests.classes.TestCheckedException;
import com.hannahrajan.serializationtests.classes.TestUncheckedException;
import com.hannahrajan.serializationtests.tests.SerializableClasses;

public class SerializableExceptionClassC extends SerializableClasses {

    private static final long serialVersionUID = 6517828109598926121L;

    public SerializableExceptionClassC() {
        super("EC");
    }


    //testing a static method and throwing an unchecked exception
    public void throwUncheckedException() throws RuntimeException
    {
        throw new TestUncheckedException("Test Unchecked Exception error", new RuntimeException());
    }

    //testing a method and throwing a checked exception
    public static void throwCheckedException() throws Exception {
        throw new TestCheckedException("Test Checked Exception error");
    }
}
