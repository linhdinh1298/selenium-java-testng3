package javaSDET;

import org.testng.Assert;
import org.testng.annotations.Test;
public class Topic_03_And_OR {
    @Test
    public void verifyAnd() {
        String contactInfo = "Linh Dinh\n" +
                "linh@gmail.com\n" +
                "Change Password";
        Assert.assertTrue(contactInfo.contains("Linh Dinh") && contactInfo.contains("linh@gmail.com"));
    }
}