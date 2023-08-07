package com.hannahrajan.serializationtests.tests.typesofattributes;

import com.hannahrajan.serializationtests.assets.LoggerManager;
import com.hannahrajan.serializationtests.assets.serializers.*;
import com.hannahrajan.serializationtests.tests.SerializableClasses;

import java.util.Arrays;
import java.util.List;

public class TypesOfAttributesTest {

    public static void main(String[] args){

        LoggerManager.setTestName("types");

        SerializableClasses testUsed = null;
        List<TypesOfAttributesEnums> enums = Arrays.asList(TypesOfAttributesEnums.values());
        Class<SerializableClasses> c = null;

        int testID = 50;

        int index = 0;

        for (TypesOfAttributesEnums e : enums){
            if (e.id == testID){
                testUsed = e.serializableClass;
                break;
            }else{
                index++;
            }
        }

        DefaultSerializer[] defaultSerializers = {
                new DefaultSerializer<SerializableClassOne>(),
                new DefaultSerializer<SerializableClassFive>(),
                new DefaultSerializer<SerializableClassTen>(),
                new DefaultSerializer<SerializableClassTwenty>(),
                new DefaultSerializer<SerializableClassFifty>()
        };

        GsonSerializer[] gsonSerializers = {
                new GsonSerializer<SerializableClassOne>(),
                new GsonSerializer<SerializableClassFive>(),
                new GsonSerializer<SerializableClassTen>(),
                new GsonSerializer<SerializableClassTwenty>(),
                new GsonSerializer<SerializableClassFifty>()
        };

        JacksonSerializer[] jacksonSerializers = {
                new JacksonSerializer<SerializableClassOne>(),
                new JacksonSerializer<SerializableClassFive>(),
                new JacksonSerializer<SerializableClassTen>(),
                new JacksonSerializer<SerializableClassTwenty>(),
                new JacksonSerializer<SerializableClassFifty>()
        };

        KryoSerializer[] kryoSerializers = {
                new KryoSerializer<SerializableClassOne>(),
                new KryoSerializer<SerializableClassFive>(),
                new KryoSerializer<SerializableClassTen>(),
                new KryoSerializer<SerializableClassTwenty>(),
                new KryoSerializer<SerializableClassFifty>()
        };

        XStreamSerializer[] xStreamSerializers = {
                new XStreamSerializer<SerializableClassOne>(),
                new XStreamSerializer<SerializableClassFive>(),
                new XStreamSerializer<SerializableClassTen>(),
                new XStreamSerializer<SerializableClassTwenty>(),
                new XStreamSerializer<SerializableClassFifty>()
        };

        MainSerializer[][] serializers = {
            defaultSerializers, gsonSerializers, jacksonSerializers, kryoSerializers, xStreamSerializers
        };

        for (MainSerializer[] s : serializers){
            s[index].serializeOutput(testUsed, testUsed.getProgramID());
            s[index].serializeInput(testUsed.getProgramID());
        }

        LoggerManager.makeCSV();

    }

}
