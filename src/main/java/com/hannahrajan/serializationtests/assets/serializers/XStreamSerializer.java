package com.hannahrajan.serializationtests.assets.serializers;

import com.hannahrajan.serializationtests.assets.memorycalculators.JsonMemoryCalculator;
import com.thoughtworks.xstream.XStream;

import java.io.*;

public class XStreamSerializer<E> extends MainSerializer<E>{

    static XStream xStream = new XStream();
    String serializedObject;

    public XStreamSerializer(){
        xStream.allowTypesByWildcard(new String[] {
                "com.hannahrajan.serializationtests.tests.**"
        });

        this.directory = "xstream";
        this.fileType = ".xml";
    }

    @Override
    public double serializeOutput(E data, Class<E> c, String filepath) {

        try(FileOutputStream fos = new FileOutputStream(filepath);){

            double start = System.nanoTime();

            serializedObject = xStream.toXML(data);

            //time for serialization (ms)
            double elapsedTime = (System.nanoTime() - start) / 1000000;

            fos.write("<?xml version=\"1.0\"?>".getBytes("UTF-8")); //write XML header, as XStream doesn't do that for us
            byte[] bytes = serializedObject.getBytes("UTF-8");
            fos.write(bytes);

            this.calculateMemoryInBytes(filepath);
            return elapsedTime;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public double serializeInput(Class<E> c, String filepath) {

        double start = System.nanoTime();

        //time for serialization (ms)
        this.deserializedObject = (E)xStream.fromXML(serializedObject);
        double elapsedTime = (System.nanoTime() - start) / 1000000;
        calculateMemoryInBytes(deserializedObject);
        return elapsedTime;

    }
}
