package webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.regex.Pattern;

public class Topic_28_Explicit_Functions {

    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        // Khởi tạo: có 3 cách, chỉ dùng 2 cách phổ biến, đặc biệt cách 1
        // Cách 1: default polling time: 0,5s
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(10));
        // Cách 2: tự set polling time, vd bên dưới: polling time = 0.3s
        // explicitWait = new WebDriverWait(driver,Duration.ofSeconds(10),Duration.ofMillis(300));
        driver.manage().window().maximize();
        // Cách 3:
    }

    @Test
    public void TC_01_(){
        // Wait cho element biến mất và không còn trong HTML (trước đó có tồn tại)
        explicitWait.until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector(""))));
        // Wait cho element không hiển thị (còn\ không còn trong HTML cũng được)
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("")));
        // Wait cho element có trên UI (có trên UI + HTML)
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("")));
        // Wait cho element được phép click (button/ link/ radio/ checkbox/...)
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("")));
        // Wait cho URL của page tuyệt đối
        explicitWait.until(ExpectedConditions.urlToBe("https://automationfc.github.io/dynamic-loading/"));
        // Wait cho URL của page tương đối
        explicitWait.until(ExpectedConditions.urlContains("dynamic-loading"));
        // Wait cho URL của page thoả mãn biểu thức (Regex)
        explicitWait.until(ExpectedConditions.urlMatches("*$^..."));
        // Wait cho 1 đoạn JS trả về kiểu dữ liệu String
        explicitWait.until(ExpectedConditions.jsReturnsValue("return arguments[0].validationMessage;"));
        // Wait cho Alert xuất hiện trong HTML
        explicitWait.until(ExpectedConditions.alertIsPresent());
        // Wait cho title của page tuyệt đối
        explicitWait.until(ExpectedConditions.titleIs("Dynamic loading to demo wait in Selenium"));
        // Wait cho title của page tương đối
        explicitWait.until(ExpectedConditions.titleContains("Dynamic loading"));
        // Wait thoả mãn cả 2 điều kiện (AND)
        explicitWait.until(ExpectedConditions.and(ExpectedConditions.urlContains(""),ExpectedConditions.titleIs("")));
        // Wait thoả mãn 1 trong 2 điều kiện (OR)
        explicitWait.until(ExpectedConditions.or(ExpectedConditions.urlContains(""),ExpectedConditions.titleIs("")));
        // Wait cho 1 element có xuất hiện trong HTML
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("")));
        // Wait cho 1 element có thuộc tính = giá trị nào đó
        explicitWait.until(ExpectedConditions.attributeToBe(By.cssSelector(""),"class","email"));
        // Wait cho 1 element có thuộc tính không được null
        explicitWait.until(ExpectedConditions.attributeToBeNotEmpty(driver.findElement(By.cssSelector("")),"class"));
        // Wait cho 1 element có thuộc tính trong DOM = 1 giá trị nào đó
        explicitWait.until(ExpectedConditions.domAttributeToBe(driver.findElement(By.cssSelector("")),
                "baseURI","https://automationfc.github.io/dynamic-loading/"));

        explicitWait.until(ExpectedConditions.domPropertyToBe(driver.findElement(By.cssSelector("")),
                "",""));
        // Wait cho đã được chọn thành công (Checkbox/ radio/ Dropdown Items)
        explicitWait.until(ExpectedConditions.elementToBeSelected(By.cssSelector("")));
        // Wait cho đã được chọn thành công (Checkbox/ radio/ Dropdown Items)
        explicitWait.until(ExpectedConditions.elementSelectionStateToBe(By.cssSelector(""),true));
        // Wait cho chưa được chọn thành công (Checkbox/ radio/ Dropdown Items)
        explicitWait.until(ExpectedConditions.elementSelectionStateToBe(By.cssSelector(""),false));
        // Wait cho frame/iframe xuất hiện và switch vào
        explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("")));
        // Wait cho 1 đoạn lệnh JS được thực thi, không trả về bất kì 1 exception nào hết
        explicitWait.until(ExpectedConditions.javaScriptThrowsNoExceptions("return arguments[0].validationMessage;"));
        // Phủ định lại điều kiện Wait
        explicitWait.until(ExpectedConditions.not(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector("")))));
        // Wait cho 1 list element = ? items
        explicitWait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(""),5));
        // Wait cho 1 list element < or > ? items
        explicitWait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.cssSelector(""),5));
        explicitWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(""),5));

        // Wait số lượng Window/ tab bao nhiêu
        explicitWait.until(ExpectedConditions.numberOfWindowsToBe(5));
        // Wait cho 1 đoạn text bằng tuyệt đối, dùng trước hàm getText()
        explicitWait.until(ExpectedConditions.textToBe(By.cssSelector(""),""));
        // Wait cho 1 đoạn text bằng tuyệt đối, dùng trước hàm getText()
        explicitWait.until(ExpectedConditions.textMatches(By.cssSelector(""), Pattern.compile("a*b")));
        // Wait cho 1 element hay bị change/ update/ refresh lại
        explicitWait.until(ExpectedConditions.refreshed(ExpectedConditions.numberOfWindowsToBe(5)));


    }
    @Test
    public void TC_02_(){

    }

    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }
}