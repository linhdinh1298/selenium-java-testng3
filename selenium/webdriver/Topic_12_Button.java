package webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_12_Button {
    WebDriver driver;
    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
    }
    @Test
    public void TC_01_Fahasa(){
        driver.get("https://www.fahasa.com/customer/account/create");
        driver.findElement(By.cssSelector("li.popup-login-tab-login")).click();
        By loginButton = By.cssSelector("button.fhs-btn-login");
        Assert.assertFalse(driver.findElement(loginButton).isEnabled());
        // Kiểm tra màu nền
//        String loginBackgroundColor = driver.findElement(loginButton).getCssValue("background-color");
//
//        // Convert mã màu từ GRBA -> Hex
//        Color loginColor = Color.fromString(loginBackgroundColor);
//          loginColor.asHex().toUpperCase();
//        // Verify
//        Assert.assertEquals(loginColor.asHex().toUpperCase(),"#00000000");
        //  gộp 1 dòng code
        Assert.assertEquals(Color.fromString(driver.findElement(loginButton).getCssValue("background-color")).asHex().toUpperCase(),"#000000");
        driver.findElement(By.cssSelector("input#login_username")).sendKeys("linh@gmail.com");
        driver.findElement(By.cssSelector("input#login_password")).sendKeys("1234567");
        Assert.assertTrue(driver.findElement(loginButton).isEnabled());
        Assert.assertEquals(Color.fromString(driver.findElement(loginButton).getCssValue("background-color")).asHex().toUpperCase(),"#C92127");
        driver.findElement(loginButton).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div.fhs-login-msg")).getText(),"Số điện thoại/Email hoặc Mật khẩu sai!");
    }
    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }
}