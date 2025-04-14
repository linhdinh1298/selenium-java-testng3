package Webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Topic_02_Selenium_Locator {

    // khai báo
    WebDriver driver;
    // WebDriver secondDriver;

    @BeforeClass
    public void initialBrowser() {
        // Open browser (khởi tạo biến driver lên - "new" là khởi tạo)
        driver = new FirefoxDriver();
        // secondDriver = new ChromeDriver();
        // Open app
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
    }

    @Test
    public void TC_01_ID(){
        driver.findElement(By.id("small-searchterms")).sendKeys("Macbook");
        // dùng với id > truyền toàn bộ giá trị của id vào
    }

    @Test
    public void TC_02_Class() throws InterruptedException {
        // không lấy hết toàn bộ giá trị nếu có space > chỉ lấy 1 phần or lấy toàn bộ nếu không có space> lấy
        driver.findElement(By.className("register-next-step-button")).click();
        Thread.sleep(3000);

    }

    @Test
    public void TC_03_Name(){
        driver.findElement(By.name("Gender"));
        // truyền toàn bộ giá trị của name vào

    }

    @Test
    public void TC_04_LinkText(){
        // chỉ làm việc vs Link và có text: là thẻ a và có thuộc tính href
        // Phải lấy hết toàn bộ text (cách lấy tuyệt đối)
        driver.findElement(By.linkText("Register"));
        driver.findElement(By.linkText("Shipping & returns"));
    }

    @Test
    public void TC_05_Partial_LinkText(){
        // chỉ làm việc với element là link
        // có thể lấy hết toàn bộ text or 1 phần (hay dùng)-nên lấy giá trị là duy nhất, vì sẽ dễ bị trùng với element#
        driver.findElement(By.partialLinkText("Shipping & returns"));
        driver.findElement(By.partialLinkText("Digital")); // lấy 1 phần Digital thay vì Digital downloads
    }

    @Test
    public void TC_06_TagName(){
        // Tên thẻ (HTML)
        // Khi nào dùng tagname?: khi tìm tất cả các element của component giống nhau
        // Tất cả các checkbox/radio /link / button,...
        driver.findElements(By.tagName("input"));
        driver.findElements(By.tagName("button"));

    }

    @Test
    public void TC_07_Css(){
        // dùng với id
        driver.findElement(By.cssSelector("input#Company")); //cách 1: cách rút gọn
        driver.findElement(By.cssSelector("#Company")); // cách 2: cách rút gọn
        driver.findElement(By.cssSelector("input[id='Company']")); // cách 3 (cú pháp chuẩn): tên thẻ[id='giá trị']

        // dùng với class
        driver.findElement(By.cssSelector("button.register-next-step-button")); // cách 1
        driver.findElement(By.cssSelector("button[class='button-1 register-next-step-button']"));
        // cách 2(cú pháp chuẩn): tên thẻ[class='(lấy toàn bộ giá trị sau dấu =)']

        // dùng với name: chỉ dùng cú pháp chuẩn
        driver.findElement(By.cssSelector("input[name='Gender']"));

        // dùng với linkText
        // khi dùng với linkText or partialLinkText, css mặc định không hỗ trợ text > dùng class or href nếu có
        driver.findElement(By.cssSelector("a[href='/register?returnUrl=%2F']"));
        // Hoặc lấy toàn bộ: dùng =

        // dùng với Partial_Link_Text
        driver.findElement(By.cssSelector("a[href*='register?']"));
        // Note *=: lấy 1 phần của href 'register?returnUrl=%2F'

        // dùng với tagName
        driver.findElement(By.cssSelector("a"));
        driver.findElement(By.cssSelector("button"));
        driver.findElement(By.cssSelector("input"));

    }

    @Test
    public void TC_08_Xpath(){
        driver.findElement(By.xpath("//input[@id='gender-male']")); // dùng với id
        // dùng với class lấy toàn bộ, sử dụng dấu =
        driver.findElement(By.xpath("//button[@class='button-1 search-box-button']"));
        // dùng với class lấy một phần, sử dụng contains, bỏ dấu = thay bằng dấu ,
        driver.findElement(By.xpath("//button[contains(@class,'search-box-button')]"));
        driver.findElement(By.xpath("//input[@name='Gender']")); // dùng với name
        driver.findElement(By.xpath("//a[text()='Register']")); // dùng với linkText
        driver.findElement(By.xpath("//a[contains(text(),'Register')]")); // dùng với partial_linkText
        driver.findElement(By.xpath("//a")); // dùng với tagName
        driver.findElement(By.xpath("//button")); // dùng với tagName



    }

    @Test
    public void TC_09_RelativeLocator(){
        driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");
    // Element/ By A
        By passwordTextboxBy = By.cssSelector("input[id='Password'");
        WebElement passwordTextbox = driver.findElement(By.cssSelector("input[id='Password']"));

    // Element/ By B
        By rememberMeCheckboxBy = By.name("RememberMe");

    // Element/ By C
        By forgotPasswordLinkBy = By.linkText("Forgot password?");
        WebElement forgotPassword = driver.findElement(By.cssSelector("span.forgot-password"));

    // Element/ By D
        By loginButtonBy = By.className("login-button");
    // Element/ By E
        driver.findElement(RelativeLocator.with(By.tagName("label"))
                .above(loginButtonBy)
                .below(passwordTextbox)
                .toLeftOf(forgotPassword)
                .toRightOf(rememberMeCheckboxBy)

        );
    }

    @Test
    public void TC_10_Xpath(){
        driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");
        //Xpath
        driver.findElement(By.xpath("//input[@id='Email']"));
        driver.findElement(By.xpath("//a[text()='Electronics']"));
    }


    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }
}
// <button type="button" class="button-1 register-button"
// onclick="if (!window.__cfRLUnblockHandlers) return false; location.href=&quot;https://demo.nopcommerce.com/register?returnUrl=%2Fclothing&quot;">Register</button>
// Interact on email textbox > need 8 types of locator to find this email address
// Tìm 1 element
       // driver.findElement(By.id(""));

// Thao tác lên luôn (dùng 1 lần): dùng 1 lần thì không cần khai báo biến
       // driver.findElement(By.id("")).click();

// Lưu dữ liệu lại (dùng nhiều lần): dùng nhiều lần thì nên khai báo biến (e.g biến "emailTexbox")
       // WebElement emailTextbox = driver.findElement(By.id("")); // 1 element
       // emailTextbox.clear();
       // emailTextbox.sendKeys();

       // List<WebElement> textboxs = driver.findElements(By.cssSelector("")); // n element thì dùng List



// Tìm nhiều element giống nhau
        // driver.findElements(By.cssSelector(""));

        // driver.findElement(By.cssSelector("")).click();

        // driver.findElement(By.cssSelector("")).getText();


//HTML source code

// <input type="text" class="inputtext _55r1 _6luy" name="email"
// id="email" data-testid="royal-email" placeholder="Email hoặc số điện thoại" autofocus="1" aria-label="Email
// hoặc số điện thoại">

// Thẻ - Thuộc tính - Giá trị thuộc tính
// Tag - Attribute - Value

// xPath: //tagname[@attribute='value']
// Css:   tagname[attribute='value']