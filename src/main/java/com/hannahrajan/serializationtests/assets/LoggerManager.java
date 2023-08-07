package com.hannahrajan.serializationtests.assets;

import com.hannahrajan.serializationtests.assets.serializers.MainSerializer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class LoggerManager<E> {

    private static HashMap<String, HashMap<String, Logger>> loggers = new HashMap<>();

    private static String testName = null;

    public static void newLog(String serializerName){
        serializerName = serializerName.toLowerCase();
        if (!loggers.keySet().contains(serializerName)){
            loggers.put(serializerName, new HashMap<>());
            loggers.get(serializerName).put("serialized", new Logger());
            loggers.get(serializerName).put("deserialized", new Logger());
        }
    }

    public static void newLog(MainSerializer s){
        newLog(s.getClass().getSimpleName());
    }

    public static <E> void logData(boolean isSerializing, String serializerName, E data, int testNum, String... attributes){
        serializerName = serializerName.toLowerCase().replaceAll("serializer", "");
        newLog(serializerName);
        loggers.get(serializerName).get((isSerializing) ? "serialized" : "deserialized").logData(data, testNum, attributes);
    }

    public static <E> void logData(boolean isSerializing, MainSerializer s, E data, int testNum, String... attributes){
        String serializerName = s.getClass().getSimpleName();
        logData(isSerializing, serializerName, data, testNum, attributes);
    }

    public static void makeCSV(){
        for (Map.Entry<String,HashMap<String, Logger>> entry : loggers.entrySet()){
            for (Map.Entry<String, Logger> l : entry.getValue().entrySet()){
                l.getValue().write(FilePaths.LOG_PATH.value + "/" + entry.getKey() + "/" + l.getKey());
            }
        }
    }

    public static void makeTotalCSV(int tag){
        for (Map.Entry<String,HashMap<String, Logger>> entry : loggers.entrySet()){
            for (Map.Entry<String, Logger> l : entry.getValue().entrySet()){
                l.getValue().writeTime(FilePaths.LOG_PATH.value + "/" + entry.getKey() + "/" + l.getKey() + tag);
            }
        }
    }

    public static String getTestName() {
        return LoggerManager.testName;
    }
    public static void setTestName(String testName) {
        LoggerManager.testName = testName;
    }

}
