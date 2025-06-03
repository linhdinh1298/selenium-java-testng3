package webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.Random;
public class Topic_10_Dropdown_Default_II {
    WebDriver driver;
    Random random;
    String firstName, lastName, email, password, date, month, year;
    @BeforeClass
    public void beforeClass() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--user-data-dir=C:\\Users\\Step Media\\AppData\\Local\\Google\\Chrome\\User Data\\");
        chromeOptions.addArguments("--profile-directory=Profile 63");
        driver = new ChromeDriver(chromeOptions);
        random = new Random();
        firstName ="lin5";
        lastName ="dinh5";
        password = "12345667";
        date = "24";
        month = "Jun";
        year = "2000";
        email ="lin" + random.nextInt(99999) + "@gmail.com";
    }
    @Test
    public void TC_01() throws InterruptedException {
        driver.get("https://demo.nopcommerce.com/");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("a.ico-register")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input#gender-male")).click();
        driver.findElement(By.cssSelector("input#FirstName")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input#LastName")).sendKeys(lastName);
        driver.findElement(By.cssSelector("input#Email")).sendKeys(email);
        driver.findElement(By.cssSelector("input#Password")).sendKeys(password);
        driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys(password);
        driver.findElement(By.cssSelector("button#register-button")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='page registration-result-page'] div[class='result']"))
                .getText(),"Your registration completed");
        driver.findElement(By.cssSelector("a.ico-account")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("input#FirstName")).getAttribute("value"),firstName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#LastName")).getAttribute("value"),lastName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#Email")).getAttribute("value"),email);
        Assert.assertTrue(driver.findElement(By.cssSelector("input#gender-male")).isEnabled());
    }
    @AfterClass
    public void afterClass(){
        //driver.quit();
    }
}