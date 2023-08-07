package com.hannahrajan.serializationtests.assets.serializers;

import com.hannahrajan.serializationtests.assets.Logger;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class MainSerializer<E> {

    protected String directory = null;

    protected String fileType = "";

    protected long memoryInBytes = 0;
    protected E deserializedObject = null;

    protected int fileCounterOutput = 0;
    protected int fileCounterInput = 0;

    SerializerIO<E> serializer = new SerializerIO<>();

    public void serializeOutput(E data, String id) {
        serializeOutput(data, id, "NORMALTEST");
    }

    public void serializeInput(String id) {
        serializeInput(id, "NORMALTEST");
    }

    public void serializeOutput(E data, String id, String testName) {
        Class<E> c = (Class<E>) data.getClass();
        deserializedObject = data;
        serializer.serializeOutput(id,this, data, c, testName);
    }

    public void serializeInput(String id, String testName) {
        Class<E> c = (Class<E>) deserializedObject.getClass();
        serializer.serializeInput(id,this, c, testName);
    }

    public abstract double serializeOutput(E data, Class<E> c, String filepath);
    public abstract double serializeInput(Class<E> c, String filepath);

    public long getMemoryInBytes(){
        return memoryInBytes;
    }

    public void calculateMemoryInBytes(Object o){
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(bos);){

            //memory size calculated through the bytestream's length (bytes)
            oos.writeObject(deserializedObject);
            byte[] byteArrayForSize = bos.toByteArray();
            memoryInBytes = byteArrayForSize.length + 12;

        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public void calculateMemoryInBytes(String filepath){
        File file = new File(filepath);
        //memory size calculated through the bytestream's length (bytes)
        memoryInBytes = file.length();
        //System.out.println(memoryInBytes);

        try {

            Path path = Paths.get(filepath);
            memoryInBytes = Files.size(path);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    E getDeserializedObject() {
        return (E) deserializedObject;
    }
    public int getFileCounterOutput() {
        return fileCounterOutput;
    }

    public int getFileCounterInput() {
        return fileCounterInput;
    }

    public void setFileCounterOutput(int fileCounterOutput) {
        this.fileCounterOutput = fileCounterOutput;
    }

    public void setFileCounterInput(int fileCounterInput) {
        this.fileCounterInput = fileCounterInput;
    }

    public String getDirectory() {
        return directory;
    }

    public String getFileType() {
        return fileType;
    }

}
