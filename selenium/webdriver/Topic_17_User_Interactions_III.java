package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.InputEvent;
import java.io.*;
import java.nio.charset.Charset;
import java.time.Duration;
import java.util.List;

public class Topic_17_User_Interactions_III {
    WebDriver driver;
    Actions action;
    String projectPath = System.getProperty("user.dir");
    JavascriptExecutor jsExecutor;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        action = new Actions(driver);
        jsExecutor = (JavascriptExecutor) driver;
    }
    @Test
    public void TC_04_Right_click() throws InterruptedException {
        driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");

        // Right click to element
        action.contextClick(driver.findElement(By.cssSelector("span.context-menu-one"))).perform();
        Thread.sleep(3000);
        // Verify Quit menu display
        WebElement quitMenu = driver.findElement(By.cssSelector("li.context-menu-icon-quit"));
        Assert.assertTrue(quitMenu.isDisplayed());
        // Hover over Quit element
        action.moveToElement(quitMenu).perform();
        Thread.sleep(3000);
        // Verify element Quit (visible + hover) with Xpath
        Assert.assertTrue(driver.findElement(By.cssSelector("li.context-menu-visible.context-menu-hover")).isDisplayed());

        // Click Quit menu
        action.click(quitMenu).perform();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
        // Verify Quit menu is invisible
        Assert.assertFalse(quitMenu.isDisplayed());
    }

    @Test
    public void TC_05_Drag_Drop_HTML4() throws InterruptedException {
        driver.get("https://automationfc.github.io/kendo-drag-drop/");
        WebElement sourceCircle = driver.findElement(By.cssSelector("div#draggable"));
        WebElement targetCircel = driver.findElement(By.cssSelector("div#droptarget"));
        // Kéo hình tròn nhỏ vào hfnh tròn lớn
        action.dragAndDrop(sourceCircle,targetCircel).perform();
        // Verify message đã thay đổi: You did great!
        Assert.assertEquals(targetCircel.getText(), "You did great!");
        // Verify background của hình tròn lớn chuyển qua màu blue
        Assert.assertEquals(Color.fromString(targetCircel.getCssValue("background-color")).asHex().toUpperCase(),"#03A9F4");

    }

    @Test
    public void TC_06_Drag_Drop_HTML5_jQuery() throws InterruptedException, IOException {
        driver.get("https://automationfc.github.io/drag-drop-html5/");

        // Trường hợp site không support jQuery
//        String jQueryLibraries = getContentFile(projectPath +"dragDrop//jQueryLib.js");
//        jsExecutor.executeScript(jQueryLibraries);

        String jQueryDragDropContent = getContentFile(projectPath + "//dragDrop//dragAndDrop.js");
        // Drag A to B
        jsExecutor.executeScript(jQueryDragDropContent);
        Thread.sleep(3000);
        // Verify
        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-a>header")).getText(),"B");
        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-b>header")).getText(),"A");
        // Drag B to A
        jsExecutor.executeScript(jQueryDragDropContent);
        Thread.sleep(3000);
        // Verify
        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-a>header")).getText(),"A");
        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-b>header")).getText(),"B");

    }
    public String getContentFile(String filePath) throws IOException {
        Charset cs = Charset.forName("UTF-8");
        FileInputStream stream = new FileInputStream(filePath);
        try {
            Reader reader = new BufferedReader(new InputStreamReader(stream, cs));
            StringBuilder builder = new StringBuilder();
            char[] buffer = new char[8192];
            int read;
            while ((read = reader.read(buffer, 0, buffer.length)) > 0) {
                builder.append(buffer, 0, read);
            }
            return builder.toString();
        } finally {
            stream.close();
        }
    }

    @Test
    public void TC_06_Drag_Drop_HTML5_java_robot() throws AWTException, InterruptedException {
        driver.get("https://automationfc.github.io/drag-drop-html5/");
        dragAndDropHTML5ByXpath("div#column-a","div#column-b");
        Thread.sleep(3000);
        // Verify
        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-a>header")).getText(),"B");
        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-b>header")).getText(),"A");

        dragAndDropHTML5ByXpath("div#column-a","div#column-b");
        Thread.sleep(3000);
        // Verify
        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-a>header")).getText(),"A");
        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-b>header")).getText(),"B");

    }
    public void dragAndDropHTML5ByXpath(String sourceLocator, String targetLocator) throws AWTException {

        WebElement source = driver.findElement(By.cssSelector(sourceLocator));
        WebElement target = driver.findElement(By.cssSelector(targetLocator));

        // Setup robot
        Robot robot = new Robot();
        robot.setAutoDelay(500);

        // Get size of elements
        Dimension sourceSize = source.getSize();
        Dimension targetSize = target.getSize();

        // Get center distance
        int xCentreSource = sourceSize.width / 2;
        int yCentreSource = sourceSize.height / 2;
        int xCentreTarget = targetSize.width / 2;
        int yCentreTarget = targetSize.height / 2;

        Point sourceLocation = source.getLocation();
        Point targetLocation = target.getLocation();

        // Make Mouse coordinate center of element
        sourceLocation.x += 20 + xCentreSource;
        sourceLocation.y += 110 + yCentreSource;
        targetLocation.x += 20 + xCentreTarget;
        targetLocation.y += 110 + yCentreTarget;

        // Move mouse to drag from location
        robot.mouseMove(sourceLocation.x, sourceLocation.y);

        // Click and drag
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseMove(((sourceLocation.x - targetLocation.x) / 2) + targetLocation.x, ((sourceLocation.y - targetLocation.y) / 2) + targetLocation.y);

        // Move to final position
        robot.mouseMove(targetLocation.x, targetLocation.y);

        // Drop
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }
    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }
}







