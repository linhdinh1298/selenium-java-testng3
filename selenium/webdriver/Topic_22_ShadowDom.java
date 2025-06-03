package webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_22_ShadowDom {
    WebDriver driver;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_(){
        driver.get("https://automationfc.github.io/shadow-dom");

        // NOTE: ShadowDom chỉ support CSS, không dùng được với Xpath

        // Element thuộc Dom cha bên ngoài
        driver.findElement(By.xpath("//a[text()='scroll.html']"));

        // Element cha chưa shadow host
        WebElement shadowHostParent = driver.findElement(By.cssSelector("div#shadow_host"));
        // Lấy ra Element shadowRoot
        SearchContext firstShadow = shadowHostParent.getShadowRoot();
        Assert.assertEquals(firstShadow.findElement(By.cssSelector("span.info")).getText(),"some text");
        Assert.assertTrue(firstShadow.findElement(By.cssSelector("input[type='file']")).isDisplayed());

        // WebElement chưa shadow host thứ 2
        WebElement firstShadowHostParent = firstShadow.findElement(By.cssSelector("div#nested_shadow_host"));
        // Lấy ra Element shadowRoot
        SearchContext secondShadow = firstShadowHostParent.getShadowRoot();
        Assert.assertEquals(secondShadow.findElement(By.cssSelector("div#nested_shadow_content>div")).getText(),"nested text");

    }
    @Test
    public void TC_02_() throws InterruptedException {
        driver.get("https://books-pwakit.appspot.com/");
        Thread.sleep(5000);
        WebElement firstShaHostElement = driver.findElement(By.xpath("//book-app"));
        SearchContext firstShadowHost = firstShaHostElement.getShadowRoot();

        WebElement secondShaHostElement = firstShadowHost.findElement(By.cssSelector("book-input-decorator"));
        SearchContext secondShadowHost = secondShaHostElement.getShadowRoot();

        firstShadowHost.findElement(By.cssSelector("input#input")).sendKeys("Harry Potter");
        secondShadowHost.findElement(By.cssSelector("div.icon")).click();
        Thread.sleep(3000);

        WebElement thirdShaHostElement = firstShadowHost.findElement(By.cssSelector("book-explore"));
        SearchContext thirdShadowHost = thirdShaHostElement.getShadowRoot();

        WebElement forthShaHostElement = thirdShadowHost.findElement(By.cssSelector("ul>li:nth-of-type(1)>book-item"));
        SearchContext forthShadowHost = forthShaHostElement.getShadowRoot();
        Assert.assertEquals(forthShadowHost.findElement(By.cssSelector("h2.title")).getText(),"The Ultimate Harry Potter and Philosophy");

        // In ra 20 title của các sản phẩm





    }

    @AfterClass
    public void cleanBrowser(){
        //driver.quit();
    }
}