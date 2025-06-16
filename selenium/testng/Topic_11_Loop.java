package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Topic_11_Loop {
    WebDriver driver;
    String firstName, lastName, emailAddress, password, fullName;
    Random random;
    Properties props = new Properties();
    FileOutputStream outputStream;
    String projectPath = System.getProperty("user.dir");
    @BeforeClass
    public void initialBrowser() throws FileNotFoundException {
        driver = new FirefoxDriver();
        random = new Random();
        firstName = "Lin";
        lastName ="Dinh";
        password = "123456";
        fullName = firstName+ " " + lastName;

        String path = projectPath + "/dataTest/user.properties";
        outputStream = new FileOutputStream(path);
    }
    @Test (invocationCount = 2)
    public void TC_01_Register() throws InterruptedException, IOException {
        driver.get("http://live.techpanda.org/");
        emailAddress ="lin" + random.nextInt(999999) + "@gmail.com";
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
        Assert.assertEquals(driver.findElement(By.id("lastname")).getAttribute("value"),lastName);
        Assert.assertEquals(driver.findElement(By.id("email")).getAttribute("value"),emailAddress);

        // Logout
        driver.findElement(By.cssSelector("div.account-cart-wrapper a")).click();
        driver.findElement(By.cssSelector("a[title='Log Out']")).click();

        System.out.println("Email address:" + emailAddress);
        System.out.println("Password:" + password);

        props.setProperty("email",emailAddress);
        props.setProperty("password",password);
        props.store(outputStream,"null");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
