package webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_03_Xpath_Css {

    // 1-Setup: OS/Browser/Web/Page/Data/Variable/Object/...
    WebDriver driver;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    // 2-Action/Execute: Element/input data/verify/...
    @Test
    public void TC_01_Regist_empty_data(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.className("fs16")).click();
        driver.findElement(By.id("txtFirstname")).getText();
        //Assert.assertEquals(driver.findElement(By.id("txtFirstname")).getText(),"Vui lòng nhập họ tên");

    }
    @Test
    public void TC_02_Regist_invalid_email(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

    }

    @Test
    public void TC_03_Regist_incorrect_confirm_email(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
    }

    @Test
    public void TC_04_Regist_invalid_password(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
    }

    @Test
    public void TC_05_Regist_incorrect_confirm_password(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
    }

    @Test
    public void TC_06_Regist_invalid_phonenumber(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
    }

    // 3-Clean: Delete data test/ account/ close browser/...
    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }
}