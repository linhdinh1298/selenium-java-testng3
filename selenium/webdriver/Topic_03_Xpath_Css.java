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

        // Action
        driver.findElement(By.xpath("//button[@class='btn_pink_sm fs16']")).click();

        // Assert
        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtFirstname-error']")).getText(),"Vui lòng nhập họ tên");
        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtEmail-error']")).getText(),"Vui lòng nhập email");
        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCEmail-error']")).getText(),"Vui lòng nhập lại địa chỉ email");
        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtPassword-error']")).getText(),"Vui lòng nhập mật khẩu");
        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCPassword-error']")).getText(),"Vui lòng nhập lại mật khẩu");
        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtPhone-error']")).getText(),"Vui lòng nhập số điện thoại.");

    }
    @Test
    public void TC_02_Regist_invalid_email(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("linh");
        driver.findElement(By.xpath("//button[@class='btn_pink_sm fs16']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtEmail-error']")).getText(),"Vui lòng nhập email hợp lệ");

    }

    @Test
    public void TC_03_Regist_incorrect_confirm_email(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("linh@gmail.com");
        driver.findElement(By.xpath("//input[@id='txtCEmail']")).sendKeys("linh1@gmail.com");
        driver.findElement(By.xpath("//button[@class='btn_pink_sm fs16']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCEmail-error']")).getText(),"Email nhập lại không đúng");
    }

    @Test
    public void TC_04_Regist_invalid_password(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("4567");
        driver.findElement(By.xpath("//button[@class='btn_pink_sm fs16']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtPassword-error']")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");
    }

    @Test
    public void TC_05_Regist_incorrect_confirm_password(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("abc4567");
        driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("4567889");
        driver.findElement(By.xpath("//button[@class='btn_pink_sm fs16']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCPassword-error']")).getText(),"Mật khẩu bạn nhập không khớp");
    }

    @Test
    public void TC_06_Regist_invalid_phonenumber1(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html"); // nếu open browser lại thì k cần phải dùng hàm clear data vì data đã reset lại
        driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("0998484885656646566"); // TH > 11 số
        driver.findElement(By.xpath("//button[@class='btn_pink_sm fs16']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtPhone-error']")).getText(),"Số điện thoại phải từ 10-11 số.");

        // xóa dữ liệu đã nhập ở lần trước, trong trường hợp get new browser thì k cần clear vì data đã reset
        driver.findElement(By.xpath("//input[@id='txtPhone']")).clear();
        driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("89333334"); // TH start without 0
        driver.findElement(By.xpath("//button[@class='btn_pink_sm fs16']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtPhone-error']")).getText(),"Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019 - 088 - 03 - 05 - 07 - 08");

        driver.findElement(By.xpath("//input[@id='txtPhone']")).clear();
        driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("09893"); // TH < 10-11 số
        driver.findElement(By.xpath("//button[@class='btn_pink_sm fs16']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtPhone-error']")).getText(),"Số điện thoại phải từ 10-11 số.");
    }

    // 3-Clean: Delete data test/ account/ close browser/...
    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }
}