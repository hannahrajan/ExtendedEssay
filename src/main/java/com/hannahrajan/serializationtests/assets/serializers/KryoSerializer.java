package com.hannahrajan.serializationtests.assets.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.hannahrajan.serializationtests.assets.ObjectTypes;
import com.hannahrajan.serializationtests.assets.memorycalculators.JsonMemoryCalculator;
import org.objenesis.strategy.StdInstantiatorStrategy;

import java.io.*;

public class KryoSerializer<E> extends MainSerializer<E>{

    static Kryo kryo;

    public KryoSerializer(){
        kryo = new Kryo();
        this.directory = "kryo";
    }

    @Override
    public double serializeOutput(E data, Class<E> c, String filepath) {
        try(FileOutputStream fos = new FileOutputStream(filepath);
            Output output = new Output(fos);){

            register(c);

            double start = System.nanoTime();

            kryo.writeObject(output, data);

            //time for serialization (ms)
            double elapsedTime = (System.nanoTime() - start) / 1000000;
            calculateMemoryInBytes(filepath);
            return elapsedTime;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public double serializeInput(Class<E> c, String filepath) {
        try (FileInputStream fis = new FileInputStream(filepath);
             Input input = new Input(fis);){

            kryo.setInstantiatorStrategy(new StdInstantiatorStrategy());

            double start = System.nanoTime();

            //time for serialization (ms)
            this.deserializedObject = kryo.readObject(input, c);

            double elapsedTime = (System.nanoTime() - start) / 1000000;
            this.calculateMemoryInBytes(deserializedObject);
            return elapsedTime;

        } catch (IOException e){
            e.printStackTrace();
        }

        return 0;
    }


    public void register(Class<E> c){
        for (Object o : ObjectTypes.returnValues()){
            kryo.register(o.getClass());
        }
        kryo.register(c);
    }

    @Override
    public void calculateMemoryInBytes(String filepath) {
        memoryInBytes = JsonMemoryCalculator.calculateMemoryInBytes(filepath);
    }
}
