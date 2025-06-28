package javaSDET;

import org.testng.annotations.Test;

import java.util.Scanner;

public class Topic_16_While_DoWhile_Exercises {
    @Test
    public void TC_01_For() {
        int number = 86;
        for (int i = number; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }

    @Test
    public void TC_01_While() {
        int number = 86;
        while (number < 100) {
            if (number % 2 == 0) {
                System.out.println(number);
            }
            number++;
        }
    }
    @Test
    public void TC_01_Do_While() {
        int number = 86;

        do {
            if (number % 2 == 0) {
                System.out.println(number);
            } number++;
        } while (number < 100);
    }

    @Test
    public void TC_02_While() {
        int numberA = 1;
        int numberB = 50;
        while (numberA < numberB) {
            if (numberA % 3 == 0 && numberA % 5 == 0) {
                System.out.println(numberA);
            }
            numberA++;
        }
    }

    @Test
    public void TC_03_While() {
        int number = 9;
        int i = 0;
        while (number > 0 ) {
            if (number % 2 != 0) {
                System.out.println(number);
                i += number;
            }
            number--;
        }
        System.out.println(i);
    }
    @Test
    public void TC_04_While() {
        int number = 9;
        int i = 1;
        while (number > 0 ) {
                i *= number;
                number--;
            }
        System.out.println(i);
    }
}


