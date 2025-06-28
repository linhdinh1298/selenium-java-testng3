package javaSDET;

import org.testng.annotations.Test;

public class Topic_18_Array_Exercises {
    int number[] ={2,3,-7,6,-9,11};
    @Test
    public void TC_01_Max_Number(){
        int x = 0;
        // i: index of array
        for (int i = 0; i < number.length; i++) {
            if (x < number[i]) {
                x = number [i];
            }
        }
        System.out.println(x);
    }

    @Test
    public void TC_02_Sum_First_Last_Number() {
        int x = 0;
        x = number[0] + number[number.length -1];
        System.out.println(x);
    }

    @Test
    public void TC_03_Even_Number() {
        for (int i = 0; i < number.length; i++) {
            if (number[i] % 2 == 0) {
                System.out.println(number[i]);
            }

        }
    }

    @Test
    public void TC_04_Odd_Number() {
        int x = 0;
        for (int i = 0; i < number.length; i++) {
            if (number[i] % 2 != 0 && number[i] > 0) {
                x = x + number[i];
            }
        }
        System.out.println(x);
    }

    @Test
    public void TC_05_Number_GreaterThan0_LessThan10() {
        for (int i = 0; i < number.length; i++) {
            if (number[i] >0  && number[i] < 10) {
                System.out.println(number[i]);
            }
        }
    }

    @Test
    public void TC_06_Total_Average() {
        int x = 0;
        for (int i = 0; i < number.length; i++) {
          x = x + number[i];
        }
        System.out.println(x);
        float Average = x/ number.length;
        System.out.println(Average);
    }
}

