package com.hannahrajan.serializationtests.tests.numofattributes;

import com.hannahrajan.serializationtests.assets.LoggerManager;
import com.hannahrajan.serializationtests.assets.serializers.*;
import com.hannahrajan.serializationtests.tests.SerializableClasses;
import com.hannahrajan.serializationtests.tests.generaltest.SerializableClassE;

import java.util.ArrayList;

public class NumOfAttributesTest {

    public static void main(String[] args){

        LoggerManager.setTestName("attributes");

        long testAmount = 10000;

        ArrayList<SerializableClasses> tests = new ArrayList<>();

        tests.add(new SerializableClassE(testAmount, "AE"));

        DefaultSerializer[] defaultSerializers = {
                new DefaultSerializer<SerializableClassE>()
        };

        GsonSerializer[] gsonSerializers = {
                new GsonSerializer<SerializableClassE>()
        };

        JacksonSerializer[] jacksonSerializers = {
                new JacksonSerializer<SerializableClassE>()
        };

        KryoSerializer[] kryoSerializers = {
                new KryoSerializer<SerializableClassE>()
        };

        XStreamSerializer[] xStreamSerializers = {
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

        LoggerManager.makeCSV();

    }

}
