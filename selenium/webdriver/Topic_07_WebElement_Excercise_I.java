package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Topic_07_WebElement_Excercise_I {
    WebDriver driver;
    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
    }
    @Test
    public void TC_01_Displayed(){
        driver.get("https://automationfc.github.io/basic-form/index.html");
        WebElement emailTextbox = driver.findElement(By.cssSelector("input#mail"));
        if (emailTextbox.isDisplayed()) {
            System.out.println("Email Textbox is displayed");
            emailTextbox.sendKeys("Automation Testing");
        } else {
            System.out.println("Email Textbox is not displayed");
        }
        WebElement ageUnder18Radio = driver.findElement(By.cssSelector("input#under_18"));
        if (ageUnder18Radio.isDisplayed()) {
            System.out.println("ageUnder18Radio is displayed");
            ageUnder18Radio.click();
        } else {
            System.out.println("ageUnder18Radio is not displayed");
        }
        WebElement EducationTextarea = driver.findElement(By.cssSelector("textarea#edu"));
        if (EducationTextarea.isDisplayed()) {
            System.out.println("EducationTextbox is displayed");
            ageUnder18Radio.sendKeys("Automation Testing");
        } else {
            System.out.println("EducationTextbox is not displayed");
        }
        WebElement user5Text = driver.findElement(By.xpath("//h5[text()=\"Name: User5\"]"));
        if (user5Text.isDisplayed()) {
            System.out.println("user5Text is displayed");
        } else {
            System.out.println("user5Text is not displayed");
        }
    }
    @Test
    public void TC_02_Enabled(){
        driver.get("https://automationfc.github.io/basic-form/index.html");
        WebElement emailTextbox = driver.findElement(By.cssSelector("input#mail"));
        if (emailTextbox.isEnabled()) {
            System.out.println("Email Textbox is enabled");
        } else {
            System.out.println("Email Textbox is not enabled");
        }
        WebElement ageUnder18Radio = driver.findElement(By.cssSelector("input#under_18"));
        if (ageUnder18Radio.isEnabled()) {
            System.out.println("ageUnder18Radio is enabled");
        } else {
            System.out.println("ageUnder18Radio is not enable");
        }
        WebElement passwordTextbox = driver.findElement(By.cssSelector("input#disable_password"));
        if (passwordTextbox.isEnabled()) {
            System.out.println("passwordTextbox is enabled");
        } else {
            System.out.println("passwordTextbox is not enable");
        }
        WebElement bioTextArea = driver.findElement(By.cssSelector("textarea#bio"));
        if (bioTextArea.isEnabled()) {
            System.out.println("bioTextArea is enabled");
        } else {
            System.out.println("bioTextArea is not enable");
        }
    }
    @Test
    public void TC_03_Selected() throws InterruptedException {
        // Kiểm tra 1 element đã chọn thành công
        driver.get("https://automationfc.github.io/basic-form/index.html");
        WebElement ageUnder18Radio = driver.findElement(By.cssSelector("input#under_18"));
        if (ageUnder18Radio.isSelected()) {
            System.out.println("ageUnder18Radio is selected");
        } else {
            System.out.println("ageUnder18Radio is de_selected");
        }
        WebElement interestCheckbox = driver.findElement(By.cssSelector("input#development"));
        if (interestCheckbox.isSelected()) {
            System.out.println("interestCheckbox is selected");
        } else {
            System.out.println("interestCheckbox is de_selected");
        }
        ageUnder18Radio.click();
        interestCheckbox.click();
        Thread.sleep(3000);
        if (ageUnder18Radio.isSelected()) {
            System.out.println("ageUnder18Radio is selected");
        } else {
            System.out.println("ageUnder18Radio is de_selected");
        }
        if (interestCheckbox.isSelected()) {
            System.out.println("interestCheckbox is selected");
        } else {
            System.out.println("interestCheckbox is de_selected");
        }
    }
    @Test
    public void TC_04_Validation_MailChimp() throws InterruptedException {
        driver.get("https://login.mailchimp.com/signup/");
        driver.findElement(By.cssSelector("input#email")).sendKeys("linh@gmail.com");
        driver.findElement(By.cssSelector("input#email")).sendKeys(Keys.TAB);
        Thread.sleep(3000);
        // Only number
        driver.findElement(By.id("new_password")).sendKeys("123");
        driver.findElement(By.id("new_password")).sendKeys(Keys.TAB);
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        // Sau dấu chấm không dùng số, vì css sẽ tưởng là index > dùng xpath
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class ='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());
        // Only lowercase
        driver.findElement(By.id("new_password")).clear();
        driver.findElement(By.id("new_password")).sendKeys("abc");
        driver.findElement(By.id("new_password")).sendKeys(Keys.TAB);
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class ='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());
        // Only uppercase
        driver.findElement(By.id("new_password")).clear();
        driver.findElement(By.id("new_password")).sendKeys("ABC");
        driver.findElement(By.id("new_password")).sendKeys(Keys.TAB);
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class ='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());
        // Only special character
        driver.findElement(By.id("new_password")).clear();
        driver.findElement(By.id("new_password")).sendKeys("@@@");
        driver.findElement(By.id("new_password")).sendKeys(Keys.TAB);
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class ='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());
        // Valid Password
        driver.findElement(By.id("new_password")).clear();
        driver.findElement(By.id("new_password")).sendKeys("Me@12345566");
        driver.findElement(By.id("new_password")).sendKeys(Keys.TAB);
        Thread.sleep(3000);

        Assert.assertFalse(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.xpath("//li[@class ='8-char completed']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());
    }
    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }
}