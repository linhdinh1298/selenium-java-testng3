package testng;

import org.testng.annotations.Test;

public class Topic_06_Skip {
    // ưu tiên theo priority > alphabet

    @Test (priority =1)
    public void TC_03(){
        System.out.println("Run TC_03");

    }
    @Test (enabled = false) // dùng enabled = true hoặc command dòng code lại //@Test
    public void TC_02(){
        System.out.println("Run TC_02");
    }
    @Test (priority =3)
    public void TC_01(){
        System.out.println("Run TC_01");
    }

}
