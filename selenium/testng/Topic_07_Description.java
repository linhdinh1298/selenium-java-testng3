package testng;

import org.testng.annotations.Test;

public class Topic_07_Description {
    // Tên của testcase = hàm/ function/ method của
    // Theo convention của từng ngôn

    // Chú thích/ note vào testcase, ví dụ ID ticket

    @Test (description = "BH-1200 - User can create new product")
    public void TC_03(){
        System.out.println("Run TC_03");

    }
    @Test
    public void TC_02(){
        System.out.println("Run TC_02");
    }
    @Test
    public void TC_01(){
        System.out.println("Run TC_01");
    }

}
