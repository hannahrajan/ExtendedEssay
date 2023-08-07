package com.hannahrajan.serializationtests.assets.serializers;

import com.hannahrajan.serializationtests.assets.FilePaths;
import com.hannahrajan.serializationtests.assets.LoggerManager;

import java.io.*;

public class SerializerIO<E>{

    public SerializerIO(){

    }

    public void serializeOutput(String id, MainSerializer<E> s, E data, Class<E> c){
        serializeOutput(id, s, data, c, "NORMALTEST");
    }

    public void serializeOutput(String id, MainSerializer<E> s, E data, Class<E> c, String testName){

        String filepath = FilePaths.OUTPUT_PATH.value + "/" + s.getDirectory().toLowerCase() + "/data_" + s.getDirectory().toLowerCase() + id + s.getFileCounterOutput()  + testName + s.getFileType();
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oosB = new ObjectOutputStream(bos);){

            double elapsedTime = s.serializeOutput(data, c, filepath);
            System.out.println(s.getDirectory().toUpperCase() + "_O: " + elapsedTime);

            //memory size calculated through the bytestream's length (bytes)
            oosB.writeObject(data);
            byte[] dataByteArray = bos.toByteArray();
            long memorySize = s.getMemoryInBytes();

            //save statistics for this test into a file for later (time, memory, etc.)
            LoggerManager.logData(true, s, data, s.getFileCounterOutput(),
                    id + String.valueOf(s.getFileCounterOutput()),
                    String.valueOf(elapsedTime),
                    String.valueOf(memorySize));

        } catch (IOException e){
            e.printStackTrace();
        } finally{
            s.setFileCounterOutput(s.getFileCounterOutput() + 1);
        }

    }

    public void serializeInput(String id, MainSerializer<E> s, Class<E> c){
        serializeInput(id, s, c, "NORMALTEST");
    }

    public void serializeInput(String id, MainSerializer<E> s, Class<E> c, String testName){
        String filepath = FilePaths.OUTPUT_PATH.value + "/" + s.getDirectory().toLowerCase() + "/data_" + s.getDirectory().toLowerCase() + id + s.getFileCounterInput() + testName + s.getFileType();
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oosB = new ObjectOutputStream(bos);
        ){

            //time for serialization (ms)
            double elapsedTime = s.serializeInput(c, filepath);
            E deserializedObject = s.getDeserializedObject();
            System.out.println(s.getDirectory().toUpperCase() + "_I: " + elapsedTime);

            //memory size calculated through the bytestream's length (bytes)
            long memorySize = s.getMemoryInBytes();

            //save statistics for this test into a file for later (time, memory, etc.)
            LoggerManager.logData(false, s, deserializedObject, s.getFileCounterInput(),
                    id + String.valueOf(s.getFileCounterOutput()),
                    String.valueOf(elapsedTime), String.valueOf(memorySize));

        } catch (IOException e){
            e.printStackTrace();
        } finally{
            s.setFileCounterInput(s.getFileCounterInput() + 1);;
        }
    }

}
