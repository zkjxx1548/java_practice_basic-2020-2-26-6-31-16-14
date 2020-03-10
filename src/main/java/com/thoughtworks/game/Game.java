package com.thoughtworks.game;

import com.thoughtworks.OutputWrongException;
import com.thoughtworks.data.Answer;
import com.thoughtworks.data.AnswerParse;
import com.thoughtworks.data.AnswerReader;
import com.thoughtworks.result.GuessResult;
import com.thoughtworks.result.MistakeGuessResult;
import com.thoughtworks.result.NormalGuessResult;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final int CHANCE_LIMIT = 6;

    private final AnswerReader answerReader = new AnswerReader();
    public final Answer answer = answerReader.readAnswer();

    private int remainChance = CHANCE_LIMIT;
    public List<GameRecord> records = new ArrayList<>();

    public Game() {
    }

    public GuessResult guess(Answer guess) {
        GuessResult result;
        try {
            AnswerReader.isCorrectAnswer(guess);
            remainChance--;
            result = AnswerParse.parse(guess, answer);
        } catch (OutputWrongException e){
            result =  new MistakeGuessResult();
        }

        records.add(new GameRecord(guess, result));
        return result;
    }

    public boolean isEnd() {
        GameRecord lastGameRecord = records.get(records.size() - 1);
        return remainChance <= 0 || lastGameRecord.getResult().isCorrect();
    }

}
