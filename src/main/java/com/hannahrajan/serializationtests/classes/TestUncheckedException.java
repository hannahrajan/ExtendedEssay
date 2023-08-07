package com.hannahrajan.serializationtests.classes;

import java.io.Serializable;

//A simple unchecked exception class.
public class TestUncheckedException extends RuntimeException implements Serializable {
    public TestUncheckedException(String errorMessage, Throwable err){
        super(errorMessage, err);
    }
}


