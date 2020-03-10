package com.thoughtworks.result;

public class MistakeGuessResult implements GuessResult {
    public MistakeGuessResult() {
    }

    @Override
    public String display() {
        return "Wrong input";
    }

    @Override
    public boolean isCorrect() {
        return false;
    }
}
