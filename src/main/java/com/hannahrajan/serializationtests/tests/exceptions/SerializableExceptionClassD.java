package com.hannahrajan.serializationtests.tests.exceptions;

import com.hannahrajan.serializationtests.classes.TestCheckedException;
import com.hannahrajan.serializationtests.classes.TestUncheckedException;
import com.hannahrajan.serializationtests.tests.SerializableClasses;

public class SerializableExceptionClassD extends SerializableClasses {

    private static final long serialVersionUID = 7177836400328296623L;

    public SerializableExceptionClassD() {
        super("ED");
    }

    //testing a static method and throwing an unchecked exception with try-catch
    public static void throwUncheckedException()
    {
        try{
            throw new TestUncheckedException("Test Unchecked Exception error", new RuntimeException());
        }catch(TestUncheckedException e){
            e.printStackTrace();
        }
    }

    //testing a method and throwing a checked exception with try-catch
    public void throwCheckedException() {
        try{
            throw new TestCheckedException("Test Checked Exception error");
        }catch(TestCheckedException e) {
            e.printStackTrace();
        }
    }
}
