package webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_25_Wait_Element_Status {

    WebDriver driver;
    WebDriverWait explicitWait; // Wait tường minh

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); // Wait ngầm định
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    @Test
    public void TC_01_Visible(){
        driver.get("https://web.facebook.com/");
        // Element có trên UI và có trong cây HTML > đợi cho element visible trong vòng 15s
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#email")));

    }
    @Test
    public void TC_02_Invisible(){
        driver.get("https://web.facebook.com/");
        driver.findElement(By.cssSelector("a[data-testid = 'open-registration-form-button']")).click();
        // Wait cho Email address textbox is visible => step để mồi cho popup được bật, lúc popup bật lên mới check invisible
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='reg_email__']")));

        // Element không có trên UI nhưng vẫn có trong cây HTML
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("input[name='reg_email_confirmation__']")));
        driver.findElement(By.cssSelector("a[aria-label='Already have an account?']")).click();

        // Element không có trên UI và không có trong HTML
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("input[name='reg_email_confirmation__']")));


    }

    @Test
    public void TC_03_Presence(){
        driver.get("https://web.facebook.com/");
        driver.findElement(By.cssSelector("a[data-testid = 'open-registration-form-button']")).click();
        // Wait cho Email address textbox is visible => step để mồi cho popup được bật, lúc popup bật lên mới check invisible
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='reg_email__']")));
        // Điều kiện mồi để cho confirm email xuất  trên UI
        driver.findElement(By.cssSelector("input[name='reg_email__']")).sendKeys("linhdtm55555@gmail.com");

        // Element có trên UI và có trong cây HTML
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='reg_email_confirmation__']")));

        // Điều kiện mồi để cho confirm email không còn xuất hiện trên UI
        driver.findElement(By.cssSelector("input[name='reg_email__']")).clear();

        // Element không có trên UI nhưng vẫn có trong cây HTML
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='reg_email_confirmation__']")));

    }

    @Test
    public void TC_04_Staleness(){
        driver.get("https://web.facebook.com/");
        // Click để mở form Regist
        driver.findElement(By.cssSelector("a[data-testid = 'open-registration-form-button']")).click();
        // Wait cho Email address textbox is visible => step để mồi cho popup được bật, lúc popup bật lên mới check invisible
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='reg_email__']")));

        // Tại thời điểm này, confirm Email đang có trong HTML
        WebElement confirmEmail = driver.findElement(By.cssSelector("input[name='reg_email_confirmation__']"));

        // Click để đóng form Regist
        driver.findElement(By.cssSelector("a[aria-label='Already have an account?']")).click();

        // Element không có trên UI và H
        explicitWait.until(ExpectedConditions.stalenessOf(confirmEmail));

    }
    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }
}