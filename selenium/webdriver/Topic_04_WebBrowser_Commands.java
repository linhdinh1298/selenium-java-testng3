package webdriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Topic_04_WebBrowser_Commands {

    // 1-Setup: OS/Browser/Web/Page/Data/Variable/Object/...
    WebDriver driver;

    @BeforeClass
    public void initialBrowser() throws MalformedURLException {
        // Run with browser (local)
        driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver = new EdgeDriver();
        driver = new SafariDriver();
        driver = new InternetExplorerDriver();

        // Run on Remote (Docker/ Grid/ Cloud Testing)
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444"), chromeOptions);

    }

    // 2-Action/Execute: Element/input data/verify/...
    @Test
    public void TC_01_(){

        // Mở ra 1 URL bất kì (bắt đầu = http or https)
        // String homepageURL = "https://demo.nopcommerce.com/";
        // driver.get("homepageURL"); // cach 1

        driver.get("https://demo.nopcommerce.com/"); // cach 2

        // Đóng browser ( Đóng active tab/window: nơi mà driver đang thao tác)
        driver.close();

        // Đóng browser (Tất cả các tab/ window)
        driver.quit();

        // Lấy ra title của page hiện tại
        // Lưu dữ liệu lại rồi kiểm tra sau
        String homePageTitle = driver.getTitle();
        Assert.assertEquals(homePageTitle,"nopCommerce demo store. Home page title");
        Assert.assertTrue(homePageTitle.contains("nopCommerce")); // => dùng 2 lần thì nên khai báo biến

        // Kiểm tra dữ liệu trực tiếp
        Assert.assertEquals(driver.getTitle(),"nopCommerce demo store. Home page title");

        // Lấy ra URL của page hiện tại
        driver.getCurrentUrl();

        // Lấy ra page source code
        String homepageSourceCode = driver.getPageSource();
        // Kiểm tra tính tương đối
        Assert.assertTrue(homepageSourceCode.contains(""));

        // Lấy ra ID của active Tab/ Window
        driver.getWindowHandle();

        // Lấy ra all ID của Tab/Window
        driver.getWindowHandles();

        // Tìm 1 element
        driver.findElement(By.xpath(""));

        // Tìm nhiều elemenent
        driver.findElements(By.xpath(""));

        WebDriver.Timeouts timeouts = driver.manage().timeouts();
        WebDriver.Window window = driver.manage().window();

        timeouts.implicitlyWait(Duration.ofSeconds(15)); // Dùng để chờ cho việc tìm nhiều
        timeouts.pageLoadTimeout(Duration.ofSeconds(15)); // Chờ page load xong, thực tế k dùng
        timeouts.scriptTimeout(Duration.ofSeconds(15)); // Chờ script thực thi xong, thực tế k

        window.maximize(); // phóng to browser để chạy, vẫn còn taskbar
        window.minimize(); // thu nhỏ browser về taskbar để chạy
        window.fullscreen(); // phóng to browser để chạy, không còn taskbar
        // Responsive
        window.getSize();
        window.setSize(new Dimension(1920,1080));

        window.getPosition();
        window.setPosition(new Point(0,0));


        // Lấy all cookies: Test class 01 (Register tài khoản - lưu cookie lại)
        Set<Cookie> cookies = driver.manage().getCookies();
        driver.manage().getCookies();

        // Delete cookie
        driver.manage().deleteCookieNamed("");
        driver.manage().deleteAllCookies();

        // driver.manage().deleteCookie(); => dùng vòng lặp để xoá, xoá cookie theo thứ tự
        for (Cookie cookie : cookies) {
            driver.manage().deleteCookie(cookie);
        }

        // Lấy cookie khi truyền vào cookie name > F12> > Cookies
        driver.manage().deleteCookieNamed("");

        // Add cookie theo thứ tự
        // Đến 1 Test class khác 02/03/04... => Không cần login, set cookie đã lưu vào rồi refresh lại là được
        for (Cookie cookie : cookies) {
            driver.manage().addCookie(cookie);
        }
        driver.navigate().refresh(); // -> login thành công mà không cần thao tác

        Logs log = driver.manage().logs();
        LogEntries logEntries = log.get("BROWSER");

        for (LogEntry logEN: logEntries) {
            System.out.println(logEN);
        }
        log.getAvailableLogTypes();

        WebDriver.Navigation navigation = driver.navigate();
        navigation.refresh();
        navigation.back();
        navigation.forward();
        navigation.to(""); // Mở URL bất

        // Alert/ Iframe/ Window (Tab)
        WebDriver.TargetLocator targetLocator = driver.switchTo();

        // Alert
        targetLocator.alert().accept();
        targetLocator.alert().dismiss();

        // Frame/ iframe
        targetLocator.frame("");
        targetLocator.defaultContent();

        // Window
        targetLocator.window("");



    }
    @Test
    public void TC_02_Regist(){

    }
    // 3-Clean: Delete data test/ account/ close browser/...
    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }
}