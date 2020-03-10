package com.thoughtworks.data;

import com.thoughtworks.OutputWrongException;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class AnswerReader {
    public static final Path ANSWER_PATH = Paths.get("answer.txt");

    public String readAnswerStr() {
        if (!isHaveFile()) {
            buildFile();
        }
        //读取
        StringBuilder sb = new StringBuilder("");
        try (FileReader fileReader = new FileReader(ANSWER_PATH.toString());
             BufferedReader bufferedReader = new BufferedReader(fileReader)
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //判断合理否
        try {
            isCorrectAnswer(sb.toString());
        } catch (Exception e) {
            File file = new File(ANSWER_PATH.toString());
            file.delete();
            return buildFile();
        }

        return sb.toString();
    }

    public boolean isHaveFile() {
        return new File(ANSWER_PATH.toString()).isFile();
    }

    public String buildFile() {
        String res = "";
        try {
            File newFile = new File(ANSWER_PATH.toString());
            newFile.createNewFile();
            try (FileWriter fileWrite = new FileWriter(newFile);
                BufferedWriter out = new BufferedWriter(fileWrite)
            ) {
                res = getAnswer();
                out.write(res);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return res;
    }

    public String getAnswer() {
        Set<Integer> set = new HashSet<>();
        while (set.size() < 4) {
            Random random = new Random();
            set.add(random.nextInt(10));
        }
        StringBuilder sb = new StringBuilder("");
        for (Integer i : set) {
            sb.append(i.toString());
        }
        return sb.toString();
    }

    public static boolean isCorrectAnswer(String str) {
        if (str.length() != 4) {
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            int number = Integer.parseInt(str.charAt(i) + "");
            set.add(number);
            if (number < 0 || number > 9) {
                return false;
            }
        }
        if (set.size() != 4) {
            return false;
        }
        return true;
    }
}
