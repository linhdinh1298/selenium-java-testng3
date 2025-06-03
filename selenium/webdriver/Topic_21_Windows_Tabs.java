package webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Topic_21_Windows_Tabs {

    WebDriver driver;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Github() throws InterruptedException {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        // ID của driver vs id của window là khác nhau nhé
        // Lấy ra ID của window/tab mà driver đang active
        String githubWindowID = driver.getWindowHandle();

        // Click vào Google link > bật lên tab mới và tự nhảy qua (theo business)
        // Về code Selenium là driver không tự nhảy qua, nó vẫn ở tab cũ
        driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
        Thread.sleep(2000);

        // Switch qua tab Google
        switchToWindowByID(githubWindowID);
        Thread.sleep(2000);
        String googleWindowID = driver.getWindowHandle();

        driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("selenium");
        Thread.sleep(2000);

        // Switch về tab Selenium
        switchToWindowByID(googleWindowID);
        Thread.sleep(2000);

        // Click vào Facebook link
        driver.findElement(By.xpath("//a[text()='FACEBOOK']")).click();
        Thread.sleep(2000);

        // Switch vào tab Facebook by Title
        switchToWindowByTitle("Facebook – log in or sign up");
        Thread.sleep(2000);

        closeAllWindow(githubWindowID);
    }

    @Test
    public void TC_02_TechPanda() throws InterruptedException {
        driver.get("http://live.techpanda.org/");
        // Click on Mobile
        driver.findElement(By.xpath("//a[text()='Mobile']")).click();
        // Add sp Sony Xperia to compare
        driver.findElement(By.xpath("//a[text()='Sony Xperia']/parent::h2"
                +"/following-sibling::div[@class='actions']//a[@class='link-compare']")).click();
        // Verify message: The product Sony Xperia has been added to comparison list
        Assert.assertEquals(driver.findElement(By.cssSelector("li[class='success-msg'] span")).getText()
                ,"The product Sony Xperia has been added to comparison list.");
        // Add sp Samsung galaxy to compare
        // Verify message: The product Samsung galaxy has been added to comparison list
        driver.findElement(By.xpath("//a[text()='Samsung Galaxy']/parent::h2"
                +"/following-sibling::div[@class='actions']//a[@class='link-compare']")).click();
        // Verify message: The product Sony Xperia has been added to comparison list
        Assert.assertEquals(driver.findElement(By.cssSelector("li[class='success-msg'] span")).getText()
                ,"The product Samsung Galaxy has been added to comparison list.");
        // Click to compare
        driver.findElement(By.cssSelector("button[title='Compare']")).click();
        // Switch to new window that contains 2 compare product
        switchToWindowByTitle("Products Comparison List - Magento Commerce");
        Thread.sleep(3000);
        // Verify title of window/tab
        Assert.assertEquals(driver.getTitle(),"Products Comparison List - Magento Commerce");
        // Close tab and switch to parent window
        driver.findElement(By.cssSelector("button[title='Close Window']")).click(); // cách 1
        // driver.close(); cách 2
        // Click clear all link and accept alert
        switchToWindowByTitle("Mobile");
        driver.findElement(By.xpath("//a[text()='Clear All']")).click();
        Assert.assertEquals(driver.switchTo().alert().getText()
                ,"Are you sure you would like to remove all products from your comparison?");
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        // Verify message display: The comparison list was cleared
        Assert.assertEquals(driver.findElement(By.cssSelector("li[class='success-msg'] span")).getText()
              ,"The comparison list was cleared.");


    }

    @Test
    public void TC_03_Cambridge() throws InterruptedException {
        driver.get("https://dictionary.cambridge.org/vi/");
        driver.findElement(By.cssSelector("span.cdo-login-button")).click();
        switchToWindowByTitle("Login");
        driver.findElement(By.cssSelector("input[value='Log in']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("input[name='username']~span.gigya-error-msg-active")).getText()
                ,"This field is required");
        Assert.assertEquals(driver.findElement(By.cssSelector("input[name='password']~span.gigya-error-msg-active")).getText()
                ,"This field is required");
        driver.close();
        switchToWindowByTitle("Cambridge Dictionary | Từ điển tiếng Anh, Bản dịch & Từ điển từ đồng nghĩa");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input#searchword")).sendKeys("code");
        driver.findElement(By.cssSelector("button[title='Tìm kiếm']")).click();
    }

    @Test
    public void TC_04_Selenium4X() throws InterruptedException {
        driver.get("http://live.techpanda.org/");
        // Hành vi này giống Business, end user thao
        // Khi nhảy qua tab mới thì nó tự switch luôn
        driver.findElement(By.xpath("//a[text()='Mobile']")).click();
        Thread.sleep(2000);

        driver.switchTo().newWindow(WindowType.WINDOW).get("http://live.techpanda.org/index.php/customer/account/");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[@title='Login']")).click();
        // Verify
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-required-entry-email")).getText(),"This is a required field.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-required-entry-pass")).getText(),"This is a required field.");

        // Muốn quay lại tab Mobile thì phải switch về lại
        switchToWindowByTitle("Mobile");
        Thread.sleep(3000);


        driver.findElement(By.xpath("//a[text()='Sony Xperia']/parent::h2"
                +"/following-sibling::div[@class='actions']//a[@class='link-compare']")).click();
        // Verify message: The product Sony Xperia has been added to comparison list
        Assert.assertEquals(driver.findElement(By.cssSelector("li[class='success-msg'] span")).getText()
                ,"The product Sony Xperia has been added to comparison list.");


    }


    // Hàm close window/tab
    private void closeAllWindow(String githubWindowID) throws InterruptedException {
        // Close all tab/window # Github
        Set<String> allWindowID = driver.getWindowHandles();
        // Dùng vòng lặp duyệt qua từng ID
        for (String id: allWindowID){
            if(!id.equals(githubWindowID)) {
                driver.switchTo().window(id);
                Thread.sleep(2000);
                driver.close();
            }
        }
        // Sau khi close, driver đang ở vị trí của tab/window cuối cùng, cần switch về lại
        driver.switchTo().window(githubWindowID);
    }

    // Hàm dùng cho TH có nhiều Window/Tab
    private void switchToWindowByTitle(String expectedPageTitle) {
        Set<String> allWindowID = driver.getWindowHandles();
        // Dùng vòng lặp duyệt qua từng ID
        for (String id: allWindowID){
            // Mỗi lần duyệt sẽ cho switch vào trước, sau đó get title, nếu đúng với title thì dừng
            driver.switchTo().window(id);
            // Get ra title của window/page hiện tại
            String pageTitle = driver.getTitle();
            // Kiểm tra title
            if(pageTitle.equals(expectedPageTitle)){
                break;
            }
        }
    }

    // Hàm dưới chỉ đúng với TH: chỉ có 2 Window/Tab
    private void switchToWindowByID(String WindowID) {
        // Lấy ra all ID của window - tab hiện tại
        Set<String> allWindow = driver.getWindowHandles();
        // Dùng vòng lặp để duyệt qua từng ID
        for (String id: allWindow){
            // Kiểm tra điều kiện: nếu ID nào khác với ID mong đợi thì switch qua
            if(!id.equals(WindowID)){
                driver.switchTo().window(id);
                driver.switchTo().window(id);
            }
        }
    }



    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }
}