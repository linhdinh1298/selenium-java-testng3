package javaSDET;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Topic_15_Loop_For_ForEach_Exercises {
    @Test
    public void TC_01(){
        int Number = 10;
        for (int i = 1; i <= Number; i++) {
            System.out.print(i + " ");

        }
    }
    @Test
    public void TC_02(){
        int numberA = 5;
        int numberB = 9;
        for (int i = numberA; i <= numberB; i++) {
            System.out.print(i + " ");

        }
    }
    @Test
    public void TC_03(){
        int numberA = 10;
        for (int i = 0; i <= numberA; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
    }
    @Test
    public void TC_04(){
        int numberA = 5;
        int numberB = 9;
        int sum = 0;
        for (int i = numberA; i <= numberB; i++) {
            sum = sum + i;
        }
        System.out.println(sum);
    }
    @Test
    public void TC_05(){
        int numberA = 10;
        int sum = 0;
        for (int i = 0; i <= numberA; i++) {
            if (i % 2 != 0) {
                sum = sum + i;
            }
        }
        System.out.println(sum);
    }
    @Test
    public void TC_06(){
        int number = 5;
        int add = 1;
        for (int i = 1; i <= number; i++) {
            add = add * i;
        }
        System.out.println(add);
    }
}
