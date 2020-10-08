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
        for (int i = 0; i < s; i++) {
            if ((i == 0) || (i == (s - 1))) { //условие для первой и последней строки
                drawString (s, ' ', ' ', '*', '_');
            }
            if (((i > 0) && (i < (s - 4) / 3 + 1)) || (i < (s - 1) && (i > (s - (s - 4) / 3 - 1)))) { //условие для строк c "|"
                drawString (s, ' ', ' ', '|', ' ');                              //в верхней и нижней части
            }
            if (i == ((s - 4) / 3 + 1) || (i == ((s - 1) - (s - 4) / 3 - 1))) { //условие для строк с "*" в средней части
                drawString (s, '*', '_', '*', ' ');
            }
            if ((i > ((s - 4) / 3 + 1)) && (i < ((s - 1) - (s - 4) / 3 - 1))) { //условие для строк с "|" в средней части
                drawString (s, '|', ' ', ' ', ' ');
            }
        }
    }

    private static void drawString (int s, char char1, char char2, char char3, char char4) {
        System.out.print(char1);            //выводит самый левый символ
        drawRepeatedCharacters (s, char2);  //выводит левую длинную послеовательность символов
        System.out.print(char3);            //выводит средний левый символ
        drawRepeatedCharacters (s, char4);  //выводит среднюю длинную послеовательность символов
        System.out.print(char3);            //выводит средний правый символ
        drawRepeatedCharacters (s, char2);  //выводит правую длинную послеовательность символов
        System.out.println(char1);          //выводит самый правый символ
    }

    private static void drawRepeatedCharacters (int s, char character) { //выводит длинные последовательности повторяющихся символов
        for (int j = 0; j < ((s - 4) / 3); j++) {
            System.out.print(character);
        }
    }
}
