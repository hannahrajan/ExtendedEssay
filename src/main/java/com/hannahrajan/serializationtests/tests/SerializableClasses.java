package com.hannahrajan.serializationtests.tests;

import java.io.Serializable;

public class SerializableClasses implements Serializable {

    protected String programID = "-";

    public SerializableClasses(){

    }

    public SerializableClasses(String programID){
        this.programID = programID;
    }

    public String getProgramID() {
        return programID;
    }

    public void setProgramID(String programID) {
        this.programID = programID;
    }
}
