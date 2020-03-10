package com.thoughtworks.result;

public class NormalGuessResult implements GuessResult {
    private static final String RESULT_TEMPLATE = "%sA%sB";

    private int correctCount;
    private int onlyNumberCorrectCount;

    public NormalGuessResult(int correctCount, int onlyNumberCorrectCount) {
        this.correctCount = correctCount;
        this.onlyNumberCorrectCount = onlyNumberCorrectCount;
    }

    @Override
    public String display() {
        return String.format(RESULT_TEMPLATE, correctCount, onlyNumberCorrectCount);
    }

    @Override
    public boolean isCorrect() {
        return true;
    }
}
