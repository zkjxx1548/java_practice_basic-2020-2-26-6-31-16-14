package com.thoughtworks.game;

import com.thoughtworks.data.Answer;
import com.thoughtworks.data.AnswerParse;
import com.thoughtworks.data.AnswerReader;
import com.thoughtworks.result.GuessResult;
import com.thoughtworks.result.MistakeGuessResult;
import com.thoughtworks.result.NormalGuessResult;

public class Game {
    private static final int CHANCE_LIMIT = 6;

    private final Answer answer = new Answer(new AnswerReader().readAnswerStr());

    public GuessResult guess(Answer guess) {
        if (AnswerReader.isCorrectAnswer(guess.getNumber())) {
            return AnswerParse.parse(guess, answer);
        } else {
            return new MistakeGuessResult();
        }
    }


}
