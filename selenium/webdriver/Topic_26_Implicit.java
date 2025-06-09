package webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_26_Implicit {
    WebDriver driver;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://automationfc.github.io/dynamic-loading/");

    }
    @Test
    public void TC_01_Dont_Set_Time(){
        // TH 1: lỗi do không set wait > sau khi bấm click thì chưa tìm thấy elememt
        driver.findElement(By.cssSelector("div#start button")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish h4")).getText(),"Hello World!");

    }

    @Test
    public void TC_02_Less_Than(){
        // TH 2: lỗi cho set wait chưa đủ time để load ra element
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.cssSelector("div#start button")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish h4")).getText(),"Hello World!");

    }
    @Test
    public void TC_03_Equal(){
        // TH 3: pass, đủ 5s để findElement
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.cssSelector("div#start button")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish h4")).getText(),"Hello World!");

    }
    @Test
    public void TC_04_Greater_Than(){
        // TH 3: pass, đủ 5s để findElement
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.findElement(By.cssSelector("div#start button")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish h4")).getText(),"Hello World!");

    }

    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }
}