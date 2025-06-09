package webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class Topic_32_Fluent_Wait {

    WebDriver driver;
    WebDriverWait explicitWait;
//    FluentWait <WebDriver> driverFluentWait;
//    FluentWait <WebElement> elementFluentWait;
//    FluentWait <WebDriver> stringFluentWait;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
    }

    @Test
    public void TC_01_Dynamic_Loading_01() {
        driver.get("https://automationfc.github.io/dynamic-loading/");
        findElement(30,100,By.cssSelector("div#start button")).click();
        Assert.assertEquals(getElementText(By.cssSelector("div#finish h4")),"Hello World!");
    }
    @Test
    public void TC_01_Dynamic_Loading_02() {
        driver.get("https://automationfc.github.io/dynamic-loading/");
        findElement(30,100,By.cssSelector("div#start button")).click();
        Assert.assertTrue(isElementDisplayed(By.xpath("//div[@id='finish']/h4[text()='Hello World!']")));
    }
    @Test
    public void TC_02_CountDown() {
        driver.get("https://automationfc.github.io/fluent-wait/");
        WebElement countDownTime = findElement(30,100,By.id("javascript_countdown_time"));
        Assert.assertTrue(isSecondMatching(countDownTime));
    }

    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }

    // Viết 1 hàm tìm element với timeout and polling tự set
    // Điều kiện của hàm sẽ là findElement: kiểu trả về của hàm apply
    // findElement thì cần có Driver: tham số của hàm apply

    public WebElement findElement(long timeout, long polling,By by ) {
        FluentWait <WebDriver> driverFluentWait = new FluentWait<>(driver);
        driverFluentWait.withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofMillis(polling))
                .ignoring(NoSuchElementException.class);
        return driverFluentWait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(by);
            }
        });

    }

    // Kiểm tra element hiển thị (hiển thị: là điều kiện)
    // isDisplayed: Boolean
    public boolean isElementDisplayed(By by ) {
        FluentWait <WebDriver> driverFluentWait = new FluentWait<>(driver);
        driverFluentWait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);
        return driverFluentWait.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return driver.findElement(by).isDisplayed();
            }
        });
    }
    // Nếu có sẵn element, thì dùng kiểu WebElement thay vì WebDriver
    // Kiểm tra element hiển thị (hiển thị: là điều kiện)
    // isDisplayed: Boolean
    public boolean isElementDisplayed(WebElement element ) {
        FluentWait <WebElement> driverFluentWait = new FluentWait<>(element);
        driverFluentWait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);
        return driverFluentWait.until(new Function<WebElement, Boolean>() {
            @Override
            public Boolean apply(WebElement driver) {
                return element.isDisplayed();
            }
        });

    }

    // Lấy ra 1 text của element (text: là điều kiện)
    // getText: String
    public String getElementText(By by ) {
        FluentWait <WebDriver> driverFluentWait = new FluentWait<>(driver);
        driverFluentWait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);
        return driverFluentWait.until(new Function<WebDriver, String>() {
            @Override
            public String apply(WebDriver driver) {
                return driver.findElement(by).getText();
            }
        });
    }

    // TC 02: CountDown
    public boolean isSecondMatching(WebElement element ) {
        FluentWait <WebElement> driverFluentWait = new FluentWait<>(element);
        driverFluentWait.withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(50))
                .ignoring(NoSuchElementException.class);
        return driverFluentWait.until(new Function<WebElement, Boolean>() {
            @Override
            public Boolean apply(WebElement driver) {
                return element.getText().endsWith("00");
            }
        });

    }
}