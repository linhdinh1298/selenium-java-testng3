package webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_20_Random_Popup {

    WebDriver driver;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_InDom_VNK() throws InterruptedException {
        driver.get("https://vnk.edu.vn/");
        Thread.sleep(5000);
        // Kiểm tra popup trong 2 trường hợp
        // TH1: có popup, đóng popup, chuyển qua step 3
        if(driver.findElements(By.cssSelector("div.pum-container")).size()>0
                &&  driver.findElements(By.cssSelector("div.pum-container")).get(0).isDisplayed())
        {
            driver.findElement(By.cssSelector("button.pum-close")).click();
        }
        // TH2: không có popup, chuyển qua step 3
        // Step3:


    }
    @Test
    public void TC_02_NotInDom_JavaCodeGeeks() throws InterruptedException {
        driver.get("https://www.javacodegeeks.com/");
        By newsletterPopupBy = By.xpath("//div[@data-title='Newsletter Free Books'"
                + " and not(contains(@style,':none'))]");
        // Kiểm tra popup trong 2 trường hợp
        // TH1: có popup, đóng popup, chuyển qua step 3
        // TH2: không có popup, chuyển qua step 3
        if (driver.findElements(newsletterPopupBy).size()>0
                && driver.findElements(newsletterPopupBy).get(0).isDisplayed()) {
            driver.findElement(By.xpath("//div[@data-title='Newsletter Free Books' " +
                    "and not(contains(@style,':none'))]//a[contains(@,'lepopup-close')])")).click();
            Thread.sleep(3000);
        }
        // Step3: Nhập vào Search box: Agile Testing Explained
        driver.findElement(By.cssSelector("input#search-input")).sendKeys("Agile Testing Explained");
        driver.findElement(By.cssSelector("form#search span.tie-search-icon")).click();
        // Kiểm tra bài víêt đầu tiên xuát hiện chưa từ khoá Agile Testing Explained
        Assert.assertTrue(driver.findElement(By.cssSelector("header>h1.page-title")).isDisplayed());

    }
    @Test
    public void TC_03_NotInDom_DeHieu() throws InterruptedException {
        driver.get("https://dehieu.vn/");
        // Kiểm tra popup trong 2 trường hợp
        By registerForm = By.cssSelector("div.modal-content");
        // TH1: có popup, đóng popup, chuyển qua step 3
        if (driver.findElements(registerForm).size()>0
                && driver.findElements(registerForm).get(0).isDisplayed()) {
            driver.findElement(By.cssSelector("button.close")).click();
            Thread.sleep(3000);
        }

        // TH2: không có popup, chuyển qua step 3
        driver.findElement(By.cssSelector("input.search-form")).sendKeys("abcd");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

    }

    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }
}