package com.hannahrajan.serializationtests.tests.nonserializable;

import com.hannahrajan.serializationtests.assets.LoggerManager;
import com.hannahrajan.serializationtests.assets.serializers.*;
import com.hannahrajan.serializationtests.tests.SerializableClasses;

import java.util.ArrayList;

public class NonSerializableTest {

    public static void main(String[] args){

        LoggerManager.setTestName("nonserializable");

        ArrayList<SerializableClasses> tests = new ArrayList<>();

        tests.add(new NonSerializableClassA(10));
        tests.add(new NonSerializableClassB(10));
        tests.add(new NonSerializableClassC(10));
        tests.add(new NonSerializableClassD(10));
        tests.add(new NonSerializableClassE(10));

        DefaultSerializer[] defaultSerializers = {
                new DefaultSerializer<NonSerializableClassA>(),
                new DefaultSerializer<NonSerializableClassB>(),
                new DefaultSerializer<NonSerializableClassC>(),
                new DefaultSerializer<NonSerializableClassD>(),
                new DefaultSerializer<NonSerializableClassE>()
        };

        GsonSerializer[] gsonSerializers = {
                new GsonSerializer<NonSerializableClassA>(),
                new GsonSerializer<NonSerializableClassB>(),
                new GsonSerializer<NonSerializableClassC>(),
                new GsonSerializer<NonSerializableClassD>(),
                new GsonSerializer<NonSerializableClassE>()
        };

        JacksonSerializer[] jacksonSerializers = {
                new JacksonSerializer<NonSerializableClassA>(),
                new JacksonSerializer<NonSerializableClassB>(),
                new JacksonSerializer<NonSerializableClassC>(),
                new JacksonSerializer<NonSerializableClassD>(),
                new JacksonSerializer<NonSerializableClassE>()
        };

        KryoSerializer[] kryoSerializers = {
                new KryoSerializer<NonSerializableClassA>(),
                new KryoSerializer<NonSerializableClassB>(),
                new KryoSerializer<NonSerializableClassC>(),
                new KryoSerializer<NonSerializableClassD>(),
                new KryoSerializer<NonSerializableClassE>()
        };

        XStreamSerializer[] xStreamSerializers = {
                new XStreamSerializer<NonSerializableClassA>(),
                new XStreamSerializer<NonSerializableClassB>(),
                new XStreamSerializer<NonSerializableClassC>(),
                new XStreamSerializer<NonSerializableClassD>(),
                new XStreamSerializer<NonSerializableClassE>()
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
