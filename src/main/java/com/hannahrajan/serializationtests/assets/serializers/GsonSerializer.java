package com.hannahrajan.serializationtests.assets.serializers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class GsonSerializer<E> extends MainSerializer<E>{

    Gson gson;

    public GsonSerializer(){
        gson = new GsonBuilder().setPrettyPrinting().create();
        this.directory = "gson";
        this.fileType = ".json";
    }

    public double serializeOutput(E data, Class<E> c, String filepath){

        try(Writer writer = new FileWriter(filepath);){

            double start = System.nanoTime();

            gson.toJson(data, writer);

            //time for serialization (ms)
            double elapsedTime = (System.nanoTime() - start) / 1000000;

            calculateMemoryInBytes(filepath);
            return elapsedTime;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public double serializeInput(Class<E> c, String filepath) {

        try (Reader reader = new FileReader(filepath);){

            double start = System.nanoTime();

            //time for serialization (ms)
            deserializedObject = gson.fromJson(reader, c);

            double elapsedTime = (System.nanoTime() - start) / 1000000;
            calculateMemoryInBytes(deserializedObject);
            return elapsedTime;

        } catch (IOException e){
            e.printStackTrace();
        }

        return 0;
    }
}
