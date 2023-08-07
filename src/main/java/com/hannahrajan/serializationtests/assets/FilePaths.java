package com.hannahrajan.serializationtests.assets;

public enum FilePaths {

    //enumerators
    OUTPUT_PATH("src/main/java/com/hannahrajan/serializationtests/output"),
    LOG_PATH("src/main/java/com/hannahrajan/serializationtests/logs"),
    CLASSES_PATH("src/main/java/com/hannahrajan/serializationtests/classes"),
    TESTS_PATH("src/main/java/com/hannahrajan/serializationtests/tests");

    //assigning their String values
    public final String value;
    private FilePaths(String value) {
        this.value = value;
    }

}
