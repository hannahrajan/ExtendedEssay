package com.hannahrajan.serializationtests.assets;

import com.opencsv.CSVWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Logger<E> {

    ArrayList<ArrayList<String>> lines = new ArrayList<>();
    HashMap<String, Integer> classesChecked = new HashMap<>();
    double totalTime = 0;
    double totalMemory = 0;

    public <E> void logData(E data, int testNum, String... attributes){
        String dataClassName = data.getClass().getSimpleName();
        if (classesChecked.keySet().contains(dataClassName)){
            int index = classesChecked.get(dataClassName);
            lines.get(index).add(attributes[0]);
            for (int i = 1; i < attributes.length; i++){
                lines.get(index + i).add(attributes[(i)]);
            }
        }else{

            lines.add(new ArrayList<>());
            lines.get(lines.size() - 1).add(dataClassName);

            lines.add(new ArrayList<>());
            lines.get(lines.size() - 1).add("");
            lines.get(lines.size() - 1).add(attributes[0]);

            classesChecked.put(dataClassName, lines.size() - 1);
            String[] values = {"TIME (MS)", "BYTE ARRAY MEMORY (BYTES)"};
            for (int i = 1; i < attributes.length; i++){
                lines.add(new ArrayList<>());
                lines.get(lines.size() - 1).add(values[i-1]);
                lines.get(lines.size() - 1).add(attributes[i]);
            }

        }

        totalTime += Double.valueOf(attributes[1]);
        totalMemory += Double.valueOf(attributes[2]);

    }

    public void write(String path) {
        writeLineByLine(this.lines, path + "_" + LoggerManager.getTestName() + "_log.csv");
    }

    public void writeTime(String path) {
        ArrayList<ArrayList<String>> timeLines = new ArrayList<>();
        timeLines.add(new ArrayList<>());
        timeLines.get(0).add("TOTAL TIME (MS): ");
        timeLines.get(0).add(String.valueOf(totalTime));
        timeLines.get(0).add("TOTAL MEMORY (MS): ");
        timeLines.get(0).add(String.valueOf(totalMemory));
        writeLineByLine(timeLines, path + "_" + LoggerManager.getTestName() + "_log.csv");
    }

    public static void writeLineByLine(ArrayList<ArrayList<String>> lines, String path) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(path))) {
            for (ArrayList<String> line : lines) {
                String l[] = line.toArray(new String[line.size()]);
                writer.writeNext(l);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
