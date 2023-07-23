package org.Antins;

import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args)  {
        offerToPlay();
    }
    public static char readInput() {
        while (true) {
            return scanner.nextLine().toUpperCase(Locale.ROOT).charAt(0);
        }
    }
    public static void offerToPlay() {
        System.out.println("Do you want play games? Write 'yes' if you do, write 'no' if you don't");
        String answer = null;
        while (answer == null) {
            answer = scanner.nextLine();
        }
        if (answer.equals("yes")) {
            try {
                Game.start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}