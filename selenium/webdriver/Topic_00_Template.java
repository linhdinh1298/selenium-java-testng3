package Webdriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_00_Template {

    // 1-Setup: OS/Browser/Web/Page/Data/Variable/Object/...
    WebDriver driver;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.get("https://www.facebook.com/");
    }
    // 2-Action/Execute: Element/input data/verify/...
    @Test
    public void TC_01_(){

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