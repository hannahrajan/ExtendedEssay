package com.hannahrajan.serializationtests.classes;

import java.io.Serializable;

//A simple checked exception class.
public class TestCheckedException extends Exception implements Serializable {
    public TestCheckedException(String errorMessage){
        super(errorMessage);
    }
}



