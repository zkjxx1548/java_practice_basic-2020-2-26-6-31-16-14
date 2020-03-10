package com.thoughtworks;

import com.thoughtworks.data.Answer;
import com.thoughtworks.data.AnswerParse;
import com.thoughtworks.data.AnswerReader;
import com.thoughtworks.game.Game;
import com.thoughtworks.game.GameRecord;
import com.thoughtworks.result.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    Game game = new Game();
    Scanner scanner = new Scanner(System.in);
    do {
      Answer guess = new Answer(scanner.nextLine());
      GuessResult guessResult = game.guess(guess);
      for (GameRecord gr : game.records) {
        System.out.println(gr);
      }
      if (guessResult.isCorrect()) {
        System.out.println("Congratulations, you win!");
      }
      if (!guessResult.isCorrect() && game.isEnd()) {
        System.out.println(String.format("Unfortunately, you have no chance, the answer is %s!", game.answer));
      }
    } while (!game.isEnd());
  }









}
