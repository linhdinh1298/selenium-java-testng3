package webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class Topic_30_Explicit_Exercise_Ajax {

    WebDriver driver;
    WebDriverWait explicitWait;
    String uploadFolderPath = System.getProperty("user.dir") + File.separator + "uploadFiles" + File.separator;
    // Dùng File.separator sẽ tự động detect được dùng \ trên máy Mac và / trên Window
    String firstImage = "download.jpeg";
    String secondImage = "download (1).jpeg";
    String thirdImage = "download (2).jpeg";

    String firstImagePath = uploadFolderPath + firstImage;
    String secondImagePath = uploadFolderPath + secondImage;
    String thirdImagePath = uploadFolderPath + thirdImage;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_Calender() {
        driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
        // Wait and Verify calendar element is displayed
        Assert.assertTrue(explicitWait.until(ExpectedConditions.
                visibilityOfElementLocated(By.cssSelector("div#ctl00_ContentPlaceholder1_Panel1"))).isDisplayed());

        // Wait and verify text
        Assert.assertTrue(explicitWait.until(ExpectedConditions.
                textToBe(By.cssSelector("span#ctl00_ContentPlaceholder1_Label1"),"No Selected Dates to display.")));

        // Wait and click to element
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td/a[text()='8']"))).click();

        // Wait and verify cho ajax loading invisible
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[id$='RadCalendar1']>div.raDiv"))));

        // Wait and verify text
        Assert.assertTrue(explicitWait.until(ExpectedConditions.
                textToBe(By.cssSelector("span#ctl00_ContentPlaceholder1_Label1"),"Sunday, June 8, 2025")));
    }

    @Test
    public void TC_02_Go_File() throws InterruptedException {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://gofile.io/?t=uploadFiles");
        // Wait cho loading icon ở màn hình upload không còn hiển thị
//        Assert.assertTrue(explicitWait.until(ExpectedConditions.
//                invisibilityOfElementLocated(By.cssSelector("div.animate-spin"))));

        By inputFile = By.cssSelector("input[type='file']");

        driver.findElement(inputFile).sendKeys(firstImagePath + "\n" + secondImagePath + "\n" + thirdImagePath);
        Thread.sleep(2000);

        // Wait cho loading icon ở màn hình load file lên biến mất
        Assert.assertTrue(explicitWait.until(ExpectedConditions.
                invisibilityOfElementLocated(By.cssSelector("div.animate-spin"))));

        // Wait cho các progress bar biến mất
        Assert.assertTrue(explicitWait.until(ExpectedConditions.
                invisibilityOfAllElements(driver.findElements(By.cssSelector("div.processing-indicator")))));

        // Wait và kiểm tra text hiển thị
        Assert.assertTrue(explicitWait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//h2[text()='Upload Complete']"))).isDisplayed());

        // Wait và click vào link
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.linkSuccessCard"))).click();

        // Wait cho icon loading biến mất
        Assert.assertTrue(explicitWait.until(ExpectedConditions.
                invisibilityOfAllElements(driver.findElements(By.cssSelector("div#filemanager_loading div.animate-spin")))));

    }

    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }
}