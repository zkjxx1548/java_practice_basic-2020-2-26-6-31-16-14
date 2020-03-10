package com.thoughtworks.game;

import com.thoughtworks.data.Answer;
import com.thoughtworks.result.GuessResult;

public class GameRecord {
    private Answer guess;
    private GuessResult result;

    public GameRecord(Answer guess, GuessResult result) {
        this.guess = guess;
        this.result = result;
    }

    public GuessResult getResult() {
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s %s", guess, result.display());
    }
}
