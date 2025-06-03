package webdriver;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v135.network.Network;
import org.openqa.selenium.devtools.v135.network.model.Headers;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Topic_16_Authentication_Alert {
    WebDriver driver;
    String username = "admin";
    String password = "admin";
    @BeforeClass
    public void initialBrowser(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void TC_01_Authentication_alert(){
        // By pass username + password through URL
        // http/ https:// + username + : + password + @ URL
        driver.get("http://" + username + ":" + password + "@"+ "the-internet.herokuapp.com/basic_auth");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.example>p")).getText(),"Congratulations! You must have the proper credentials.");
    }
    @Test
    public void TC_02_Authentication_navigate() {
        driver.get("http://the-internet.herokuapp.com/");
        String basicAuth = driver.findElement(By.xpath("//a[text()='Basic Auth']")).getAttribute("href");
        driver.get(getAuthenticationUrl(basicAuth,username,password));
        Assert.assertEquals(driver.findElement(By.cssSelector("div.example>p")).getText(),"Congratulations! You must have the proper credentials.");
    }
    public String getAuthenticationUrl (String link, String username, String password) {
        String[] linkArray = link.split("//");
        // Array[0] = http:
        // Array[1] = the-internet.herokuapp.com/
        return  linkArray[0] + "//" + username + ":" + password + "@" + linkArray[1];
    }

    @Test
    public void TC_03_Authentication_CDP() {
        // Get DevTool object
        DevTools devTools = ((HasDevTools) driver).getDevTools();

        // Start new session
        devTools.createSession();

        // Enable the Network domain of devtools
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        // Encode username/ password
        Map<String, Object> headers = new HashMap<String, Object>();
        String basicAuthen = "Basic " + new String(new Base64().encode(String.format("%s:%s", "admin", "admin").getBytes()));
        headers.put("Authorization", basicAuthen);

        // Set to Header
        devTools.send(Network.setExtraHTTPHeaders(new Headers(headers)));

        driver.get("https://the-internet.herokuapp.com/basic_auth");
    }

    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }
}













