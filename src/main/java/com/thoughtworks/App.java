package com.thoughtworks;

import com.thoughtworks.data.ReadAnswer;
import com.thoughtworks.output.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

  public static void main(String[] args) throws FileNotFoundException {
    ReadAnswer ra = new ReadAnswer();
    String answer = ra.readAnswerStr();
    ArrayList<OutputCheck> lists = new ArrayList<>();
    boolean flag = false;
    for (int i = 0; i < 6; i++) {
      Scanner scanner = new Scanner(System.in);
      System.out.println(String.format("请输入第%d次猜测：", (i + 1)));
      String input = scanner.nextLine();
      OutputCheck oc = null;
      try {
        ra.isCorrectAnswer(input);
        oc = addToLists(input, answer, lists);
      } catch (OutputWrongException e) {
        lists.add(new OutputG(input, e.getMessage()));
        /*System.out.println("猜测结果为：");
        printList(lists);*/
        i--;
      } finally {
        System.out.println("猜测结果为：");
        printList(lists);
        if (oc != null && oc.getInstruction().equals("win, all correct")) {
          System.out.println("Congratulations, you win!");
          flag = true;
          break;
        }
      }
    }
    if (!flag) {
      System.out.println(String.format("Unfortunately, you have no chance, the answer is %s!", answer));
    }
  }

  //根据猜测获取输出
  public static String getOutput(String str, String answer) {
    int numberA = 0;
    int numberB = 0;

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

  //遍历lists
  public static void printList(ArrayList<OutputCheck> lists) {
    for (OutputCheck oc : lists) {
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
  public static OutputCheck addToLists(String input, String answer, ArrayList<OutputCheck> lists) {
    String output = getOutput(input, answer);
    OutputCheck oc = getOutputObj(input, output);
    lists.add(oc);
    return oc;
  }
}
