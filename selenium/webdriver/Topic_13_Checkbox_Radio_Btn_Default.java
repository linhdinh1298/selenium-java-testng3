package webdriver;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_13_Checkbox_Radio_Btn_Default {

    WebDriver driver;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        // Tăng độ phân giải màn hình
        //driver.manage().window().setSize(new Dimension(1920,1200));
    }


    @Test
    public void TC_01_Select_Single_Ex2() {
        driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)"); // Scroll màn hình nếu items bị ẩn ở dưới

        // Click vào checkbox Dual zone
        By dualAirBy = By.xpath("//label[text()=\"Dual-zone air conditioning\"]/preceding-sibling::span/input");


        // Kiểm tra nếu chưa chọn thì mới chọn
        if (!driver.findElement(dualAirBy).isSelected()) {
            driver.findElement(dualAirBy).click();
        }
        //Assert.assertTrue(driver.findElement(By.xpath("//label[text()=\"Dual-zone air conditioning\"]/preceding-sibling::span/input")).isSelected());
        //driver.findElement(By.xpath("//label[text()=\"Dual-zone air conditioning\"]/preceding-sibling::span/input")).click();

        // Kiểm tra checkbox đó đã chọn
        Assert.assertTrue(driver.findElement(dualAirBy).isSelected());

        // Sau khi checkbox đã chọn, bỏ chọn, kiểm tra đã bỏ chọn
        if (driver.findElement(dualAirBy).isSelected()) {
            driver.findElement(dualAirBy).click();
        }
        Assert.assertFalse(driver.findElement(dualAirBy).isSelected());

        driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)");

        // Click vào radio btn 2.0
        By twoPetrolBy = By.xpath("//label[text()=\"2.0 Petrol, 147kW\"]/preceding-sibling::span/input");
        if (!driver.findElement(twoPetrolBy).isSelected()) {
            driver.findElement(twoPetrolBy).click();
        }
        Assert.assertTrue(driver.findElement(twoPetrolBy).isSelected());


        // Kiểm tra radio đó đã chọn hay chưa, nếu chưa thì chọn lại
        if (!driver.findElement(twoPetrolBy).isSelected()) {
            driver.findElement(twoPetrolBy).click();
        }
        Assert.assertTrue(driver.findElement(twoPetrolBy).isSelected());
    }

    @Test
    public void TC_02_Select_Single_Ex3(){
        driver.get("https://material.angular.io/components/radio/examples");
        By summerBy = By.xpath("//label[text()=\"Summer\"]/preceding-sibling::div/input");
        if (!driver.findElement(summerBy).isSelected()) {
            driver.findElement(summerBy).click();
        }
        Assert.assertTrue(driver.findElement(summerBy).isSelected());


        // Kiểm tra radio đó đã chọn hay chưa, nếu chưa thì chọn lại
        if (!driver.findElement(summerBy).isSelected()) {
            driver.findElement(summerBy).click();
        }
        Assert.assertTrue(driver.findElement(summerBy).isSelected());

        driver.get("https://material.angular.dev/components/checkbox/examples");
        By checkedBy = By.xpath("//label[text()=\"Checked\"]/preceding-sibling::div/input");
        By inderterminateBy = By.xpath("//label[text()=\"Indeterminate\"]/preceding-sibling::div/input");
        if (!driver.findElement(checkedBy).isSelected()) {
            driver.findElement(checkedBy).click();
        }
        Assert.assertTrue(driver.findElement(checkedBy).isSelected());


        // Kiểm tra radio đó đã chọn hay chưa, nếu chưa thì chọn lại
        if (driver.findElement(checkedBy).isSelected()) {
            driver.findElement(checkedBy).click();
        }
        Assert.assertFalse(driver.findElement(checkedBy).isSelected());

        if (!driver.findElement(inderterminateBy).isSelected()) {
            driver.findElement(inderterminateBy).click();
        }
        Assert.assertTrue(driver.findElement(inderterminateBy).isSelected());


        // Kiểm tra radio đó đã chọn hay chưa, nếu chưa thì chọn lại
        if (!driver.findElement(inderterminateBy).isSelected()) {
            driver.findElement(inderterminateBy).click();
        }
        Assert.assertTrue(driver.findElement(inderterminateBy).isSelected());

    }

    @Test
    public void TC_03_Select_All(){
        driver.get("https://automationfc.github.io/multiple-fields/");

        // Select all checkbox
        List<WebElement> checkboxes = driver.findElements(By.xpath("//span[@class=\"form-checkbox-item\"]/input"));

        // Dùng vòng lặp for click all
        for (WebElement checkbox: checkboxes) {
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }

        // Verify all checkboxes are selected
        for (WebElement checkbox: checkboxes) {
            Assert.assertTrue(checkbox.isSelected());
        }

        // Deselect all checkbox
        for (WebElement checkbox: checkboxes) {
            if (checkbox.isSelected()) {
                checkbox.click();
            }
        }
        // Verify all checkboxes are deselected
        for (WebElement checkbox: checkboxes) {
            Assert.assertFalse(checkbox.isSelected());
        }

        // Select 1 in all  + verify
        for (WebElement checkbox: checkboxes) {
            if (!checkbox.isSelected() && checkbox.getAttribute("value").equals("Kidney Disease")){
                checkbox.click();
            }
        }
        Assert.assertTrue(driver.findElement(By.cssSelector("input[value='Kidney Disease']")).isSelected());

    }

            @AfterClass
            public void cleanBrowser () {
                driver.quit();
            }

        }