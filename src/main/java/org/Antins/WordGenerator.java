package org.Antins;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class WordGenerator {
    String word;

    public WordGenerator() throws IOException {
        this.word = generateRandomWord();
    }

    public static String generateRandomWord() throws IOException {
        ArrayList<String> words = GenerateWordsMass();
        Random random = new Random();
        int randomIndex = random.nextInt(words.size());
        return words.get(randomIndex);
    }
    public static void prepareWords() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/roman/Documents/Projects/Hangman/src/main/resources/Words.txt"));
        Scanner scanner = new Scanner(bufferedReader);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Users/roman/Documents/Projects/Hangman/src/main/resources/rightWords.txt"));
        String word;
        while (scanner.hasNextLine()) {
            word = scanner.nextLine();
            String[] simbols = word.split("");
            if (simbols.length > 5) {
                bufferedWriter.write(word);
                bufferedWriter.write("\n");
            }
        }
        bufferedReader.close();
        bufferedWriter.close();
    }

    public static ArrayList<String> GenerateWordsMass() throws IOException {
        prepareWords();
        BufferedReader reader = new BufferedReader(new FileReader("/Users/roman/Documents/Projects/Hangman/src/main/resources/rightWords.txt"));
        Scanner scanner = new Scanner(reader);
        String word;
        ArrayList<String> words = new ArrayList<>();
        while (scanner.hasNextLine()) {
            word = scanner.nextLine();
            words.add(word);
        }
        return words;
    }
}
