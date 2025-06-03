package webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class Topic_10_Dropdown_Default {

    WebDriver driver;
    Select select;
    Random random;
    String firstName, lastName, email, password, date, month, year;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        random = new Random();
        firstName ="lin";
        lastName ="dinh";
        password = "123456";
        date = "24";
        month = "Jun";
        year = "2000";
        email ="lin" + random.nextInt(99999) + "@gmail.com";
    }


    @Test
    public void TC_00_Demo() throws InterruptedException {
        driver.get("https://www.facebook.com/r.php?entry_point=login");

        // Truyền vào tham số là "Text": giống như end user
        // Không bị trùng dữ , không để trống dữ
        // Không thay đổi text nếu có đổi vị trí

        // Không truyền index: vì tham số có thể thay đổi theo vị trí, đọc code không hiểu
        // khi run fail > manual test sẽ kb truyền vào giá trị là gì

        // Không truyền vào attribute value: attribute này là optional, đọc code không hiểu
        // khi run fail > manual test sẽ kb truyền vào giá trị là gì

        // Chọn 1 item
        select.selectByVisibleText("");

        // Chọn xong verify đã thành công hay chưa
        select.getFirstSelectedOption();

        // Verify dropdown có phải dạng multiple hay không
        // Nếu là multiple > trả về True
        // Nếu là single > trả về False
        Assert.assertFalse(select.isMultiple());

        // Verify tổng số lượng item trong dropdown
        Assert.assertEquals(select.getOptions().size(),31);

        // Khởi tạo trong TC bởi vì lúc này đã get browser > có thể tìm thấy element
        select = new Select(driver.findElement(By.cssSelector("select#day")));
        select.selectByVisibleText("30");
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"30");

        select = new Select(driver.findElement(By.cssSelector("select#month")));
        select.selectByVisibleText("Sep");
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Sep");

        select = new Select(driver.findElement(By.cssSelector("select#year")));
        select.selectByVisibleText("2009");
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"2009");


    }
    @Test
    public void TC_01_NopEcommerce() throws InterruptedException {
        driver.get("https://demo.nopcommerce.com/");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("a.ico-register")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input#gender-male")).click();
        driver.findElement(By.cssSelector("input#FirstName")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input#LastName")).sendKeys(lastName);
        driver.findElement(By.cssSelector("input#Email")).sendKeys(email);
        driver.findElement(By.cssSelector("input#Password")).sendKeys(password);
        driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys(password);
        driver.findElement(By.cssSelector("button#register-button")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='page registration-result-page'] div[class='result']"))
                .getText(),"Your registration completed");
        driver.findElement(By.cssSelector("a.ico-account")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("input#FirstName")).getText(),firstName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#LastName")).getText(),lastName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#Email")).getText(),email);
        Assert.assertTrue(driver.findElement(By.cssSelector("input#gender-male")).isEnabled());

    }
    @Test
    public void TC_02_Rode(){
        driver.get("https://rode.com/en/support/where-to-buy");
        Assert.assertFalse(new Select(driver.findElement(By.cssSelector("select#country"))).isMultiple());
        new Select(driver.findElement(By.cssSelector("select#country"))).selectByVisibleText("Vietnam");
        driver.findElement(By.cssSelector("input#map_search_query")).sendKeys("HO CHI MINH");
        driver.findElement(By.cssSelector("button.btn-default")).click();
        List<WebElement> dealers = driver.findElements(By.xpath("//h3[text()='Dealers']/following-sibling::div//h4"));
        Assert.assertEquals(dealers.size(),16);

        // Dùng vòng lặp để lấy ra từng element > dùng hàm getText để lấy ra giá trị > in ra
        for(WebElement element: dealers){
            System.out.println(element.getText());
        }
    }

    @Test
    public void TC_03_Rode(){
        driver.get("https://rode.com/en/support/where-to-buy");
        Assert.assertFalse(new Select(driver.findElement(By.cssSelector("select#country"))).isMultiple());
        new Select(driver.findElement(By.cssSelector("select#country"))).selectByVisibleText("Vietnam");
        driver.findElement(By.cssSelector("input#map_search_query")).sendKeys("HO CHI MINH");
        driver.findElement(By.cssSelector("button.btn-default")).click();
        List<WebElement> dealers = driver.findElements(By.xpath("//h3[text()='Dealers']/following-sibling::div//h4"));
        Assert.assertEquals(dealers.size(),16);

        // Dùng vòng lặp để lấy ra từng element > dùng hàm getText để lấy ra giá trị > in ra
        for(WebElement element: dealers){
            System.out.println(element.getText());
        }
    }


    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }
}