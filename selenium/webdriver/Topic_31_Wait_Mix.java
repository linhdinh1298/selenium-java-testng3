package webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_31_Wait_Mix {

    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Element_Found(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.get("https://live.techpanda.org/index.php/customer/account/login/");
        // Wait vs Explicit
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#email")));

        // Wait vs Implicit
        driver.findElement(By.cssSelector("input#email"));
    }
    @Test
    public void TC_02_Element_Not_Found_Only_Implicit(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://live.techpanda.org/index.php/customer/account/login/");

        // Wait vs Implicit
        driver.findElement(By.cssSelector("input#automation"));
    }
    @Test
    public void TC_03_Element_Not_Found_Only_Explicit_By(){
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(3));
        driver.get("https://live.techpanda.org/index.php/customer/account/login/");

        // Wait vs Explicit
        // Implicit = 0
        // Explicit = 3
        By emailTextBoxBy = By.cssSelector("input#automation");
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(emailTextBoxBy));
        // TC Failed ở time là 3s
    }
    @Test
    public void TC_03_Element_Not_Found_Only_Explicit_WebElement(){
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(3));
        driver.get("https://live.techpanda.org/index.php/customer/account/login/");

        // Wait vs Explicit
        // Implicit = 0
        // Explicit = 3
        explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input#automation"))));
        // TC Failed ở time là 0s, vì sẽ chạy hàm driver.findElement trước > mà implicit đang set = 0 => Failed
    }
    @Test
    public void TC_04_Element_Not_Found_Mix(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(8));
        driver.get("https://live.techpanda.org/index.php/customer/account/login/");

        // Wait vs Explicit
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#automation")));
    }



    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }
}