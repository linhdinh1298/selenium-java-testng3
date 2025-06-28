package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Topic_14_Condition_Statement_Switch_Case {
    WebDriver driver;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // TC_01
//        int month = scanner.nextInt();
//        switch (month) {
//            case 1:
//            case 3:
//            case 5:
//            case 7:
//            case 8:
//            case 10:
//            case 12:
//                System.out.println("31");
//                break;
//            case 2:
//                System.out.println("28");
//                break;
//            case 4:
//            case 6:
//            case 9:
//            case 11:
//                System.out.println("30");
//                break;
//            default:
//                System.out.println("invalid month");
//                break;
//            // break : không bắt buộc phải có, nếu không có break, thì sẽ run all case => performance , không chính xác
//        }

        // TC_02


        int firstNumber = scanner.nextInt();
        int secondNumber = scanner.nextInt();
        String operator = scanner.next();

        switch (operator) {
            case "+":
                System.out.println("A + B =" + (firstNumber + secondNumber));
                break;
            case "-":
                System.out.println("A - B =" + (firstNumber - secondNumber));
                break;
            case "*":
                System.out.println("A * B =" + (firstNumber * secondNumber));
                break;
            case "/":
                System.out.println("A / B =" + (firstNumber / secondNumber));
                break;
            case "%":
                System.out.println("A % B =" + (firstNumber % secondNumber));
                break;



        }

    }
}
