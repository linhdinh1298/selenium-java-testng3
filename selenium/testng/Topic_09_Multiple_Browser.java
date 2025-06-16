package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class Topic_09_Multiple_Browser {
    WebDriver driver;
    By emailTextbox = By.cssSelector("input#email");
    By passwordTextbox = By.cssSelector("input#pass");
    By loginButton = By.cssSelector("button#send2");
    String email = "selenium_11_01@gmail.com";
    String password = "111111";

    @BeforeClass
    @Parameters ("browser") // Parameters không dùng được với beforeSuite, afterSuite, còn lại dùng dc hết
    // Lưu ý: khi run TC, phải run từ file xml vì nó sẽ không biết lấy parameter từ đâu
    public void beforeClass(String browserName) {
        // Khởi tạo browser
        // Cách 1: Dùng If-Else
        if (browserName.equalsIgnoreCase("Chrome")){
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("Firefox")){
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("Edge")){
            driver = new EdgeDriver();
        } else if (browserName.equalsIgnoreCase("Safari")){
            driver = new SafariDriver();
        } else {
            throw new RuntimeException("Browser name is not valid !");
        }
        // Cách 2: Dùng Switch-
        switch (browserName){
            case "Chrome":
                driver = new ChromeDriver();
            case "Firefox":
                driver = new FirefoxDriver();
            case "Edge":
                driver = new EdgeDriver();
            case "Safari":
                driver = new SafariDriver();
            default:
                new RuntimeException("Browser name is not valid !");

        }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void loginOnMultipleBrowser() {
        driver.get("http://live.techpanda.org/index.php/customer/account/login/");

        driver.findElement(emailTextbox).sendKeys(email);
        driver.findElement(passwordTextbox).sendKeys(password);
        driver.findElement(loginButton).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='col-1']//p")).getText().contains(email));
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
