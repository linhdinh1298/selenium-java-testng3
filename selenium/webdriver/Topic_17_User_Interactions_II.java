package webdriver;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;
public class Topic_17_User_Interactions_II {
    WebDriver driver;
    Actions action;
    String osName = System.getProperty("os.name"); // kiểm tra hệ điều hành
    Keys key;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        action = new Actions(driver);
        // Cách 1
        if(osName.startsWith("Window")){
            key = Keys.CONTROL;
        } else {
            key = Keys.COMMAND;
        }
        // Cách 2: dùng toán tử 3 ngôi trong java
        // key = osName.startsWith("Window") ? Keys.CONTROL : Keys.COMMAND;
    }
    @Test
    public void TC_01_Click_And_Hold_Block() throws InterruptedException {
        driver.get("https://automationfc.github.io/jquery-selectable/");
        List<WebElement> allNumber = driver.findElements(By.cssSelector("ol#selectable li"));
        Assert.assertEquals(allNumber.size(),20);
        action.clickAndHold(allNumber.get(0)) // Click vào số 1 và giữ chuột
                .moveToElement(allNumber.get(3)) // Di chuột tới số 4
                .release() // Nhả chuột trái ra - kết thúc cho sự kiện click and hold
                .perform(); // Thực thi các câu lệnh trên
        Thread.sleep(3000);
        List<WebElement> allNumberSelected = driver.findElements(By.cssSelector("ol#selectable li.ui-selected"));
        Assert.assertEquals(allNumberSelected.size(),4);
    }

    @Test
    public void TC_02_Click_And_Hold_Random() {
        driver.get("https://automationfc.github.io/jquery-selectable/");
        List<WebElement> allNumber = driver.findElements(By.cssSelector("ol#selectable li"));
        Assert.assertEquals(allNumber.size(),20);

        // Nhấn phím ctrl nhưng chưa nhả
        action.keyDown(key).perform();
        // Click vào các số 1,4,6,8,10
        action.click(allNumber.get(0))
                .click(allNumber.get(3))
                .click(allNumber.get(5))
                .click(allNumber.get(7))
                .click(allNumber.get(9))
                .pause(Duration.ofSeconds(3))
                .perform();
        // Nhả phím ctrl
        action.keyUp(key).perform();
        // Verify các số được chọn
        List<WebElement> allNumberSelected = driver.findElements(By.cssSelector("ol#selectable li.ui-selected"));
        Assert.assertEquals(allNumberSelected.size(),5);
    }

    @Test
    public void TC_03_Double_click() throws InterruptedException {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        WebElement element = driver.findElement(By.xpath("//button[@ondblclick ='doubleClickMe()']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(3000);

        // Thử lại với scroll to element = selenium : chỉ dùng được với ChromeDriver or Edge
//        action.scrollToElement(driver.findElement(By.xpath("//button[@ondblclick ='doubleClickMe()']"))).perform();

        Thread.sleep(3000);
        action.doubleClick(driver.findElement(By.xpath("//button[@ondblclick ='doubleClickMe()']"))).perform();
        Assert.assertEquals(driver.findElement(By.cssSelector("p#demo")).getText(),"Hello Automation Guys!");


    }

    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }
}








