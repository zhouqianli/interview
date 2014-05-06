package com.interview;

/**
 * @author zhouzh on 4/18/2014.
 */
public enum String2Enum {
    A("first"),
    B("second"),
    C("third");

    String2Enum(String internal) {
        value = internal;
    }

    private String value;

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
