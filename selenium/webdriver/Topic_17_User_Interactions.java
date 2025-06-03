package webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
public class Topic_17_User_Interactions {
    WebDriver driver;
    Actions action;
    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        action = new Actions(driver);
    }
    @Test
    public void TC_01_Hover_jQuery() throws InterruptedException {
        driver.get("https://automationfc.github.io/jquery-tooltip/");
        Thread.sleep(3000);
        action.moveToElement(driver.findElement(By.cssSelector("input#age"))).perform();
        Assert.assertTrue(driver.findElement(By.cssSelector("div.ui-tooltip-content")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.cssSelector("div.ui-tooltip-content")).getText(),"We ask for your age only for statistical purposes.");
    }
    @Test
    public void TC_03_Hover_Fahasa() throws InterruptedException {
        driver.get("https://www.fahasa.com/");
        action.moveToElement(driver.findElement(By.cssSelector("span.icon_menu"))).perform();
        Thread.sleep(1000);
        action.moveToElement(driver.findElement(By.xpath("//span[@class='menu-title' and text()='Sách Trong Nước']"))).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='fhs_column_stretch']//a[text()='Kỹ Năng Sống']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ol[@class='breadcrumb']//strong[text()='Kỹ năng sống']")).isDisplayed());
    }
    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }
}