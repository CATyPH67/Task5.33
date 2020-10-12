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
            if ((i == 0) || (i == (s - 1))) { //условие для первой и последней строки
                drawString(s, ' ', ' ', '*', '_');
            }
            if (((i > 0) && (i < longOfRepeatedCharacters + 1)) || (i < (s - 1) && (i > ((s - 1) - longOfRepeatedCharacters - 1)))) {
                drawString(s, ' ', ' ', '|', ' '); //условие для строк c "|" в верхней и нижней части
            }
            if (i == (longOfRepeatedCharacters + 1) || (i == ((s - 1) - longOfRepeatedCharacters - 1))) {
                drawString(s, '*', '_', '*', ' '); //условие для строк с "*" в средней части
            }
            if ((i > (longOfRepeatedCharacters + 1)) && (i < ((s - 1) - longOfRepeatedCharacters - 1))) {
                drawString(s, '|', ' ', ' ', ' '); //условие для строк с "|" в средней части
            }
        }
    }

    private static void drawString(int s, char char1, char char2, char char3, char char4) {
        System.out.print(char1);            //выводит самый левый символ
        drawRepeatedCharacters (s, char2);  //выводит левую длинную послеовательность символов
        System.out.print(char3);            //выводит средний левый символ
        drawRepeatedCharacters (s, char4);  //выводит среднюю длинную послеовательность символов
        System.out.print(char3);            //выводит средний правый символ
        drawRepeatedCharacters (s, char2);  //выводит правую длинную послеовательность символов
        System.out.println(char1);          //выводит самый правый символ
    }

    private static void drawRepeatedCharacters(int s, char character) { //выводит длинные последовательности повторяющихся символов
        for (int i = 0; i < ((s - 4) / 3); i++) {
            System.out.print(character);
        }
    }
}
