package com.thoughtworks;

import com.thoughtworks.data.AnswerReader;
import com.thoughtworks.game.Game;
import com.thoughtworks.result.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

  public static void main(String[] args) throws FileNotFoundException {
    Game game = new Game();


<<<<<<< HEAD
  }


=======
    for (int i = 0; i < answer.length(); i++) {
      int input = Integer.parseInt(String.valueOf(str.charAt(i)));
      if (input == Integer.parseInt(String.valueOf(answer.charAt(i)))) {
        numberA++;
        continue;
      }
      int j = 0;
      while (j < 4) {
        if (input == Integer.parseInt(answer.charAt(j) + "")) {
          numberB++;
          break;
        }
        j++;
      }
    }
    return String.format("%dA%dB", numberA, numberB);
  }

  //根据output返回OutputCheck类型的不同实例
  public static OutputCheck getOutputObj(String input, String output) {
    int numberA = Integer.parseInt(String.valueOf(output.charAt(0)));
    int numberB = Integer.parseInt(String.valueOf(output.charAt(2)));
    if (numberA == 0 && numberB == 0) {
      return new OutputA(input, output);
    } else if (numberA == 0 && numberB == 4) {
      return new OutputB(input, output);
    } else if (numberA == 4 && numberB == 0) {
      return new OutputC(input, output);
    } else if (numberA == 0 && (numberB > 0 && numberB < 4)) {
      return new OutputD(input, output);
    } else if (numberB == 0 && (numberA > 0 && numberA < 4)) {
      return new OutputE(input, output);
    }
    return new OutputF(input, output);
  }
>>>>>>> 03d2beee22547069f4cf0e2b07376abe44ff7119

  //遍历lists
  public static void printList(ArrayList<GuessResult> lists) {
    for (GuessResult oc : lists) {
      StringBuilder sb = new StringBuilder();
      if (!(oc instanceof OutputG)) {
        sb.append(oc.getInput()).append(" ").append(oc.getOutput()).append(" ").append(oc.getInstruction());
      } else {
        sb.append(oc.getInput()).append(" ").append(oc.getOutput());
      }
      System.out.println(sb);
    }
  }

  //添加至lists
  public static GuessResult addToLists(String input, String answer, ArrayList<GuessResult> lists) {
    String output = getOutput(input, answer);
    GuessResult oc = getOutputObj(input, output);
    lists.add(oc);
    return oc;
  }
}
