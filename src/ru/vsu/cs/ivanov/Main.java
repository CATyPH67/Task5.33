package ru.vsu.cs.ivanov;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        drawFigure(enterS());
    }

    private static int enterS() {
        Scanner scan = new Scanner(System.in);
        int s;
        do {
            System.out.print("enter the s (s = 4 + 3n, n = 0, 1, 2, 3, ...): ");
            s = scan.nextInt();
        } while (((s - 4) % 3 != 0) || (s < 4));
        return s;
    }

    private static void drawFigure(int s) {
        int longOfRepeatedCharacters = (s - 4) / 3;
        for (int i = 0; i < s; i++) {
            //условие для первой и последней строки
            if ((i == 0) || (i == (s - 1))) {
                drawStringOfFigure(longOfRepeatedCharacters, ' ', ' ', '*', '_');
            }
            //условие для строк c "|" в верхней и нижней части
            if (((i > 0) && (i < longOfRepeatedCharacters + 1))
                    || (i < (s - 1) && (i > ((s - 1) - longOfRepeatedCharacters - 1)))) {
                drawStringOfFigure(longOfRepeatedCharacters, ' ', ' ', '|', ' ');
            }
            //условие для строк с "*" в средней части
            if (i == (longOfRepeatedCharacters + 1) || (i == ((s - 1) - longOfRepeatedCharacters - 1))) {
                drawStringOfFigure(longOfRepeatedCharacters,  '*', '_', '*', ' ');
            }
            //условие для строк с "|" в средней части
            if ((i > (longOfRepeatedCharacters + 1)) && (i < ((s - 1) - longOfRepeatedCharacters - 1))) {
                drawStringOfFigure(longOfRepeatedCharacters,  '|', ' ', ' ', ' ');
            }
        }
    }

    private static void drawStringOfFigure(int longOfRepeatedCharacters, char char1, char char2, char char3, char char4) {
        //выводит самый левый символ
        System.out.print(char1);
        //выводит левую длинную послеовательность символов
        drawRepeatedCharactersForPartOfStringOfFigure(longOfRepeatedCharacters, char2);
        //выводит средний левый символ
        System.out.print(char3);
        //выводит среднюю длинную послеовательность символов
        drawRepeatedCharactersForPartOfStringOfFigure(longOfRepeatedCharacters, char4);
        //выводит средний правый символ
        System.out.print(char3);
        //выводит правую длинную послеовательность символов
        drawRepeatedCharactersForPartOfStringOfFigure(longOfRepeatedCharacters, char2);
        //выводит самый правый символ
        System.out.println(char1);
    }

    //выводит длинные последовательности повторяющихся символов
    private static void drawRepeatedCharactersForPartOfStringOfFigure(int longOfRepeatedCharacters, char character) {

        for (int i = 0; i < longOfRepeatedCharacters; i++) {
            System.out.print(character);
        }
    }
}
