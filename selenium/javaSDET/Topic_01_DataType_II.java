package javaSDET;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.*;

public class Topic_01_DataType_II {
    // Global variable
    static int number;
    String address = "Ho Chi Minh";
    public static void main (String[] args){
     // Local variable => nếu dùng phải khởi tạo dữ liệu
        int studentNumber = 0;
        System.out.println(number);
        System.out.println(studentNumber);
        Topic_01_DataType_II topic = new Topic_01_DataType_II();
        System.out.println(topic.address);
    }
}
