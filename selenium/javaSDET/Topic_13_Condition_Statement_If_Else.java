package javaSDET;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class Topic_13_Condition_Statement_If_Else {
    WebDriver driver;
    @Test
    public void TC_01_If() {
        boolean status = 3<5;
        System.out.println(status);

        // Hàm if sẽ nhận vào 1 điều kiên đúng
        // Kiểm tra duy nhất 1 điều kiện
        // Nếu điều kiện đúng thì action
        if(status){
            // Đúng thì vào phần thân của If
            // Sai thì bỏ qua
            System.out.println("Go to If");
        }
        WebDriver driver = new FirefoxDriver();
        // Nếu element luôn có trong DOM dù popup có hiển thị hay không thì có thể dùng hàm if ở bên dưới
        WebElement salePopup = driver.findElement(By.cssSelector(""));
        if(salePopup.isDisplayed()){

        }

        // Nếu element không trong DOM khi popup bị đóng thì có thể dùng hàm if với List element => hàm if sẽ không bị lỗi
        // Vì khi dùng List, nếu không có data thì trả về list rỗng chứ không bị Failed
        List<WebElement> salePopups = driver.findElements(By.cssSelector(""));
        if(salePopups.size()>0 && salePopups.get(0).isDisplayed()){

        }

    }

    @Test
    public void TC_02_If_Else(){
        // Có 2 điều kiện, nếu đúng thì vào If, nếu sai thì vào Else
        // DK1: Nếu driver start với browser như Chrome, Firefox, Edge, Safari thì dùng hàm click thông thường của Selenium
//        driver = new InternetExplorerDriver();
        // DK2: Nếu driver start với browser như IE thì dùng hàm click của JavaScriptExecutor
        driver = new ChromeDriver();
        System.out.println(driver.toString());
        if (driver.toString().contains("internet explorer")){
            System.out.println("click by javaScriptExecutor");
        } else {
            System.out.println("click by Selenium");
        }
    }

    @Parameters("browser")
    @Test
    public void TC_02_If_Else_If_Else(String browserName) {
        if (browserName.equalsIgnoreCase("Chrome")){
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("Firefox")){
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("Edge")){
            driver = new EdgeDriver();
        } else if (browserName.equalsIgnoreCase("Safari")){
            driver = new SafariDriver();
        } else {
            throw new RuntimeException("Browser name is not valid !");
        }
    }
}
