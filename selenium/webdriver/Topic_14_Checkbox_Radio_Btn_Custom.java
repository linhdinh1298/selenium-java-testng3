package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_14_Checkbox_Radio_Btn_Custom {

    WebDriver driver;
    JavascriptExecutor jsExecutor;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        jsExecutor = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        // Tăng độ phân giải màn hình
        //driver.manage().window().setSize(new Dimension(1920,1200));
    }


    @Test
    public void TC_05_Ubuntu() throws InterruptedException {
        driver.get("https://login.ubuntu.com/");

        // Click on I don't have U account
        By newUserRadio = By.cssSelector("input#id_new_user");
        jsExecutor.executeScript("arguments[0].click();", driver.findElement(newUserRadio));
        Assert.assertTrue(driver.findElement(newUserRadio).isSelected());

        // Click on checkbox I have read and accept ...
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)");
        By newCheckboxUser = By.cssSelector("input#id_accept_tos");
        jsExecutor.executeScript("arguments[0].click();", driver.findElement(newCheckboxUser));
        Assert.assertTrue(driver.findElement(newCheckboxUser).isSelected());
        Thread.sleep(3000);
    }

    @Test
    public void TC_06_Docs() throws InterruptedException {
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSfiypnd69zhuDkjKgqvpID9kwO29UCzeCVrGGtbNPZXQok0jA/viewform");
        Thread.sleep(3000);
        // Verify "Cần Thơ" is not selected
        By radioCanTho = By.xpath("//div[@aria-label ='Cần Thơ']");
        Assert.assertEquals(driver.findElement(radioCanTho).getAttribute("aria-checked"),"false");

        // Click on "Cần Thơ" radio button
        driver.findElement(radioCanTho).click();

        // Verify "Cần Thơ" is selected
        Assert.assertEquals(driver.findElement(radioCanTho).getAttribute("aria-checked"),"true");

        By checkboxMiQuang = By.xpath("//div[@aria-label ='Mì Quảng']");
        if (driver.findElement(checkboxMiQuang).getAttribute("aria-checked").equals("false"))
        {
            driver.findElement(checkboxMiQuang).click();
        }
        Assert.assertEquals(driver.findElement(checkboxMiQuang).getAttribute("aria-checked"),"true");

    }

    @AfterClass
    public void cleanBrowser () {
        driver.quit();
        }

    }