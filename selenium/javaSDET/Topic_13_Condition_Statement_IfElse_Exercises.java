package javaSDET;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import java.util.Scanner;

public class Topic_13_Condition_Statement_IfElse_Exercises {
    WebDriver driver;
    Scanner scanner = new Scanner(System.in);
    @Test
    public void TC_01() {
        int number = scanner.nextInt();
        if (number % 2 == 0){
            System.out.println("so chan");
        } else {
            System.out.println("so le");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // TC_01
//        int number = scanner.nextInt();

        // Dùng == cho kiểu primitive, thường dùng với số
        // Kiểm tra value của biến
//        if (number % 2 == 0){
//            System.out.println("so chan");
//        } else {
//            System.out.println("so le");
//        }

        // Dùng equal cho kiểu Reference, kiểu string
        // Kiểm tra value của biến
        // Kiểm tra vị trí của biến trong vùng nhớ

        // TC_02
//        String firstStudent = scanner.nextLine().trim();
//        String secondStudent = scanner.nextLine().trim();
//
//        if (firstStudent.equals(secondStudent)) {
//            System.out.println("2 sinh vien giong ten");
//        } else {
//            System.out.println("2 sinh vien khac ten");
//        }
        // TC_03
          float Point = scanner.nextFloat();
          if (Point <= 10 && Point >= 8.5){
              System.out.println("Diem A");
          } else if (Point < 8.5 && Point >=0){
            System.out.println("Diem B");
        } else {
            System.out.println("Vui long nhap lại");
        }
    }
}
