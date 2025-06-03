package javaSDET;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_06_If_Else {

    public static void main(String[] args) {
        WebDriver driver;
        String osName = System.getProperty("os.name");
        String browserName = "Chrome";
        // Biểu thức điều kiện
        // if (có 1 điều kiện)
        if (browserName.equals("IE")) {
            System.out.println("Click to submit button");
        }
        // if else (có 2 điều kiện)
        if (osName.contains("Windows")) {
            System.out.println("Window OS");
        } else {
            System.out.println("MAC or Linux OS");
        }
        // if else if else (có nhiều hơn 2 điều kiện, có thể bị trùng điều kiện)
        if (browserName.equals("Chrome")){
            driver = new ChromeDriver();
        } else if (browserName.equals("Firefox")){
            driver = new FirefoxDriver();
        } else {
            driver = new EdgeDriver();
        }

        // switch case (không bị trùng điều kiện)
        switch (browserName){
            case "Firefox":
                driver = new FirefoxDriver();
                break;
            case "Chrome":
                driver = new ChromeDriver();
                break;
            default:
                driver = new EdgeDriver();
                break;

        }
    }
}
