package javaSDET;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Topic_19_String_Exercises {
    String courseName = "Automation FC 12 Testing Tutorials";
    @Test
    public void TC_01_Sum_Of_UpperCase(){
        // Chuyển chuỗi thành mảng kí tự
        char courseNameArray [] = courseName.toCharArray();
        int countUpper = 0;
        int countLower = 0;
        int countNumber = 0;
        for (char courseNameCharacter: courseNameArray){
            // Upper case
            if (courseNameCharacter <='Z' && courseNameCharacter >='A'){
                countUpper++;
            }
            // Lower case : <='z' && >='a'
            if (courseNameCharacter <='z' && courseNameCharacter >='a'){
                countLower++;
            }
            // Number: <=9 && >=0
            if (courseNameCharacter <='9' && courseNameCharacter >='0'){
                countNumber++;
            }

        }
        System.out.println(countUpper);
        System.out.println(countLower);
        System.out.println(countNumber);
    }

    @Test
    public void TC_02() {
        // Chuyển chuỗi thành mảng kí tự
        char courseNameArray[] = courseName.toCharArray();
        int count = 0;
        for (char courseNameCharacter : courseNameArray) {
            if (courseNameCharacter == 'a'){
                count++;
            }
        }
        System.out.println(count);
        System.out.println(courseName.contains("Testing"));
        System.out.println(courseName.startsWith("Automation"));
        System.out.println(courseName.endsWith("Online"));
        System.out.println(courseName.indexOf("Tutorials"));
        System.out.println(courseName.replace("12","14"));
    }

    @Test
    public void TC_03_Revert() {
        // Cách 1
        String courseName = "Selenium";
        char[] courseNameArray = courseName.toCharArray();

        // Chuyển char[] -> Character[]
        Character[] characterArray = new Character[courseNameArray.length];
        for (int i = 0; i < courseNameArray.length; i++) {
            characterArray[i] = courseNameArray[i];
        }

        // Đảo ngược
        List<Character> charList = Arrays.asList(characterArray);
        Collections.reverse(charList);

        // In ra kết quả
        for (Character c : charList) {
            System.out.println(c);
        }


        // Cách 2:
        for (int i = courseNameArray.length - 1; i >= 0; i--) {
            System.out.println(courseNameArray[i]);

        }
    }
}
