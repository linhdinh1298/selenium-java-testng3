package javaSDET;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Random;
public class Topic_04_Random {
    // Khai báo toàn cục: biến global
    String prefixEmail = "lin";
    String postfixEmail ="@gmail.com";
    @Test
    public void testEmail(){
        Random random = new Random();
        // Khai báo trong hàm > gọi là biến Local
        String fullEmail = prefixEmail + random.nextInt(999999) + postfixEmail;
        System.out.println(fullEmail);
    }
}
