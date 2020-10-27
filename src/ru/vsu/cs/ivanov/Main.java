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
        int lengthOfRepeatedCharacters = (s - 4) / 3;
        for (int i = 0; i < s; i++) {
            if (isFirstLastStrings(i, s)) {
                drawString(lengthOfRepeatedCharacters, ' ', ' ', '*', '_');
            }
            if (isUpperLowerStringsVerticalBars(i, s, lengthOfRepeatedCharacters)) {
                drawString(lengthOfRepeatedCharacters, ' ', ' ', '|', ' ');
            }
            if (isMiddleStringsAsterisks(i, s, lengthOfRepeatedCharacters)) {
                drawString(lengthOfRepeatedCharacters,  '*', '_', '*', ' ');
            }
            if (isMiddleStringsVerticalBars(i, s, lengthOfRepeatedCharacters)) {
                drawString(lengthOfRepeatedCharacters,  '|', ' ', ' ', ' ');
            }
        }
    }

    private static boolean isFirstLastStrings(int i, int s) {
        return (i == 0) || (i == (s - 1));
    }

    private static boolean isUpperLowerStringsVerticalBars(int i, int s, int lengthOfRepeatedCharacters) {
        return ((i > 0) && (i < lengthOfRepeatedCharacters + 1))
                || (i < (s - 1) && (i > ((s - 1) - lengthOfRepeatedCharacters - 1)));
    }

    private static boolean isMiddleStringsAsterisks(int i, int s, int lengthOfRepeatedCharacters) {
        return i == (lengthOfRepeatedCharacters + 1) || (i == ((s - 1) - lengthOfRepeatedCharacters - 1));
    }

    private static boolean isMiddleStringsVerticalBars(int i, int s, int lengthOfRepeatedCharacters) {
        return  (i > (lengthOfRepeatedCharacters + 1)) && (i < ((s - 1) - lengthOfRepeatedCharacters - 1));
    }


    private static void drawString(int lengthOfRepeatedCharacters, char char1, char char2, char char3, char char4) {
        System.out.print(char1);
        drawRepeatedCharacters(lengthOfRepeatedCharacters, char2);
        System.out.print(char3);
        drawRepeatedCharacters(lengthOfRepeatedCharacters, char4);
        System.out.print(char3);
        drawRepeatedCharacters(lengthOfRepeatedCharacters, char2);
        System.out.println(char1);
    }

    private static void drawRepeatedCharacters(int lengthOfRepeatedCharacters, char ch) {

        for (int i = 0; i < lengthOfRepeatedCharacters; i++) {
            System.out.print(ch);
        }
    }
}
