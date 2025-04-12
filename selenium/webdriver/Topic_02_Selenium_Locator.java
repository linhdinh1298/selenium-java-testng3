package Webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Selenium_Locator {

    // khai báo
    WebDriver driver;
    WebDriver secondDriver;

    @BeforeClass
    public void initialBrowser() {
        // Open browser (khởi tạo biến driver lên - "new" là khởi tạo)
        driver = new FirefoxDriver();
        secondDriver = new ChromeDriver();
        // Open app
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void TC_01_(){
        // Interact on email textbox > need 8 types of locator to find this email address
        driver.findElement(By.id(""));
        // <input type="text" class="inputtext _55r1 _6luy" name="email" id="email" data-testid="royal-email" placeholder="Email hoặc số điện thoại" autofocus="1" aria-label="Email hoặc số điện thoại">
    }
    @Test
    public void TC_02_(){

    }

    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }
}