package com.hannahrajan.serializationtests.assets;

import com.hannahrajan.serializationtests.tests.typesofattributes.classes.*;

import java.util.ArrayList;
import java.util.HashMap;

public class ObjectTypes {

    static ArrayList<Object> a = new ArrayList<>();
    static ArrayList<Character> b = new ArrayList<>();
    static ArrayList<Double> c = new ArrayList<>();
    static HashMap<Object, Object> d = new HashMap<>();
    static HashMap<Character, Character> e = new HashMap<>();
    static HashMap<Character, Double> f = new HashMap<>();
    static HashMap<Double, Double> g = new HashMap<>();
    static boolean[] h = new boolean[0];
    static char[] i = new char[0];
    static int[] j = new int[0];
    static double[] k = new double[0];
    static String[] l = new String[0];
    static ONE one = new ONE();
    static TWO two = new TWO();
    static THREE three = new THREE();
    static FOUR four = new FOUR();
    static FIVE five = new FIVE();
    static SIX six = new SIX();
    static SEVEN seven = new SEVEN();
    static EIGHT eight = new EIGHT();
    static NINE nine = new NINE();
    static TEN ten = new TEN();
    static ELEVEN eleven = new ELEVEN();
    static TWELVE twelve = new TWELVE();
    static THIRTEEN thirteen = new THIRTEEN();
    static FOURTEEN fourteen = new FOURTEEN();
    static FIFTEEN fifteen = new FIFTEEN();
    static SIXTEEN sixteen = new SIXTEEN();
    static SEVENTEEN seventeen = new SEVENTEEN();
    static EIGHTEEN eighteen = new EIGHTEEN();
    static NINETEEN nineteen = new NINETEEN();
    static TWENTY twenty = new TWENTY();
    static TWENTYONE twentyone = new TWENTYONE();
    static TWENTYTWO twentytwo = new TWENTYTWO();
    static TWENTYTHREE twentythree = new TWENTYTHREE();
    static TWENTYFOUR twentyfour = new TWENTYFOUR();
    static TWENTYFIVE twentyfive = new TWENTYFIVE();
    static TWENTYSIX twentysix = new TWENTYSIX();
    static TWENTYSEVEN twentyseven = new TWENTYSEVEN();
    static TWENTYEIGHT twentyeight = new TWENTYEIGHT();
    static TWENTYNINE twentynine = new TWENTYNINE();
    static THIRTY thirty = new THIRTY();
    static THIRTYONE thirtyone = new THIRTYONE();
    static THIRTYTWO thirtytwo = new THIRTYTWO();
    static THIRTYTHREE thirtythree = new THIRTYTHREE();
    static THIRTYFOUR thirtyfour = new THIRTYFOUR();
    static THIRTYFIVE thirtyfive = new THIRTYFIVE();
    static THIRTYSIX thirtysix = new THIRTYSIX();
    static THIRTYSEVEN thirtyseven = new THIRTYSEVEN();
    static THIRTYEIGHT thirtyeight = new THIRTYEIGHT();
    static THIRTYNINE thirtynine = new THIRTYNINE();
    static FORTY forty = new FORTY();
    static FORTYONE fortyone = new FORTYONE();
    static FORTYTWO fortytwo = new FORTYTWO();
    static FORTYTHREE fortythree = new FORTYTHREE();
    static FORTYFOUR fortyfour = new FORTYFOUR();
    static FORTYFIVE fortyfive = new FORTYFIVE();
    static FORTYSIX fortysix = new FORTYSIX();
    static FORTYSEVEN fortyseven = new FORTYSEVEN();
    static FORTYEIGHT fortyeight = new FORTYEIGHT();
    static FORTYNINE fortynine = new FORTYNINE();
    static FIFTY fifty = new FIFTY();

    public static Object[] returnValues(){
        if (LoggerManager.getTestName().equals("types")){
            return new Object[]{one, two, three, four, five, six, seven, eight, nine, ten,
                    eleven, twelve, thirteen, fourteen, fifteen, sixteen, seventeen, eighteen, nineteen, twenty,
                    twentyone, twentytwo, twentythree, twentyfour, twentyfive, twentysix, twentyseven, twentyeight, twentynine, thirty,
                    thirtyone, thirtytwo, thirtythree, thirtyfour, thirtyfive, thirtysix, thirtyseven, thirtyeight, thirtynine, forty,
                    fortyone, fortytwo, fortythree, fortyfour, fortyfive, fortysix, fortyseven, fortyeight, fortynine, fifty};
        }
        return new Object[]{a, b, c, d, e, f, g, h, i, j, k, l};
    }

}
