package webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class Topic_24_Upload_File {

    WebDriver driver;
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_Single_Upload() throws InterruptedException {
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");
        By inputFile = By.cssSelector("input[type='file']");

        // 1 element đã khai báo trước đó nhưng vẫn mang ra sử dụng > bị lỗi: Stale element exception
        // Cần file element sau mỗi lần upload vì nếu khai báo biến 1 lần và sau đó send key liên tục sẽ bị lỗi trên

        // Load file - mỗi lần load 1 file

        driver.findElement(inputFile).sendKeys(firstImagePath);
        Thread.sleep(2000);

        driver.findElement(inputFile).sendKeys(secondImagePath);
        Thread.sleep(2000);

        driver.findElement(inputFile).sendKeys(thirdImagePath);
        Thread.sleep(2000);

        // Verify file
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+firstImage+"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+secondImage+"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+thirdImage+"']")).isDisplayed());

        // Click upload cho từng file
        List<WebElement> startButtons = driver.findElements(By.cssSelector("table button.start"));
        for (WebElement startButton: startButtons) {
            startButton.click();
            Thread.sleep(2000);
        }

        // Verify các file được upload thành công
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+firstImage+"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+secondImage+"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+thirdImage+"']")).isDisplayed());


    }
    @Test
    public void TC_02_Multiple_Upload() throws InterruptedException {
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");
        By inputFile = By.cssSelector("input[type='file']");

        // 1 element đã khai báo trước đó nhưng vẫn mang ra sử dụng > bị lỗi: Stale element exception
        // Cần file element sau mỗi lần upload vì nếu khai báo biến 1 lần và sau đó send key liên tục sẽ bị lỗi trên

        // Load file - mỗi lần load n file ( thẻ phải cho upload nhiều file cùng lúc (có thuộc tính multiple)

        driver.findElement(inputFile).sendKeys(firstImagePath + "\n" + secondImagePath + "\n" + thirdImagePath);
        Thread.sleep(2000);

        // Verify file
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+firstImage+"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+secondImage+"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+thirdImage+"']")).isDisplayed());

        // Click upload cho từng file
        List<WebElement> startButtons = driver.findElements(By.cssSelector("table button.start"));
        for (WebElement startButton: startButtons) {
            startButton.click();
            Thread.sleep(2000);
        }

        // Verify các file được upload thành công
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+firstImage+"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+secondImage+"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+thirdImage+"']")).isDisplayed());

    }

    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }
}