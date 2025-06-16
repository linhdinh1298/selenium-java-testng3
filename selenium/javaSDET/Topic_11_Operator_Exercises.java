package javaSDET;

import org.testng.annotations.Test;

public class Topic_11_Operator_Exercises {
    @Test
    public void TC_01_swapNumber(){
        int a = 5;
        int b = 6;
        a = a + b ; //a = 11
        b = a - b;  //b = 5
        a = a - b;  //a = 6

        System.out.println("a:" + a);
        System.out.println("b:" + b);
    }

    @Test
    public void TC_02_Name_Age(){
        String name = "Tuan";
        int age = 15;
        System.out.println("After 15 years, age of Tuan will be " + (age+15));
    }

    @Test
    public void TC_03(){
        int a = 5;
        int b = 6;
        boolean status = (a>b) ? true : false;
        System.out.println(status);
    }
}
