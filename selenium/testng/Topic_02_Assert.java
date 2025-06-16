package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Assert {
    WebDriver driver;

    @Test
    public void assertion(){
        // AssertTrue: Khi kiểm tra 1 điều kiện mong muốn trả về ĐÚNG
        // Các hàm trả về True/False: isSelected/ isDisplayed/ isEnabled/ isMultiple
        // Các hàm tự define
        Assert.assertTrue(driver.findElement(By.cssSelector("")).isDisplayed());

        // AssertFalse: Khi kiểm tra 1 điều kiện mong muốn trả về SAI
        Assert.assertFalse(driver.findElement(By.cssSelector("")).isEnabled());

        // AssertEquals: Kiểm tra 1 điều kiện mong đợi (Expected) bằng với điều kiện thực tế (Actual)
        // getText, getAttribute, getCss, gettitle, getURL,...
        Assert.assertEquals(driver.findElement(By.cssSelector("")).getText(),"");
        Assert.assertEquals(driver.findElement(By.cssSelector("")).getAttribute("placeholder"),"");
        Assert.assertEquals(driver.findElements(By.cssSelector("")).size(),40);
    }
}
