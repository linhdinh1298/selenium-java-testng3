package javaSDET;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.Random;
public class Topic_05_Wait {
    WebDriver driver;
    WebDriverWait explicitWait;
    FluentWait<WebDriver> fluentWait; // Java Generic
    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        // Explicit wait
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(15));
        // Implicit wait, chỉ dùng cho tìm element (findElement(s))
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // Fluent wait
        fluentWait = new FluentWait<WebDriver>(driver);
    }
    @Test
    public void TC_01_() {
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("")));
    }
}

