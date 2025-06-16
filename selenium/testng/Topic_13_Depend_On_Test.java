package testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_13_Depend_On_Test {
    @Test (groups = "create")
    public void TC_01_Product_Create(){
        System.out.println("Run TC_01");
        Assert.assertTrue(false);

    }
    @Test (dependsOnMethods = "TC_01_Product_Create")
    public void TC_02_Product_View(){
        System.out.println("Run TC_02");
    }
    @Test (dependsOnGroups = "create")
    public void TC_03_Product_Edit(){
        System.out.println("Run TC_03");
    }
    @Test
    public void TC_04_Product_Move(){
        System.out.println("Run TC_03");
    }
    @Test
    public void TC_04_Product_Delete(){
        System.out.println("Run TC_03");
    }
}
