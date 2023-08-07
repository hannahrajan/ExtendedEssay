package com.hannahrajan.serializationtests.tests.exceptions;

import com.hannahrajan.serializationtests.assets.LoggerManager;
import com.hannahrajan.serializationtests.assets.serializers.*;
import com.hannahrajan.serializationtests.tests.SerializableClasses;

import java.util.ArrayList;

public class ExceptionsTest {

    public static void main(String[] args){

        LoggerManager.setTestName("exceptions");

        ArrayList<SerializableClasses> tests = new ArrayList<>();

        tests.add(new SerializableExceptionClassA());
        tests.add(new SerializableExceptionClassB());
        tests.add(new SerializableExceptionClassC());
        tests.add(new SerializableExceptionClassD());
        tests.add(new SerializableExceptionClassE());

        DefaultSerializer[] defaultSerializers = {
                new DefaultSerializer<SerializableExceptionClassA>(),
                new DefaultSerializer<SerializableExceptionClassB>(),
                new DefaultSerializer<SerializableExceptionClassC>(),
                new DefaultSerializer<SerializableExceptionClassD>(),
                new DefaultSerializer<SerializableExceptionClassE>()
        };

        GsonSerializer[] gsonSerializers = {
                new GsonSerializer<SerializableExceptionClassA>(),
                new GsonSerializer<SerializableExceptionClassB>(),
                new GsonSerializer<SerializableExceptionClassC>(),
                new GsonSerializer<SerializableExceptionClassD>(),
                new GsonSerializer<SerializableExceptionClassE>()
        };

        JacksonSerializer[] jacksonSerializers = {
                new JacksonSerializer<SerializableExceptionClassA>(),
                new JacksonSerializer<SerializableExceptionClassB>(),
                new JacksonSerializer<SerializableExceptionClassC>(),
                new JacksonSerializer<SerializableExceptionClassD>(),
                new JacksonSerializer<SerializableExceptionClassE>()
        };

        KryoSerializer[] kryoSerializers = {
                new KryoSerializer<SerializableExceptionClassA>(),
                new KryoSerializer<SerializableExceptionClassB>(),
                new KryoSerializer<SerializableExceptionClassC>(),
                new KryoSerializer<SerializableExceptionClassD>(),
                new KryoSerializer<SerializableExceptionClassE>()
        };

        XStreamSerializer[] xStreamSerializers = {
                new XStreamSerializer<SerializableExceptionClassA>(),
                new XStreamSerializer<SerializableExceptionClassB>(),
                new XStreamSerializer<SerializableExceptionClassC>(),
                new XStreamSerializer<SerializableExceptionClassD>(),
                new XStreamSerializer<SerializableExceptionClassE>()
        };

        MainSerializer[][] serializers = {
                defaultSerializers, gsonSerializers, jacksonSerializers, kryoSerializers, xStreamSerializers
        };

        for (int i = 0; i < tests.size(); i++){
            for (MainSerializer[] s : serializers){
                s[i % s.length].serializeOutput(tests.get(i), tests.get(i).getProgramID());
                s[i % s.length].serializeInput(tests.get(i).getProgramID());
            }
        }

        LoggerManager.makeCSV();

    }

}

