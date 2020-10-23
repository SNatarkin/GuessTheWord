package ru.skillbench.GuesTheWord;

import java.util.Scanner;

import static ru.skillbench.GuesTheWord.Computer.processString;

public class Main {


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        char hasContinue;
        do {
            String temp;
            boolean valid;
            Computer a = new Computer();
            String source = Computer.randomString("wordsbook");
            int n = source.length();
            String guess = new String(new char[n]).replace('\0', '*');
            char charGuess;
            int[] countMissed = new int[1];
            do {
                do {
                    System.out.print("(Угадать) Введите букву или слово " + guess + " > ");
                    temp = input.next();
                    charGuess = temp.charAt(0);
                    valid = temp.length() == 1 &&
                            'a' <= charGuess && charGuess <= 'z' ||
                            'A' <= charGuess && charGuess <= 'Z' ||
                            charGuess == '_';
                    if (!valid) System.out.println("-> " + "ВВедено не правильно !");
                } while (!valid);

                guess = processString(source, guess, charGuess, countMissed);
            } while (!guess.equals(source));

            System.out.println(
                    "Это слово " + source + ". " +
                            "Количество попыток " + countMissed[0] + " раз");

            do {
                System.out.print("Вы хотите угадать другое слово? Enter y or n > ");
                temp = input.next();
                hasContinue = temp.charAt(0);
                valid = temp.length() == 1 && hasContinue == 'y' || hasContinue == 'n';
                if (!valid) System.out.println("-> " + "Введено не правильно !");
            } while (!valid);

        } while (hasContinue == 'y');
        System.out.println("Пока!");
    }


}


