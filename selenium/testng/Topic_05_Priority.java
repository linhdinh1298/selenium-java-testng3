package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Priority {
    // ưu tiên theo priority > alphabet

    @Test (priority =1)
    public void TC_03(){
        System.out.println("Run TC_03");

    }
    @Test (priority =2)
    public void TC_02(){
        System.out.println("Run TC_02");
    }
    @Test (priority =3)
    public void TC_01(){
        System.out.println("Run TC_01");
    }

}
