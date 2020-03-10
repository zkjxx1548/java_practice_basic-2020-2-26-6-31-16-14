package com.thoughtworks.data;

import com.thoughtworks.OutputWrongException;
import com.thoughtworks.game.Game;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class AnswerReader {
    public static final Path ANSWER_PATH = Paths.get("answer.txt");
    private static final int ANSWER_NUMBER_LIMIT = 10;
    private static final String ANSWER_DELIMITER = "";

    public Answer readAnswer() {
        ClassLoader classLoader = getClass().getClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream(ANSWER_PATH.toString())) {
            Objects.requireNonNull(inputStream);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String number = bufferedReader.readLine();
            Answer answer = new Answer(number);
            isCorrectAnswer(answer);
            return answer;
        } catch (Exception e) {
            return randomGenerate();
        }
    }

    private Answer randomGenerate() {
        Random random = new Random();
        Set<String> digits = new HashSet<>();
        while (digits.size() < Answer.LENGTH) {
            int digit = random.nextInt(ANSWER_NUMBER_LIMIT);
            digits.add(String.valueOf(digit));
        }
        String number = String.join(ANSWER_DELIMITER, digits);

        return new Answer(number);
    }

    public static void isCorrectAnswer(Answer answer) {
        String number = answer.getNumber();
        boolean correct = number.length() == Answer.LENGTH;

        for (char num : number.toCharArray()) {
            if (!Character.isDigit(num)) {
                correct = false;
                break;
            }
        }

        HashSet<String> nums = new HashSet<>(Arrays.asList(number.split("")));
        if (nums.size() < number.length()) {
            correct = false;
        }

        if (!correct) {
            throw new OutputWrongException();
        }
    }
}
