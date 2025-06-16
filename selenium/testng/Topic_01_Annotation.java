package testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_01_Annotation {

    // Run TC theo thứ tự:
    // Before Suite
    // Before Test
    // Before Class
    // Before Method = Test case

    @BeforeClass
    public void beforeClass(){

    }

    @Test
    public void TC_01(){

    }
    @Test
    public void TC_02(){

    }
    @Test
    public void TC_03(){

    }

    @AfterClass
    public void afterClass(){

    }
}
