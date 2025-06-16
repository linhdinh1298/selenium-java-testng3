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

public class Topic_10_Multiple_Server {
    WebDriver driver;
    By emailTextbox = By.cssSelector("input#email");
    By passwordTextbox = By.cssSelector("input#pass");
    By loginButton = By.cssSelector("button#send2");
    String email = "selenium_11_01@gmail.com";
    String password = "111111";
    String domainURL;

    @BeforeClass
    @Parameters ({"server","browser"}) // Parameters không dùng được với beforeSuite, afterSuite, còn lại dùng dc hết
    // Lưu ý: khi run TC, phải run từ file xml vì nó sẽ không biết lấy parameter từ đâu
    // Dùng @Optional khi quên set giá trị trong xml
    public void beforeClass(String serverName, @Optional("Firefox") String browserName) {
        // Khởi tạo browser
        // Dùng 1 trong 2 cách If-Else or Switch - Case đều được
        // Cách 1: Dùng If-Else cho serverName
        if (serverName.equalsIgnoreCase("Dev")){
            domainURL ="http://dev.techpanda.org";

        } else if (serverName.equalsIgnoreCase("TesTing")){
            domainURL ="http://testing.techpanda.org";

        } else if (serverName.equalsIgnoreCase("Staging")){
            domainURL ="http://staging.techpanda.org";

        } else if (serverName.equalsIgnoreCase("Production")){
            domainURL ="http://live.techpanda.org";

        } else {
            throw new RuntimeException("Server name is not valid !");
        }
        // Cách 2: Dùng Switch - Case cho Browser
        switch (browserName){
            case "Chrome":
                driver = new ChromeDriver();
                break;
            case "Firefox":
                driver = new FirefoxDriver();
                break;
            case "Edge":
                driver = new EdgeDriver();
                break;
            default:
                new RuntimeException("Browser name is not valid !");

        }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void loginOnMultipleBrowser() {
        driver.get(domainURL+ "/index.php/customer/account/login/");

        driver.findElement(emailTextbox).sendKeys(email);
        driver.findElement(passwordTextbox).sendKeys(password);
        driver.findElement(loginButton).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='col-1']//p")).getText().contains(email));
    }

    @AfterClass (enabled = true)
    public void afterClass() {
        driver.quit();
    }
}
