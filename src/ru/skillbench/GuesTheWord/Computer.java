package ru.skillbench.GuesTheWord;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Computer {
    public static String randomString(String fileName) {
        ArrayList<String> words = new ArrayList<>();
        try {
            File file = new File("src/ru/skillbench/GuesTheWord/" + fileName + ".txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = reader.readLine();
            while (line != null) {
                words.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return words.get((int) (Math.random() * (words.size())));
    }

    public static String processString(String source, String guessed, char charGuess, int[] countMissed) {
        int l = source.length();
        boolean isCorrectGuess = false;
        boolean isCorrected = false;

        for (int i = 0; i < l; i++) {
            if (guessed.charAt(i) == '*') {
                if (source.charAt(i) == charGuess) {
                    isCorrectGuess = true;
                    guessed = guessed.substring(0, i) +
                            charGuess +
                            guessed.substring(i + 1);
                }
            } else {
                if (source.charAt(i) == charGuess) {
                    isCorrected = true;
                    System.out.println("-> " + charGuess + " уже в слове");
                    break;
                }
            }
        }

        if (!isCorrected && !isCorrectGuess) {
            System.out.println("-> " + charGuess + " нету в слове");
            countMissed[0]++;
        }


        return guessed;
    }

}

