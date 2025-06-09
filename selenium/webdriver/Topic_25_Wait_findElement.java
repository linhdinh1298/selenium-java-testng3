package webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_25_Wait_findElement {

    WebDriver driver;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        // Set total time là 15s
        // Nếu set = 0 thì đánh fail TC luôn
        // Nếu không  implicitWait luôn thì findElement nhận tgian = 0 > Fail TC luôn
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // Hàm implicitWait chỉ ảnh huởng đến việc FindElement
    }
    @Test
    public void TC_01_FindElement(){
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
        // Nếu tìm thấy duy nhất 1 element
        // Output: Trả về đúng element
        // Không cần chờ hết time của implicit
        driver.findElement(By.cssSelector("input#FirstName"));

        // Nếu tìm thấy nhiều hơn 1 element > lấy element đầu tiên để thao tác
        // => Khi lấy Locator nên check trước element là duy nhất > tránh trường hợp tìm thấy nhiều element
        driver.findElement(By.cssSelector("input[type='text']")).sendKeys("Testing");

        // Nếu không tìm thấy element
        // Vào tìm mà không thấy > tìm lại > không thấy > đánh fail testcase
        // Show lỗi: NoSuchElementException
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // Nếu set implicitWait ở đây thì vẫn sẽ apply cho all element từ đây trở xuống, kể cả TC02
        driver.findElement(By.cssSelector("input#RememberMe"));

    }
    @Test
    public void TC_02_FindElements(){
        List<WebElement> elements = null;
        // Hàm FindElements
        // Tìm all element với locator
        // Bị ảnh hưởng bởi implicitWait

        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
        // Nếu tìm thấy duy nhất 1 element
        elements = driver.findElements(By.cssSelector("input#FirstName"));
        System.out.println(elements.size());

        // Nếu tìm thấy nhiều hơn 1 element
        // Trả về list element với all element được tìm thấy
        elements = driver.findElements(By.cssSelector("input[type='text']"));
        System.out.println(elements.size());

        // Nếu không tìm thấy
        // Tìm lại và hết tổng thời gian thì:
        // + Trả về list = 0
        // + KHÔNG ĐÁNH FAIL TEST CASE
        elements = driver.findElements(By.cssSelector("input#RememberMe"));
        System.out.println(elements.size());
        Assert.assertEquals(elements.size(),0);

    }

    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }
}