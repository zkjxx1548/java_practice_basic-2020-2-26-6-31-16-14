package com.thoughtworks.data;

public class Answer {
    private static final int LENGTH = 4;

    private String number;

    public Answer(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return number;
    }
}
