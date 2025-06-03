package webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_18_Frame_iFrame {
    WebDriver driver;

    @BeforeClass
    public void initialBrowser() {
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_Iframe() throws InterruptedException {
        driver.get("https://www.formsite.com/templates/education/campus-safety-survey/");
        driver.findElement(By.cssSelector("img[alt='Campus Safety Survey']")).click();
        Thread.sleep(3000);

        // Switch to iframe: có 3 cách

        // Cách 1: dùng index, frame đầu tiên có index = 0
        // Khi thêm mới or xoá bớt thì index sẽ bị đổi > k nên dùng
//        driver.switchTo().frame(0);
        // Cách 2: dùng id or name, phù hợp vs page có frame có id or name
//        driver.switchTo().frame("frame-one85593366");
        // Cách 3: có thể cover 2 cách trên
        driver.switchTo().frame(driver.findElement(By.cssSelector("div#formTemplateContainer>iframe")));

        // Input data into 3 fields: year, residence, gender and click submit
        new Select(driver.findElement(By.cssSelector("select#RESULT_RadioButton-2"))).selectByVisibleText("Sophomore");
        new Select(driver.findElement(By.cssSelector("select#RESULT_RadioButton-3"))).selectByVisibleText("North Dorm");
        driver.findElement(By.xpath("//label[text()='Male']")).click();

        // Quay lại main page
        driver.switchTo().defaultContent();
        Thread.sleep(3000);

        // Click to Login button
        driver.findElement(By.cssSelector("a.menu-item-login.fs-btn--transparent-kashmir")).click();
        // No input data, click Login button in Login form
        driver.findElement(By.cssSelector("button#login")).click();
        // Verify error message is displayed
        Assert.assertEquals(driver.findElement(By.cssSelector("div#message-error")).getText(),"Username and password are both required.");
    }

    @Test
    public void TC_02_Iframe_Toidicodedao(){
        driver.get("https://toidicodedao.com/");
        driver.switchTo().frame(driver.findElement(By.cssSelector("div.fb_iframe_widget iframe")));
        Assert.assertEquals(driver.findElement(By.xpath("//a[@title='Tôi đi code dạo']/parent::div/following-sibling::div[text()]")).getText(),"400,918 followers");

    }

    @Test
    public void TC_03_Frame() throws InterruptedException {
        driver.get("https://netbanking.hdfcbank.com/netbanking/");
        driver.switchTo().frame("login_page");
        driver.findElement(By.cssSelector("input[name='fldLoginUserId']")).sendKeys("linh");
        driver.findElement(By.cssSelector("a.login-btn")).click();
        Thread.sleep(5000);

        driver.findElement(By.cssSelector("input#keyboard")).sendKeys("123456789");
        driver.findElement(By.cssSelector("a#loginBtn")).click();
        Thread.sleep(3000);
    }

    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }
}