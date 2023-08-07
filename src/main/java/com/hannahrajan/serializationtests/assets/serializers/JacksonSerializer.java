package com.hannahrajan.serializationtests.assets.serializers;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hannahrajan.serializationtests.assets.memorycalculators.JsonMemoryCalculator;

import java.io.*;

public class JacksonSerializer<E> extends MainSerializer<E>{

    ObjectMapper mapper;

    public JacksonSerializer(){
        mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        this.directory = "jackson";
        this.fileType = ".json";
    }

    @Override
    public double serializeOutput(E data, Class<E> c, String filepath) {
        try {

            File file = new File(filepath);
            file.createNewFile();

            double start = System.nanoTime();

            mapper.writeValue(file, data);

            double elapsedTime = (System.nanoTime() - start) / 1000000;
            this.calculateMemoryInBytes(filepath);
            return elapsedTime;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public double serializeInput(Class<E> c, String filepath) {
        try {

            File file = new File(filepath);

            double start = System.nanoTime();

            //time for serialization (ms)
            deserializedObject = mapper.readValue(file, c);

            double elapsedTime = (System.nanoTime() - start) / 1000000;
            calculateMemoryInBytes(deserializedObject);
            return elapsedTime;

        } catch (IOException e){
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public void calculateMemoryInBytes(String filepath) {
        memoryInBytes = JsonMemoryCalculator.calculateMemoryInBytes(filepath);
    }
}
