package javaSDET;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Topic_08_List {
    public static void main(String[] args) {
        // Java Collection
        WebDriver driver; // Cha
        // Remote WebDriver; // or có thể sd cha là Remote WebDriver
        driver = new FirefoxDriver(); // new thằng Con
        // driver = new ChromeDriver();
        // FirefoxDriver Ddriver = new FirefoxDriver(); nếu khai báo như trên thì k thể new thêm Chrome, vì cùng hàng

        List<String> address = new ArrayList<>(); // Khởi tạo
         // Thao tác với List
        address.add("HO CHI MINH"); // index = 0
        address.add("HA NOT"); // index = 1
        address.add("CAN THO"); // index = 2

        // Lấy ra 1 element cụ thể
        System.out.println(address.get(0));

        // Lấy ra toàn bộ, dùng vòng lặp
        // Cách 1
        for (String a: address) {
            System.out.println(a);
        }
        // Cách 2
        for(int i = 0; i<address.size(); i++){
            System.out.println(address.get(i));
        }

    }
}
