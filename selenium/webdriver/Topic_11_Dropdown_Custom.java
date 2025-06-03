package webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;
public class Topic_11_Dropdown_Custom {
    WebDriver driver;
    WebDriverWait explicitWait;
    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); // chỉ dùng cho tìm element (findElement(s))
    }
    @Test
    public void TC_01_jQuery() throws InterruptedException {
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
        selectItemInCustomDropdown ("span#speed-button","ul#speed-menu>li>div","Faster");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#speed-button>span.ui-selectmenu-text")).getText(),"Faster");
        selectItemInCustomDropdown ("span#files-button","ul#files-menu>li>div","ui.jQuery.js");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#files-button>span.ui-selectmenu-text")).getText(),"ui.jQuery.js");
        selectItemInCustomDropdown ("span#number-button","ul#number-menu>li>div","2");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#number-button>span.ui-selectmenu-text")).getText(),"2");
        selectItemInCustomDropdown ("span#salutation-button","ul#salutation-menu>li>div","Mr.");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#salutation-button>span.ui-selectmenu-text")).getText(),"Mr.");
    }
    @Test
    public void TC_02_React() throws InterruptedException {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
        selectItemInCustomDropdown ("div.dropdown","div.transition>div>span","Matt");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider")).getText(),"Matt");
    }
    @Test
    public void TC_03_VueJS() throws InterruptedException {
        driver.get("https://mikerodham.github.io/vue-dropdowns/");
        selectItemInCustomDropdown ("li.dropdown-toggle","ul.dropdown-menu>li>a","First Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(),"First Option");
    }
    @Test
    public void TC_04_Editable_Dropdown() throws InterruptedException {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");
        enterItemInCustomDropdown ("input.search","div.menu>div>span","Albania");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.text")).getText(),"Albania");
        enterItemInCustomDropdown ("input.search","div.menu>div>span","Algeria");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.text")).getText(),"Algeria");
    }
    private void selectItemInCustomDropdown(String parentCss, String childCss, String textItem) throws InterruptedException {
        // Hành vi để thao tác lên dropdown
        // 1- Chờ cho dropdown có thể thao tác lên được (clickable)
        // 2 - Click vào element nào để sổ dropdown
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(parentCss))).click();
        Thread.sleep(2000); // => Sau khi click, theo user's behavior thì cần chờ 1-2s để quan sát > dùng sleep
        // 3 - Chờ cho tất cả các item được load ra (presence) => cần bắt 1 locator đại diện cho all items
        // nếu dùng visible, trong TH 1 dropdown số lượng item quá nhiều > items visible sẽ ít, k thấy đủ.
        // presence : chỉ cần items có xuất hiện ở trong thẻ html
        // 4- Tìm item nào đúng với mong đợi
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childCss)));
        // dùng vòng lặp for để duyệt qua all items > dùng if để kiểm tra điều kiện
        for (WebElement item: allItems) {
            // hàm getText chỉ lấy được text của những items nào visible, còn nhưng items invisible thì k thể lấy được
            if (item.getText().equals(textItem)) {
                item.click(); // 5- Click lên item đó
                break;
            }
        }
    }
    private void enterItemInCustomDropdown(String parentCss, String childCss, String textItem) throws InterruptedException {
        // Hành vi để thao tác lên dropdown
        // 1- Chờ cho dropdown có thể nhập được (visible)
        // 2 - sendkey vào dropdown
        WebElement dropdownTextbox = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(parentCss)));
        dropdownTextbox.clear();
        dropdownTextbox.sendKeys(textItem);
        Thread.sleep(2000); // => Sau khi click, theo user's behavior thì cần chờ 1-2s để quan sát > dùng sleep
        // 3 - Chờ cho tất cả các item được load ra (presence) => cần bắt 1 locator đại diện cho all items
        // nếu dùng visible, trong TH 1 dropdown số lượng item quá nhiều > items visible sẽ ít, k thấy đủ.
        // presence : chỉ cần items có xuất hiện ở trong thẻ html
        // 4- Tìm item nào đúng với mong đợi
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childCss)));
        // dùng vòng lặp for để duyệt qua all items > dùng if để kiểm tra điều kiện
        for (WebElement item: allItems) {
            // hàm getText chỉ lấy được text của những items nào visible, còn nhưng items invisible thì k thể lấy được
            if (item.getText().equals(textItem)) {
                item.click(); // 5- Click lên item đó
                break;
            }
        }
    }
    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }
}