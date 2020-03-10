package com.thoughtworks.data;

import com.thoughtworks.result.GuessResult;
import com.thoughtworks.result.NormalGuessResult;

public class AnswerParse {
    public static GuessResult parse(Answer guess, Answer answer) {
        int correctCount = 0;
        int onlyNumberCorrectCount = 0;

        for (int i = 0; i < answer.getNumber().length(); i++) {
            String guessStr = guess.getNumber();
            String answerStr = answer.getNumber();
            int input = Integer.parseInt(guessStr.charAt(i) +"");
            if (input == Integer.parseInt(answerStr.charAt(i) + "")) {
                correctCount++;
                continue;
            }
            int j = 0;
            while (j < 4) {
                if (input == Integer.parseInt(answerStr.charAt(j) + "")) {
                    onlyNumberCorrectCount++;
                    break;
                }
                j++;
            }
        }
        return new NormalGuessResult(correctCount, onlyNumberCorrectCount);
    }
}
