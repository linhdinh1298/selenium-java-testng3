package webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class Topic_07_WebElement_Excercise_II {
    WebDriver driver;
    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
    }
    @Test
    public void TC_Login_01_EmptyEmailPassword(){
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        driver.findElement(By.xpath("//button[@title='Login']")).click();
        // Verify
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-required-entry-email")).getText(),"This is a required field.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-required-entry-pass")).getText(),"This is a required field.");
    }
    @Test
    public void TC_Login_02_invalidEmail(){
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        // Khai báo biến: emailTextbox = driver.findElement(By.cssSelector("input#email"));
        driver.findElement(By.cssSelector("input#email")).sendKeys("123@123.123");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@title='Login']")).click();
        // Verify
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-validate-email-email")).getText(),"Please enter a valid email address. For example johndoe@domain.com.");
    }
    @Test
    public void TC_Login_03_invalidPassword(){
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        // Khai báo biến: emailTextbox = driver.findElement(By.cssSelector("input#email"));
        driver.findElement(By.cssSelector("input#email")).sendKeys("linh@gmail.com");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("123");
        driver.findElement(By.xpath("//button[@title='Login']")).click();
        // Verify
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-validate-password-pass")).getText(),
                "Please enter 6 or more characters without leading or trailing spaces.");
    }
    @Test
    public void TC_Login_04_incorrectEmailPassword(){
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        // Khai báo biến: emailTextbox = driver.findElement(By.cssSelector("input#email"));
        driver.findElement(By.cssSelector("input#email")).sendKeys("linh1@gmail.com");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("123456678");
        driver.findElement(By.xpath("//button[@title='Login']")).click();
        // Verify
        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='error-msg']//span")).getText(),
                "Invalid login or password.");
    }
    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }
}