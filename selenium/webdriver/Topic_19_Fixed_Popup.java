package webdriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_19_Fixed_Popup {

    WebDriver driver;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Fixed_Pop_InDom_NgoaiNgu_24h() throws InterruptedException {
        driver.get("https://ngoaingu24h.vn/");
        driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();
        By loginPopup = By.cssSelector("div.MuiPaper-root");
        // Kiểm tra 1 element có hiển thị trong HTML
        // Hiển thị trên UI > True
        // Không hiển thị trên UI > False
        Assert.assertTrue(driver.findElement(loginPopup).isDisplayed());
        driver.findElement(By.xpath("//input[@autocomplete='username']")).sendKeys("automation");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("automation");
        driver.findElement(By.xpath("//button[@type='submit' and text()='Đăng nhập']")).click();
        Thread.sleep(2000);

        WebElement errorMessage = driver.findElement(By.xpath("//*[contains(text(),'Bạn đã nhập sai tài khoản hoặc mật khẩu!')]"));
        Assert.assertTrue(errorMessage.isDisplayed());

        driver.findElement(By.cssSelector("button.close-btn")).click();
        Assert.assertFalse(driver.findElement(loginPopup).isDisplayed());
    }
    @Test
    public void TC_02_Fixed_Pop_NotInDom_Tiki() throws InterruptedException {
        driver.get("https://tiki.vn/");
        // Click Login/Sign up
        driver.findElement(By.xpath("//span[text()='Tài khoản']")).click();
        // Verify Login popup display
        By loginPopup = By.cssSelector("div.ReactModal__Content.ReactModal__Content--after-open");
        Assert.assertTrue(driver.findElement(loginPopup).isDisplayed());// cách 1
        // cách 2. kiểm tra 1 element có trong cây HTML
        // Không chắc chắn được nó có hiển thị hay không > dùng isDisplayed sẽ chắc chắn hơn
        // Assert.assertEquals(driver.findElements(loginPopup).size(),1);

        // Click login by email link
        driver.findElement(By.cssSelector("p.login-with-email")).click();
        Thread.sleep(5000);
        // No input and click Login
        driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();
        // Verify text is displayed
        Assert.assertEquals(driver.findElement(By.xpath("//input[@type='email']/parent::div/following-sibling::span[1]")).getText(),"Email không được để trống");
        Assert.assertEquals(driver.findElement(By.xpath("//input[@type='password']/parent::div/following-sibling::span")).getText(),"Mật khẩu không được để trống");
        // Click to close popup
        driver.findElement(By.cssSelector("img.close-img")).click();
        // Verify popup is not displayed anymore
        Assert.assertEquals(driver.findElements(loginPopup).size(),0);

    }

    @Test
    public void TC_03_Fixed_Pop_NotInDom_Facebook() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        // Click Create new account
        driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']")).click();
        // Verify Register popup display
        By signupPopup = By.xpath("//div[text()='Create a new account']/parent::div/parent::div");
        Assert.assertTrue(driver.findElement(signupPopup).isDisplayed());
        // Click to close popup
        driver.findElement(By.cssSelector("a[aria-label='Already have an account?']")).click();
        // Verify Register popup is not displayed
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertEquals(driver.findElements(signupPopup).size(),0);

    }
    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }
}