package ru.vsu.cs.ivanov;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("enter the s: ");
        int s = scan.nextInt();
        drawFigure(s);
    }

    private static void drawFigure(int s) {
        int longOfRepeatedCharacters = (s - 4) / 3;
        for (int i = 0; i < s; i++) {
            //условие для первой и последней строки
            if ((i == 0) || (i == (s - 1))) {
                drawStringOfFigure(s, longOfRepeatedCharacters, ' ', ' ', '*', '_');
            }
            //условие для строк c "|" в верхней и нижней части
            if (((i > 0) && (i < longOfRepeatedCharacters + 1))
                    || (i < (s - 1) && (i > ((s - 1) - longOfRepeatedCharacters - 1)))) {
                drawStringOfFigure(s, longOfRepeatedCharacters, ' ', ' ', '|', ' ');
            }
            //условие для строк с "*" в средней части
            if (i == (longOfRepeatedCharacters + 1) || (i == ((s - 1) - longOfRepeatedCharacters - 1))) {
                drawStringOfFigure(s, longOfRepeatedCharacters,  '*', '_', '*', ' ');
            }
            //условие для строк с "|" в средней части
            if ((i > (longOfRepeatedCharacters + 1)) && (i < ((s - 1) - longOfRepeatedCharacters - 1))) {
                drawStringOfFigure(s, longOfRepeatedCharacters,  '|', ' ', ' ', ' ');
            }
        }
    }

    private static void drawStringOfFigure(int s, int longOfRepeatedCharacters, char char1, char char2, char char3, char char4) {
        //выводит самый левый символ
        System.out.print(char1);
        //выводит левую длинную послеовательность символов
        drawRepeatedCharactersForPartOfStringOfFigure (s, longOfRepeatedCharacters, char2);
        //выводит средний левый символ
        System.out.print(char3);
        //выводит среднюю длинную послеовательность символов
        drawRepeatedCharactersForPartOfStringOfFigure (s, longOfRepeatedCharacters, char4);
        //выводит средний правый символ
        System.out.print(char3);
        //выводит правую длинную послеовательность символов
        drawRepeatedCharactersForPartOfStringOfFigure (s, longOfRepeatedCharacters, char2);
        //выводит самый правый символ
        System.out.println(char1);
    }

    //выводит длинные последовательности повторяющихся символов
    private static void drawRepeatedCharactersForPartOfStringOfFigure(int s, int longOfRepeatedCharacters, char character) {

        for (int i = 0; i < longOfRepeatedCharacters; i++) {
            System.out.print(character);
        }
    }
}
