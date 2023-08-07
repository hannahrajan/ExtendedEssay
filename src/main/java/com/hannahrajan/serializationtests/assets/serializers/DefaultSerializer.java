package com.hannahrajan.serializationtests.assets.serializers;

import java.io.*;

public class DefaultSerializer<E> extends MainSerializer<E> {

    byte[] serializedObject;

    public DefaultSerializer(){
        this.directory = "default";
    }

    public double serializeOutput(E data, Class<E> c, String filepath){

        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             FileOutputStream fos = new FileOutputStream(filepath);
             ObjectOutputStream oosB = new ObjectOutputStream(bos);
             ObjectOutputStream oosF = new ObjectOutputStream(fos);){

            double start = System.nanoTime();

            //time for serialization with byte stream (ms)
            oosB.writeObject(data);

            double elapsedTime = (System.nanoTime() - start) / 1000000;
            calculateMemoryInBytes(filepath);

            oosF.writeObject(data);

            return elapsedTime;

        } catch (IOException e){
            e.printStackTrace();
        }

        return 0.0;
    }

    public double serializeInput(Class<E> c, String filepath){
        try (FileInputStream fis = new FileInputStream(filepath);
             ObjectInputStream oisF = new ObjectInputStream(fis);
             ){

            double start = System.nanoTime();

            //time for serialization (ms)
            this.deserializedObject = (E) oisF.readObject();

            double elapsedTime = (System.nanoTime() - start) / 1000000;
            calculateMemoryInBytes(deserializedObject);
            return elapsedTime;

        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return 0;
    }

}
