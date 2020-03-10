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


  }



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
