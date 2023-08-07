package com.hannahrajan.serializationtests.tests.exceptions;

import com.hannahrajan.serializationtests.classes.TestCheckedException;
import com.hannahrajan.serializationtests.classes.TestUncheckedException;
import com.hannahrajan.serializationtests.tests.SerializableClasses;

public class SerializableExceptionClassE extends SerializableClasses {

    private static final long serialVersionUID = 5110019476138355966L;

    public SerializableExceptionClassE() {
        super("EE");
    }


    //testing a method, catching a checked exception, and throwing an unchecked exception
    public void throwUncheckedException() throws TestUncheckedException {
        try{
            throw new TestCheckedException("Test Unchecked Exception error");
        }catch(TestCheckedException e){
            e.printStackTrace();
        }
        throw new TestUncheckedException("Test Checked Exception error", new RuntimeException());
    }

    //testing a static method, catching an unchecked exception, and throwing a checked exception
    public static void throwCheckedException() throws TestCheckedException {
        try{
            throw new TestUncheckedException("Test Unchecked Exception error", new RuntimeException());
        }catch(TestUncheckedException e){
            e.printStackTrace();
        }
        throw new TestCheckedException("Test Checked Exception error");
    }
}
