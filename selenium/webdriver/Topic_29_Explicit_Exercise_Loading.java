package webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_29_Explicit_Exercise_Loading {

    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_Less_Than(){
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(3));
        driver.get("https://automationfc.github.io/dynamic-loading/");
        driver.findElement(By.cssSelector("div#start button")).click();

        // Điều kiện Wait , chờ cho element được hiển thị (3s)
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#finish h4")));
        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish h4")).getText(),"Hello World!");

    }
    @Test
    public void TC_02_Equal(){
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(5));
        driver.get("https://automationfc.github.io/dynamic-loading/");
        driver.findElement(By.cssSelector("div#start button")).click();

        // Điều kiện Wait , chờ cho element được hiển thị (5s)
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#finish h4")));
        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish h4")).getText(),"Hello World!");

    }
    @Test
    public void TC_03_Greater_Than(){
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.get("https://automationfc.github.io/dynamic-loading/");
        driver.findElement(By.cssSelector("div#start button")).click();

        // Điều kiện Wait , chờ cho element được hiển thị (10s)
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#finish h4")));
        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish h4")).getText(),"Hello World!");

    }
    @Test
    public void TC_04(){
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.get("https://automationfc.github.io/dynamic-loading/");
        driver.findElement(By.cssSelector("div#start button")).click();

        // Visible (chờ cho 1 element sau được xuất hiện)

        WebElement helloText = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#finish h4")));
        Assert.assertEquals(helloText.getText(),"Hello World!");

        // Invisible (chờ cho 1 element sắp biến mất/ kỳ vọng biến mất đi)
        boolean loadingIconStatus = explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#loading")));
        Assert.assertTrue(loadingIconStatus);

        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish h4")).getText(),"Hello World!");

        // Text
        boolean helloTextStatus = explicitWait.until(ExpectedConditions.textToBe(By.cssSelector("div#finish h4"),"Hello World!"));
        Assert.assertTrue(helloTextStatus);

    }

    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }
}