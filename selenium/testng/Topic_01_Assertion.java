package testng;

import org.testng.Assert;

public class Topic_01_Assertion {
    public static void main (String[] arg){
        // 3 hàm chính để kiểm tra tính đúng đắn của dữ liệu
        boolean gender = 3 < 5;

        // Kiểm tra dữ liệu phải ĐÚNG
        Assert.assertTrue(gender);

        // Kiểm tra dữ liệu phải SAI
        Assert.assertFalse(3>5);

        // Kiểm tra dữ liệu đúng mong đợi (Actual, Expected)
        // Kiểu dữ liệu giống nhau
        // Giá trị của dữ liệu bằng nhau
        Assert.assertEquals(3,5);

    }
}

