package webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.Random;
public class Topic_08_Textbox_TextArea {
    WebDriver driver;
    String educationText = "Automation Testing\nwith\nselenium";
    String firstName, lastName, emailAddress, password, fullName;
    Random random;
    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        random = new Random();
        firstName = "Lin";
        lastName ="Dinh";
        emailAddress ="lin" + random.nextInt(999999) + "@gmail.com";
        password = "123456";
        fullName = firstName+ " " + lastName;
    }
    @Test
    public void TC_00(){
        driver.get("https://automationfc.github.io/basic-form/");
        driver.findElement(By.cssSelector("textarea#edu")).sendKeys("Automation Testing\n" +
                "with\n" +
                "selenium"); // cách 1
        // Cách 2 (dùng biến)llll driver.findElement(By.cssSelector("textarea#edu")).sendKeys("educationText");
    }
    // Exercise
    @Test
    public void TC_01_TechPanda() throws InterruptedException {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        driver.findElement(By.cssSelector("input#firstname")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input#lastname")).sendKeys(lastName);
        driver.findElement(By.cssSelector("input#email_address")).sendKeys(emailAddress);
        driver.findElement(By.cssSelector("input#password")).sendKeys(password);
        driver.findElement(By.cssSelector("input#confirmation")).sendKeys(password);
        driver.findElement(By.xpath("//button[@title='Register']")).click();
        // Verify tuyệt đối
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span"))
                .getText(),"Thank you for registering with Main Website Store.");
        String contactInfoText = driver.findElement(By
                        .xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p"))
                .getText(); // getText lấy tất cả các text nằm trong thẻ vào gồm text của sub-element
        // Verify tương đối (vì sao k dùng verify tuyệt đối trong trường hợp này: vì text sẽ thay đổi theo nội dung
        // được nhập vào > text sẽ thay đổi + text quá dài > không nên verify tuyệt đối, vì toàn bộ text đều nằm trong 1 thẻ
        Assert.assertTrue(contactInfoText.contains(fullName) && contactInfoText.contains(emailAddress)); // Fullname & Email
        driver.findElement(By.xpath("//h3[text()='Contact Information']/following-sibling::a")).click();
        Assert.assertEquals(driver.findElement(By.id("firstname")).getAttribute("value"),firstName);
        // Product review
        driver.findElement(By.xpath("//a[text()='Mobile']")).click();
        driver.findElement(By.xpath("//a[@title='Samsung Galaxy']")).click();
        driver.findElement(By.xpath("//a[text()='Add Your Review']")).click();
        driver.findElement(By.cssSelector("input[id='Quality 1_5']")).click();
        driver.findElement(By.cssSelector("textarea[id='review_field']")).sendKeys("Lin\nANC");
        driver.findElement(By.cssSelector("input[id='summary_field']")).sendKeys("abc");
        driver.findElement(By.cssSelector("input[id='nickname_field']")).clear();
        driver.findElement(By.cssSelector("input[id='nickname_field']")).sendKeys("lin");
        driver.findElement(By.xpath("//button[@title='Submit Review']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),
                "Your review has been accepted for moderation.");
        // Logout
        driver.findElement(By.cssSelector("div.account-cart-wrapper a")).click();
        driver.findElement(By.cssSelector("a[title='Log Out']")).click();
        Thread.sleep(6000);
        Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/");
    }
    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }
}