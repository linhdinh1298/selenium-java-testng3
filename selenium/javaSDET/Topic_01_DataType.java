package javaSDET;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.*;

public class Topic_01_DataType {

    // cách khai báo biến:
    // Access modifier: phạm vi truy cập (private/ public/ protected/ default)
    // 1: Access modifier - Kiểu dữ liệu - Tên biến - Giá trị của biến (Ngoài Hàm/ Trong hàm đều được)
    public char cName ='b';
    // 2.1: Access modifier - Kiểu dữ liệu - Tên biến
    private char cAddress;
    // 2.2: Tên biến - Giá trị gán sau (trong Hàm)

    public void clickToElement(){
        cAddress ='c';
    }

    // 2 nhóm kiểu dữ liệu

    // Nhóm 1: Kiểu dữ liệu nguyên thủy (primitive type)

    // Char: kí tự (character) > khi gán giá trị nằm trong dấu ''
    char cZip ='b';

    // byte/ short/ int/ long: số nguyên > khi khán giá trị không nằm trong dấu gì
    byte bNumber = 120;
    short sNumber = 1200;
    int iNumber = 35000;
    long lNumber = 234240234;

    // float/ double: số thực > khi khán giá trị không nằm trong dấu gì
    float fNumber = 15.7f;
    double dNumber = 15.925d;

    //: Boolean: logic > khi gán giá trị thì không nắn tròng dấu gì
    boolean gender = false;

    // Nhóm 2 - Kiểu dữ liệu tham chiếu (reference/ non-primitive type)

    // String: chuỗi > khi gán giá trị nằm trong dấu ""
    String fullName ="automation testing";

    // Class > kiểu dữ liệu class thường phải "new" mới dùng được
    FirefoxDriver fDriver = new FirefoxDriver();
    Actions actions = new Actions(fDriver);
    // Class: kiểu do người dùng tự định nghĩa
    Topic_01_DataType Topic = new Topic_01_DataType();
    // Topic là 1 object đại diện cho kiểu class Topic_01_DataType

    // Interface
    WebDriver driver;
    JavascriptExecutor jsExecutor;

    // Array: kiểu mảng: kiểu dữ liệu chứa dữ liệu , mảng nằm trong dấu {}, define dữ liệu bên trong.
    // > Bắt buộc giá trị define trong mảng phải giống nhau. Nếu giá trị trong mảng khác nhau > dùng List/ Set/Queue
    // > Mảng cố định, bắt buộc phải define trước
    String studentName1 = "Linh";
    String[] studentName = {studentName1, "Hiền", "Nam", "An"};
    Integer[] studentPhone = {98789, 77848, 83888};

    // Collection: List, Set, Queue, Map
    // List/ Set/ Queue: động, có thể add/delete/edit trong quá trình
    // List/ Set/ Queue: là Interface (Interface: sẽ không dùng "new")
    // mà sẽ "new" những thằng kế thừa Interface e.g: Arraylist, linkedList,...refer to Java collection link in bookmark
    // List sẽ lưu trùng
    List<String> studentAddess = new ArrayList<String>();
    List<String> studentCity = new LinkedList<String>();
    List<WebElement> homePageLinks = driver.findElements(By.tagName("a"));
    // Set không lưu trùng
    Set<String> allWindows = driver.getWindowHandles();

    // Map
    Map<String, Integer> zip = new HashMap<String, Integer>();


    // Object: khi define có thể add những kiểu dữ liệu khác
    Object name = "name";
    Object score = "10";
    Object isDisplayed = true;


    // Convention: Quy ước khi lập trình
    // Tên biến, tên hàm: viết dưới dạng camel case > chữ cái đầu tiên luôn viết thường nếu 1 từ e.g name/address
    // Nếu nhiều hơn 1 từ: chữ cái đầu tiên của từ t2 viết hoa e.g getUserName, clickToElement

    // Sự khác biệt giữa Primitive & non-Primitive
    // 1. Primitive: không có các functions theo sau
    // 2. Cách thức lưu trữ dữ
    // Primitive: khi khai báo cộng gán giá trị: giá trị luôn cố định
    // non-Primitive: thay đổi giá trị của vùng nhớ, thì những biến đang tham chiếu tới vùng nhớ sẽ bị thay đổi
    // vì: non-primitive: lưu biến ở 1 vùng nhớ, và giá thị ở 1 vùng nhớ
    public void clickToElement2() {
        fullName.contains("");
        driver.getTitle();
        name.toString();
        studentAddess.size();
    }

}
