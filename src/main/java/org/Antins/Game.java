package org.Antins;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Game {
    //error count
    static int errorCount;
    // max count of error
    static final int errorMax = 6;
    //errorList for game session
    static List<Character> errorList;
    //conceived word for session
    static String conceivedWord;
    static String guessedPartWord = "";
    static Stages stagesScaffold;

    public static void start() throws IOException {
        errorCount = 0;
        errorList = new ArrayList<>();
        WordGenerator wordGenerator = new WordGenerator();
        conceivedWord = wordGenerator.word.toUpperCase(Locale.ROOT);
        Stages stagesScaffold;
        String[] scaffold = {"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX"};
        stagesScaffold = Stages.valueOf(scaffold[errorCount]);
        for (int i = 0; i < conceivedWord.length(); i++) {
            guessedPartWord += "_";
        }
        boolean check = true;

        while (check) {
            System.out.println(conceivedWord);
            System.out.println(stagesScaffold);
            System.out.println("состояние загаданного слова: " + guessedPartWord);
            System.out.println("счетчик ошибок: " + errorCount);
            System.out.println("Введите английскую букву");
            char ch = Main.readInput();
            System.out.println("\n");

            if (conceivedWord.contains(String.valueOf(ch))) {
                char[] tempConceivedWord = conceivedWord.toCharArray();
                char[] tempGuessedPartWord = guessedPartWord.toCharArray();
                for (int i = 0; i < conceivedWord.length(); i++) {
                    if (tempConceivedWord[i] == ch) {
                        tempGuessedPartWord[i] = ch;
                    }
                }
                guessedPartWord = new String(tempGuessedPartWord);
                if (!guessedPartWord.contains("_")) {
                    check = false;
                }
            } else {
                if (errorList.contains(ch)) {
                    System.out.println("Вы уже вводили эту букву");
                } else {
                    errorList.add(ch);
                }
                errorCount++;
                stagesScaffold = Stages.valueOf(scaffold[errorCount]);
                if (errorCount == errorMax) {
                    check = false;
                }
            }
        }
        if (errorCount != errorMax) {
            System.out.println("You are win");
        } else {
            System.out.println(Stages.SIX);
            System.out.println("Your are lose");
        }
    }
}
