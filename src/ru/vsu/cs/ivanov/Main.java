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
            if ((i == 0) || (i == (s - 1))) {
                drawString (s, ' ', ' ', '*', '_');
            }
            if (((i > 0) && (i <= (s - 4) / 3)) || (i < (s - 1) && (i > (s - (s - 4) / 3 - 1)))) {
                drawString (s, ' ', ' ', '|', ' ');
            }
            if (i == ((s - 4) / 3 + 1) || (i == (s - (s - 4) / 3 - 2))) {
                drawString (s, '*', '_', '*', ' ');
            }
            if ((i > ((s - 4) / 3 + 1)) && (i < (s - (s - 4) / 3 - 2))) {
                drawString (s, '|', ' ', ' ', ' ');
            }
        }
    }

    private static void drawString (int s, char char1, char char2, char char3, char char4) {
        System.out.print(char1);
        drawCharactersBetweenAsterisks (s, char2);
        System.out.print(char3);
        drawCharactersBetweenAsterisks (s, char4);
        System.out.print(char3);
        drawCharactersBetweenAsterisks (s, char2);
        System.out.println(char1);
    }

    private static void drawCharactersBetweenAsterisks (int s, char character) {
        for (int j = 0; j < ((s - 4) / 3); j++) {
            System.out.print(character);
        }
    }
}
