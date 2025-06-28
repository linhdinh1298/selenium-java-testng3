package javaSDET;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_19_String {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        String schoolName = "Automation Testing";
        String courseName = "AUTOMATION TESTING";
        String schoolAddress = "Da Nang";

        // Get length of String
        System.out.println(schoolName.length());;
        // Lấy ra kí tự
        System.out.println(schoolName.charAt(1));;
        // Nối chuỗi
        System.out.println(schoolName + schoolAddress );
        System.out.println(schoolName.concat(schoolAddress));
        // So sánh tuyệt đối
        System.out.println(schoolName.equals(schoolAddress));
        System.out.println(schoolName.equals("Automation Testing"));
        // So sánh tương đối, không phân biệt hoa thường
        System.out.println(schoolName.equalsIgnoreCase(courseName));
        // Start with, end with, contains
        System.out.println(schoolName.startsWith("A"));
        System.out.println(schoolName.endsWith("g"));
        System.out.println(schoolName.contains("Test"));
        // Index (vị trí của từ trong 1 chuỗi)
        System.out.println(schoolName.indexOf("A"));
        System.out.println(schoolName.indexOf("utomation"));
        System.out.println(schoolName.indexOf("Testing"));
        // subString (chuỗi con từ vị trí)
        System.out.println(schoolName.substring(11));
        System.out.println(schoolName.substring(11,15));
        // Split: tách chuỗi dựa vào kí tự or chuỗi kí tự
        String result = "Viewing 48 of 132 results";
        String results[] = result.split(" ");
        for (String result1: results){
            System.out.println(result1);
        }
        System.out.println(results[1]);
        // Replace
        String productPrice ="$100.000";
        productPrice = productPrice.replace("$","");
        System.out.println(productPrice);
        // Chuyển dữ liêụ kiểu chuỗi thành kiểu float > dùng để tính toán
        float productPriceF = Float.parseFloat(productPrice);
        System.out.println(productPriceF);
        // Chuyển kiểu dữ liệu từ float qua String
        String.valueOf(productPriceF);

        // LowerCase - UpperCase
        String osName = System.getProperty("os.name");
        System.out.println(osName);
        // Handle multiple OS
        if (osName.toLowerCase().contains("Mac OS X")){
            Keys key = Keys.COMMAND;
        } else {
            Keys key = Keys.CONTROL;
        };
        // Handel multiple browser
        // firefox = FIREFOX (Enum)

        String driverInstanceName = driver.toString();
        System.out.println(driverInstanceName);
        // FirefoxDriver: firefox on mac (b45f4845-c8a3-436a-9f44-553da7c34d40)
        // Close browser/driver
        if (driverInstanceName.contains("internet explorer")){
            // Sleep cứng thêm 5s sau mỗi lần chuển page
        }
        // Trim: loại bỏ kí tự khoảng trắng, xuống dòng, tab
        String helloWorld =" \n  \t  HelloWord!     ";
        System.out.println(helloWorld.trim());

        // Format / Dynamic Locator
        // Đại diện cho 1 chuỗi: %s
        // %b, %d, %t,..
        String dynamicButtonXpath = "//button[@id='%s']";
        System.out.println("Click to Login button = " + dynamicButtonXpath.format(dynamicButtonXpath,"Login"));
        System.out.println("Click to Search button = " + dynamicButtonXpath.format(dynamicButtonXpath,"Search"));
        System.out.println("Click to Register button = " + dynamicButtonXpath.format(dynamicButtonXpath,"Register"));



        driver.quit();



    }
}
