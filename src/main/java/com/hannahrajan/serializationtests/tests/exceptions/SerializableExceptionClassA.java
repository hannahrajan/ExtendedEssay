package com.hannahrajan.serializationtests.tests.exceptions;

import com.hannahrajan.serializationtests.classes.TestCheckedException;
import com.hannahrajan.serializationtests.classes.TestUncheckedException;
import com.hannahrajan.serializationtests.tests.SerializableClasses;

public class SerializableExceptionClassA extends SerializableClasses {

    private static final long serialVersionUID = 1073183416390844277L;

    public SerializableExceptionClassA() {
        super("EA");
    }

    //testing a static method and throwing an unchecked exception
    public static void throwUncheckedException() throws TestUncheckedException
    {
        throw new TestUncheckedException("Test Unchecked Exception error", new RuntimeException());
    }

    //testing a method and throwing a checked exception
    public void throwCheckedException() throws TestCheckedException {
        throw new TestCheckedException("Test Checked Exception error");
    }
}
