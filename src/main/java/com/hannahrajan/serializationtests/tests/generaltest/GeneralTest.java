package com.hannahrajan.serializationtests.tests.generaltest;

import com.hannahrajan.serializationtests.assets.LoggerManager;
import com.hannahrajan.serializationtests.assets.serializers.*;
import com.hannahrajan.serializationtests.classes.TestEnum;
import com.hannahrajan.serializationtests.tests.SerializableClasses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GeneralTest {

    public static void main(String[] args){

        LoggerManager.setTestName("general");

        ArrayList<SerializableClasses> tests = new ArrayList<>();
        List<TestEnum> enums = Arrays.asList(TestEnum.values());

        for (TestEnum e : enums){
            tests.add(new SerializableClassA(e));
            tests.add(new SerializableClassB(e));
            tests.add(new SerializableClassC(e));
            tests.add(new SerializableClassD(e));
            tests.add(new SerializableClassE(e));
            tests.add(new SerializableClassA(e.id));
            tests.add(new SerializableClassB(e.id));
            tests.add(new SerializableClassC(e.id));
            tests.add(new SerializableClassD(e.id));
            tests.add(new SerializableClassE(e.id));
            tests.add(new SerializableClassA((double)e.id));
            tests.add(new SerializableClassB((double)e.id));
            tests.add(new SerializableClassC((double)e.id));
            tests.add(new SerializableClassD((double)e.id));
            tests.add(new SerializableClassE(e.id));
        }

        DefaultSerializer[] defaultSerializers = {
                new DefaultSerializer<SerializableClassA>(),
                new DefaultSerializer<SerializableClassB>(),
                new DefaultSerializer<SerializableClassC>(),
                new DefaultSerializer<SerializableClassD>(),
                new DefaultSerializer<SerializableClassE>()
        };

        GsonSerializer[] gsonSerializers = {
                new GsonSerializer<SerializableClassA>(),
                new GsonSerializer<SerializableClassB>(),
                new GsonSerializer<SerializableClassC>(),
                new GsonSerializer<SerializableClassD>(),
                new GsonSerializer<SerializableClassE>()
        };

        JacksonSerializer[] jacksonSerializers = {
                new JacksonSerializer<SerializableClassA>(),
                new JacksonSerializer<SerializableClassB>(),
                new JacksonSerializer<SerializableClassC>(),
                new JacksonSerializer<SerializableClassD>(),
                new JacksonSerializer<SerializableClassE>()
        };

        KryoSerializer[] kryoSerializers = {
                new KryoSerializer<SerializableClassA>(),
                new KryoSerializer<SerializableClassB>(),
                new KryoSerializer<SerializableClassC>(),
                new KryoSerializer<SerializableClassD>(),
                new KryoSerializer<SerializableClassE>()
        };

        XStreamSerializer[] xStreamSerializers = {
                new XStreamSerializer<SerializableClassA>(),
                new XStreamSerializer<SerializableClassB>(),
                new XStreamSerializer<SerializableClassC>(),
                new XStreamSerializer<SerializableClassD>(),
                new XStreamSerializer<SerializableClassE>()
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
        LoggerManager.makeTotalCSV(0);
    }

}
