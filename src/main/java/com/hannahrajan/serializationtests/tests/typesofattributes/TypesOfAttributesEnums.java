package com.hannahrajan.serializationtests.tests.typesofattributes;

import com.hannahrajan.serializationtests.tests.SerializableClasses;

public enum TypesOfAttributesEnums {

    //enumerators
    ONE(1, new SerializableClassOne()), FIVE(5, new SerializableClassFive()),
    TEN(10, new SerializableClassTen()), TWENTY(20, new SerializableClassTwenty()),
    FIFTY(50, new SerializableClassFifty());

    //assigning their String values
    public final int id;
    public final SerializableClasses serializableClass;
    private TypesOfAttributesEnums(int id, SerializableClasses serializableClass) {
        this.id = id;
        this.serializableClass = serializableClass;
    }

}
