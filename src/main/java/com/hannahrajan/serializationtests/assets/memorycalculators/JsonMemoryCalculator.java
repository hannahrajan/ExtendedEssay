package com.hannahrajan.serializationtests.assets.memorycalculators;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class JsonMemoryCalculator {

    public static long calculateMemoryInBytes(String filepath){
        String s = "";

        try{

            File f = new File(filepath);
            Scanner scanner = new Scanner(f);

            while (scanner.hasNextLine()){
                s += scanner.nextLine();
            }

            scanner.close();

            return s.getBytes().length;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

}

