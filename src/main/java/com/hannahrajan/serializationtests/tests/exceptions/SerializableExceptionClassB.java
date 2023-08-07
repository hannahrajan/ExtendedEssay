package com.hannahrajan.serializationtests.tests.exceptions;

import com.hannahrajan.serializationtests.classes.TestCheckedException;
import com.hannahrajan.serializationtests.classes.TestUncheckedException;
import com.hannahrajan.serializationtests.tests.SerializableClasses;

public class SerializableExceptionClassB extends SerializableClasses {

    private static final long serialVersionUID = 2986524727133491285L;

    public SerializableExceptionClassB() {
        super("EB");
    }

    //testing a method and throwing an unchecked exception with try-catch
    public void throwUncheckedException()
    {
        try{
            throw new TestUncheckedException("Test Unchecked Exception error", new RuntimeException());
        }catch(TestUncheckedException e){
            e.printStackTrace();
        }
    }

    //testing a static method and throwing a checked exception with try-catch
    public static void throwCheckedException() {
        try{
            throw new TestCheckedException("Test Checked Exception error");
        }catch(TestCheckedException e) {
            e.printStackTrace();
        }
    }
}
