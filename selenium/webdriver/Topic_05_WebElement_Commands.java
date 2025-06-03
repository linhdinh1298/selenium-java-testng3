package webdriver;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_05_WebElement_Commands {
    WebDriver driver;
    @Test
    public void TC_01_WebElement() {
        // Dùng 1 làn
        driver.findElement(By.xpath("")).click();
        // Khai báo biến dùng n lần
        WebElement element = driver.findElement(By.xpath(""));

        // Click vào các element dạng: button/ checkbox/ link/ image/ icon,...
        element.click();

        // Nhập liệu vào các element dạng textbox/ textarea/ dropdown (edit)
        element.clear(); // xóa dữ liệu trước khi send key
        element.sendKeys(""); // nhập dạng string
        element.sendKeys(Keys.ENTER); // dùng keys (bàn phím  trên máy), vd: bấm enter thay button Login

        driver.findElement(By.cssSelector("div.login-page"))
                .findElement(By.cssSelector("div.customer-blocks"))
                .findElement(By.id("Email")); // cách 1

        driver.findElement(By.cssSelector("div.login-page div.customer-blocks input#Email")); // cách 2

        element.submit(); // Chỉ có tác dụng với thẻ Form (SignUp/ Login/ Search/...)
        driver.findElement(By.id("Email")).sendKeys("");
        driver.findElement(By.id("Password")).sendKeys("");
        driver.findElement(By.id("Password")).submit();

        // áp dụng cho tất cả các loại Elements/ kiểm tra 1 element có hiển thị hay không
        // 1 Element có hiển thị: có width/height > 0. Nhìn thấy, thao tác được
        element.isDisplayed();
        Assert.assertTrue(element.isDisplayed()); // mong đợi là hiển thị
        Assert.assertFalse(element.isDisplayed()); // mong đợi là không hiển thị

        // áp dụng cho 3 loại: radio/ checkbox/ dropdown dạng default
        // Kiểm tra 1 element đã được chọn rồi hay chưa
        element.isSelected();

        // áp dụng cho tất cả các element
        // kiểm tra 1 element có disable hay chưa
        element.isEnabled();

        // Test GUI: font/ size/ color/ position/ location
        element.getCssValue("background-color"); //#f82735

        // Áp dụng cho all element contain text: Lable/ Link/ Button/ Header,..
        element.getText();

        element.getAttribute("Placeholder");

        Dimension dimensionBrowser = driver.manage().window().getSize();
        // chiều rộng, chiêu cao của element
        Dimension dimensionElement = element.getSize();

        Point pointBrowser = driver.manage().window().getPosition();
        // Vị trí của element so với viewport
        Point pointElement = element.getLocation();

        Rectangle RectElement = element.getRect(); // tổng hợp get Size & Location
        // get size
        RectElement.getWidth();
        RectElement.getHeight();
        RectElement.getDimension();
        // get location
        RectElement.getX();
        RectElement.getY();
        RectElement.getPoint();

        // Lấy ra thẻ html của element đó
        String tagname = driver.findElement(By.cssSelector("")).getTagName(); // get tagname của element A
        driver.findElement(By.xpath("//"+tagname+ "[@id='LastName")); // tag name A truyền bào B

        // Tab Accessibility/ Properties ở trong Elements ở Chrome
        element.getAccessibleName();
        element.getAriaRole();
        element.getDomAttribute("");
        element.getDomProperty("");

        // Popup
        element.getShadowRoot();

        // Framework: HTML report
        element.getScreenshotAs(OutputType.BASE64);
        element.getScreenshotAs(OutputType.FILE);
        element.getScreenshotAs(OutputType.BYTES);
    }
}